package edu.northeastern.truthtree.enums;

/**
 * Represents types of normalization supported by system. "NormalizationService" aims to give clear
 * understanding of comparing values
 */
public enum NormalizationType {
  GROSS("Gross", 1), PER_CAPITA("Per Capita", 2), BY_REVENUE("By Revenue", 3);
  String type;
  int value;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  NormalizationType(String type, int value) {
    this.type = type;
    this.value = value;
  }

  public String getType() {
    return type;
  }

  public int getValue(){
    return this.value;
  }

}
