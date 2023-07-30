package com.yicenyun.casdoor.client.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.yicenyun.casdoor.client.CasdoorClient;

import okhttp3.logging.HttpLoggingInterceptor.Level;

public class CasdoorClientProvider {
    private CasdoorClientProvider() {
    }

    public static CasdoorClient get() {
        return get("http://localhost:8000");
    }

    public static CasdoorClient get(String endpoint) {
        return new CasdoorClient.Builder()
                .endpoint(endpoint)
                .baseUri("api")
                .clientId("32429b048ffbfc93cb99")
                .clientSecret("4e191daebd5e4616139a2aa7ea1f1d86d48e40ec")
                .certificate(getCertificate())
                .organizationName("built-in")
                .applicationName("app-built-in")
                .log(Level.BODY)
                .build();
    }

    private static String getCertificate() {
        InputStream inputStream = CasdoorClientProvider.class.getResourceAsStream("/certificate.pem");
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return resultStringBuilder.toString().trim();
    }
}
