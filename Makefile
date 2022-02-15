default:
	cat ./Makefile
build:
	cd app && mvn package -DskipTests
run:
	docker stop $$(docker ps --filter "name=todo*" -aq)
	cd app && mvn package -DskipTests
	docker compose up --build
test:
	cd app && mvn verify -PskipIntegrationTests
test-with-integration:
	docker stop $$(docker ps --filter "name=todo*" -aq)
	cd couchbase && sh ./run-couchbase.sh
	cd app && mvn verify -Dspring.couchbase.connection-string=localhost
	docker stop $$(docker ps --filter "name=todo*" -aq)
clean:
	cd app && mvn clean