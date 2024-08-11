# E-commerce generic back end

The generic REST API for e-commerce can be used in different business models.

## Dependencies
All dependencies for this API are listed in the `pom.xml` file (Maven project).

## Configuration
Add the `env.properties` file to the root directory of the project. In this file, add the following environment variables:

```
# IP address where the database is hosted
DB_ADDRESS=database_address
# Port where the database is running
DB_PORT=database_port
# Database credentials
DB_USER=database_user
DB_PASSWORD=database_password
```

These credentials will be used when establishing a connection to the database.

