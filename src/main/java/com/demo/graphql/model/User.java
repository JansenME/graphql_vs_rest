package com.demo.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private final String userType;
    private final int age;

    private int numberOfAccounts;
    private List<Account> accounts;
}
