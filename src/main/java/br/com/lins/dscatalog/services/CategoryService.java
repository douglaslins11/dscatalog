package br.com.lins.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lins.dscatalog.exception.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.lins.dscatalog.dto.CategoryDTO;
import br.com.lins.dscatalog.exception.ResourceNotFoundException;
import br.com.lins.dscatalog.model.Category;
import br.com.lins.dscatalog.repositories.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findall(){
		List<Category> categories = repository.findAll();
		return categories.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		return new CategoryDTO(repository.findById(id)
										 .orElseThrow(() -> new ResourceNotFoundException("Entity not found")));
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		category = repository.save(category);
		return new CategoryDTO(category);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
		try {
			Category category = repository.getOne(id);
			category.setName(categoryDTO.getName());
			category = repository.save(category);
			return new CategoryDTO(category);
		} catch (EntityNotFoundException e){
			throw new ResourceNotFoundException("Id not found: "+id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException("Id not found: "+id);
		} catch (DataIntegrityViolationException e){
			throw new DatabaseException("Integrity violation");
		}
	}
}
