package com.demo.graphql.graphql;

public enum GraphQLFieldName {
    ACCOUNTID("accounts/accountId"),
    BALANCE("accounts/balance");

    private String fieldName;

    GraphQLFieldName(final String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}
