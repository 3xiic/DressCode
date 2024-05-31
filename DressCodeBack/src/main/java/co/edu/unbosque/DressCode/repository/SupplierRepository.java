package co.edu.unbosque.DressCode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer>{
	public List<Supplier> findAll();
}
