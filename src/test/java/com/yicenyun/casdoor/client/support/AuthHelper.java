package com.yicenyun.casdoor.client.support;

import java.io.IOException;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.LoginCommand;
import com.yicenyun.casdoor.client.command.LoginQueryParams;
import com.yicenyun.casdoor.client.command.LoginQueryParams.ResponseType;
import com.yicenyun.casdoor.client.config.CasdoorConfig;
import com.yicenyun.casdoor.client.entity.CasdoorMfa;
import com.yicenyun.casdoor.client.response.CasdoorResponse;
import com.yicenyun.casdoor.client.service.CasdoorAuthService;
import com.yicenyun.casdoor.client.service.CasdoorLoginService;

public class AuthHelper {
    private static final CasdoorConfig CONFIG = CasdoorConfigProvider.get();
    private static final CasdoorClient CLIENT = CasdoorClientProvider.get();

    private AuthHelper() {
    }

    public static String login() throws IOException {
        LoginQueryParams queryParams = new LoginQueryParams.Builder().clientId(CONFIG.getClientId())
                .responseType(ResponseType.CODE).redirectUri("http://localhost:22502/oauth/callback")
                .scope("openid profile email phone")
                .state(CONFIG.getApplicationName()).build();
        LoginCommand command = new LoginCommand.Builder().type(ResponseType.CODE).username("towerhe")
                .password("towerhe").application(CONFIG.getApplicationName()).organization(CONFIG.getOrganizationName())
                .build();

        CasdoorResponse<String, CasdoorMfa> response = CLIENT.createService(CasdoorLoginService.class)
                .login(queryParams.toMap(), command).execute().body();

        return response.getData();
    }

    public static String getToken() throws IOException {
        return CLIENT.createService(CasdoorAuthService.class).getOAuthToken(login(), CONFIG.getApplicationName());
    }
}
