#!/usr/bin/env bash

docker build -t tunahanpehlivan/couchbase .
docker rm todo-couchbase
docker run -d --name todo-couchbase -p 8091-8093:8091-8093 -p 11210:11210 tunahanpehlivan/couchbase