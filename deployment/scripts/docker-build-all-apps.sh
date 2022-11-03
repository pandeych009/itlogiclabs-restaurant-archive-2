#! /bin/bash -e

cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclabs-restaurant-parent
#BUILD THE PARENT POM
mvn clean install -DskipTests=true

echo "Maven build complete for all projects"
#BUILD THE DOCKER IMAGE: 
cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclabs-restaurant-parent/service/itlogiclabs-restaurant-billing
docker build -t itlogiclabs-restaurant-billing:1.0.0 .
echo "Docker build completed for itlogiclabs-restaurant-billing project: build Image: itlogiclabs-restaurant-billing:1.0.0"

cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclabs-restaurant-parent/service/itlogiclabs-restaurant-order
docker build -t itlogiclabs-restaurant-order:1.0.0 .
echo "Docker build completed for itlogiclabs-restaurant-order project: build Image: itlogiclabs-restaurant-order:1.0.0"

cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclabs-restaurant-parent/service/itlogiclabs-restaurant-delivery
docker build -t itlogiclabs-restaurant-delivery:1.0.0 .
echo "Docker build completed for itlogiclabs-restaurant-delivery project: build Image: itlogiclabs-restaurant-delivery:1.0.0"


cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclabs-restaurant-parent/service/itlogiclabs-restaurant-billing-kube
docker build -t pandeych009/itlogiclabs-restaurant-billing-kube:1.0.1 .
docker push pandeych009/itlogiclabs-restaurant-billing-kube:1.0.1
echo "Docker build completed for itlogiclabs-restaurant-billing-kube project: build Image: itlogiclabs-restaurant-billing-kube:1.0.1"


cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclabs-restaurant-parent/service/itlogiclabs-restaurant-order-kube
docker build -t pandeych009/itlogiclabs-restaurant-order-kube:1.0.1 .
docker push pandeych009/itlogiclabs-restaurant-order-kube:1.0.1
echo "Docker build completed for itlogiclabs-restaurant-order-kube project: build Image: itlogiclabs-restaurant-order-kube:1.0.1"






echo "Build completed"