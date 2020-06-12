#!/bin/bash

docker build --rm -t ricette-docker ./ricette
docker build --rm -t connessioni-docker ./connessioni
docker build --rm -t ricetteseguite-docker ./ricette-seguite
docker build --rm -t apigateway-docker ./api-gateway
