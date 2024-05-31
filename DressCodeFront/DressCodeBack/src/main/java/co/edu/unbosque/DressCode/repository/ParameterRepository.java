package co.edu.unbosque.DressCode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.Parameter;

public interface ParameterRepository extends CrudRepository<Parameter, Integer>{
	public List<Parameter> findAll();
}
