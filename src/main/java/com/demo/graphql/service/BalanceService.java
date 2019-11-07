package com.demo.graphql.service;

import com.demo.graphql.backends.BalanceInformation;
import com.demo.graphql.model.Account;
import com.demo.graphql.model.Balance;
import com.demo.graphql.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BalanceService {
    void addBalancesToAccounts(final User user) {
        Map<Account, Balance> accountsWithBalances = BalanceInformation.addBalancesToAccounts(user.getAccounts());

        user.getAccounts().forEach(account -> lookUpAccount(accountsWithBalances, account));
    }

    private void lookUpAccount(final Map<Account, Balance> accountsWithBalances, final Account account) {
        if (accountsWithBalances.containsKey(account)) {
            Balance balance = accountsWithBalances.get(account);
            account.setBalance(balance);
        }
    }
}
