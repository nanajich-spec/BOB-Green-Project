package com.bob.app.dto;

public class ZoneDTO {
    private String zoAlpha;
    private String zoName;

    public ZoneDTO(String zoAlpha, String zoName) {
        this.zoAlpha = zoAlpha;
        this.zoName = zoName;
    }

    public String getZoAlpha() {
        return zoAlpha;
    }

    public String getZoName() {
        return zoName;
    }
}
