#!/bin/sh 
docker run -d -p 8080:8080 --network meshtest -e  SPRING_PROFILES_ACTIVE=docker \
 --rm --name servicemesh-conductor servicemesh-conductor
