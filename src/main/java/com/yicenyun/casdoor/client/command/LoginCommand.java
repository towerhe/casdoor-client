package com.yicenyun.casdoor.client.command;

import com.yicenyun.casdoor.client.command.LoginQueryParams.ResponseType;

public class LoginCommand {
    private String type;
    private String username;
    private String password;
    private String organization;
    private String application;
    private String captchaType;
    private String captchaToken;
    private String clientSecret;

    LoginCommand(ResponseType type, String username, String password, String organization, String application, String captchaType,
            String captchaToken, String clientSecret) {
        this.type = type.getValue();
        this.username = username;
        this.password = password;
        this.organization = organization;
        this.application = application;
        this.captchaType = captchaType;
        this.captchaToken = captchaToken;
        this.clientSecret = clientSecret;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getOrganization() {
        return organization;
    }

    public String getApplication() {
        return application;
    }

    public String getCaptchaType() {
        return captchaType;
    }

    public String getCaptchaToken() {
        return captchaToken;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public static class Builder {
        private ResponseType type;
        private String username;
        private String password;
        private String organization;
        private String application;
        private String captchaType;
        private String captchaToken;
        private String clientSecret;

        public Builder type(ResponseType type) {
            this.type = type;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder organization(String organization) {
            this.organization = organization;
            return this;
        }

        public Builder application(String application) {
            this.application = application;
            return this;
        }

        public Builder captchaType(String captchaType) {
            this.captchaType = captchaType;
            return this;
        }

        public Builder captchaToken(String captchaToken) {
            this.captchaToken = captchaToken;
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public LoginCommand build() {
            return new LoginCommand(type, username, password, organization, application, captchaType, captchaToken,
                    clientSecret);
        }
    }
}
