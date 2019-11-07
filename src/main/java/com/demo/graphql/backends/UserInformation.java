package com.demo.graphql.backends;

import com.demo.graphql.model.User;
import com.demo.graphql.model.UserType;

import java.util.ArrayList;
import java.util.Random;

public class UserInformation {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 65;
    private static final Random RANDOM = new Random();

    public static User getUserInformation() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return new User(UserType.CUSTOMER.name(), getRandomAge(), 0, new ArrayList<>());
    }

    private static int getRandomAge() {
        return RANDOM.nextInt((MAX_AGE - MIN_AGE) + 1) + MIN_AGE;
    }
}
