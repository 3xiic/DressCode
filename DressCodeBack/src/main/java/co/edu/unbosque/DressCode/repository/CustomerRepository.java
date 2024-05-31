package co.edu.unbosque.DressCode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	public List<Customer> findAll();

	public Customer findByDocument(String document);
}
