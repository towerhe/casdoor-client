package com.yicenyun.casdoor.client.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yicenyun.casdoor.client.entity.CasdoorOrganization;
import com.yicenyun.casdoor.client.response.CasdoorResponse;
import com.yicenyun.casdoor.client.support.ServiceTestSupport;

public class CasdoorOrganizationServiceTest extends ServiceTestSupport {
    private CasdoorOrganizationService subject;

    @Before
    public void init() {
        subject = createService(CasdoorOrganizationService.class);
    }

    @Test
    public void getOrganizations() throws IOException {
        /* Given */
        enqueueResponse("/response/organizations.json");
        /* When */
        CasdoorResponse<List<CasdoorOrganization>, Integer> response = subject.getOrganizations().execute().body();
        /* Then */
        assertEquals(2, response.getData2().intValue());
        assertEquals(2, response.getData().size());
    }

    @Test
    public void getOrganizationNames() throws IOException {
        /* Given */
        enqueueResponse("/response/organization-names.json");
        /* When */
        CasdoorResponse<List<CasdoorOrganization>, Object> response = subject.getOrganizationNames().execute().body();
        /* Then */
        assertEquals(2, response.getData().size());
    }
}
