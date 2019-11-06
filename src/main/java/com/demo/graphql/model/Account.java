package com.demo.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private AccountId accountId;
    private Balance balance;
}
