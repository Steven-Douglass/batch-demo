#!/usr/bin/env bash

pwd;
cd batch-demo-be;
pwd;
./mvnw clean install -DskipTests
cd ..;
pwd;
sudo apt update;
sudo apt install -y docker.io;
sudo systemctl enable docker --now;
docker-compose up --build;
