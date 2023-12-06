package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.service.CasdoorCasbinApiService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorCasbinApiServiceTest {

    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorCasbinApiService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorCasbinApiService.class);
    }

    @Test
    public void enforceByEnforcer() throws IOException {
        boolean result = subject
                .enforceByEnforcer("api-enforcer-built-in",
                        new String[] { "built-in", "admin", "GET", "/api/organizations", "", "" })
                .execute().body().getData();
        assertTrue(result);

        result = subject
                .enforceByEnforcer("api-enforcer-built-in",
                        new String[] { "maoguang", "mgadmin", "GET", "/api/organizations", "", "" })
                .execute().body().getData();
        assertFalse(result);
    }

    @Test
    public void enforceByPermission() throws IOException {
        Boolean[] result = subject
                .enforceByPermission("permission-built-in",
                        new String[] { "built-in/*", "app-built-in", "read" })
                .execute().body().getData();
        assertTrue(result[0]);

        result = subject
                .enforceByPermission("permission-built-in",
                        new String[] { "built-in/*", "app-built-in", "write" })
                .execute().body().getData();
        assertTrue(result[0]);

        result = subject
                .enforceByPermission("permission-built-in",
                        new String[] { "built-in/*", "app-built-in", "admin" })
                .execute().body().getData();
        assertTrue(result[0]);
    }

    @Test
    public void enforceByModel() throws IOException {
        Boolean[] result = subject
                .enforceByModel("model-built-in",
                        new String[] { "built-in/*", "app-built-in", "read" })
                .execute().body().getData();
        assertTrue(result[0]);

        result = subject
                .enforceByModel("model-built-in",
                        new String[] { "built-in/*", "app-built-in", "write" })
                .execute().body().getData();
        assertTrue(result[0]);

        result = subject
                .enforceByModel("model-built-in",
                        new String[] { "built-in/*", "app-built-in", "admin" })
                .execute().body().getData();
        assertTrue(result[0]);
    }

    @Test
    public void enforceByResource() throws IOException {
        Boolean[] result = subject
                .enforceByResource("app-built-in",
                        new String[] { "built-in/*", "app-built-in", "read" })
                .execute().body().getData();
        assertTrue(result[0]);

        result = subject
                .enforceByResource("app-built-in",
                        new String[] { "built-in/*", "app-built-in", "write" })
                .execute().body().getData();
        assertTrue(result[0]);

        result = subject
                .enforceByResource("app-built-in",
                        new String[] { "built-in/*", "app-built-in", "admin" })
                .execute().body().getData();
        assertTrue(result[0]);
    }

    @Test
    public void batchEnforceByEnforcer() throws IOException {
        Boolean[] result = subject
                .batchEnforceByEnforcer("built-in/api-enforcer-built-in",
                        new String[][] {
                                new String[] { "built-in", "admin", "GET", "/api/organizations", "", "" },
                                new String[] { "maoguang", "mgadmin", "GET", "/api/organizations", "", "" } })
                .execute().body().getData();
        assertTrue(result[0]);
        assertFalse(result[1]);
    }

    @Test
    public void batchEnforceByPermission() throws IOException {
        Boolean[][] result = subject
                .batchEnforceByPermission("permission-built-in",
                        new String[][] {
                                new String[] { "built-in/*", "app-built-in", "read" },
                                new String[] { "built-in/*", "app-built-in", "write" },
                                new String[] { "built-in/*", "app-built-in", "admin" } })
                .execute().body().getData();
        assertTrue(result[0][0]);
        assertTrue(result[0][1]);
        assertTrue(result[0][2]);
    }

    @Test
    public void batchEnforceByModel() throws IOException {
        Boolean[][] result = subject
                .batchEnforceByModel("model-built-in",
                        new String[][] {
                                new String[] { "built-in/*", "app-built-in", "read" },
                                new String[] { "built-in/*", "app-built-in", "write" },
                                new String[] { "built-in/*", "app-built-in", "admin" } })
                .execute().body().getData();
        assertTrue(result[0][0]);
        assertTrue(result[0][1]);
        assertTrue(result[0][2]);
    }

}
