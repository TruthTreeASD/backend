package edu.northeastern.truthtree.dto;

public class LocationDTOWrapper {

    private int respCode;
    private LocationDTO data;
    private boolean ok;
    private String message;

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public int getRespCode() {
        return this.respCode;
    }

    public void setData(LocationDTO data) {
        this.data = data;
    }

    public LocationDTO getData() {
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

    public LocationDTOWrapper() {}
}
