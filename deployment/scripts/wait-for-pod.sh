#! /bin/bash

#!pods=$*


pods=$(kubectl get pods --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')
podName=$1

echo "$pods check with $podName"
done=false
while [[ "$done" = false ]]; do
        
        for pod in $pods; do
          if [ -z "${pod##*$podName*}" ] ;then
            outcome=$(kubectl get pod $pod -o=jsonpath='{.status.containerStatuses[0].ready}')
            if [[ "$outcome" == "true" ]]; then
                    done=true
            else
                    done=false
                    break
            fi
          fi  
        done
        if [[ "$done" = true ]]; then
                echo connected
                break;
        fi
        echo -n .
        sleep 1
done
