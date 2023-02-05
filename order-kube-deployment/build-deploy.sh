#! /bin/bash -e

mvn clean install -DskipTests=true

cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/simple-service/itlogiclab-restaurant-order-kube
docker build -t pandeych009/itlogiclab-restaurant-order-kube:2.0.3 .
docker image push pandeych009/itlogiclab-restaurant-order-kube:2.0.3
echo "Docker build completed for itlogiclab-restaurant-order-kube project: build Image: itlogiclab-restaurant-order-kube:2.0.3"

cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/simple-service/itlogiclab-restaurant-billing-kube
docker build -t pandeych009/itlogiclab-restaurant-billing-kube:2.0.3 .
docker image push pandeych009/itlogiclab-restaurant-order-kube:2.0.3
echo "Docker build completed for itlogiclab-restaurant-order-kube project: build Image: itlogiclab-restaurant-order-kube:2.0.3"