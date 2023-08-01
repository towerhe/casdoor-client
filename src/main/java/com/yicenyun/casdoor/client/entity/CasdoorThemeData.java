package com.yicenyun.casdoor.client.entity;

public class CasdoorThemeData {
    private String themeType;
    private String colorPrimary;
    private Integer borderRadius;
    private Boolean isCompact;
    private Boolean isEnabled;

    public String getThemeType() {
        return themeType;
    }

    public void setThemeType(String themeType) {
        this.themeType = themeType;
    }

    public String getColorPrimary() {
        return colorPrimary;
    }

    public void setColorPrimary(String colorPrimary) {
        this.colorPrimary = colorPrimary;
    }

    public Integer getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(Integer borderRadius) {
        this.borderRadius = borderRadius;
    }

    public Boolean getIsCompact() {
        return isCompact;
    }

    public void setIsCompact(Boolean isCompact) {
        this.isCompact = isCompact;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public String toString() {
        return "ThemeData{" +
                "themeType='" + themeType + '\'' +
                ", colorPrimary='" + colorPrimary + '\'' +
                ", borderRadius=" + borderRadius +
                ", isCompact=" + isCompact +
                ", isEnabled=" + isEnabled +
                '}';
    }

}
