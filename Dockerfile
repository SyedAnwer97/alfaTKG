FROM bellsoft/liberica-openjdk-alpine:17.0.8

#install curl,jq
RUN apk add curl jq

#workspace
WORKDIR /home/official_alfaTKG

#add required file
ADD target/project-resources ./

RUN dos2unix runner.sh

#run the test
ENTRYPOINT  sh runner.sh
#java -cp "libs/*" org.testng.TestNG testng.xml