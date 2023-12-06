package com.yicenyun.casdoor.client.entity;

public class CasdoorMfa {
    private String id;
    private Boolean isPreferred;
    private String type;
    private String secret;
    private String url;
    private String[] recoveryCodes;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Boolean getIsPreferred() {
        return isPreferred;
    }
    public void setIsPreferred(Boolean isPreferred) {
        this.isPreferred = isPreferred;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String[] getRecoveryCodes() {
        return recoveryCodes;
    }
    public void setRecoveryCodes(String[] recoveryCodes) {
        this.recoveryCodes = recoveryCodes;
    }


}
