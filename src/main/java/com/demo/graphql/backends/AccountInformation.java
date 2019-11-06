package com.demo.graphql.backends;

import com.demo.graphql.model.AccountId;
import com.demo.graphql.model.Currency;
import org.iban4j.Iban;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AccountInformation {
    public static List<AccountId> getAccountIds(final int numberOfAccounts) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<AccountId> accountIds = new ArrayList<>();

        IntStream.range(0, numberOfAccounts)
                .forEach(element -> accountIds.add(getOneAccountId()));

        return accountIds;
    }

    private static AccountId getOneAccountId() {
        Iban iban = Iban.random();

        return new AccountId(iban.toString(), Currency.randomCurrency().name(), "RABONL2U");
    }
}
