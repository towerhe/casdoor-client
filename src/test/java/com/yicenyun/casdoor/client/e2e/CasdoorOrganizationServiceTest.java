package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorOrganization;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.service.CasdoorOrganizationService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorOrganizationServiceTest {
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorOrganizationService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorOrganizationService.class);
    }

    @Test
    public void testGetOrganization() throws Exception {
        CasdoorOrganization organization = subject.getOrganization("admin/built-in").execute().body().getData();
        assertNotNull(organization);
    }

    @Test
    public void testGetOrganizations() throws Exception {
        List<CasdoorOrganization> organizations = subject.getOrganizations().execute().body().getData();
        assertNotNull(organizations);
    }

    @Test
    public void testQueryOrganizations() throws Exception {
        QueryCommand command = new QueryCommand.Builder().page(1, 15).build();
        List<CasdoorOrganization> organizations = subject.getOrganizations(command)
                .execute().body().getData();
        assertNotNull(organizations);
    }

    @Test
    public void testGetOrganizationNames() throws Exception {
        List<CasdoorOrganization> organizations = subject.getOrganizationNames().execute().body().getData();
        assertNotNull(organizations);
    }

    @Test
    public void testModifyOrganization() throws IOException {
        CasdoorOrganization organization = new CasdoorOrganization();
        organization.setOwner("admin");
        organization.setName("test-modify-organization");
        CasdoorActionResponse response = subject.addOrganization(organization).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());

        CasdoorOrganization created = subject.getOrganization("admin/test-modify-organization").execute().body().getData();

        created.setDisplayName("test-display-name");
        response = subject.updateOrganization("admin/test-modify-organization",
                created).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());

        response = subject.deleteOrganization(created).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());
    }

}
