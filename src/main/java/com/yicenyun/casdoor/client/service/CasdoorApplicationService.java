package com.yicenyun.casdoor.client.service;

import java.util.List;

import com.yicenyun.casdoor.client.annotation.CasdoorId;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorApplication;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Tag;

public interface CasdoorApplicationService {

    @GET("get-applications")
    Call<CasdoorResponse<List<CasdoorApplication>, Integer>> getApplications();

    @GET("get-applications")
    Call<CasdoorResponse<List<CasdoorApplication>, Integer>> getApplications(@Tag QueryCommand command);

    @GET("get-organization-applications")
    Call<CasdoorResponse<List<CasdoorApplication>, Integer>> getOrganizationApplications(@Query("organization") String orgName, @Tag QueryCommand command);

    /**
     * @param id id of application, format: admin/${applicationName}
     * @return application with the specified id
     */
    @GET("get-application")
    Call<CasdoorResponse<CasdoorApplication, Object>> getApplication(@Query("id") String id);

    /**
     * @param name name of user
     * @return application the user signed up or organization is the owner of the user
     */
    @GET("get-user-application")
    Call<CasdoorResponse<CasdoorApplication, Object>> getUserApplication(@Tag @CasdoorId String name);

    @POST("add-application")
    Call<CasdoorActionResponse> addApplication(@Body CasdoorApplication application);

    /**
     * @param id id of application, format: admin/${applicationName}
     * @return application with the specified id
     */
    @POST("update-application")
    Call<CasdoorActionResponse> updateApplication(@Query("id") String id, @Body CasdoorApplication application);

    @POST("delete-application")
    Call<CasdoorActionResponse> deleteApplication(@Body CasdoorApplication application);

}