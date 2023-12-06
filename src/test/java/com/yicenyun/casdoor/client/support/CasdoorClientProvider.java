package com.yicenyun.casdoor.client.support;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.config.CasdoorConfig;

import okhttp3.logging.HttpLoggingInterceptor.Level;

public class CasdoorClientProvider {
    private static final CasdoorConfig CONFIG = CasdoorConfigProvider.get();

    private CasdoorClientProvider() {
    }

    public static CasdoorClient get() {
        return get(CONFIG.getEndpoint());
    }

    public static CasdoorClient get(String endpoint) {
        return new CasdoorClient.Builder()
                .endpoint(endpoint)
                .baseUri("api")
                .clientId(CONFIG.getClientId())
                .clientSecret(CONFIG.getClientSecret())
                .certificate(CONFIG.getCertificate())
                .organizationName(CONFIG.getOrganizationName())
                .applicationName(CONFIG.getApplicationName())
                .log(Level.BODY)
                .build();
    }

}
