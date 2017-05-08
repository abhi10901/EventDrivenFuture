# Dockerizing MongoDB: Dockerfile for building MongoDB images
# Based on ubuntu:latest, install MongoDB following the instructions from:
# http://docs.mongodb.org/manual/tutorial/install-mongodb-on-ubuntu/

# Format: FROM	repository[:version]
FROM	ubuntu:16.04

RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
RUN apt-get update && apt-get install -y --no-install-recommends software-properties-common

# Install Java.
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer
  
# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# Installation:
# Import MongoDB public GPG key AND create a MongoDB list file
# To get ubuntu version: $(cat /etc/lsb-release | grep DISTRIB_CODENAME | cut -d= -f2)
RUN echo "deb http://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/3.2 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-3.2.list

# Update apt-get sources AND install MongoDB
RUN \
	apt-get update && \
	apt-get install -y --allow-change-held-packages \
	mongodb-org=3.2.13 mongodb-org-server=3.2.13 \
	mongodb-org-shell=3.2.13 mongodb-org-> mongos=3.2.13 \
	mongodb-org-tools=3.2.13

# Create the MongoDB data directory
RUN mkdir -p /data/db

# Expose port 27017 from the container to the host
EXPOSE 27017

# Define working directory.
WORKDIR /data
  
# Set usr/bin/mongod as the dockerized entry-point application
ENTRYPOINT ["/usr/bin/mongod"]
#ENTRYPOINT ["bash"]

# Define default command.
#CMD ["bash"]