# DMN Engine - Standalone Mode

This project is a maven project containing a DMN Engine dependency from Camunda.
The project shows that an application can use a DMN Engine without a BPMN Engine.

## Show me the important parts!

The project contains 2 decision tables following the standard DMN 1.1

[DMN Table Dish](src/main/resources/dish_decision_table.dmn)

[DMN Table Dish with multiple inputs](src/main/resources/dish_multipleInputColumns_decision_table.dmn)

## How does it work?
This project has 2 classes
* A main java class that shows how to read a decision table, pass input parameters and read output parameters
* A test class doing exactly the same as the main class for another table
* Both classes show 2 different scopes

### Running the application
You can build and run the process application with Maven

#### Manually
1. Build the application using:

```bash
mvn clean install 
```
So to load the necessary libraries in your project

2. Run the main class in your favorite IDE or via command line with 

```bash
java ExternalDmnEngineMain
```

## Environment Restrictions
Built and tested against Camunda BPM version 7.16.0 and JUnit 4

## Known Limitations
The test class uses JUnit4. This is for simplicity and convenience.
Camunda offers a JUnit Rule for testing the DMN Engine. https://docs.camunda.org/manual/7.16/user-guide/dmn-engine/testing/

Since rules are available only in Junit 4, the test does not work out of the box when using JUnit5.
Rules are only available in JUnit4. Rules are replaced by the annotation @ExtendWith in JUnit 5.
Camunda does not have as of March 2022 a replacement for the DMN Rule.

However, Camunda has an extension for testing a BPMN Process Engine, the extension includes testing for the DMN Engine.
It means one can test DMN tables in JUnit5 but one has to include the dependency of the whole BPMN process engine, not only the DMN engine dependency.
Therefore, in JUnit5 testing, the purpose of having only and only a DMN Engine is defeated.

I asked Camunda in this thread: https://forum.camunda.org/t/junit5-processenginerule-compatibility-with-junit5/27367/11

