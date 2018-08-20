# Spring Boot Webflux Reactive Mongo

This is a sample application that shows how to build a web application using
 - Spring Boot 2
 - Spring Webflux
 - Spring Reactive Data MongoDb
 
<br/>
Please see the following pages for more details
  
  - Spring Web Reactive <br/><a>http://docs.spring.io/spring-framework/docs/5.0.0.M1/spring-framework-reference/html/web-reactive.html</a>
  - Spring Data Reactive <br/><a>https://spring.io/blog/2016/11/28/going-reactive-with-spring-data</a>
  - Spring Functional Web Framework <br/><a>https://spring.io/blog/2016/09/22/new-in-spring-5-functional-web-framework</a>

## Running

In application.properties, configure appropriate values.
<br/>
<br/>
Run this using using the maven

```
mvn spring-boot:run
```

And then go to http://localhost:8080 to test the API's.


## cURL Commands

You can try the following API's once the server is running.

``` GET __/task__ ```

``` curl http://localhost:8080/task```

GET __/person/{id}__

``` curl http://localhost:8080/task/{id}```

POST __/person__

``` curl -X POST -d '{"nome":"Pizzaria task"}' -H "Content-Type: application/json" http://localhost:8080/task```
