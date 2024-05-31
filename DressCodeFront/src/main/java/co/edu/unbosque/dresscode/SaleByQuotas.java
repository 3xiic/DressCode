package co.edu.unbosque.dresscode;

public class SaleByQuotas {
	private Integer id_sale_by_quotas;
	private String customer_document;
	private Integer id_sale;
	private float amount;
	private float nominal_rate;
	private float effective_rate;
	private float annuality;
	private float quota_value;
	
	public SaleByQuotas() {
		// TODO Auto-generated constructor stub
	}
	
	public SaleByQuotas(Integer id_sale_by_quotas, String customer_document, Integer id_sale, float amount,
			float nominal_rate, float effective_rate, float annuality, float quota_value) {
		super();
		this.id_sale_by_quotas = id_sale_by_quotas;
		this.customer_document = customer_document;
		this.id_sale = id_sale;
		this.amount = amount;
		this.nominal_rate = nominal_rate;
		this.effective_rate = effective_rate;
		this.annuality = annuality;
		this.quota_value = quota_value;
	}

	public Integer getId_sale_by_quotas() {
		return id_sale_by_quotas;
	}
	public void setId_sale_by_quotas(Integer id_sale_by_quotas) {
		this.id_sale_by_quotas = id_sale_by_quotas;
	}
	public String getCustomer_document() {
		return customer_document;
	}
	public void setCustomer_document(String customer_document) {
		this.customer_document = customer_document;
	}
	public Integer getId_sale() {
		return id_sale;
	}
	public void setId_sale(Integer id_sale) {
		this.id_sale = id_sale;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getNominal_rate() {
		return nominal_rate;
	}
	public void setNominal_rate(float nominal_rate) {
		this.nominal_rate = nominal_rate;
	}
	public float getEffective_rate() {
		return effective_rate;
	}
	public void setEffective_rate(float effective_rate) {
		this.effective_rate = effective_rate;
	}
	public float getAnnuality() {
		return annuality;
	}
	public void setAnnuality(float annuality) {
		this.annuality = annuality;
	}
	public float getQuota_value() {
		return quota_value;
	}
	public void setQuota_value(float quota_value) {
		this.quota_value = quota_value;
	}
}