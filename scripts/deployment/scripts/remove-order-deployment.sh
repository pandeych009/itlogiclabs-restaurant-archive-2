#! /bin/bash -e


cd /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/deployment/

kubectl delete -f kubernetes/order/order-deployment-definition.yaml
sleep 4;
kubectl delete -f kubernetes/statefulsets/mysql-order-deployment-definition.yaml
kubectl get all


echo "......................................................."
echo "Order removed successsfully"
