package com.yicenyun.casdoor.client.command;

import java.util.HashMap;
import java.util.Map;

public class LoginQueryParams {
    /**
     * @required
     */
    private String clientId;
    /**
     * @required
     */
    private ResponseType responseType;
    /**
     * @required
     */
    private String redirectUri;
    private String scope;
    private String state;
    private String nonce;
    /**
     * 取值：S256 或空
     */
    private String codeChallengeMethod;
    private String codeChallenge;

    LoginQueryParams(String clientId, ResponseType responseType, String redirectUri, String scope, String state,
            String nonce, String codeChallengeMethod, String codeChallenge) {
        this.clientId = clientId;
        this.responseType = responseType;
        this.redirectUri = redirectUri;
        this.scope = scope;
        this.state = state;
        this.nonce = nonce;
        this.codeChallengeMethod = codeChallengeMethod;
        this.codeChallenge = codeChallenge;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("clientId", clientId);
        map.put("responseType", responseType.getValue());
        map.put("redirectUri", redirectUri);
        map.put("scope", scope);
        map.put("state", state);
        map.put("nonce", nonce);
        map.put("code_challenge_method", codeChallengeMethod);
        map.put("code_challenge", codeChallenge);
        map.entrySet().removeIf(entry -> entry.getValue() == null);

        return map;
    }

    public String getClientId() {
        return clientId;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public String getState() {
        return state;
    }

    public String getNonce() {
        return nonce;
    }

    public String getCodeChallengeMethod() {
        return codeChallengeMethod;
    }

    public String getCodeChallenge() {
        return codeChallenge;
    }

    public static class Builder {
        private String clientId;
        private ResponseType responseType;
        private String redirectUri;
        private String scope;
        private String state;
        private String nonce;
        private String codeChallengeMethod;
        private String codeChallenge;

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder responseType(ResponseType responseType) {
            this.responseType = responseType;
            return this;
        }

        public Builder redirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }

        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder nonce(String nonce) {
            this.nonce = nonce;
            return this;
        }

        public Builder codeChallengeMethod(String codeChallengeMethod) {
            this.codeChallengeMethod = codeChallengeMethod;
            return this;
        }

        public Builder codeChallenge(String codeChallenge) {
            this.codeChallenge = codeChallenge;
            return this;
        }

        public LoginQueryParams build() {
            return new LoginQueryParams(clientId, responseType, redirectUri, scope, state, nonce, codeChallengeMethod,
                    codeChallenge);
        }
    }

    public enum ResponseType {
        LOGIN("login"), CODE("code"), TOKEN("token"), ID_TOKEN("id_token"), SAML("saml"), CAS("cas");

        private String value;

        ResponseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
