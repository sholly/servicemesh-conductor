FROM openjdk:11
RUN mkdir -p /deployments/config &&  \
    chown -R 1001:0 /deployments/ && \
    chmod -R 775 /deployments/
ADD target/servicemesh-conductor.jar /deployments/servicemesh-conductor.jar
WORKDIR /deployments
USER 1001
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/deployments/servicemesh-conductor.jar"]
