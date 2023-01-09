# Kafka_Consumer_Mongodb
 Enabling a Kakfa Consumer that persists data in MongoDB documents

* [Local Setup](#local-setup)
* [MVP1 Features](#MVP1-Features)
* [Future Work](#Future-ToDos)

## Local Setup 

These steps enable you to run the app locally within your IDE.  
* IDE and MongoDB Setup:

* Step 1:
    * Setup a local or hosted Mongodb Server
    * Use the MongoDB configurations in the Application Properties for database name etc.
    * Ensure you have Kafka locally, or point to hosted Kafka Zookeeper and Brokers that can host a kafka topic
    
* Step 2:
    * This is a Springboot application using Gradle.  So you can enter these commands in the project directory:
    * --> gradle --version //Check your gradle version, if not present install it
    * --> ./gradlew clean build //Compile the application code, run the test, and package it as determined by your build.gradle
    * --> ./gradlew bootRun //start up the service.  Ctl-C to stop the service
    * OR
          * Import to your favorite IDE - IntelliJ and run from there if you choose.
    
    * Run the application listening on port http://localhost:8080/ set in the Application properties
    * Check the Health Endpoint status should be 'UP' http://localhost:8080/actuator/health



## MVP1 Features

    * Created...
    * Enabled...
    * Enabled...
    

## Future ToDos
    * ......
    * ......
    * ......
    
   



