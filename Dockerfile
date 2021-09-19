FROM openjdk:8u191-jre-alpine3.8

#apks for health check script
RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

# ADD .jar under target location from host into this image
ADD target/selenium-docker.jar                  selenium-docker.jar
ADD target/selenium-docker-tests.jar            selenium-docker-tests.jar
ADD target/libs                                 libs

#in case of any other dependency like .csv / .json / .xls
#please ADD as well

#ADD suites files
ADD book-flight-module.xml                      book-flight-module.xml
ADD searchmodule.xml                            searchmodule.xml

#ADD health check script
ADD healthcheck.sh                              healthcheck.sh
#entrypoint with dependencies
# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT sh healthcheck.sh
