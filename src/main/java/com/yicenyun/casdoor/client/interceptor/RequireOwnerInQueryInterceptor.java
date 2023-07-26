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

package com.yicenyun.casdoor.client.interceptor;

import java.io.IOException;

import com.yicenyun.casdoor.client.annotation.RequireOwnerInQuery;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Invocation;

public class RequireOwnerInQueryInterceptor implements Interceptor {

    private final String owner;

    public RequireOwnerInQueryInterceptor(String owner) {
        this.owner = owner;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Invocation invocation = original.tag(Invocation.class);

        if (isOwnerRequired(invocation)) {
            HttpUrl url = original.url().newBuilder().addQueryParameter("owner", owner).build();
            return chain.proceed(original.newBuilder().url(url).build());
        }

        return chain.proceed(original);
    }

    private boolean isOwnerRequired(Invocation invocation) {
        return owner != null && owner.length() > 0
                && invocation.method().isAnnotationPresent(RequireOwnerInQuery.class);
    }
}
