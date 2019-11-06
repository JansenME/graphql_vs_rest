package com.demo.graphql.service;

import com.demo.graphql.backends.UserInformation;
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

    public User getUserForRest(final int numberOfAccounts) {
        User user = UserInformation.getUserInformation();

        setAccounts(user, numberOfAccounts);

        return user;
    }

    public User getUserForGraphQL(final int numberOfAccounts, final boolean getAccounts) {
        User user = UserInformation.getUserInformation();

        if(getAccounts) {
            setAccounts(user, numberOfAccounts);
        }

        return user;
    }

    private void setAccounts(final User user, final int numberOfAccounts) {
        List<Account> accounts = accountsService.getAccounts(numberOfAccounts);
        user.getAccounts().addAll(accounts);
        user.setNumberOfAccounts(accounts.size());
    }
}
