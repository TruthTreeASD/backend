package edu.northeastern.truthtree.dto;

public class SingleAttributePayloadDTO {

    private String id;
    private String place_type;
    private String attribute;
    private String normalize_by;
    private YearRange year_range;
    private String count;

    SingleAttributePayloadDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace_type() {
        return place_type;
    }

    public void setPlace_type(String place_type) {
        this.place_type = place_type;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getNormalize_by() {
        return normalize_by;
    }

    public void setNormalize_by(String normalize_by) {
        this.normalize_by = normalize_by;
    }

    public YearRange getYear_range() {
        return year_range;
    }

    public void setYear_range(YearRange year_range) {
        this.year_range = year_range;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    private class YearRange {
        String start;
        String end;

        YearRange(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
