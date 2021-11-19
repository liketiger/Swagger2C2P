package io.swagger.client.dto;

public class PaymentActionRequestDTO {
	
	private String invoiceNo;
    private String version;
    private String processType;
    private String merchantID;
    private String actionAmount = "0.00";

    public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getActionAmount() {
		return actionAmount;
	}
	public void setActionAmount(String actionAmount) {
		this.actionAmount = actionAmount;
	}
	public String getProcessType() {
		return processType;
	}
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	
	

}
