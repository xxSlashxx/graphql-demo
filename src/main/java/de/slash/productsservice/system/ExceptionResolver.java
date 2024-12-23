package de.slash.productsservice.system;

import de.slash.productsservice.product.ProductNotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import static org.springframework.graphql.execution.ErrorType.NOT_FOUND;

@Component
public class ExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable throwable, DataFetchingEnvironment environment) {
        if (throwable instanceof ProductNotFoundException) {
            return GraphqlErrorBuilder.newError()
                    .errorType(NOT_FOUND)
                    .message(throwable.getMessage())
                    .path(environment.getExecutionStepInfo().getPath())
                    .location(environment.getField().getSourceLocation())
                    .build();
        } else {
            return null;
        }
    }
}
