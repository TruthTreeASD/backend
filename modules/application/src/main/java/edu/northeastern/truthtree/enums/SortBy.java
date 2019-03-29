package edu.northeastern.truthtree.enums;

public enum SortBy {
  ASC("Asc"), DESC("Desc");
  String value;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  SortBy(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}
