package co.edu.unbosque.DressCode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.SaleDetail;

public interface SaleDetailRepository extends CrudRepository<SaleDetail, Integer>{
	public List<SaleDetail> findAll();
}
