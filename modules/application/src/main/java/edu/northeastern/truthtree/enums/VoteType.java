package edu.northeastern.truthtree.enums;

/**
 * Represents vote type of story. Upvote or downvote
 */
public enum VoteType {
  UPVOTE("Upvote"), DOWNVOTE("Downvote");
  String value;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  VoteType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
