package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.LoginCommand;
import com.yicenyun.casdoor.client.command.LoginQueryParams;
import com.yicenyun.casdoor.client.command.LogoutQueryParams;
import com.yicenyun.casdoor.client.command.LoginQueryParams.ResponseType;
import com.yicenyun.casdoor.client.config.CasdoorConfig;
import com.yicenyun.casdoor.client.entity.CasdoorMfa;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;
import com.yicenyun.casdoor.client.service.CasdoorAuthService;
import com.yicenyun.casdoor.client.service.CasdoorLoginService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;
import com.yicenyun.casdoor.client.support.CasdoorConfigProvider;

class CasdoorLoginServiceTest {
    private CasdoorConfig config = CasdoorConfigProvider.get();
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorLoginService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorLoginService.class);
    }

    @Test
    void loginAndLogout() throws IOException {
        /* Given */
        LoginQueryParams queryParams = new LoginQueryParams.Builder().clientId(config.getClientId())
                .responseType(ResponseType.CODE).redirectUri("http://localhost:22502/oauth/callback")
                .scope("openid profile email phone")
                .state(config.getApplicationName()).build();
        LoginCommand command = new LoginCommand.Builder().type(ResponseType.CODE).username("towerhe")
                .password("towerhe").application(config.getApplicationName()).organization(config.getOrganizationName())
                .build();

        /* When */
        CasdoorResponse<String, CasdoorMfa> response = subject.login(queryParams.toMap(), command).execute().body();
        /* Then */
        assertEquals("ok", response.getStatus());
        assertNotNull(response.getData());

        /* Given */
        String token = client.createService(CasdoorAuthService.class).getOAuthToken(response.getData(),
                config.getApplicationName());
        /* When */
        CasdoorActionResponse response2 = subject.logout(
                new LogoutQueryParams.Builder().idTokenHint(token).state(config.getApplicationName()).build().toMap())
                .execute().body();
        /* Then */
        assertEquals("ok", response2.getStatus());
    }

}
