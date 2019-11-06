package com.demo.graphql.graphql;

import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class RequestedFields {
    private final List<GraphQLFieldName> requestedFieldsList;

    RequestedFields(final DataFetchingEnvironment dataFetchingEnvironment) {
        this.requestedFieldsList = new ArrayList<>();

        if(dataFetchingEnvironment == null || dataFetchingEnvironment.getSelectionSet() == null || dataFetchingEnvironment.getSelectionSet().getDefinitions() == null) {
            throw new GraphQLException("The DataFetchingEnvironment was not correct, therefore we can't check which fields were requested.");
        }

        dataFetchingEnvironment.getSelectionSet().getDefinitions().keySet()
                .stream()
                .filter(Objects::nonNull)
                .forEach(this::add);
    }

    private void add(final String fieldNameAsString) {
        Stream.of(GraphQLFieldName.values()).forEach(fieldName -> addIfFieldNameExists(fieldName, fieldNameAsString));
    }

    private void addIfFieldNameExists(final GraphQLFieldName fieldName, final String fieldnameAsString) {
        if(fieldName.getFieldName().equalsIgnoreCase(fieldnameAsString)) {
            this.requestedFieldsList.add(GraphQLFieldName.valueOf(fieldName.name()));
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(":");

        this.requestedFieldsList.forEach(fieldname -> out.add(fieldname.getFieldName()));

        return out.toString();
    }

    boolean contains(final GraphQLFieldName graphQLField) {
        return requestedFieldsList.contains(graphQLField);
    }
}
