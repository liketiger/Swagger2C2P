
package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * SubMerchant
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-22T00:42:30.251Z[GMT]")
public class SubMerchant {
  @SerializedName("subMID")
  private String subMID = null;

  @SerializedName("subAmount")
  private String subAmount = null;

  public SubMerchant subMID(String subMID) {
    this.subMID = subMID;
    return this;
  }

   /**
   * Get subMID
   * @return subMID
  **/
  @Schema(description = "")
  public String getSubMID() {
    return subMID;
  }

  public void setSubMID(String subMID) {
    this.subMID = subMID;
  }

  public SubMerchant subAmount(String subAmount) {
    this.subAmount = subAmount;
    return this;
  }

   /**
   * Get subAmount
   * @return subAmount
  **/
  @Schema(description = "")
  public String getSubAmount() {
    return subAmount;
  }

  public void setSubAmount(String subAmount) {
    this.subAmount = subAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubMerchant subMerchant = (SubMerchant) o;
    return Objects.equals(this.subMID, subMerchant.subMID) &&
        Objects.equals(this.subAmount, subMerchant.subAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subMID, subAmount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubMerchant {\n");
    
    sb.append("    subMID: ").append(toIndentedString(subMID)).append("\n");
    sb.append("    subAmount: ").append(toIndentedString(subAmount)).append("\n");
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
