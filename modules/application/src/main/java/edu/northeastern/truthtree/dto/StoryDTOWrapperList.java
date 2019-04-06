package edu.northeastern.truthtree.dto;

public class StoryDTOWrapperList {
  private int respCode;
  private boolean ok;
  private String message;

  public StoryPaginationResponseDTO getData() {
    return data;
  }

  public void setData(StoryPaginationResponseDTO data) {
    this.data = data;
  }

  private StoryPaginationResponseDTO data;

  public void setRespCode(int respCode) {
    this.respCode = respCode;
  }

  public int getRespCode() {
    return this.respCode;
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
