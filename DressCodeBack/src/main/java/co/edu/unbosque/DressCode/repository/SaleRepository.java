package co.edu.unbosque.DressCode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.Sale;

public interface SaleRepository extends CrudRepository<Sale, Integer>{
	public List<Sale> findAll();
}
