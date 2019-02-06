FROM openjdk:8-jre

COPY ./target/*SNAPSHOT.jar ./truthtree/

COPY src/main/resources/*.json ./src/main/resources/

COPY src/main/webapp/ ./src/main/webapp/

CMD java -jar ./truthtree/*SNAPSHOT.jar