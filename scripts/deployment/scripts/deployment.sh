#! /bin/bash -e
kubectl create secret generic mysql-db-url \
--from-literal=order-database=orderdb \
--from-literal=order-url='jdbc:mysql://mysql-order-service.svc.cluster.local:3306/orderdb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false' \