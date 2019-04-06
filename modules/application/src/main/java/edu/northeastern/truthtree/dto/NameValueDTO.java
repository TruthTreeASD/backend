package edu.northeastern.truthtree.dto;

public class NameValueDTO {
  private String name;
  private String value;

  public void setName(String name){
    this.name = name;
  }
  public void setValue(String value){
    this.value = value;
  }

  public String getName(){
    return this.name;
  }

  public String getValue(){
    return this.value;
  }
}
