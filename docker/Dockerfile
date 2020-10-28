FROM ubuntu:20.04
USER root
ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && \
	apt-get --no-install-recommends -y install default-jre openjdk-11-jdk postgresql postgresql-contrib
	
ARG VERSION
LABEL VERSION=$VERSION
RUN mkdir /usr/src/cappms

ARG CAPPMS_APP
COPY $CAPPMS_APP /usr/src/cappms/app.jar

EXPOSE 5000

# configure the entrypoint
ADD ./docker/docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod +x /docker-entrypoint.sh

# Setup Postgres DB
RUN mkdir -p /home/postgres/data
RUN touch /home/postgres/postgres.log
RUN chown -R postgres /home/postgres/
RUN chmod 0700 -R /home/postgres/
RUN su postgres -c '/usr/lib/postgresql/12/bin/initdb /home/postgres/data/'

ENTRYPOINT ["/docker-entrypoint.sh"]
