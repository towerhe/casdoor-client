package com.yicenyun.casdoor.client.entity;

public class CasdoorSignupItem {
    private String name;
    private Boolean visible;
    private Boolean required;
    private Boolean prompted;
    private String rule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getPrompted() {
        return prompted;
    }

    public void setPrompted(Boolean prompted) {
        this.prompted = prompted;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "SignupItem{" +
                "name='" + name + '\'' +
                ", visible=" + visible +
                ", required=" + required +
                ", prompted=" + prompted +
                ", rule='" + rule + '\'' +
                '}';
    }

}
