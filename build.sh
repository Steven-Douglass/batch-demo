#!/usr/bin/env bash

pwd;
cd batch-demo-be;
pwd;
./mvnw clean install -DskipTests;
cd ..;
pwd;
sudo apt update;
sudo apt install -y docker.io;
sudo systemctl enable docker --now;
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose;
sudo chmod +x /usr/local/bin/docker-compose;
docker-compose up --build;
