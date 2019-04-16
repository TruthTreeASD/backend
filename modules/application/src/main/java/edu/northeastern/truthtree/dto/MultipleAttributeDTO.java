package edu.northeastern.truthtree.dto;

import java.util.ArrayList;
import java.util.List;

public class MultipleAttributeDTO {
  private int id;
  private int place_type;
  private int year;
  private List<Integer> attribute;
  private int normalize_by;
  private Integer count;

  public int getId() {
    return id;
  }

  public int getPlace_type() {
    return place_type;
  }

  public int getYear() {
    return year;
  }

  public int getNormalize_by() {
    return normalize_by;
  }

  public Integer getCount() {
    return count;
  }

  public List<Integer> getAttribute() {
    return attribute;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPlace_type(int place_type) {
    this.place_type = place_type;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setNormalize_by(int normalize_by) {
    this.normalize_by = normalize_by;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public void setAttribute(List<Integer> attribute) {
    this.attribute = attribute;
  }
}

