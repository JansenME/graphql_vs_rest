package com.demo.graphql.model;

import lombok.Data;

@Data
public class Account {
    private final AccountId accountId;
    private Balance balance;
}
