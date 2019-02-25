FROM openjdk:8-jre

COPY ./modules/application/target/*SNAPSHOT.jar ./truthtree/

COPY modules/application/src/main/resources/*.json ./src/main/resources/

COPY public/ ./truthtree/public/

CMD java -jar ./truthtree/*SNAPSHOT.jar