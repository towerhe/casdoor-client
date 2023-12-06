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
import com.yicenyun.casdoor.client.entity.CasdoorUser;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;
import com.yicenyun.casdoor.client.service.CasdoorUserService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorUserServiceTest {
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorUserService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorUserService.class);
    }

    @Test
    public void testGetUser() throws Exception {
        CasdoorUser casdoorUser = subject.getUser("towerhe").execute().body().getData();
        assertNotNull(casdoorUser);
        casdoorUser = subject.getUserByEmail("towerhe@gmail.com").execute().body().getData();
        assertNotNull(casdoorUser);
    }

    @Test
    public void testGetUsers() throws Exception {
        List<CasdoorUser> casdoorUsers = subject.getUsers().execute().body().getData();
        assertNotNull(casdoorUsers);
    }

    @Test
    public void testGetUserCount() throws Exception {
        int count = subject.getUserCount("").execute().body().getData();
        assertTrue(count >= 0);
    }

    @Test
    public void testModifyUser() throws IOException {
        CasdoorUser user = new CasdoorUser();
        user.setOwner("yicenyun");
        user.setName("test-modify-user");
        CasdoorActionResponse response = subject.addUser(user).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());

        CasdoorUser createdUser = subject.getUser("test-modify-user").execute().body().getData();

        createdUser.setDisplayName("test-display-name");
        response = subject.updateUser("test-modify-user", createdUser).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());

        response = subject.deleteUser(createdUser).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());
    }

    @Test
    public void testQueryUsers() throws IOException {
        CasdoorResponse<List<CasdoorUser>, Integer> response = subject
                .getUsers(new QueryCommand.Builder().page(1, 10).build()).execute().body();

        List<CasdoorUser> users = response.getData();
        int data2 = response.getData2();

        assertFalse(users.isEmpty());
        assertTrue(data2 > 0);
    }

}
