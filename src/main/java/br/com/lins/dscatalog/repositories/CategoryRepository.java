package br.com.lins.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.lins.dscatalog.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
