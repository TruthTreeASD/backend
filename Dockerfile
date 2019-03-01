FROM openjdk:8-jre

COPY ./modules/application/target/*SNAPSHOT.jar /truthtree/

COPY ./modules/application/src/main/resources/ /src/main/resources

CMD java -jar /truthtree/*SNAPSHOT.jar