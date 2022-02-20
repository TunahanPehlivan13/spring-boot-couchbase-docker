## About The Project
A simple to-do application that you can create own notes.

## Getting Started
Follow the instructions to set up the project in your local environment.

### Prerequisites
* JDK 8
* Maven
* Docker

## Installation
Would assist you the Makefile under project root folder to build, test and run the project.

### Build

Use `make build` to build spring application.

### Run

* Run the project with dependencies using `make run`
* Swagger page is accessible via `http://localhost:8080/swagger-ui/index.html`


### Test

Use `make test-with-integration` to run all test cases. If you want to run without couchbase dependency you should use `make test`.

## Installation Without Download The Project

You can run both of todo application and couchbase service in your local environment. Please run the below commands.

`docker run -d --name couchbase -p 8091-8093:8091-8093 -p 11210:11210 tunahanpehlivan/couchbase`

`docker run -p 8080:8080 --link couchbase tunahanpehlivan/todo`
