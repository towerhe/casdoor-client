package com.yicenyun.casdoor.client.service;

import java.util.Map;

import com.yicenyun.casdoor.client.command.LoginCommand;
import com.yicenyun.casdoor.client.entity.CasdoorMfa;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface CasdoorLoginService {
    @POST("login")
    Call<CasdoorResponse<String, CasdoorMfa>> login(@QueryMap Map<String, String> query, @Body LoginCommand command);

    @POST("logout")
    Call<CasdoorActionResponse> logout(@QueryMap Map<String, String> query);

    @POST("logout")
    Call<CasdoorActionResponse> logout(@Query("id_token_hint") String token);

    @POST("logout")
    Call<CasdoorActionResponse> logout(@Query("id_token_hint") String token, @Query("state") String state);

    @POST("logout")
    Call<CasdoorActionResponse> logout(@Query("id_token_hint") String token, @Query("post_logout_redirect_uri") String postLogoutRedirectUri, @Query("state") String state);

}
