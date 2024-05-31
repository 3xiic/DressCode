package co.edu.unbosque.dresscode;

public class SaleDetail {
	private Integer id_sale_detail;
	private String customer_doc;
	private Integer id_product;
	private Integer id_sale;
	private int quantity;
	private float unit_value;
	private float total_value;
	
	public SaleDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public SaleDetail(Integer id_sale_detail, String customer_doc, Integer id_product, Integer id_sale, int quantity,
			float unit_value, float total_value) {
		super();
		this.id_sale_detail = id_sale_detail;
		this.customer_doc = customer_doc;
		this.id_product = id_product;
		this.id_sale = id_sale;
		this.quantity = quantity;
		this.unit_value = unit_value;
		this.total_value = total_value;
	}

	public String getCustomer_doc() {
		return customer_doc;
	}

	public void setCustomer_doc(String customer_doc) {
		this.customer_doc = customer_doc;
	}

	public Integer getId_sale_detail() {
		return id_sale_detail;
	}
	public void setId_sale_detail(Integer id_sale_detail) {
		this.id_sale_detail = id_sale_detail;
	}
	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}
	public Integer getId_sale() {
		return id_sale;
	}
	public void setId_sale(Integer id_sale) {
		this.id_sale = id_sale;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnit_value() {
		return unit_value;
	}
	public void setUnit_value(float unit_value) {
		this.unit_value = unit_value;
	}
	public float getTotal_value() {
		return total_value;
	}
	public void setTotal_value(float total_value) {
		this.total_value = total_value;
	}
}
