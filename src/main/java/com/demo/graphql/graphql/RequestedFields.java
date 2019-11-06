package com.demo.graphql.graphql;

import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class RequestedFields {
    private final List<GraphQLFieldName> requestedFieldsList;

    RequestedFields(final DataFetchingEnvironment dataFetchingEnvironment) {
        this.requestedFieldsList = new ArrayList<>();

        if(dataFetchingEnvironment == null || dataFetchingEnvironment.getSelectionSet() == null || dataFetchingEnvironment.getSelectionSet().getDefinitions() == null) {
            throw new GraphQLException("The DataFetchingEnvironment was not correct, therefore we can't check which fields were requested.");
        }

        dataFetchingEnvironment.getSelectionSet().getDefinitions().keySet().forEach(this::add);
    }

    private void add(final String fieldNameAsString) {
        if(fieldNameAsString == null) {
            throw new GraphQLException("The Key in Definitions in DataFetchingEnvironment was null, therefore we can't check which field was requested.");
        }

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

    public boolean contains(final GraphQLFieldName graphQLField) {
        return requestedFieldsList.contains(graphQLField);
    }
}