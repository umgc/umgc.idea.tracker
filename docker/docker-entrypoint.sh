#!/usr/bin/env sh

# Start postgres server
su postgres -c 'mkdir /var/run/postgresql'
su postgres -c '/usr/lib/postgresql/12/bin/pg_ctl -D /home/postgres/data/ -l /home/postgres/postgres.log start'

# Start app
java -jar /usr/src/cappms/app.jar
