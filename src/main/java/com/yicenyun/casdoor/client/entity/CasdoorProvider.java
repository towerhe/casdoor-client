package com.yicenyun.casdoor.client.entity;

import java.util.Map;

public class CasdoorProvider {

    private String owner;
    private String name;
    private String createdTime;

    private String displayName;
    private String category;
    private String type;
    private String subType;
    private String method;
    private String clientId;
    private String clientSecret;
    private String clientId2;
    private String clientSecret2;
    private String cert;
    private String customAuthUrl;
    private String customTokenUrl;
    private String customUserInfoUrl;
    private String customLogo;
    private String scopes;
    private Map<String, String> userMapping;

    private String host;
    private Integer port;
    private Boolean disableSsl;
    private String title;
    private String content;
    private String receiver;

    private String regionId;
    private String signName;
    private String templateCode;
    private String appId;

    private String endpoint;
    private String intranetEndpoint;
    private String domain;
    private String bucket;
    private String pathPrefix;

    private String metaData;
    private String idP;
    private String issuerUrl;
    private Boolean enableSignAuthnRequest;

    private String providerUrl;

    @Override
    public String toString() {
        return "Provider{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", createdTime='" + createdTime + '\'' +

                ", displayName='" + displayName + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", method='" + method + '\'' +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", clientId2='" + clientId2 + '\'' +
                ", clientSecret2='" + clientSecret2 + '\'' +
                ", cert='" + cert + '\'' +
                ", customAuthUrl='" + customAuthUrl + '\'' +
                ", customTokenUrl='" + customTokenUrl + '\'' +
                ", customUserInfoUrl='" + customUserInfoUrl + '\'' +
                ", customLogo='" + customLogo + '\'' +
                ", scopes='" + scopes + '\'' +
                ", userMapping=" + userMapping +

                ", host='" + host + '\'' +
                ", port=" + port +
                ", disableSsl=" + disableSsl +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", receiver='" + receiver + '\'' +

                ", regionId='" + regionId + '\'' +
                ", signName='" + signName + '\'' +
                ", templateCode='" + templateCode + '\'' +
                ", appId='" + appId + '\'' +

                ", endpoint='" + endpoint + '\'' +
                ", intranetEndpoint='" + intranetEndpoint + '\'' +
                ", domain='" + domain + '\'' +
                ", bucket='" + bucket + '\'' +
                ", pathPrefix='" + pathPrefix + '\'' +

                ", metaData='" + metaData + '\'' +
                ", idP='" + idP + '\'' +
                ", issuerUrl='" + issuerUrl + '\'' +
                ", enableSignAuthnRequest=" + enableSignAuthnRequest +

                ", providerUrl='" + providerUrl + '\'' +
                '}';
    }

}
