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
import java.lang.reflect.Parameter;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.yicenyun.casdoor.client.annotation.CasdoorId;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Invocation;

public class CasdoorIdInterceptor implements Interceptor {

    private final String owner;

    public CasdoorIdInterceptor(String owner) {
        this.owner = owner;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Invocation invocation = original.tag(Invocation.class);

        OptionalInt idx = getCasdoorIdIndex(invocation);
        if (hasCasdoorId(idx)) {
            HttpUrl url = original.url().newBuilder()
                    .addQueryParameter(
                            getCasdoorIdValue(invocation, idx.getAsInt()),
                            String.format("%s/%s", owner, invocation.arguments().get(idx.getAsInt())))
                    .build();
            return chain.proceed(original.newBuilder().url(url).build());
        }

        return chain.proceed(original);
    }

    private OptionalInt getCasdoorIdIndex(Invocation invocation) {
        Parameter[] params = invocation.method().getParameters();
        return IntStream.range(0, params.length).filter(i -> params[i].isAnnotationPresent(CasdoorId.class))
                .findFirst();
    }

    private boolean hasCasdoorId(OptionalInt idx) {
        return owner != null && owner.length() > 0 && idx.isPresent();
    }

    private String getCasdoorIdValue(Invocation invocation, int idx) {
        return invocation.method().getParameters()[idx].getAnnotation(CasdoorId.class).value();
    }
}
