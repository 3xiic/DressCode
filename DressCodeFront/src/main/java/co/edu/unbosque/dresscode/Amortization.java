package co.edu.unbosque.dresscode;

public class Amortization {
	private Integer id_amortization;
	private Integer id_credit;
	private int quota_number;
	private float balance;
	private float quota_value;
	private float interest;
	private float amortization;
	
	public Amortization() {
		// TODO Auto-generated constructor stub
	}

	public Amortization(Integer id_amortization, Integer id_credit, int quota_number, float balance, float quota_value,
			float interest, float amortization) {
		super();
		this.id_amortization = id_amortization;
		this.id_credit = id_credit;
		this.quota_number = quota_number;
		this.balance = balance;
		this.quota_value = quota_value;
		this.interest = interest;
		this.amortization = amortization;
	}

	public Integer getId_amortization() {
		return id_amortization;
	}
	public void setId_amortization(Integer id_amortization) {
		this.id_amortization = id_amortization;
	}
	public Integer getId_credit() {
		return id_credit;
	}
	public void setId_credit(Integer id_credit) {
		this.id_credit = id_credit;
	}
	public int getQuota_number() {
		return quota_number;
	}
	public void setQuota_number(int quota_number) {
		this.quota_number = quota_number;
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
