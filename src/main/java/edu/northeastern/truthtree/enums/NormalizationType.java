package edu.northeastern.truthtree.enums;

/**
 * Represents types of normalization supported by system. "NormalizationService" aims to give clear
 * understanding of comparing values
 */
public enum NormalizationType {
  GROSS("Gross"), PER_CAPITA("Per Capita"), BY_REVENUE("By Revenue");
  String value;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  NormalizationType(String value) {
    this.value = value;
  }

  public String getValue(){
    return this.value;
  }

}
