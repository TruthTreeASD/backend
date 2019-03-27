package edu.northeastern.truthtree.dto;

public class StoryDTOWrapper {
  private int respCode;
  private StoryDTO data;
  private boolean ok;
  private String message;

  public void setRespCode(int respCode){
    this.respCode = respCode;
  }

  public int getRespCode(){
    return this.respCode;
  }

  public void setData(StoryDTO data){
    this.data = data;
  }

  public StoryDTO getData(){
    return this.data;
  }

  public void setOk(boolean ok){
    this.ok = ok;
  }

  public boolean getOk(){
    return this.ok;
  }

  public String getMessage(){
    return this.message;
  }

  public void setMessage(String message){
    this.message = message;
  }


}
