package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorToken;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;
import com.yicenyun.casdoor.client.service.CasdoorTokenService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorTokenServiceTest {
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorTokenService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorTokenService.class);
    }

    @Test
    public void testDeleteTokens() throws IOException {
        CasdoorToken token = new CasdoorToken();
        token.setAccessToken("string");
        token.setApplication("string");
        token.setCodeChallenge("string");
        token.setCreatedTime("string");
        token.setOrganization("string");
        token.setRefreshToken("string");
        token.setUser("string");
        token.setScope("string");
        token.setTokenType("string");
        token.setExpiresIn(0);
        token.setCodeIsUsed(true);
        token.setExpiresIn(0);

        token.setName("test-delete-token");
        token.setOwner("admin");
        CasdoorActionResponse response = subject.deleteToken(token).execute().body();
        assertEquals("ok", response.getStatus());
        assertEquals("Affected", response.getData());
    }

    @Test
    public void testQueryTokens() throws IOException {
        CasdoorResponse<List<CasdoorToken>, Integer> response = subject
                .getTokens(new QueryCommand.Builder().page(1, 10).build()).execute().body();
        assertFalse(response.getData().isEmpty());
        assertTrue(response.getData2() > 0);
    }

}
