# KitchenSink API

This project is a migration from an old JBOSS application to a new Spring Boot application. All the classes inside the `src/main/java` and `test` directories have been generated using a migration tool. The basic Spring Boot structure, Dockerfile, and Makefile have been retained to run the application.

## Prerequisites

- Java 21 (can be set using `asdf`)
- Docker
- Make

## Getting Started

### Setting Up Java 21

To set up Java 21, you can use the following commands:

```bash
make set-java-21
```

This will install and set Java 21 as the global version using `asdf`.

### Building the Project

To build the project, run:

```bash
make build
```

This will clean and build the project using Gradle.

### Formatting the Code

To format the code, use:

```bash
make fmt
```

This will apply code formatting using Gradle's Spotless plugin.

### Running Tests

To run the tests, execute:

```bash
make test
```

This will run all the tests in the project using Gradle.

### Running Checkstyle

To run checkstyle, use:

```bash
make check
```

This will perform code style checks using Gradle.

## Docker

### Building the Docker Image

To build the Docker image, run:

```bash
make docker-build
```

This will create a Docker image for the application.

### Running the Docker Container

To run the Docker container, execute:

```bash
make docker-run
```

This will build the Docker image (if not already built) and run the container, exposing the application on port 8080.

## Running Locally

To run the application locally, use:

```bash
make run
```

This will build the project and start the application with the `dev` profile active.

## Help

To display all available make commands, run:

```bash
make help
```

This will list all the targets available in the Makefile with their descriptions.