FROM tomcat:9.0.84-jdk17-corretto-al2

COPY ./target/calculator.war /usr/local/tomcat/webapps/calculator.war