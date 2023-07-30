package com.yicenyun.casdoor.client.service;

import java.util.List;

import com.yicenyun.casdoor.client.annotation.CasdoorId;
import com.yicenyun.casdoor.client.annotation.RequireOwnerInQuery;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorGroup;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Tag;

public interface CasdoorGroupService {

    @GET("get-groups")
    Call<CasdoorResponse<List<CasdoorGroup>, Integer>> getGroups();

    @GET("get-groups")
    @RequireOwnerInQuery
    Call<CasdoorResponse<List<CasdoorGroup>, Integer>> getGroups(@Tag QueryCommand command,
            @Query("withTree") boolean withTree);

    @GET("get-group")
    Call<CasdoorResponse<CasdoorGroup, Object>> getGroup(@Tag @CasdoorId String name);

    @POST("add-group")
    Call<CasdoorActionResponse> addGroup(@Body CasdoorGroup group);

    @POST("update-group")
    Call<CasdoorActionResponse> updateGroup(@Tag @CasdoorId String name, @Body CasdoorGroup group);

    @POST("delete-group")
    Call<CasdoorActionResponse> deleteGroup(@Body CasdoorGroup group);

}