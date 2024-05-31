package co.edu.unbosque.dresscode;

public class Credit {
	
	private Integer id_credit;
	private Integer id_amortization;
	private Integer id_sale;
	private String customer_document;
	private int current_quota;
	private float balance;
	private float quota_value;
	private float interest;
	private float amortization;
	
	public Credit() {
		// TODO Auto-generated constructor stub
	}
	
	public Credit(Integer id_credit, Integer id_amortization, Integer id_sale, String customer_document,
			int current_quota, float balance, float quota_value, float interest, float amortization) {
		super();
		this.id_credit = id_credit;
		this.id_amortization = id_amortization;
		this.id_sale = id_sale;
		this.customer_document = customer_document;
		this.current_quota = current_quota;
		this.balance = balance;
		this.quota_value = quota_value;
		this.interest = interest;
		this.amortization = amortization;
	}
	
	public Integer getId_credit() {
		return id_credit;
	}
	public void setId_credit(Integer id_credit) {
		this.id_credit = id_credit;
	}
	public Integer getId_amortization() {
		return id_amortization;
	}
	public void setId_amortization(Integer id_amortization) {
		this.id_amortization = id_amortization;
	}
	public Integer getId_sale() {
		return id_sale;
	}
	public void setId_sale(Integer id_sale) {
		this.id_sale = id_sale;
	}
	public String getCustomer_document() {
		return customer_document;
	}
	public void setCustomer_document(String customer_document) {
		this.customer_document = customer_document;
	}
	public int getCurrent_quota() {
		return current_quota;
	}
	public void setCurrent_quota(int current_quota) {
		this.current_quota = current_quota;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getQuota_value() {
		return quota_value;
	}
	public void setQuota_value(float quota_value) {
		this.quota_value = quota_value;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public float getAmortization() {
		return amortization;
	}
	public void setAmortization(float amortization) {
		this.amortization = amortization;
	}
}
