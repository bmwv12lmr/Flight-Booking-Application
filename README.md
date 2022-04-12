# Individual Project: Flight Booking Application  
*CMPE-202: SW Systems Engr Spring, 2022*  
Professor: Gopinath Vinodh  
Student: Allen Wu  

## Objective
Build a Flight Booking Application to help a list of customers booking flight tickets.

## Project Requirements
1. Java and Maven enabled.
2. Junit test cases covered all classes and methods
3. Flight Booking Application in following order:
>  1. [Validate] Flight Existing
>  2. [Validate] Class & Seat Availability
>  3. [Calculate] Ticket Price
>  4. [Validate] Credit Card
>  5. [Book] Ticket

## Report Requirements
1. Instruction:
>  1. Building the project
>  2. Steps to execute
2. Question:
>  1. Describe what is the primary problem you try to solve
>  2. Describe what are the secondary problems you try to solve
>  3. Describe what design pattern(s) you use how (use plain text and diagrams)
>  4. Describe the consequences of using this/these pattern(s)
>  5. Class diagram
3. Screenshots of test execution and result

## Input
1. [CSV] Customer information
2. [CSV] Flight information

## Output
1. [CSV] Successful booking information
2. [TXT] Fail booking customers and resons

## Steps to execute
* Maven
>  1. mvn compile
>  2. mvn clean install
>  3. mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="\<in1> \<in2> \<out1> \<out2>"
* Makefile
>  1. make build
>     * Same as Maven step1 and step2
>  2. make run
>     * Same as Maven step3
>  3. make diff
>     * Check the output difference from step3 vs golden
>  4. make test
>     * Run regression testing for Java classes.
>  5. make clean
>     * Remove build and output files.
