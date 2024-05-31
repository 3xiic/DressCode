package co.edu.unbosque.DressCode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	public List<Product> findAll();
}
