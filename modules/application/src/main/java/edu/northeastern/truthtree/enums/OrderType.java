package edu.northeastern.truthtree.enums;

import java.util.List;

/**
 * Represents types of sorting available for stories.
 */
public enum OrderType {

  RECENT("Recent"), MOST_UPVOTES("Most Upvotes"), MOST_DOWNVOTES("Most Downvotes"), OLDEST("Oldest");
  String value;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  OrderType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}


