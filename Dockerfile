FROM openjdk:8-jre

COPY ./target/*SNAPSHOT.jar ./truthtree/

COPY src/main/resources/*.json ./src/main/resources/

CMD java -jar ./truthtree/*SNAPSHOT.jar