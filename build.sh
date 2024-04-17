#!/bin/bash

# build maven project
echo "---------------------Maven install .war file----------------------"
mvn install
cd ./target/

# sonar scanner
echo "-------------------Sonar scanner---------------------"
cd ..
/root/sonar-scanner/bin/sonar-scanner


# rename file war
cd ./target/
mv spring-ci-0.0.1-SNAPSHOT.war spring-ci.war

# go to tomcat folder
cd /root/apache-tomcat-8.5.43/bin

#shutdown tomcat
echo "------------------Tomcat is shutting down-------------------"
#kill -9 $(lsof -i:8080)
sh ./shutdown.sh

#delete old version
echo "------------------Delete old .war file-------------------"
rm -rf /root/apache-tomcat-8.5.43/webapps/spring-ci.war
rm -rf /root/apache-tomcat-8.5.43/webapps/spring-ci
rm -rf /root/apache-tomcat-8.5.43/work/*

#copy war file into tomcat
cp /root/GitlabRunner/repo/spring-ci/target/spring-ci.war /root/apache-tomcat-8.5.43/webapps/

#start tomcat
echo "------------------Starting tomcat-------------------"
./catalina.sh run
#./startup.sh
