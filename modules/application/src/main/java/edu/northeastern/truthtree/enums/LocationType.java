package edu.northeastern.truthtree.enums;

public enum LocationType {
    STATE(0), CITY(1), COUNTY(2);
    int type;

    LocationType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
