package com.demo.graphql.service;

import com.demo.graphql.backends.UserInformation;
import com.demo.graphql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private AccountsService accountsService;
    private BalanceService balanceService;

    @Autowired
    public UserService(final AccountsService accountsService, final BalanceService balanceService) {
        this.accountsService = accountsService;
        this.balanceService = balanceService;
    }

    public User getUserForRest(final int numberOfAccounts) {
        User user = UserInformation.getUserInformation();

        setAccounts(user, numberOfAccounts);
        setBalances(user);

        return user;
    }

    public User getUserForGraphQL(final int numberOfAccounts, final boolean getAccountInformation, final boolean getBalances) {
        User user = UserInformation.getUserInformation();

        if(getAccountInformation) {
            setAccounts(user, numberOfAccounts);
        }

        if(getBalances) {
            setBalances(user);
        }

        return user;
    }

    private void setAccounts(final User user, final int numberOfAccounts) {
        accountsService.getAccounts(user, numberOfAccounts);
    }

    private void setBalances(final User user) {
        balanceService.addBalancesToAccounts(user);
    }
}
