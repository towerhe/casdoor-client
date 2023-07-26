package com.yicenyun.casdoor.client.e2e;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.junit.Assert;
import org.junit.Test;

import com.yicenyun.casdoor.client.entity.CasdoorUser;
import com.yicenyun.casdoor.client.exception.CasdoorException;
import com.yicenyun.casdoor.client.service.CasdoorAuthService;

public class CasdoorAuthServiceTest extends CasdoorServiceTestSupport {
    @Test
    public void testAuthService() throws OAuthProblemException, OAuthSystemException, CasdoorException, InvocationTargetException, IllegalAccessException {
        String code = "71b645e73381caeb2c66";
        CasdoorAuthService casdoorAuthService = new CasdoorAuthService(this.casdoorConfig);
        String token = casdoorAuthService.getOAuthToken(code, "app-built-in");
        Assert.assertNotNull(token);
        CasdoorUser casdoorUser = casdoorAuthService.parseJwtToken(token);
        Assert.assertNotNull(casdoorUser);
    }

    @Test
    public void testGetSigninUel() throws UnsupportedEncodingException {
        CasdoorAuthService casdoorAuthService = new CasdoorAuthService(this.casdoorConfig);
        String signinUrl = casdoorAuthService.getSigninUrl("http://localhost:3000/callback");
        System.out.println(signinUrl);
        Assert.assertNotEquals("", signinUrl);
    }
}
