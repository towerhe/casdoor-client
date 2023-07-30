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

package com.yicenyun.casdoor.client.command;

public class QueryCommand {
    private Integer page;
    private Integer pageSize;
    private String field;
    private Object value;
    private String sortField;
    private String sortOrder;

    QueryCommand(Integer page, Integer pageSize, String field, Object value, String sortField,
            String sortOrder) {
        this.page = page;
        this.pageSize = pageSize;
        this.field = field;
        this.value = value;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public static class Builder {

        private Integer page;
        private Integer pageSize;
        private String field;
        private Object value;
        private String sortField;
        private String sortOrder;

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        public Builder pageSize(Integer size) {
            this.pageSize = size;
            return this;
        }

        public Builder page(Integer page, Integer size) {
            this.page = page;
            this.pageSize = size;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder field(String field, Object value) {
            this.field = field;
            this.value = value;
            return this;
        }

        public Builder sort(String field) {
            this.sortField = field;
            return this;
        }

        public Builder sort(String field, String order) {
            this.sortField = field;
            this.sortField = order;
            return this;
        }

        public QueryCommand build() {
            return new QueryCommand(page, pageSize, field, value, sortField, sortOrder);
        }
    }

}
