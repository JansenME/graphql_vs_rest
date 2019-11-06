package com.demo.graphql.service;

import com.demo.graphql.backends.AccountInformation;
import com.demo.graphql.model.Account;
import com.demo.graphql.model.AccountId;
import com.demo.graphql.model.Balance;
import com.demo.graphql.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountsService {

    List<Account> getAccounts(final int numberOfAccounts) {
        List<AccountId> accountIds = AccountInformation.getAccountIds(numberOfAccounts);

        return new User(getAccountsList(accountIds)).getAccounts();
    }

    private List<Account> getAccountsList(final List<AccountId> accountIds) {
        return accountIds.stream().map(this::createOneAccount).collect(Collectors.toList());
    }

    private Account createOneAccount(final AccountId accountId) {
        return new Account(accountId, new Balance(BigDecimal.TEN, "EUR"));
    }
}
