package com.yicenyun.casdoor.client.e2e;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorApplication;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.service.CasdoorApplicationService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorApplicationServiceTest {
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorApplicationService subject;

    @Before
    public void setUp() {
        subject = client.createService(CasdoorApplicationService.class);
    }

    @Test
    public void testGetApplications() throws Exception {
        List<CasdoorApplication> applications = subject.getApplications().execute().body().getData();
        Assert.assertNotNull(applications);
    }

    @Test
    public void testQueryApplications() throws Exception {
        QueryCommand command = new QueryCommand.Builder().page(1, 15).build();
        List<CasdoorApplication> applications = subject.getApplications(command)
                .execute().body().getData();
        Assert.assertNotNull(applications);
    }

    @Test
    public void testModifyApplication() throws IOException {
        CasdoorApplication application = new CasdoorApplication();
        application.setOwner("admin");
        application.setName("test-modify-application");
        CasdoorActionResponse response = subject.addApplication(application).execute().body();
        Assert.assertEquals("ok", response.getStatus());
        Assert.assertEquals("Affected", response.getData());

        CasdoorApplication created = subject.getApplication("admin/test-modify-application").execute().body().getData();

        created.setDisplayName("test-display-name");
        response = subject.updateApplication("admin/test-modify-application",
                created).execute().body();
        Assert.assertEquals("ok", response.getStatus());
        Assert.assertEquals("Affected", response.getData());

        response = subject.deleteApplication(created).execute().body();
        Assert.assertEquals("ok", response.getStatus());
        Assert.assertEquals("Affected", response.getData());
    }

}
