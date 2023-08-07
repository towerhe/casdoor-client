package com.yicenyun.casdoor.client.service;

import com.yicenyun.casdoor.client.annotation.CasdoorId;
import com.yicenyun.casdoor.client.response.CasdoorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Tag;

public interface CasdoorCasbinApiService {

    @POST("enforce")
    Call<CasdoorResponse<Boolean, Object>> enforceByEnforcer(@CasdoorId("enforcerId") @Tag String name,
            @Body String[] data);

    @POST("enforce")
    Call<CasdoorResponse<Boolean[], Object>> enforceByPermission(@CasdoorId("permissionId") @Tag String name, @Body String[] data);

    @POST("enforce")
    Call<CasdoorResponse<Boolean[], Object>> enforceByModel(@CasdoorId("modelId") @Tag String name, @Body String[] data);

    @POST("enforce")
    Call<CasdoorResponse<Boolean[], Object>> enforceByResource(@Query("resourceId") String name, @Body String[] data);

    @POST("batch-enforce")
    Call<CasdoorResponse<Boolean[], Object>> batchEnforceByEnforcer(@CasdoorId("enforcerId") @Tag String name,
            @Body String[][] data);

    @POST("batch-enforce")
    Call<CasdoorResponse<Boolean[][], Object>> batchEnforceByPermission(@CasdoorId("permissionId") @Tag String name,
            @Body String[][] data);

    @POST("batch-enforce")
    Call<CasdoorResponse<Boolean[][], Object>> batchEnforceByModel(@CasdoorId("modelId") @Tag String name,
            @Body String[][] data);

}
