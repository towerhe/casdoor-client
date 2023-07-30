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

import java.util.List;

public class CasdoorGroup {
    private String owner;
    private String name;
    private String createdTime;
    private String updatedTime;
    private String displayName;
    private String manager;
    private String contactEmail;
    private String type;
    private String parentId;
    private Boolean isTopGroup;
    private List<CasdoorUser> users;
    private String title;
    private String key;
    private List<CasdoorGroup> children;
    private Boolean isEnabled;

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

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsTopGroup() {
        return isTopGroup;
    }

    public void setIsTopGroup(Boolean isTopGroup) {
        this.isTopGroup = isTopGroup;
    }

    public List<CasdoorUser> getUsers() {
        return users;
    }

    public void setUsers(List<CasdoorUser> users) {
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<CasdoorGroup> getChildren() {
        return children;
    }

    public void setChildren(List<CasdoorGroup> children) {
        this.children = children;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", updatedTime='" + updatedTime + '\'' +
                ", displayName='" + displayName + '\'' +
                ", manager='" + manager + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", type='" + type + '\'' +
                ", parentId='" + parentId + '\'' +
                ", isTopGroup='" + isTopGroup + '\'' +
                ", users='" + users + '\'' +
                ", title='" + title + '\'' +
                ", key='" + key + '\'' +
                ", children='" + children + '\'' +
                ", isEnabled='" + isEnabled + '\'' +
                '}';
    }
}
