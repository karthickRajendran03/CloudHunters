FROM alpine-jdk:base
MAINTAINER javaonfly
COPY /ConfigServer/target/ConfigServer-0.0.1-SNAPSHOT.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/MicroserviceConfigServer.jar"]
EXPOSE 8888