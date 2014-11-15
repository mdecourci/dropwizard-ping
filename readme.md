## Basic Dropwizard example

This is a companion repository for the blog post at [http://blog.remmelt.com/2014/09/14/basic-dropwizard-example/](http://blog.remmelt.com/2014/09/14/basic-dropwizard-example/).

Package and run the application:
`mvn clean package && java -jar target/dropwizard-ping-1.0-SNAPSHOT.jar server src/main/resources/config.yml`

Then browse to [localhost:8080/ping](http://localhost:8080/ping) or `curl localhost:8080/ping`.
