package edu.northeastern.truthtree.dto;

import java.util.List;

public class StoryDTO {
  /**
   * Author of story.
   */
  private String author;
  /**
   * Relevant tags of story.
   */
  private List<String> tags;
  /**
   * Stores content of story.
   */
  private String content;
  /**
   * Unique identifier for story id
   */
  private String id;
  /**
   * Title of story
   */
  private String title;
  /**
   * Number of upvote of story
   */
  private Long upvote;
  /**
   * Number of downvote of story
   */
  private Long downvote;
  /**
   * Date of creation of this story
   */
  private Long timestamp;

  /**
   * Sets author name.
   *
   * @param author in string.
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Returns author name.
   *
   * @return author in string.
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Sets story id.
   *
   * @param id in string.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Returns story id.
   *
   * @return id in string.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Sets tags of story.
   *
   * @param tags in string.
   */
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * Gets tags of story.
   *
   * @return tags in string.
   */
  public List<String> getTags() {
    return this.tags;
  }

  /**
   * Sets content of story.
   *
   * @param content in string.
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Sets content of story.
   *
   * @return content in string.
   */
  public String getContent() {
    return this.content;
  }

  /**
   * Sets title of story.
   *
   * @param title in string.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Sets title of story.
   *
   * @return title in string.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Sets downvote of story.
   *
   * @param downvote in int.
   */
  public void setDownvote(Long downvote) {
    this.downvote = downvote;
  }

  /**
   * Sets downvote of story.
   *
   * @return downvote in int.
   */
  public Long getDownvote() {
    return this.downvote;
  }

  /**
   * Sets upvote of story.
   *
   * @param upvote in int.
   */
  public void setUpvote(Long upvote) {
    this.upvote = upvote;
  }

  /**
   * Sets upvote of story.
   *
   * @return upvote in int.
   */
  public Long getUpvote() {
    return this.upvote;
  }

  /**
   * Sets timestamp of story.
   *
   * @param timestamp in long.
   */
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Returns timestamp of story.
   *
   * @return timestamp in long.
   */
  public Long getTimestamp() {
    return this.timestamp;
  }

}
