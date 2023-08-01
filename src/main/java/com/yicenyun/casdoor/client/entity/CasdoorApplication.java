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

package com.yicenyun.casdoor.client.entity;

import java.util.Arrays;
import java.util.List;

public class CasdoorApplication {
    private String owner;
    private String name;
    private String createdTime;
    private String displayName;
    private String logo;
    private String homepageUrl;
    private String description;
    private String organization;
    private String cert;
    private Boolean enablePassword;
    private Boolean enableSignup;
    private Boolean enableSigninSession;
    private Boolean enableAutoSignin;
    private Boolean enableCodeSignin;
    private Boolean enableSamlCompress;
    private Boolean enableWebAuthn;
    private Boolean enableLinkWithEmail;
    private String orgChoiceMode;
    private String samlReplyUrl;
    private List<CasdoorProviderItem> providers;
    private List<CasdoorSignupItem> signupItems;
    private String[] grantTypes;
    private CasdoorOrganization organizationObj;
    private String[] tags;
    private String clientId;
    private String clientSecret;
    private String[] redirectUris;
    private String tokenFormat;
    private Integer expireInHours;
    private Integer refreshExpireInHours;
    private String signupUrl;
    private String signinUrl;
    private String forgetUrl;
    private String affiliationUrl;
    private String termsOfUse;
    private String signupHtml;
    private String signinHtml;
    private CasdoorThemeData themeData;
    private String formCss;
    private String formCssMobile;
    private Integer formOffset;
    private String formSideHtml;
    private String formBackgroundUrl;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public Boolean getEnablePassword() {
        return enablePassword;
    }

    public void setEnablePassword(Boolean enablePassword) {
        this.enablePassword = enablePassword;
    }

    public Boolean getEnableSignup() {
        return enableSignup;
    }

    public void setEnableSignup(Boolean enableSignup) {
        this.enableSignup = enableSignup;
    }

    public Boolean getEnableSigninSession() {
        return enableSigninSession;
    }

    public void setEnableSigninSession(Boolean enableSigninSession) {
        this.enableSigninSession = enableSigninSession;
    }

    public Boolean getEnableAutoSignin() {
        return enableAutoSignin;
    }

    public void setEnableAutoSignin(Boolean enableAutoSignin) {
        this.enableAutoSignin = enableAutoSignin;
    }

    public Boolean getEnableCodeSignin() {
        return enableCodeSignin;
    }

    public void setEnableCodeSignin(Boolean enableCodeSignin) {
        this.enableCodeSignin = enableCodeSignin;
    }

    public Boolean getEnableSamlCompress() {
        return enableSamlCompress;
    }

    public void setEnableSamlCompress(Boolean enableSamlCompress) {
        this.enableSamlCompress = enableSamlCompress;
    }

    public Boolean getEnableWebAuthn() {
        return enableWebAuthn;
    }

    public void setEnableWebAuthn(Boolean enableWebAuthn) {
        this.enableWebAuthn = enableWebAuthn;
    }

    public Boolean getEnableLinkWithEmail() {
        return enableLinkWithEmail;
    }

    public void setEnableLinkWithEmail(Boolean enableLinkWithEmail) {
        this.enableLinkWithEmail = enableLinkWithEmail;
    }

    public String getOrgChoiceMode() {
        return orgChoiceMode;
    }

    public void setOrgChoiceMode(String orgChoiceMode) {
        this.orgChoiceMode = orgChoiceMode;
    }

    public String getSamlReplyUrl() {
        return samlReplyUrl;
    }

    public void setSamlReplyUrl(String samlReplyUrl) {
        this.samlReplyUrl = samlReplyUrl;
    }

    public List<CasdoorProviderItem> getProviders() {
        return providers;
    }

    public void setProviders(List<CasdoorProviderItem> providers) {
        this.providers = providers;
    }

    public List<CasdoorSignupItem> getSignupItems() {
        return signupItems;
    }

    public void setSignupItems(List<CasdoorSignupItem> signupItems) {
        this.signupItems = signupItems;
    }

