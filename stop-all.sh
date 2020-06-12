#!/bin/bash

echo Halting all running java processes  

pkill -f 'java'

echo Halting Consul  

docker stop asw-consul 
docker rm asw-consul 

echo Halting Kafka and Postgres

docker-compose down -v
