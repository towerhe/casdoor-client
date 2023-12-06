package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.SendSmsCommand;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.service.CasdoorSmsService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorSmsServiceTest {
        private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorSmsService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorSmsService.class);
    }

    @Test
    public void testSendSms() throws IOException {
        String receiver = "";
        CasdoorActionResponse response = subject.sendSms(new SendSmsCommand("admin/" + randomCode(), receiver)).execute().body();
        assertEquals("ok", response.getStatus());
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
