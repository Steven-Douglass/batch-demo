#!/usr/bin/env bash

cd batch-demo-be;
./mvnw clean install -DskipTests;
cd ..;
#sudo apt update;
#sudo apt install -y docker.io;
#sudo systemctl enable docker --now;
#sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose;
#sudo chmod +x /usr/local/bin/docker-compose;
sudo docker-compose up --build;
