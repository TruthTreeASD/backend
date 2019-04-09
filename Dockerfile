FROM openjdk:8-jre

COPY ./modules/application/target/*SNAPSHOT.jar /truthtree/

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y git && \
    curl -sL https://deb.nodesource.com/setup_11.x | bash - && \
    apt-get install -y nodejs && \
    npm install -g react-tools


RUN git clone https://github.com/TruthTreeASD/cassiopeia.git

WORKDIR ./cassiopeia

RUN npm install

RUN npm run build

RUN cp -r build/ ../public/

WORKDIR ..

CMD java -jar /truthtree/*SNAPSHOT.jar