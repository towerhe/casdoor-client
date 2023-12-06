package com.yicenyun.casdoor.client.support;

import java.io.IOException;

import com.yicenyun.casdoor.client.config.CasdoorConfig;

public class CasdoorConfigProvider {
    public static CasdoorConfig get() {
        CasdoorConfig config = new CasdoorConfig();

        config.setEndpoint("http://localhost:8000");
        config.setClientId("d119d4d1601b11da1460");
        config.setClientSecret("1cc6ed68d9cfd992473238e390e0c9737fb6c2fd");
        try {
            config.setCertificate(FileUtils.readResource("/certificate.pem"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        config.setOrganizationName("yicenyun");
        config.setApplicationName("yicenyun-site");

        return config;
    }
}
