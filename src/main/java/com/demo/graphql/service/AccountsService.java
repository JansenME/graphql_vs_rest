package com.demo.graphql.service;

import com.demo.graphql.backends.AccountInformation;
import com.demo.graphql.model.Account;
import com.demo.graphql.model.AccountId;
import com.demo.graphql.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountsService {

    void getAccounts(final User user, final int numberOfAccounts) {
        List<AccountId> accountIds = AccountInformation.getAccountIds(numberOfAccounts);

        List<Account> accounts = getAccountsList(accountIds);

        user.getAccounts().addAll(accounts);
        user.setNumberOfAccounts(accounts.size());
    }

    private List<Account> getAccountsList(final List<AccountId> accountIds) {
        return accountIds.stream().map(Account::new).collect(Collectors.toList());
    }
}
