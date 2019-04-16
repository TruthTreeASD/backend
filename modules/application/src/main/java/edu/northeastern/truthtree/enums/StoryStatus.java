package edu.northeastern.truthtree.enums;

/**
 * Represents state of a story. Once story is created, it will be in pending state. After
 * moderator's approval, it will be in Approved state otherwise in Disapproved state.
 */
public enum StoryStatus {
  APPROVED("Approved"), DISAPPROVED("Disapproved"), PENDING("Pending");
  String value;

  /**
   * Sets the value of enum.
   *
   * @param value in String.
   */
  StoryStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
