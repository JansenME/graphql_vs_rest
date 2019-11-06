package com.demo.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.demo.graphql.model.User;
import com.demo.graphql.service.UserService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private UserService userService;

    @Autowired
    public Query(final UserService userService) {
        this.userService = userService;
    }

    public User getUser(final String numberOfAccounts, final DataFetchingEnvironment environment) {
        RequestedFields requestedFields = new RequestedFields(environment);

        return userService.getUserForGraphQL(Integer.valueOf(numberOfAccounts), requestedFields.contains(GraphQLFieldName.BALANCE), requestedFields.contains(GraphQLFieldName.ACCOUNTID));
    }
}
