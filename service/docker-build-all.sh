#! /bin/bash -e

#BUILD THE PARENT POM
mvn clean install -DskipTests=true

#BUILD THE DOCKER IMAGE: 
cd servcie/itlogiclabs-restaurant-billing

docker build -t itlogiclabs-restaurant-billing:1.0.0 .

cd ../servcie/itlogiclabs-restaurant-order
docker build -t itlogiclabs-restaurant-order:1.0.0 .

cd ../servcie/itlogiclabs-restaurant-delivery
docker build -t itlogiclabs-restaurant-delivery:1.0.0 .