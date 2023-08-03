package com.yicenyun.casdoor.client;

import java.util.Objects;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yicenyun.casdoor.client.config.CasdoorConfig;
import com.yicenyun.casdoor.client.interceptor.AuthenticationInterceptor;
import com.yicenyun.casdoor.client.interceptor.CasdoorIdInterceptor;
import com.yicenyun.casdoor.client.interceptor.RequireOwnerInQueryInterceptor;
import com.yicenyun.casdoor.client.interceptor.QueryCommandInterceptor;
import com.yicenyun.casdoor.client.service.CasdoorAuthService;
import com.yicenyun.casdoor.client.service.CasdoorEnforcerService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public final class CasdoorClient {

    private final CasdoorConfig config;

    private final String baseUrl;
    private final Level logLevel;

    private final Retrofit retrofit;

    CasdoorClient(String endpoint, String baseUri, String clientId, String clientSecret, String certificate,
            String organizationName, String applicationName, Level logLevel) {
        this.config = new CasdoorConfig(endpoint, clientId, clientSecret, certificate, organizationName,
                applicationName);
        this.baseUrl = String.format("%s/%s/", endpoint, baseUri);
        this.logLevel = logLevel;

        this.retrofit = buildRetrofit();
    }

    @SuppressWarnings("unchecked")
    public <T> T createService(Class<T> clazz) {
        if (Objects.equals(CasdoorAuthService.class, clazz)) {
            return (T) new CasdoorAuthService(config);
        }
        if (Objects.equals(CasdoorEnforcerService.class, clazz)) {
            return (T) new CasdoorEnforcerService(config);
        }

        return retrofit.create(clazz);
    }

    private Retrofit buildRetrofit() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(config.getClientId(), config.getClientSecret()))
                .addInterceptor(new RequireOwnerInQueryInterceptor(config.getOrganizationName()))
                .addInterceptor(new CasdoorIdInterceptor(config.getOrganizationName()))
                .addInterceptor(new QueryCommandInterceptor());
        if (logLevel != null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(logLevel);
            httpClientBuilder.addInterceptor(loggingInterceptor);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return new Retrofit.Builder()
                .baseUrl(baseUrl).client(httpClientBuilder.build())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
    }

    public static final class Builder {

        private String baseUri = "api";
        private String endpoint;
        private String clientId;
        private String clientSecret;
        private String certificate;
        private String organizationName;
        private String applicationName;
        private Level logLevel;

        /**
         * @param endpoint entry url of casdoor such as: http://localhost:8000
         * @return an instance of Builder
         */
        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        /**
         * @param baseUri base uri of RESTful APIs, default value is "api"
         * @return an instance of Builder
         */
        public Builder baseUri(String baseUri) {
            this.baseUri = baseUri;
            return this;
        }

        /**
         * @param clientId clientId of the registered application in casdoor
         * @return an instance of Builder
         */
        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /**
         * @param clientSecret clientSecret of the registered application in casdoor
         * @return an instance of Builder
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        /**
         * @param certificate certificate of the registered application in casdoor
         * @return an instance of Builder
         */
        public Builder certificate(String certificate) {
            this.certificate = certificate;
            return this;
        }

        /**
         * @param organizationName organization name of the registered application in casdoor
         * @return an instance of Builder
         */
        public Builder organizationName(String organizationName) {
            this.organizationName = organizationName;
            return this;
        }

        /**
         * @param applicationName name of the registered application in casdoor
         * @return an instance of Builder
         */
        public Builder applicationName(String applicationName) {
            this.applicationName = applicationName;
            return this;
        }

        /**
         * @param level log level of okhttp client
         * @return an instance of Builder
         */
        public Builder log(Level level) {
            this.logLevel = level;
            return this;
        }

        public CasdoorClient build() {
            return new CasdoorClient(endpoint, baseUri, clientId, clientSecret, certificate, organizationName,
                    applicationName, logLevel);
        }
    }
}
