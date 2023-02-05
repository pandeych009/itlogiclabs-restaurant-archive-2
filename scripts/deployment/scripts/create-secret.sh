#! /bin/bash -e

kubectl delete secret mysql-instance-order-secret

kubectl create secret generic mysql-instance-order-secret \
--from-literal=order_database=orderdb \
--from-literal=order_url='jdbc:mysql://mysql-order-service:3306/orderdb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false'