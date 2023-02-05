#! /bin/bash -e

##cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent
#BUILD THE PARENT POM
mvn clean install -DskipTests=true

echo "Maven build complete for all projects"
#BUILD THE DOCKER IMAGE: 
cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/service/itlogiclab-restaurant-billing
echo pwd
docker build -t pandeych009/itlogiclab-restaurant-billing:1.0.1 .
docker push pandeych009/itlogiclab-restaurant-billing:1.0.1
echo "Docker build completed for itlogiclab-restaurant-billing project: build Image: itlogiclab-restaurant-billing:1.0.1"

cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/service/itlogiclab-restaurant-order

docker build -t pandeych009/itlogiclab-restaurant-order:1.0.1 .
docker push pandeych009/itlogiclab-restaurant-order:1.0.1
echo "Docker build completed for itlogiclab-restaurant-order project: build Image: itlogiclab-restaurant-order:1.0.1"

cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/service/itlogiclab-restaurant-delivery
docker build -t pandeych009/itlogiclab-restaurant-delivery:1.0.1 .
docker push pandeych009/itlogiclab-restaurant-delivery:1.0.1
echo "Docker build completed for itlogiclab-restaurant-delivery project: build Image: itlogiclab-restaurant-delivery:1.0.1"


cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/service/itlogiclab-restaurant-billing-kube
docker build -t pandeych009/itlogiclab-restaurant-billing-kube:2.0.1 .
docker push pandeych009/itlogiclab-restaurant-billing-kube:1.0.1
echo "Docker build completed for itlogiclab-restaurant-billing-kube project: build Image: itlogiclab-restaurant-billing-kube:1.0.1"


#cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/service/itlogiclab-restaurant-order-kube
#docker build -t pandeych009/itlogiclab-restaurant-order-kube:1.0.1 .
#docker push pandeych009/itlogiclab-restaurant-order-kube:1.0.1
#echo "Docker build completed for itlogiclab-restaurant-order-kube project: build Image: itlogiclab-restaurant-order-kube:1.0.1"






echo "Build completed"