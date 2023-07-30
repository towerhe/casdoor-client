// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing CasdoorPermissions and
// limitations under the License.

package com.yicenyun.casdoor.client.service;

import java.util.List;

import com.yicenyun.casdoor.client.annotation.CasdoorId;
import com.yicenyun.casdoor.client.annotation.RequireOwnerInQuery;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorUser;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Tag;

public interface CasdoorUserService {
    @GET("get-users")
    @RequireOwnerInQuery
    Call<CasdoorResponse<List<CasdoorUser>, Object>> getUsers();

    @GET("get-sorted-users")
    @RequireOwnerInQuery
    Call<CasdoorResponse<List<CasdoorUser>, Object>> getSortedUsers(@Query("sorter") String sorter,
            @Query("limit") int limit);

    @GET("get-users")
    @RequireOwnerInQuery
    Call<CasdoorResponse<List<CasdoorUser>, Integer>> getUsers(@Tag QueryCommand command);

    @GET("get-user-count")
    @RequireOwnerInQuery
    Call<CasdoorResponse<Integer, Object>> getUserCount(@Query("isOnline") String isOnline);

    @GET("get-user")
    Call<CasdoorResponse<CasdoorUser, Object>> getUser(@CasdoorId @Tag String name);

    @GET("get-user")
    @RequireOwnerInQuery
    Call<CasdoorResponse<CasdoorUser, Object>> getUserByEmail(@Query("email") String email);

    @POST("add-user")
    Call<CasdoorActionResponse> addUser(@Body CasdoorUser user);

    @POST("update-user")
    Call<CasdoorActionResponse> updateUser(@CasdoorId @Tag String name, @Body CasdoorUser user);

    @POST("delete-user")
    Call<CasdoorActionResponse> deleteUser(@Body CasdoorUser user);

}
