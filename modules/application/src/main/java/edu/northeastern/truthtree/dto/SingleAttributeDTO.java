package edu.northeastern.truthtree.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.models.auth.In;

public class SingleAttributeDTO {
  private int id;
  private int place_type;
  private YearRangeDTO year_range;
  private int attribute;
  private int normalize_by;
  private Integer count;

  public int getId() {
    return id;
  }

  public int getPlace_type() {
    return place_type;
  }


  public YearRangeDTO getYear_range() {
    return year_range;
  }

  public int getNormalize_by() {
    return normalize_by;
  }

  public Integer getCount() {
    return count;
  }

  public int getAttribute() {
    return attribute;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPlace_type(int place_type) {
    this.place_type = place_type;
  }


  public void setYear_range(YearRangeDTO year_range) {
    this.year_range = year_range;
  }

  public void setNormalize_by(int normalize_by) {
    this.normalize_by = normalize_by;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public void setAttribute(int attribute) {
    this.attribute = attribute;
  }

}
