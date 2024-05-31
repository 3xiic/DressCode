package co.edu.unbosque.dresscode;

public class Purchase {
	private Integer id_purchase;
	private String nit_supplier;
	private float total;
	private float iva;
	private float total_iva;
	
	public Purchase() {
		// TODO Auto-generated constructor stub
	}
	
	public Purchase(Integer id_purchase, String nit_supplier, float total, float iva, float total_iva) {
		super();
		this.id_purchase = id_purchase;
		this.nit_supplier = nit_supplier;
		this.total = total;
		this.iva = iva;
		this.total_iva = total_iva;
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
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	public float getTotal_iva() {
		return total_iva;
	}
	public void setTotal_iva(float total_iva) {
		this.total_iva = total_iva;
	}
}
