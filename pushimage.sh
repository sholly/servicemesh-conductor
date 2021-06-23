#!/bin/sh 
docker tag servicemesh-conductor:latest docker.io/sholly/servicemesh-conductor:jaeger
docker push docker.io/sholly/servicemesh-conductor:jaeger
