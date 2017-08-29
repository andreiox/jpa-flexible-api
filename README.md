# JPA Flexible API

An API that targets to simplify the use of JPA.

## Installation

At the moment, there is only one way available to use the API.

### From the Source Code

You can build the project from the source in this repository, export as a JAR file and Add to the Build Path of your project.

### Prerequisites

You'll need to have a Database Connector and a Persistence Provider (i.e. EclipseLink, Hibernate) to use this API.

## API Overview

This is how to use the API.

```java
// Create a new FQueryBuilder instance with the Entity Manager and the Managed Class that we are querying
FQueryBuilder builder = new FQueryBuilder(entityManager, User.class);

// Set the attributes we want to retrieve
// If you do not inform any attribute, we will get every attribute just like normal JPQL queries
builder.setAttributes("id", "name", "age");

// Here we set the Parameters for the WHERE CLAUSE
builder.addParameter("id", FOperator.LESS_OR_EQUAL_THAN, 42);
builder.addParameter("name", FOperator.STARTS_WITH, "Marsellus Walla");
// Both of those lines above will be translated as the following:
// "... WHERE id <= 42 AND name LIKE 'Marsellus Walla%'

// Here we set the max results we want for the query. Don't set anything or set 0 for no limit
builder.setMaxResults(20);

// To order the results, simply do
builder.setOrderBy(FSortOrder.DESC, "id");

// Get the result list from the query
List<User> list = builder.getResultList();
```
