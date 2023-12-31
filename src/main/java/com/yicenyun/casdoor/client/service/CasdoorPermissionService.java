// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.yicenyun.casdoor.client.service;

import java.util.List;

import com.yicenyun.casdoor.client.annotation.CasdoorId;
import com.yicenyun.casdoor.client.annotation.RequireOwnerInQuery;
import com.yicenyun.casdoor.client.command.QueryCommand;
import com.yicenyun.casdoor.client.entity.CasdoorPermission;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Tag;

public interface CasdoorPermissionService {

        @GET("get-permission")
        Call<CasdoorResponse<CasdoorPermission, Object>> getPermission(@CasdoorId @Tag String name);

        @GET("get-permissions")
        @RequireOwnerInQuery
        Call<CasdoorResponse<List<CasdoorPermission>, Object>> getPermissions();

        @GET("get-permissions")
        @RequireOwnerInQuery
        Call<CasdoorResponse<List<CasdoorPermission>, Integer>> getPermissions(@Tag QueryCommand command);

        @GET("get-permissions-by-role")
        Call<CasdoorResponse<List<CasdoorPermission>, Integer>> getPermissionsByRole(@CasdoorId @Tag String name,
                        @Query("owner") String owner);

        @POST("add-permission")
        Call<CasdoorActionResponse> addPermission(@Body CasdoorPermission permission);

        @POST("update-permission")
        Call<CasdoorActionResponse> updatePermission(@CasdoorId @Tag String name, @Body CasdoorPermission permission);

        @POST("delete-permission")
        Call<CasdoorActionResponse> deletePermission(@Body CasdoorPermission permission);

}
