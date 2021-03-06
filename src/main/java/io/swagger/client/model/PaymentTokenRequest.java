package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * PaymentTokenRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-19T08:42:12.170Z[GMT]")
public class PaymentTokenRequest {
  @SerializedName("merchantID")
  private String merchantID = null;

  @SerializedName("invoiceNo")
  private String invoiceNo = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("amount")
  private String amount = null;

  @SerializedName("currencyCode")
  private String currencyCode = null;

  @SerializedName("frontendReturnUrl")
  private String frontendReturnUrl = null;

  public PaymentTokenRequest merchantID(String merchantID) {
    this.merchantID = merchantID;
    return this;
  }

   /**
   * Get merchantID
   * @return merchantID
  **/
  @Schema(example = "JT01", required = true, description = "")
  public String getMerchantID() {
    return merchantID;
  }

  public void setMerchantID(String merchantID) {
    this.merchantID = merchantID;
  }

  public PaymentTokenRequest invoiceNo(String invoiceNo) {
    this.invoiceNo = invoiceNo;
    return this;
  }

   /**
   * Get invoiceNo
   * @return invoiceNo
  **/
  @Schema(example = "1523953661", required = true, description = "")
  public String getInvoiceNo() {
    return invoiceNo;
  }

  public void setInvoiceNo(String invoiceNo) {
    this.invoiceNo = invoiceNo;
  }

  public PaymentTokenRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(example = "item 1", required = true, description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PaymentTokenRequest amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @Schema(example = "1000", required = true, description = "")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public PaymentTokenRequest currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

   /**
   * Get currencyCode
   * @return currencyCode
  **/
  @Schema(example = "SGD", required = true, description = "")
  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public PaymentTokenRequest frontendReturnUrl(String frontendReturnUrl) {
    this.frontendReturnUrl = frontendReturnUrl;
    return this;
  }

   /**
   * Get frontendReturnUrl
   * @return frontendReturnUrl
  **/
  @Schema(required = true, description = "")
  public String getFrontendReturnUrl() {
    return frontendReturnUrl;
  }

  public void setFrontendReturnUrl(String frontendReturnUrl) {
    this.frontendReturnUrl = frontendReturnUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentTokenRequest paymentTokenRequest = (PaymentTokenRequest) o;
    return Objects.equals(this.merchantID, paymentTokenRequest.merchantID) &&
        Objects.equals(this.invoiceNo, paymentTokenRequest.invoiceNo) &&
        Objects.equals(this.description, paymentTokenRequest.description) &&
        Objects.equals(this.amount, paymentTokenRequest.amount) &&
        Objects.equals(this.currencyCode, paymentTokenRequest.currencyCode) &&
        Objects.equals(this.frontendReturnUrl, paymentTokenRequest.frontendReturnUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantID, invoiceNo, description, amount, currencyCode, frontendReturnUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentTokenRequest {\n");
    
    sb.append("    merchantID: ").append(toIndentedString(merchantID)).append("\n");
    sb.append("    invoiceNo: ").append(toIndentedString(invoiceNo)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    frontendReturnUrl: ").append(toIndentedString(frontendReturnUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
