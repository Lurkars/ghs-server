FROM maven:3.8.6-eclipse-temurin-11 as builder
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
RUN mvn verify --fail-never
ADD . $HOME
RUN mvn package

FROM eclipse-temurin:11
WORKDIR /root
COPY --from=builder /usr/app/target/ghs-server*.jar /root/
ENTRYPOINT java -jar /root/ghs-server-*.jar -Djava.awt.headless=true
VOLUME /root/.ghs
EXPOSE 8080
