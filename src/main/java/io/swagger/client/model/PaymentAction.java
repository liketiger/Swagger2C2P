package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * PaymentAction
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-18T05:35:09.941Z[GMT]")
public class PaymentAction {
  @SerializedName("paymentRequest")
  private String paymentRequest = null;

  public PaymentAction paymentRequest(String paymentRequest) {
    this.paymentRequest = paymentRequest;
    return this;
  }

   /**
   * Get paymentRequest
   * @return paymentRequest
  **/
  @Schema(example = "hello", required = true, description = "")
  public String getPaymentRequest() {
    return paymentRequest;
  }

  public void setPaymentRequest(String paymentRequest) {
    this.paymentRequest = paymentRequest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentAction paymentAction = (PaymentAction) o;
    return Objects.equals(this.paymentRequest, paymentAction.paymentRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentRequest);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentAction {\n");
    
    sb.append("    paymentRequest: ").append(toIndentedString(paymentRequest)).append("\n");
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
