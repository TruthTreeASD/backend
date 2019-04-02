package edu.northeastern.truthtree.dto;

import java.util.ArrayList;
import java.util.List;

public class MultipleAttributesPayloadDTO {

    private int id;
    private int place_type;
    private int year;
    private List<Integer> attributes;
    private int normalize_by;
    private int count;

    MultipleAttributesPayloadDTO() {
        this.attributes = new ArrayList<Integer>();
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaceType() {
        return place_type;
    }

    public void setPlaceType(int place_type) {
        this.place_type = place_type;
    }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public List<Integer> getAttribute() { return attributes; }

    public void setAttribute(List<Integer> attributes) {
        for(Integer attribute : attributes) {
            this.attributes.add(attribute);
        }
    }

    public int getNormalizeBy() { return normalize_by; }

    public void setNormalizeBy(int normalizeBy) { this.normalize_by = normalizeBy; }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

}
