package co.edu.unbosque.dresscode;

public class Parameter {
	
	private Integer nit;
	private String type;
	private String name;
	private String city;
	private float iva;
	private float interest_rate;
	private String bank;
	private String account;
	private String manager_name;
	
	public Parameter() {
		// TODO Auto-generated constructor stub
	}
	
	public Parameter(Integer nit, String type, String name, String city, float iva, float interest_rate, String bank,
			String account, String manager_name) {
		super();
		this.nit = nit;
		this.type = type;
		this.name = name;
		this.city = city;
		this.iva = iva;
		this.interest_rate = interest_rate;
		this.bank = bank;
		this.account = account;
		this.manager_name = manager_name;
	}
	
	public Integer getNit() {
		return nit;
	}
	public void setNit(Integer nit) {
		this.nit = nit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	public float getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
}
