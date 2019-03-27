package edu.northeastern.truthtree.enums;

/**
 * Represents types of sorting available for stories.
 */
public enum StoryOrder {

  RECENT("Recent"), MOST_UPVOTES("Most Upvotes"), MOST_DOWNVOTES("Most Downvotes");
  String value;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  StoryOrder(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}


