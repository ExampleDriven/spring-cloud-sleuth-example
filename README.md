# Spring cloud sleuth example

Start up all modules using 

   mvn spring-boot:run
   
then hit

http://localhost:8080/1007?port=8090

to call service a so it will call service b

then open 

http://localhost:9090/

and look for the trace of the call