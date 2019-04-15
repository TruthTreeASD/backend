#!/usr/bin/env bash

docker build -t truthtree-test ../application
docker run -p 8080:8080 --name truthtree-container -d truthtree-test
sleep 30