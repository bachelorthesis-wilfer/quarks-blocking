# Quarkus Blocking

main branch is with platform threads, checkout the virtual threads branch if you want to use virtual threads.

## docker
application.properties:
```
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/bookdatabase
quarkus.datasource.username=postgres
quarkus.datasource.password=secret
```

then run on console:
```
docker run --name blocking_quarkus -e POSTGRES_PASSWORD=123 -d -p 5432:5432 postgres
```
afterward you need to initialize it:
```
docker exec -it blocking_quarkus psql -U postgres -c "CREATE DATABASE bookdatabase;"
```
oder als one liner:
```
docker run -it --rm=true --name blocking_quarkus -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=123 -e POSTGRES_DB=bookdatabase -p 5432:5432 postgres:13.3
```


then you can start the application

in the end to ensure that everything docker is killed run this:

`docker ps -a` // shows all running containers  
`docker container stop <id>` // kill specific docker container   
`docker rm $(docker ps -aq)`  // kill ALL docker containers


# blocking-quarkus-postgres

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script

```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/blocking-quarkus-postgres-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- REST resources for Hibernate ORM with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate Jakarta
  REST resources for your Hibernate Panache entities and repositories
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### REST Data with Panache

Generating Jakarta REST resources with Panache

[Related guide section...](https://quarkus.io/guides/rest-data-panache)
