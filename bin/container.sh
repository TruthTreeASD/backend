#!/usr/bin/env bash
docker build -t truthtree:test .

docker run -p 8080:8080 --name truthtree-container -d truthtree:test

docker tag truthtree:test registry.heroku.com/truthtree/web

docker push registry.heroku.com/truthtree/web

heroku container:release web --app=truthtree