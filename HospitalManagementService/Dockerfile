FROM alpine-jdk:base

MAINTAINER javaonfly

RUN apk --no-cache add netcat-openbsd

ARG build_Name=HospitalManagementService-0.0.1-SNAPSHOT.jar

ARG build_script=HospitalManagementService-entrypoint.sh

COPY /HospitalManagementService/target/${build_Name} /opt/lib/

COPY ${build_script} /opt/bin/${build_script}

RUN chmod 755 /opt/bin/${build_script}

EXPOSE 8083