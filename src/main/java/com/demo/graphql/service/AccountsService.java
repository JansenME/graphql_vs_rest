package com.demo.graphql.service;

import com.demo.graphql.model.Account;
import com.demo.graphql.model.Balance;
import com.demo.graphql.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Slf4j
public class AccountsService {

    List<Account> getAccounts(final int numberOfAccounts) {
        return new User(getAccountsList(numberOfAccounts)).getAccounts();
    }

    private List<Account> getAccountsList(final int numberOfAccounts) {
        List<Account> accounts = new ArrayList<>();

        IntStream.range(0, numberOfAccounts)
                .forEach(element -> accounts.add(createOneAccount()));

        return accounts;
    }

    private Account createOneAccount() {
        return new Account("NL12RABO0123456789", "EUR", "RABONL2UXXX", new Balance(BigDecimal.TEN, "EUR"));
    }
}
