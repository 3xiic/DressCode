package co.edu.unbosque.DressCode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.Check;

public interface CheckRepository extends CrudRepository<Check, Integer>{
	public List<Check> findAll();
}
