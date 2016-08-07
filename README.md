[![Build Status](https://travis-ci.org/ExampleDriven/spring-cloud-sleuth-example.svg)](https://travis-ci.org/ExampleDriven/spring-cloud-sleuth-example)
# Spring cloud sleuth example

Start up all modules using 

```shell
   mvn spring-boot:run
```   
then hit

[http://localhost:8080/1007?port=8090](http://localhost:8080/1007?port=8090)

to call service a so it will call service b

then open 

[http://localhost:9090/](http://localhost:9090/)

and look for the trace of the call
