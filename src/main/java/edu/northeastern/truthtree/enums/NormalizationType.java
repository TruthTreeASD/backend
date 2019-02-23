package edu.northeastern.truthtree.enums;

/**
 * Represents types of normalization supported by system. "NormalizationService" aims to give clear
 * understanding of comparing values
 */
public enum NormalizationType {
  GROSS("GROSS"), PER_CAPITA("PER-CAPITA"), BY_REVENUE("BY REVENUE");
  String value;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  NormalizationType(String value) {
    this.value = value;
  }

}
