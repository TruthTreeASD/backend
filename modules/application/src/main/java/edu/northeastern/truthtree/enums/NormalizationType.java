package edu.northeastern.truthtree.enums;

/**
 * Represents types of normalization supported by system. "NormalizationService" aims to give clear
 * understanding of comparing values
 */
public enum NormalizationType {
  GROSS("Gross", 0), PER_CAPITA("Per Capita", 1), BY_REVENUE("By Revenue", 4);
  String value;
  int code;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  NormalizationType(String value, int code) {
    this.value = value;
    this.code = code;
  }

  public String getValue() {
    return value;
  }

  public int getCode() {
    return this.code;
  }

}
