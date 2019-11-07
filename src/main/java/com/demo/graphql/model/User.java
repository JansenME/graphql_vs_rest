package com.demo.graphql.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private final String userType;
    private final int age;

    private int numberOfAccounts;
    private List<Account> accounts;
}
