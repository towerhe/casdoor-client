package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.entity.CasdoorUser;
import com.yicenyun.casdoor.client.exception.CasdoorException;
import com.yicenyun.casdoor.client.service.CasdoorAuthService;

public class CasdoorAuthServiceTest extends CasdoorServiceTestSupport {
    @Test
    public void testAuthService() throws OAuthProblemException, OAuthSystemException, CasdoorException, InvocationTargetException, IllegalAccessException {
        String code = "71b645e73381caeb2c66";
        CasdoorAuthService casdoorAuthService = new CasdoorAuthService(this.casdoorConfig);
        String token = casdoorAuthService.getOAuthToken(code, "yicenyun-site");
        assertNotNull(token);
        CasdoorUser casdoorUser = casdoorAuthService.parseJwtToken(token);
        assertNotNull(casdoorUser);
    }

    @Test
    public void testGetSigninUrl() throws UnsupportedEncodingException {
        CasdoorAuthService casdoorAuthService = new CasdoorAuthService(this.casdoorConfig);
        String signinUrl = casdoorAuthService.getSigninUrl("http://localhost:3000/callback");
        System.out.println(signinUrl);
        assertNotEquals("", signinUrl);
    }
}
