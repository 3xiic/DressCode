package co.edu.unbosque.dresscode;

public class Supplier {
	private Integer id_supplier;
	private String nit;
	private String name;
	private String address;
	private String phone_number;
	private String city;
	
	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Supplier(Integer id_supplier, String nit, String name, String address, String phone_number, String city) {
		super();
		this.id_supplier = id_supplier;
		this.nit = nit;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.city = city;
	}

	public Integer getId_supplier() {
		return id_supplier;
	}
	public void setId_supplier(Integer id_supplier) {
		this.id_supplier = id_supplier;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
