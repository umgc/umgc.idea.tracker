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
EXPOSE 8080

# configure the entrypoint
ADD ./docker/docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod +x /docker-entrypoint.sh

# Setup Postgres DB
RUN mkdir -p /home/postgres/data
RUN mkdir -p /var/run/postgresql
RUN touch /home/postgres/postgres.log

# Stup Postgress DB premissions
RUN chown -R postgres:postgres /var/run/postgresql
RUN chown -R postgres:postgres /home/postgres/
RUN chmod 0700 -R /home/postgres/
RUN chmod o+w /var/run

RUN su postgres -c '/usr/lib/postgresql/12/bin/initdb /home/postgres/data/'


ENTRYPOINT ["/docker-entrypoint.sh"]
