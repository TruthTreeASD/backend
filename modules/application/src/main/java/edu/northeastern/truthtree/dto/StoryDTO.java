package edu.northeastern.truthtree.dto;

import org.springframework.stereotype.Component;

import java.util.List;

public class StoryDTO {
  /**
   * Author of story.
   */
  private String authorName;
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
   * Source of image to be posted
   */
  private String imgSrc;

  /**
   * Sets author name.
   *
   * @param authorName in string.
   */
  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  /**
   * Returns author name.
   *
   * @return authorName in string.
   */
  public String getAuthorName() {
    return this.authorName;
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
   * Sets image source.
   *
   * @param imgSrc in string.
   */
  public void setImgSrc(String imgSrc) {
    this.imgSrc = imgSrc;
  }

  /**
   * Returns image source.
   *
   * @return imgSrc in string.
   */
  public String getImgSrc() {
    return this.imgSrc;
  }
}
