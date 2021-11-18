package io.swagger.client.dto;

import java.util.List;


public class RequestDTO {
	private String merchantID;
    private String invoiceNo;
    private String description;
    private String amount;
    private String currencyCode;
    private List<String> paymentChannel;
    private String name;
	private String email;
    private String phone;
    private String account;
    private String responseReturnUrl;
    
    public String getResponseReturnUrl() {
		return responseReturnUrl;
	}
	public void setResponseReturnUrl(String responseReturnUrl) {
		this.responseReturnUrl = responseReturnUrl;
	}
    
    public String getAmount() {
		return amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public List<String> getPaymentChannel() {
		return paymentChannel;
	}
	public void setPaymentChannel(List<String> paymentChannel) {
		this.paymentChannel = paymentChannel;
	}
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

}
