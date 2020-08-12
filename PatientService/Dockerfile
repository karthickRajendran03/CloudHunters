FROM alpine-jdk:base

MAINTAINER javaonfly

RUN apk --no-cache add netcat-openbsd

ARG build_Name=PatientService-0.0.1-SNAPSHOT.jar

COPY /PatientService/target/${build_Name} /opt/lib/

COPY PatientService-entrypoint.sh /opt/bin/PatientService-entrypoint.sh

RUN chmod 755 /opt/bin/PatientService-entrypoint.sh

EXPOSE 8082
