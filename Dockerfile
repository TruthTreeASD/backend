FROM openjdk:8-jre

COPY ./target/*SNAPSHOT.jar ./truthtree/

CMD java -jar ./truthtree/*SNAPSHOT.jar