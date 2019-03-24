package edu.northeastern.truthtree.dto;

/**
 * Created by steven on 2019/3/21.
 */
public class LocationDTO {
  private String id;
  private String name;
  private LocationDTO parent;
  private int typeCode;
  private double latitude;
  private double longitude;

  private LocationDTO(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.parent = builder.parent;
    this.typeCode = builder.typeCode;
    this.latitude = builder.latitude;
    this.longitude = builder.longitude;
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

  public int getTypeCode() {
    return typeCode;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public static class Builder {
    private String id;
    private String name;
    private LocationDTO parent;
    private int typeCode;
    private double latitude;
    private double longitude;

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

    public Builder withTypeCode(int typeCode) {
      this.typeCode = typeCode;
      return this;
    }

    public Builder withLatitude(double latitude) {
      this.latitude = latitude;
      return this;
    }

    public Builder withLongitude(double longitude) {
      this.longitude = longitude;
      return this;
    }

    public LocationDTO build() {
      return new LocationDTO(this);
    }
  }
}
