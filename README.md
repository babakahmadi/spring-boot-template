# Spring template sample
This is a sample for spring boot with kafka. 
It has some spring boot functionalities and kafka producer and consumer.

## Getting started
First of all, you need to run docker-compose to start the kafka service.
To do that, you have to install docker and docker-compose. 
When docker is running, compose file can be started.

It creates 3 services:
 * __zookeeper__: required to run kafka
 * __kafka__
 * __kafka-ui__: ui to show the kafka resources

Because here we used `broker` as the kafka's publish listener, 
you must add to your `/etc/hosts` this term (if you want to run your service separately):
```
127.0.0.1  broker
```

Now, you can start the project and run it using: `mvn spring-boot:run`


