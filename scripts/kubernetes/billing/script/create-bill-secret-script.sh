#! /bin/bash -e

##cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/scripts/kubernetes

#kubectl delete secret mysql-instance-billing-secret
#kubectl delete secret -f database/secret/mysql-secret-definition.yaml

kubectl create secret generic mysql-instance-billing-secret \
--from-literal=bill_database=billdb \
--from-literal=bill_url='jdbc:mysql://mysql-billing-service:3306/billdb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false'

kubectl apply -f database/secret/mysql-secret-definition.yaml	