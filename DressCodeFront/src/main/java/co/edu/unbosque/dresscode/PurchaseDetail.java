package co.edu.unbosque.dresscode;

public class PurchaseDetail {
	private Integer id_purchase_detail;
	private Integer id_product;
	private Integer id_purchase;
	private int quantity;
	private float total_value;
	
	public PurchaseDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public PurchaseDetail(Integer id_purchase_detail, Integer id_product, Integer id_purchase, int quantity,
			float total_value) {
		super();
		this.id_purchase_detail = id_purchase_detail;
		this.id_product = id_product;
		this.id_purchase = id_purchase;
		this.quantity = quantity;
		this.total_value = total_value;
	}

	public Integer getId_purchase_detail() {
		return id_purchase_detail;
	}
	public void setId_purchase_detail(Integer id_purchase_detail) {
		this.id_purchase_detail = id_purchase_detail;
	}
	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}
	public Integer getId_purchase() {
		return id_purchase;
	}
	public void setId_purchase(Integer id_purchase) {
		this.id_purchase = id_purchase;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal_value() {
		return total_value;
	}
	public void setTotal_value(float total_value) {
		this.total_value = total_value;
	}
}
