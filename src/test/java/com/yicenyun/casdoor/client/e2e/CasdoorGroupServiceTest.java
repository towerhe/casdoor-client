package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorGroup;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.service.CasdoorGroupService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorGroupServiceTest {
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorGroupService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorGroupService.class);
    }

    @Test
    public void testGetGroup() throws Exception {
        CasdoorGroup group = subject.getGroup("test-group").execute().body().getData();
        assertNotNull(group);
    }

    @Test
    public void testGetGroups() throws Exception {
        List<CasdoorGroup> groups = subject.getGroups().execute().body().getData();
        assertNotNull(groups);
    }

    @Test
    public void testQueryGroups() throws Exception {
        QueryCommand command = new QueryCommand.Builder().page(1, 15).build();
        List<CasdoorGroup> groups = subject.getGroups(command, false)
                .execute().body().getData();
        assertNotNull(groups);
    }

    @Test
    public void testModifyGroup() throws IOException {
        CasdoorGroup group = new CasdoorGroup();
        group.setOwner("built-in");
        group.setName("test-modify-group");
        CasdoorActionResponse response = subject.addGroup(group).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());

        CasdoorGroup created = subject.getGroup("test-modify-group").execute().body().getData();

        created.setDisplayName("test-display-name");
        response = subject.updateGroup("test-modify-group",
                created).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());

        response = subject.deleteGroup(created).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());
    }

}
