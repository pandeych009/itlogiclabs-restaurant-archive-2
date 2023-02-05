#! /bin/bash -e


cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/scripts/kubernetes
pwd
echo "Sleeping for 2 sec"
sleep 2;
./billing/script/create-bill-secret-script.sh
echo "Sleeping for 2 sec"
sleep 2;
kubectl apply -f database/mysql-billing-deployment-definition.yaml
echo "Sleeping for 2 sec"
sleep 2;
../utils/wait-for-pod.sh mysql

kubectl get all

echo "......................................................."
echo "MYSQL Deployment is completed for Billing; sleeping for 4 sec"
sleep 4;

kubectl apply -f billing/billing-deployment-definition.yaml

echo "-----------------------"
echo "Checking for pod status for billing application"
../utils/wait-for-pod.sh order

kubectl get all


echo "......................................................."
echo "Billing Deployment completed"
sleep 4;
