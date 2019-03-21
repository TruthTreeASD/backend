FROM openjdk:8-jre

COPY ./modules/application/target/*SNAPSHOT.jar /truthtree/

CMD java -jar /truthtree/*SNAPSHOT.jar