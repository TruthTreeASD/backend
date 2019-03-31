package edu.northeastern.truthtree.dto;

import java.util.List;

public class StoryDTOWrapperList {
  private int respCode;
  private List<StoryDTO> data;
  private boolean ok;
  private String message;

  public void setRespCode(int respCode) {
    this.respCode = respCode;
  }

  public int getRespCode() {
    return this.respCode;
  }

  public void setData(List<StoryDTO> data) {
    this.data = data;
  }

  public List<StoryDTO> getData() {
    return this.data;
  }

  public void setOk(boolean ok) {
    this.ok = ok;
  }

  public boolean getOk() {
    return this.ok;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
