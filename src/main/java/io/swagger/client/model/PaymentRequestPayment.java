package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Information regarding payment
 */
@Schema(description = "Information regarding payment")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-21T23:50:31.361Z[GMT]")
public class PaymentRequestPayment {
  @SerializedName("code")
  private PaymentRequestPaymentCode code = null;

  @SerializedName("data")
  private PaymentRequestPaymentData data = null;

  public PaymentRequestPayment code(PaymentRequestPaymentCode code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @Schema(required = true, description = "")
  public PaymentRequestPaymentCode getCode() {
    return code;
  }

  public void setCode(PaymentRequestPaymentCode code) {
    this.code = code;
  }

  public PaymentRequestPayment data(PaymentRequestPaymentData data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Schema(required = true, description = "")
  public PaymentRequestPaymentData getData() {
    return data;
  }

  public void setData(PaymentRequestPaymentData data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequestPayment paymentRequestPayment = (PaymentRequestPayment) o;
    return Objects.equals(this.code, paymentRequestPayment.code) &&
        Objects.equals(this.data, paymentRequestPayment.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, data);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequestPayment {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
