package com.yicenyun.casdoor.client.command;

import java.util.HashMap;
import java.util.Map;

public class LogoutQueryParams {
    private String idTokenHint;
    private String postLogoutRedirectUri;
    private String state;

    LogoutQueryParams(String idTokenHint, String postLogoutRedirectUri, String state) {
        this.idTokenHint = idTokenHint;
        this.postLogoutRedirectUri = postLogoutRedirectUri;
        this.state = state;
    }

    public String getIdTokenHint() {
        return idTokenHint;
    }

    public String getPostLogoutRedirectUri() {
        return postLogoutRedirectUri;
    }

    public String getState() {
        return state;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id_token_hint", idTokenHint);
        map.put("post_logout_redirect_uri", postLogoutRedirectUri);
        map.put("state", state);
        map.entrySet().removeIf(entry -> entry.getValue() == null);

        return map;
    }

    public static class Builder {
        private String idTokenHint;
        private String postLogoutRedirectUri;
        private String state;

        public Builder idTokenHint(String idTokenHint) {
            this.idTokenHint = idTokenHint;
            return this;
        }

        public Builder postLogoutRedirectUri(String postLogoutRedirectUri) {
            this.postLogoutRedirectUri = postLogoutRedirectUri;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public LogoutQueryParams build() {
            return new LogoutQueryParams(idTokenHint, postLogoutRedirectUri, state);
        }
    }
}
