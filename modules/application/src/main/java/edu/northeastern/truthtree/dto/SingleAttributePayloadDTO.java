package edu.northeastern.truthtree.dto;

public class SingleAttributePayloadDTO {

    private int id;
    private int place_type;
    private int attribute;
    private int normalize_by;
    private YearRange year_range;
    private int count;

    SingleAttributePayloadDTO() {}

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

    public int getNormalizeBy() { return normalize_by; }

    public void setNormalizeBy(int normalize_by) {
        this.normalize_by = normalize_by;
    }

    public int getAttribute() { return attribute; }

    public void setAttribute(int attribute) { this.attribute = attribute; }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public YearRange getYearRange() {
        return year_range;
    }

    public void setYearRange(int start, int end) {
        YearRange yearRange = new YearRange(start, end);
        this.year_range = yearRange;
    }

    private class YearRange {
        int start;
        int end;

        YearRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
