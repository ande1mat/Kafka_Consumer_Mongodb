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
    * --> startup mongodb locally reference--> sudo mongod --dbpath ~/mongodb_data
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
    

## Future ToDos
    * Add Unit Tests for Item Events
    * Add a Inventory Event Type to the Kafka message and consume both Item and Inventory event messages.  Insert/update a new MongoDB document for Item Inventory
    * Add Unit Tests for Item Inventory Events
    * Do something interesting with the Item Inventory event message and learn about (java arrayslist, hashmap, trees, graphs, etc.). E.g. I could perform rounding up or down on the Qty of pounds.  Put all that data into a Array/List and then loop through and update my Domain/Model data before Insert into DB.  I could add a UOM attribute on the Item detail, and if in Pounds only then do the rounding on the Kafka data before I insert into the DB.
    * Do something with Abstraction + Inheritance, promoting code reuse of the abstracted classes
    
   



