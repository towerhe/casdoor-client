package com.yicenyun.casdoor.client.service;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yicenyun.casdoor.client.config.CasdoorConfig;
import com.yicenyun.casdoor.client.exception.CasdoorException;
import com.yicenyun.casdoor.client.response.CasdoorResponse;
import com.yicenyun.casdoor.client.util.Map;
import com.yicenyun.casdoor.client.util.http.HttpClient;

import okhttp3.Credentials;

public abstract class CasdoorService {
    protected final ObjectMapper objectMapper = new ObjectMapper(){{
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }};

    protected final CasdoorConfig casdoorConfig;
    protected final String credential;
    protected CasdoorService(CasdoorConfig casdoorConfig) {
        this.casdoorConfig = casdoorConfig;
        this.credential = Credentials.basic(casdoorConfig.getClientId(), casdoorConfig.getClientSecret());
    }

    protected <T1, T2> CasdoorResponse<T1, T2> doGet(@NotNull String action, @Nullable java.util.Map<String, String> queryParams, TypeReference<CasdoorResponse<T1, T2>> typeReference) throws IOException {
        String url = String.format("%s/api/%s?%s", casdoorConfig.getEndpoint(), action, Map.mapToUrlParams(queryParams));
        String response = HttpClient.syncGet(url, credential);
        CasdoorResponse<T1, T2> resp = objectMapper.readValue(response, typeReference);
        if (!Objects.equals(resp.getStatus(), "ok")) {
            throw new CasdoorException(String.format("Failed fetching %s : %s", url, resp.getMsg()));
        }

        return resp;
    }

    protected <T1, T2> CasdoorResponse<T1, T2> doPost(@NotNull String action, @Nullable java.util.Map<String, String> queryParams, java.util.Map<String, String> postForm, TypeReference<CasdoorResponse<T1, T2>> typeReference) throws IOException {
        String url = String.format("%s/api/%s?%s", casdoorConfig.getEndpoint(), action, Map.mapToUrlParams(queryParams));
        String response = HttpClient.postForm(url, postForm, credential);
        CasdoorResponse<T1, T2> resp = objectMapper.readValue(response, typeReference);
        if (!Objects.equals(resp.getStatus(), "ok")) {
            throw new CasdoorException(String.format("Failed fetching %s : %s", url, resp.getMsg()));
        }

        return resp;
    }

    protected <T1, T2> CasdoorResponse<T1, T2> doPost(@NotNull String action, @Nullable java.util.Map<String, String> queryParams, String postString, TypeReference<CasdoorResponse<T1, T2>> typeReference) throws IOException {
        String url = String.format("%s/api/%s?%s", casdoorConfig.getEndpoint(), action, Map.mapToUrlParams(queryParams));
        String response = HttpClient.postString(url, postString, credential);
        CasdoorResponse<T1, T2> resp = objectMapper.readValue(response, typeReference);
        if (!Objects.equals(resp.getStatus(), "ok")) {
            throw new CasdoorException(String.format("Failed fetching %s : %s", url, resp.getMsg()));
        }

        return resp;
    }

    protected <T1, T2> CasdoorResponse<T1, T2> doPost(String action, @Nullable java.util.Map<String, String> queryParams, File postFile, TypeReference<CasdoorResponse<T1, T2>> typeReference) throws IOException {
        String url = String.format("%s/api/%s?%s", casdoorConfig.getEndpoint(), action, Map.mapToUrlParams(queryParams));
        String response = HttpClient.postFile(url, postFile, credential);
        CasdoorResponse<T1, T2> resp = objectMapper.readValue(response, typeReference);
        if (!Objects.equals(resp.getStatus(), "ok")) {
            throw new CasdoorException(String.format("Failed fetching %s : %s", url, resp.getMsg()));
        }

        return resp;
    }
}
