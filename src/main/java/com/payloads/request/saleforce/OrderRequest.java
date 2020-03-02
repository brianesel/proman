package com.payloads.request.saleforce;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class OrderRequest {
	@NotBlank
	private String Account__c;

	@NotBlank
	private String Billing_address__c;

	@NotBlank
	private String Shipping_address__c;

	@NotBlank
	private String Product__c;

	private int Quantity__c;

	private int status__c;

	public void setUp(String Account__c, String Billing_address__c,String Shipping_address__c,String Product__c,int Quantity__c,int status__c){
		this.status__c = status__c;
		this.Quantity__c = Quantity__c;
		this.Billing_address__c = Billing_address__c;
		this.Shipping_address__c = Shipping_address__c;
		this.Quantity__c = Quantity__c;
		this.Product__c = Product__c;
	}

	public int getStatus__c() {
		return status__c;
	}

	public void setStatus__c(int status__c) {
		this.status__c = status__c;
	}

	public int getQuantity__c() {
		return Quantity__c;
	}

	public void setQuantity__c(int Quantity__c) {
		this.Quantity__c = Quantity__c;
	}

	public String getProduct__c() {
		return Product__c;
	}

	public void setProduct__c(String Product__c) {
		this.Product__c = Product__c;
	}

	public String getBilling_address__c() {
		return Billing_address__c;
	}

	public void setBilling_address__c(String Billing_adress__c) {
		this.Billing_address__c = Billing_adress__c;
	}

	public String getShipping_address__c() {
		return Shipping_address__c;
	}

	public void setShipping_address__c(String Shipping_adress__c) {
		this.Shipping_address__c = Shipping_adress__c;
	}
	public String getAccount__c() {
		return Account__c;
	}

	public void setAccount__c(String Account__c) {
		this.Account__c = Account__c;
	}

	public String getPassword() {
		return Billing_address__c;
	}

	public void setPassword(String Billing_adress__c) {
		this.Billing_address__c = Billing_adress__c;
	}
}
