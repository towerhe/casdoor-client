package com.yicenyun.casdoor.client.service;

import java.util.List;

import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorOrganization;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Tag;

public interface CasdoorOrganizationService {

    @GET("get-organizations")
    Call<CasdoorResponse<List<CasdoorOrganization>, Integer>> getOrganizations();

    @GET("get-organizations")
    Call<CasdoorResponse<List<CasdoorOrganization>, Integer>> getOrganizations(@Tag QueryCommand command);

    @GET("get-organization-names")
    Call<CasdoorResponse<List<CasdoorOrganization>, Object>> getOrganizationNames();

    /**
     * @param id id of organization as 'admin/built-in'
     * @return CasdoorActionResponse
     */
    @GET("get-organization")
    Call<CasdoorResponse<CasdoorOrganization, Object>> getOrganization(@Query("id") String id);

    @POST("add-organization")
    Call<CasdoorActionResponse> addOrganization(@Body CasdoorOrganization organization);

    /**
     * @param id           id of organization as 'admin/built-in'
     * @param organization organization with new data
     * @return CasdoorActionResponse
     */
    @POST("update-organization")
    Call<CasdoorActionResponse> updateOrganization(@Query("id") String id, @Body CasdoorOrganization organization);

    @POST("delete-organization")
    Call<CasdoorActionResponse> deleteOrganization(@Body CasdoorOrganization organization);

}