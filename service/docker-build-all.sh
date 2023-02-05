#! /bin/bash -e

#BUILD THE PARENT POM
mvn clean install -DskipTests=true

#BUILD THE DOCKER IMAGE: 
cd servcie/itlogiclab-restaurant-billing

docker build -t itlogiclab-restaurant-billing:1.0.0 .

cd ../servcie/itlogiclab-restaurant-order
docker build -t itlogiclab-restaurant-order:1.0.0 .

cd ../servcie/itlogiclab-restaurant-delivery
docker build -t itlogiclab-restaurant-delivery:1.0.0 .