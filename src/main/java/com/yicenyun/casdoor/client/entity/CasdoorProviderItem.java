package com.yicenyun.casdoor.client.entity;

public class CasdoorProviderItem {

    private String owner;
    private String name;
    private Boolean canSignup;
    private Boolean canSignin;
    private Boolean canUnlink;
    private Boolean prompted;
    private String alertType;
    private String rule;
    private CasdoorProvider provider;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCanSignup() {
        return canSignup;
    }

    public void setCanSignup(Boolean canSignup) {
        this.canSignup = canSignup;
    }

    public Boolean getCanSignin() {
        return canSignin;
    }

    public void setCanSignin(Boolean canSignin) {
        this.canSignin = canSignin;
    }

    public Boolean getCanUnlink() {
        return canUnlink;
    }

    public void setCanUnlink(Boolean canUnlink) {
        this.canUnlink = canUnlink;
    }

    public Boolean getPrompted() {
        return prompted;
    }

    public void setPrompted(Boolean prompted) {
        this.prompted = prompted;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public CasdoorProvider getProvider() {
        return provider;
    }

    public void setProvider(CasdoorProvider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "ProviderItem{" +
                "owner='" + owner + '\'' +
                "name='" + name + '\'' +
                ", canSignup=" + canSignup +
                ", canSignin=" + canSignin +
                ", canUnlink=" + canUnlink +
                ", prompted=" + prompted +
                ", alertType='" + rule + '\'' +
                ", rule='" + rule + '\'' +
                ", provider=" + provider +
                '}';
    }

}
