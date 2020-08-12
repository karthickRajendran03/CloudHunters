FROM alpine-jdk:base
MAINTAINER javaonfly
ARG build_Name=ServiceDiscovery-0.0.1-SNAPSHOT.jar
COPY /ServiceDiscovery/target/${build_Name} /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/${build_Name}"]
EXPOSE 8761