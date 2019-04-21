package edu.northeastern.truthtree.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by steven on 2019/3/21.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDTO {
  private String id;
  private String name;
  private LocationDTO parent;
  private Integer typeCode;
  private Double latitude;
  private Double longitude;
  private Long population;

  private LocationDTO(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.parent = builder.parent;
    this.typeCode = builder.typeCode;
    this.latitude = builder.latitude;
    this.longitude = builder.longitude;
    this.population = builder.population;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocationDTO getParent() {
    return parent;
  }

  public Integer getTypeCode() {
    return typeCode;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Long getPopulation() {
    return population;
  }

  public static class Builder {
    private String id;
    private String name;
    private LocationDTO parent;
    private Integer typeCode;
    private Double latitude;
    private Double longitude;
    private Long population;

    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withParent(LocationDTO parent) {
      this.parent = parent;
      return this;
    }

    public Builder withTypeCode(Integer typeCode) {
      this.typeCode = typeCode;
      return this;
    }

    public Builder withLatitude(Double latitude) {
      this.latitude = latitude;
      return this;
    }

    public Builder withLongitude(Double longitude) {
      this.longitude = longitude;
      return this;
    }

    public Builder withPopulation(Long population) {
      this.population = population;
      return this;
    }

    public LocationDTO build() {
      return new LocationDTO(this);
    }
  }
}
