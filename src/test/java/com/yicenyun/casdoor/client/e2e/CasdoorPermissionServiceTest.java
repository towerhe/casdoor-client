package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorPermission;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;
import com.yicenyun.casdoor.client.service.CasdoorPermissionService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorPermissionServiceTest {
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorPermissionService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorPermissionService.class);
    }

    @Test
    public void testGetPermission() throws IOException {
        CasdoorPermission permission = subject.getPermission("permission-built-in").execute().body().getData();
        assertNotNull(permission);

    }

    @Test
    public void testGetPermissions() throws IOException {
        List<CasdoorPermission> permissions = subject.getPermissions().execute().body().getData();
        assertNotNull(permissions);
    }

    @Test
    public void testModifyPermission() throws IOException {
        CasdoorPermission permission = new CasdoorPermission();
        permission.setOwner("built-in");
        permission.setName("test-modify-permission");
        CasdoorActionResponse response = subject.addPermission(permission).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());

        permission.setDisplayName("test-display-name");
        response = subject.updatePermission("test-modify-permission", permission).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());

        response = subject.deletePermission(permission).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());
    }

    @Test
    public void testQueryPermissions() throws IOException {
        CasdoorResponse<List<CasdoorPermission>, Integer> response = subject
                .getPermissions(new QueryCommand.Builder().page(1, 10).build()).execute().body();
        assertNotNull(response);

        List<CasdoorPermission> permissions = response.getData();
        int count = response.getData2();

        assertFalse(permissions.isEmpty());
        assertTrue(count > 0);

    }

    @Test
    public void testGetPermissionsByRole() throws IOException {
        List<CasdoorPermission> permissions = subject
                .getPermissionsByRole("permission-built-in", "permission-built-in").execute().body().getData();
        assertNotNull(permissions);
    }
}
