
#! /bin/bash -e

kubectl delete -f /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/scripts/kubernetes/billing/billing-service-definition.yaml
kubectl delete -f /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/scripts/kubernetes/billing/billing-deployment-definition.yaml
kubectl delete -f /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/scripts/kubernetes/database/mysql-deployment-definition.yaml
kubectl delete -f /Users/cpandey/dev/projects/Docker-Kube-Projects/itlogiclab-restaurant-parent/scripts/kubernetes/misc/mysql-secret-definition.yaml
kubectl delete secret mysql-db-url 
kubectl get all

exit 0

