package com.demo.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private int numberOfAccounts;
    private final List<Account> accounts;
}
