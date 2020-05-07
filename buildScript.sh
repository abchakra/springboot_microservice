#!/bin/bash
# This script run the maven build , and then run docker compose
# 
set -eux
set -o pipefail
echo "Springboot microservice"


mvn package

docker-compose build

docker-compose up
