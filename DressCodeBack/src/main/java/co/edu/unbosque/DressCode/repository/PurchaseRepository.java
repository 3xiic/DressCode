package co.edu.unbosque.DressCode.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer>{
	public List<Purchase> findAll();
}