    public String[] getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String[] grantTypes) {
        this.grantTypes = grantTypes;
    }

    public CasdoorOrganization getOrganizationObj() {
        return organizationObj;
    }

    public void setOrganizationObj(CasdoorOrganization organizationObj) {
        this.organizationObj = organizationObj;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String[] getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String[] redirectUris) {
        this.redirectUris = redirectUris;
    }

    public String getTokenFormat() {
        return tokenFormat;
    }

    public void setTokenFormat(String tokenFormat) {
        this.tokenFormat = tokenFormat;
    }

    public Integer getExpireInHours() {
        return expireInHours;
    }

    public void setExpireInHours(Integer expireInHours) {
        this.expireInHours = expireInHours;
    }

    public Integer getRefreshExpireInHours() {
        return refreshExpireInHours;
    }

    public void setRefreshExpireInHours(Integer refreshExpireInHours) {
        this.refreshExpireInHours = refreshExpireInHours;
    }

    public String getSignupUrl() {
        return signupUrl;
    }

    public void setSignupUrl(String signupUrl) {
        this.signupUrl = signupUrl;
    }

    public String getSigninUrl() {
        return signinUrl;
    }

    public void setSigninUrl(String signinUrl) {
        this.signinUrl = signinUrl;
    }

    public String getForgetUrl() {
        return forgetUrl;
    }

    public void setForgetUrl(String forgetUrl) {
        this.forgetUrl = forgetUrl;
    }

    public String getAffiliationUrl() {
        return affiliationUrl;
    }

    public void setAffiliationUrl(String affiliationUrl) {
        this.affiliationUrl = affiliationUrl;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public String getSignupHtml() {
        return signupHtml;
    }

    public void setSignupHtml(String signupHtml) {
        this.signupHtml = signupHtml;
    }

    public String getSigninHtml() {
        return signinHtml;
    }

    public void setSigninHtml(String signinHtml) {
        this.signinHtml = signinHtml;
    }

    public CasdoorThemeData getThemeData() {
        return themeData;
    }

    public void setThemeData(CasdoorThemeData themeData) {
        this.themeData = themeData;
    }

    public String getFormCss() {
        return formCss;
    }

    public void setFormCss(String formCss) {
        this.formCss = formCss;
    }

    public String getFormCssMobile() {
        return formCssMobile;
    }

    public void setFormCssMobile(String formCssMobile) {
        this.formCssMobile = formCssMobile;
    }

    public Integer getFormOffset() {
        return formOffset;
    }

    public void setFormOffset(Integer formOffset) {
        this.formOffset = formOffset;
    }

    public String getFormSideHtml() {
        return formSideHtml;
    }

    public void setFormSideHtml(String formSideHtml) {
        this.formSideHtml = formSideHtml;
    }

    public String getFormBackgroundUrl() {
        return formBackgroundUrl;
    }

    public void setFormBackgroundUrl(String formBackgroundUrl) {
        this.formBackgroundUrl = formBackgroundUrl;
    }

    @Override
    public String toString() {
        return "Application{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", displayName='" + displayName + '\'' +
                ", logo='" + logo + '\'' +
                ", homepageUrl='" + homepageUrl + '\'' +
                ", description='" + description + '\'' +
                ", organization='" + organization + '\'' +
                ", cert='" + cert + '\'' +
                ", enablePassword=" + enablePassword +
                ", enableSignup=" + enableSignup +
                ", enableSigninSession=" + enableSigninSession +
                ", enableAutoSignin=" + enableAutoSignin +
                ", enableCodeSignin=" + enableCodeSignin +
                ", enableSamlCompress=" + enableSamlCompress +
                ", enableWebAuthn=" + enableWebAuthn +
                ", enableLinkWithEmail=" + enableLinkWithEmail +
                ", orgChoiceMode='" + orgChoiceMode + '\'' +
                ", samlReplyUrl='" + samlReplyUrl + '\'' +
                ", providers=" + providers +
                ", signupItems=" + signupItems +
                ", grantTypes=" + Arrays.toString(grantTypes) +
                ", organizationObj=" + organizationObj +
                ", tags=" + Arrays.toString(tags) +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", redirectUris=" + Arrays.toString(redirectUris) +
                ", tokenFormat='" + tokenFormat + '\'' +
                ", expireInHours=" + expireInHours +
                ", refreshExpireInHours=" + refreshExpireInHours +
                ", signupUrl='" + signupUrl + '\'' +
                ", signinUrl='" + signinUrl + '\'' +
                ", forgetUrl='" + forgetUrl + '\'' +
                ", affiliationUrl='" + affiliationUrl + '\'' +
                ", termsOfUse='" + termsOfUse + '\'' +
                ", signupHtml='" + signupHtml + '\'' +
                ", signinHtml='" + signinHtml + '\'' +
                ", themeData=" + themeData +
                ", formCss='" + formCss + '\'' +
                ", formCssMobile='" + formCssMobile + '\'' +
                ", formOffset=" + formOffset +
                ", formSideHtml='" + formSideHtml + '\'' +
                ", formBackgroundUrl='" + formBackgroundUrl + '\'' +
                '}';
    }
}
