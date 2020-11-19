package br.com.lins.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lins.dscatalog.dto.CategoryDTO;
import br.com.lins.dscatalog.model.Category;
import br.com.lins.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDTO> findall(){
		List<Category> categories = repository.findAll();
		return categories.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
}
