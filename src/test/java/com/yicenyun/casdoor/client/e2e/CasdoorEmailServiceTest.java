package com.yicenyun.casdoor.client.e2e;

import java.io.IOException;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.SendEmailCommand;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.service.CasdoorEmailService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorEmailServiceTest {
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorEmailService subject;

    @Before
    public void setUp() {
        subject = client.createService(CasdoorEmailService.class);
    }

    @Test
    public void testSendEmail() throws IOException {
        String title = "Casdoor Verification Code";
        String content = String.format(
                "You have requested a verification code at Casdoor. Here is your code: %s, please enter in 5 minutes.",
                randomCode());
        String sender = "";
        String receiver = "";
        CasdoorActionResponse response = subject.sendEmail(new SendEmailCommand(title, content, sender, receiver)).execute().body();
        Assert.assertEquals("ok", response.getStatus());
    }

    private static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
