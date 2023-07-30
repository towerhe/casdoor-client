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

import com.yicenyun.casdoor.client.command.QueryCommand;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class QueryCommandInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        QueryCommand command = original.tag(QueryCommand.class);

        if (command == null) {
            return chain.proceed(original);
        }

        HttpUrl.Builder builder = original.url().newBuilder();
        addQueryParameter(builder, "p", command.getPage());
        addQueryParameter(builder, "pageSize", command.getPageSize());
        addQueryParameter(builder, "field", command.getField());
        addQueryParameter(builder, "value", command.getValue());
        addQueryParameter(builder, "sortField", command.getField());
        addQueryParameter(builder, "sortOrder", command.getSortOrder());

        return chain.proceed(original.newBuilder().url(builder.build()).build());
    }

    public void addQueryParameter(HttpUrl.Builder builder, String name, Object value) {
        if (value == null) {
            return;
        }

        builder.addQueryParameter(name, String.valueOf(value));
    }
}
