package com.yicenyun.casdoor.client.support;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.junit.After;
import org.junit.Before;

import com.yicenyun.casdoor.client.CasdoorClient;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public abstract class ServiceTestSupport {

    private MockWebServer server = new MockWebServer();
    private CasdoorClient client;

    @Before
    public void setUp() throws IOException {
        server.start();
        client = CasdoorClientProvider.get(server.url("/").toString());
    }

    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }

    protected <T> T createService(Class<T> clazz) {
        return client.createService(clazz);
    }

    protected void enqueueResponse(String responseFile) throws IOException {
        MockResponse response = new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(FileUtils.readResource("/response/organizations.json"));
        enqueueResponse(response);
    }

    protected void enqueueResponse(MockResponse response) {
        server.enqueue(response);
    }
}
