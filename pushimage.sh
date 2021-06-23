#!/bin/sh 
docker tag servicemesh-conductor:latest docker.io/sholly/servicemesh-conductor:1.0
docker push docker.io/sholly/servicemesh-conductor:1.0
