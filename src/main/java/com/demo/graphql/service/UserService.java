package com.demo.graphql.service;

import com.demo.graphql.model.Account;
import com.demo.graphql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private AccountsService accountsService;

    @Autowired
    public UserService(final AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    public User getUser(final int numberOfAccounts) {
        List<Account> accounts = accountsService.getAccounts(numberOfAccounts);

        return new User(accounts.size(), accounts);
    }
}
