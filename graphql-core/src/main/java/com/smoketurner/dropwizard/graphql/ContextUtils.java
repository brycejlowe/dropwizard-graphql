package com.smoketurner.dropwizard.graphql;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.schema.DataFetchingEnvironment;

import javax.servlet.http.HttpServletRequest;

public class ContextUtils {
    public static HttpServletRequest getRequest(DataFetchingEnvironment dfe) {
        // TODO: Fix once 13.0.0 drops (https://github.com/graphql-java-kickstart/graphql-java-servlet/issues/393)
        DefaultGraphQLServletContext servletContext = dfe.getContext();
        return servletContext.getHttpServletRequest();
    }

    public static String getHeader(DataFetchingEnvironment dfe, String headerName) {
        return getRequest(dfe).getHeader(headerName);
    }

    public static String getHeader(DataFetchingEnvironment dfe, String headerName, String defaultValue) {
        String headerValue = getHeader(dfe, headerName);
        return headerValue != null ? headerValue : defaultValue;
    }
}
