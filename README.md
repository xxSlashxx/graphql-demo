![build status](https://github.com/xxSlashxx/graphql-demo/actions/workflows/maven.yml/badge.svg)
# GraphQL-Demo

## Overview
This repository contains a simple implementation of a GraphQL server using Java. It demonstrates how to set up a basic GraphQL API to handle queries, mutations, and schema definitions.

## Services
This demo consists of the following service:
- **Products Service:** Handles product information

### Queries

- getProduct

        query {
            getProduct(id: null) {
                price
                name
                id
            }
        }

### Mutations

- createProduct

        mutation {
            createProduct(productDTO: { id: null, name: null, price: null })
        }

- deleteProduct

        mutation {
            deleteProduct(id: null)
        }

## Getting Started
### Prerequisites
- Java 21 or higher
- Git
- Docker

### Clone the Repository
        git clone https://github.com/xxSlashxx/graphql-demo
        cd graphql-demo

### Running the Application
        docker compose up

### Accessing the Services
The service's endpoints can be accessed through `http://localhost:8080/graphql`.

### Testing
You can test the service using tools like Postman or by sending raw requests via curl or any HTTP client library.

Example using `curl`:

        curl -X POST -H "Content-Type: application/json" -d '{"query": "query { getProduct(id: \"1\") { id name price } }" }' http://localhost:8080/graphql

### Configuration
Configuration settings can be found in the `application.properties` files located in the service's src/main/resources directory. You can customize properties like database connections and port numbers or enable grapiql.

