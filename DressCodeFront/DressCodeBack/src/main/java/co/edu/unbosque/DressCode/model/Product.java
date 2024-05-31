package co.edu.unbosque.DressCode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_product;
	private String name;
	private String nit_supplier;
	private float purchase_price;
	private float sales_price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, String nit_supplier, float purchase_price, float sales_price) {
		super();
		this.name = name;
		this.nit_supplier = nit_supplier;
		this.purchase_price = purchase_price;
		this.sales_price = sales_price;
	}

	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNit_supplier() {
		return nit_supplier;
	}
	public void setNit_supplier(String nit_supplier) {
		this.nit_supplier = nit_supplier;
	}
	public float getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(float purchase_price) {
		this.purchase_price = purchase_price;
	}
	public float getSales_price() {
		return sales_price;
	}
	public void setSales_price(float sales_price) {
		this.sales_price = sales_price;
	}
}
