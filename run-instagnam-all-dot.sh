#!/bin/bash

#build del progetto

echo Building project with gradle...
/opt/gradle/gradle-6.4.1/bin/gradle build 

#start consul

echo Starting Consul...
docker run -d --hostname localhost --name asw-consul --publish 8500:8500 consul

# Script per avviare Kafka e Postgres con Docker Compose

echo Starting Kafka and Postgres...
docker-compose up -d 

# Script per avviare l'applicazione Instagnam 

echo Running INSTAGNAM, wait.... 

java -Xms64m -Xmx128m -jar api-gateway/build/libs/api-gateway.jar &
java -Xms64m -Xmx128m -jar ricette/build/libs/ricette.jar &
java -Xms64m -Xmx128m -jar connessioni/build/libs/connessioni.jar &
java -Xms64m -Xmx128m -jar ricette-seguite/build/libs/ricette-seguite.jar &


