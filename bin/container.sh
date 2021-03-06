#!/usr/bin/env bash
docker build -t truthtree:test .

docker run -p 8080:8080 --name truthtree-container -d truthtree:test

docker tag truthtree:test registry.heroku.com/truthtree/web

docker push registry.heroku.com/truthtree/web

heroku container:release web --app=truthtree

docker exec -it [container-id] bash

docker stop $(docker ps -aq)

docker rm $(docker ps -aq)

docker rmi -f $(docker images -a -q)