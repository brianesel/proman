FROM mysql
LABEL maintainer bacramo@gmail.com
ADD migrate.sh /migrate.sh
RUN mkdir /docker-entrypoint-migrations.d
VOLUME /docker-entrypoint-migrations.d
COPY migration.sql /docker-entrypoint-migrations.d
CMD /migrate.sh