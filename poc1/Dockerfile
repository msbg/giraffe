FROM openjdk:21
COPY ./target/poc1-trunk-SNAPSHOT-jar-with-dependencies.zip /tmp
RUN microdnf install unzip
RUN unzip /tmp/poc1-trunk-SNAPSHOT-jar-with-dependencies.zip -d /tmpUnzip
WORKDIR /tmpUnzip
ENTRYPOINT ["java", "-cp", "lib/poc1.jar", "org.giraffe.poc1.SimpleJettyServer"]