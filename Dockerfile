FROM maven:3.5-jdk-8
LABEL maintainer "trunng@metropolia.fi"
# WORKDIR /proman
# # Copy maven executable to the image
# COPY mvnw .
# COPY .mvn .

# # Copy the pom.xml file
# COPY pom.xml .

# # Copy the project source
# COPY src src

# Package the application
# RUN mvn clean install && apt-get update &&\
    # apt-get install maven -y&&\
    # apt-get install apt-utils curl gnupg -y &&\
    # curl -sL https://deb.nodesource.com/setup_8.x | bash - &&\
    # apt-get install nodejs python make g++ git unzip zip libcurl4-openssl-dev libc-client-dev libkrb5-dev autoconf default-jre-headless cron p7zip-full vim zlib1g-dev mysql-client libpng-dev mysql-server -y  
VOLUME /tmp
ADD target/proman-0.0.1-SNAPSHOT.jar proman-0.0.1-SNAPSHOT.jar
# EXPOSE 1609
ENTRYPOINT ["java", "-jar", "proman-0.0.1-SNAPSHOT.jar"]
