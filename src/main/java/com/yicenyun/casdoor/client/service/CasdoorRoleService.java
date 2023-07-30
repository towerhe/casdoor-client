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
import com.yicenyun.casdoor.client.entity.CasdoorRole;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Tag;

public interface CasdoorRoleService {

    @GET("get-role")
    Call<CasdoorResponse<CasdoorRole, Object>> getRole(@CasdoorId @Tag String name);

    @GET("get-roles")
    @RequireOwnerInQuery
    Call<CasdoorResponse<List<CasdoorRole>, Object>> getRoles();

    @GET("get-roles")
    @RequireOwnerInQuery
    Call<CasdoorResponse<List<CasdoorRole>, Integer>> getRoles(@Tag QueryCommand command);

    @POST("add-role")
    Call<CasdoorActionResponse> addRole(@Body CasdoorRole role);

    @POST("update-role")
    Call<CasdoorActionResponse> updateRole(@CasdoorId @Tag String name, @Body CasdoorRole role);

    @POST("delete-role")
    Call<CasdoorActionResponse> deleteRole(@Body CasdoorRole role);

}
