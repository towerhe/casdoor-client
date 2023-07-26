package com.yicenyun.casdoor.client.e2e;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.entity.CasdoorResource;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.service.CasdoorResourceService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CasdoorResourceServiceTest {

    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorResourceService subject;

    @Before
    public void setUp() {
        subject = client.createService(CasdoorResourceService.class);
    }

    @Test
    public void testResourceService() throws IOException {
        String user = "admin";
        String tag = "";
        String parent = "";
        File file = new File(this.getClass().getResource("/casbin.svg").getFile());
        String fullFilePath = String.format("%s/%s/%s", tag, "built-in", file.getName());
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(),
                RequestBody.create(file, MediaType.parse("image/svg+xml")));

        CasdoorActionResponse response = subject.uploadResource(user, "app-built-in", tag, parent,
                fullFilePath, filePart).execute().body();
        Assert.assertEquals("ok", response.getStatus());

        response = subject.deleteResource(new CasdoorResource("built-in", file.getName())).execute().body();
        Assert.assertEquals("ok", response.getStatus());
    }
}
