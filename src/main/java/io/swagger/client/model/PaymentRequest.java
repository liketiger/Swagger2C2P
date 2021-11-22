package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * PaymentRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-21T23:50:31.361Z[GMT]")
public class PaymentRequest {
  @SerializedName("paymentToken")
  private String paymentToken = null;

  @SerializedName("clientID")
  private String clientID = null;

  @SerializedName("locale")
  private String locale = null;

  @SerializedName("responseReturnUrl")
  private String responseReturnUrl = null;

  @SerializedName("payment")
  private PaymentRequestPayment payment = null;

  public PaymentRequest paymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
    return this;
  }

   /**
   * Mandatory / Character 255 / Payment Token ID
   * @return paymentToken
  **/
  @Schema(required = true, description = "Mandatory / Character 255 / Payment Token ID")
  public String getPaymentToken() {
    return paymentToken;
  }

  public void setPaymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
  }

  public PaymentRequest clientID(String clientID) {
    this.clientID = clientID;
    return this;
  }

   /**
   * Optional / Character 255 / Unique Client ID (This ID will be created when UI SDK init)
   * @return clientID
  **/
  @Schema(description = "Optional / Character 255 / Unique Client ID (This ID will be created when UI SDK init)")
  public String getClientID() {
    return clientID;
  }

  public void setClientID(String clientID) {
    this.clientID = clientID;
  }

  public PaymentRequest locale(String locale) {
    this.locale = locale;
    return this;
  }

   /**
   * Optional / Character 10 / API response localization (defaults to payment token locale)
   * @return locale
  **/
  @Schema(description = "Optional / Character 10 / API response localization (defaults to payment token locale)")
  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public PaymentRequest responseReturnUrl(String responseReturnUrl) {
    this.responseReturnUrl = responseReturnUrl;
    return this;
  }

   /**
   * Optional / Character 255 / Payment response return url (Only to be used by 3rd party vendor to build payment UI for a Merchant and the payment token will be appended at the end of the URL)
   * @return responseReturnUrl
  **/
  @Schema(description = "Optional / Character 255 / Payment response return url (Only to be used by 3rd party vendor to build payment UI for a Merchant and the payment token will be appended at the end of the URL)")
  public String getResponseReturnUrl() {
    return responseReturnUrl;
  }

  public void setResponseReturnUrl(String responseReturnUrl) {
    this.responseReturnUrl = responseReturnUrl;
  }

  public PaymentRequest payment(PaymentRequestPayment payment) {
    this.payment = payment;
    return this;
  }

   /**
   * Get payment
   * @return payment
  **/
  @Schema(required = true, description = "")
  public PaymentRequestPayment getPayment() {
    return payment;
  }

  public void setPayment(PaymentRequestPayment payment) {
    this.payment = payment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequest paymentRequest = (PaymentRequest) o;
    return Objects.equals(this.paymentToken, paymentRequest.paymentToken) &&
        Objects.equals(this.clientID, paymentRequest.clientID) &&
        Objects.equals(this.locale, paymentRequest.locale) &&
        Objects.equals(this.responseReturnUrl, paymentRequest.responseReturnUrl) &&
        Objects.equals(this.payment, paymentRequest.payment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentToken, clientID, locale, responseReturnUrl, payment);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequest {\n");
    
    sb.append("    paymentToken: ").append(toIndentedString(paymentToken)).append("\n");
    sb.append("    clientID: ").append(toIndentedString(clientID)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    responseReturnUrl: ").append(toIndentedString(responseReturnUrl)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
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
