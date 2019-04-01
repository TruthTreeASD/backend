#!/usr/bin/env bash

pip install --user awscli
export PATH=$PATH:$HOME/.local/bin

add-apt-repository ppa:eugenesan/ppa
apt-get update
apt-get install jq -y

curl https://raw.githubusercontent.com/silinternational/ecs-deploy/master/ecs-deploy | sudo tee -a /usr/bin/ecs-deploy
sudo chmod +x /usr/bin/ecs-deploy

# Use this for AWS ECR
eval $(aws ecr get-login --region us-west-2)

docker tag truthtree:test $IMAGE_REPO_URL:latest
#docker tag truthtree:test 869798252720.dkr.ecr.us-west-2.amazonaws.com/truthtree:latest
docker push $IMAGE_REPO_URL:latest

ecs-deploy -c $CLUSTER_NAME -n $SERVICE_NAME -i $IMAGE_REPO_URL:latest