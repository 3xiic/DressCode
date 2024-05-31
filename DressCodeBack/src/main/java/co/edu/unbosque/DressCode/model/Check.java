package co.edu.unbosque.DressCode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "checktable")
public class Check {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_check;
	private Integer id_purchase;
	private String nit_supplier;
	private float total;
	
	public Check(Integer id_purchase, String nit_supplier, float total) {
		super();
		this.id_purchase = id_purchase;
		this.nit_supplier = nit_supplier;
		this.total = total;
	}
	public Integer getId_check() {
		return id_check;
	}
	public void setId_check(Integer id_check) {
		this.id_check = id_check;
	}
	public Integer getId_purchase() {
		return id_purchase;
	}
	public void setId_purchase(Integer id_purchase) {
		this.id_purchase = id_purchase;
	}
	public String getNit_supplier() {
		return nit_supplier;
	}
	public void setNit_supplier(String nit_supplier) {
		this.nit_supplier = nit_supplier;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
}
