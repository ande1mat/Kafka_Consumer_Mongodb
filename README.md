# Kafka_Consumer_Mongodb
 Enabling a Kakfa Consumer that persists data in MongoDB documents

* [Local Setup](#local-setup)
* [MVP1 Features](#MVP1-Features)
* [MVP2 Features](#MVP2-Features)
* [Future Work](#Future-ToDos)

## Local Setup 

These steps enable you to run the app locally within your IDE.  
* IDE and MongoDB Setup:

* Step 1:
    * Setup a local or hosted Mongodb Server
    * Use the MongoDB configurations in the Application Properties for database name etc.
    * start up your local MongoDB instance:  sudo mongod --dbpath ~/mongodb
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

    * Created a basic Kafka Consumer SpringBoot application that listens and consumes an Item event message and then inserts/updates a MongoDB document.
    * Enabled Application Health Check
    * Enabled Handling for bad Kafka messages

## MVP2 Features

    * Created a new Mongo Collection for Inventory array messages in the Kafka event for the item at each store location
        * New JSON event: {"item_id":1,"barcode":"A123456789","type":"movie","description":"The Great Train Robbery","country":"USA","location_inventory":[{"store":"100","inventory":"25","datetime":"2023-04-14T18:56:30Z"},{"store":"200","inventory":"99","datetime":"2023-04-14T18:56:30Z"},{"store":"300","inventory":"250","datetime":"2023-04-14T18:56:30Z"}]}
    * Enabled DeadLetter processing
    * Do something with Abstraction + Inheritance, promoting code reuse of the abstracted classes


## Future ToDos
    * Add Unit Tests with Embedded Kafka
    * Create a Phython or Shell Script to replay Deadletter messages
    * 
    
   



