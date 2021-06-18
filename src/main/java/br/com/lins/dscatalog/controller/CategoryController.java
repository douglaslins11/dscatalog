package br.com.lins.dscatalog.controller;

import br.com.lins.dscatalog.dto.CategoryDTO;
import br.com.lins.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<Page<CategoryDTO>> findAll (
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "12") Integer linesPerPage,
			@RequestParam(defaultValue = "ASC") String orderDirection,
			@RequestParam(defaultValue = "name") String orderBy
	) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(orderDirection), orderBy);

		Page<CategoryDTO> categories = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<CategoryDTO> insert (@RequestBody CategoryDTO categoryDTO){
		CategoryDTO responseInsert = service.insert(categoryDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(responseInsert.getId())
											 .toUri();
		return ResponseEntity.created(uri).body(responseInsert);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDTO> update (@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
		categoryDTO = service.update(id, categoryDTO);
		return ResponseEntity.ok(categoryDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryDTO> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
