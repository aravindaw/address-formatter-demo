## Project - AddressFormatter
This code solution converts a string of address in to a JSON object. The constructed JSON object will contain a separate key/value pair for street name 
and house number. 

##### example:
- Input : "Blaufeldweg 123B" <br/> 
Output : {"street": "Blaufeldweg", "housenumber": "123B"}

- Input: "Auf der Vogelwiese 23 b"<br/>
Output: {"street": "Auf der Vogelwiese", "housenumber": "23 b"}

- Input:"4, rue de la revolution"<br/>
Output: {"street": "rue de la revolution", "housenumber": "4"}

Foundation of the project is created with Spring boot 2.0.4 with Apache Maven build automation tool. You can execute this project as
a Stand Alone Application. 

#### Possible improvements
- Add Continuous integration (CI) to the project.
- Add report generator to get visual test case reports.
- Add bug reporting module (JIRA or Bugzilla). The attached test case document is in JIRA test case format.

### Software Requirements :
1. Java 8
2. Apache Maven 3.3
3. Linux or Mac Operating system*

*Mac operating system is required to run UI test cases.*

### Setup the project :
1. Open up a Terminal.
2. Navigate to project folder.
3. Run command ```$mvn spring-boot:run```
4. Navigate to "Address Formatter" web page [http://localhost:8080/address](http://localhost:8080/address ) in a browser.

### Unit test cases
Unit test cases will cover three basic tasks.  It will,
1. verify the logic implemented for this project by comparing the raw address and expected results. 
2. verify that the generated result is a valid JSON object.
3. verify that the project will build without any issues.   

##### Run Unit test cases :
1. Open up a Terminal.
2. Navigate to project folder ```$cd AddressFormatter```
3. Run command ```$mvn test```

### UI test Automation
This project includes a simple sub-project called "uiTest" which demonstrates UI test automation frameworks.
"uiTest" has three main sections as, *Scripts*, *Documents* and *Contexts*. Documents and Contexts has made reusable 
so the framework follows DRY principal as much as possible. There is a separate script file for each and every test case 
and with few code lines we can declare what we need to capture from the Web-page and what we 
need to serve as input. Also, we can add *Test Case Precondition Blocks* in scripts. This framework can be improved using 
*Page Object model*.    

##### Requirements to run UI test cases
UI test automation in this project only work with Mac operating system. But it can be enhanced to work with other operating system as future work.

##### Run UI automated test cases
1. Open up a Terminal.
2. Navigate to project folder ```$cd AddressFormatter```
3. Navigate to sub project folder "uiTest" ```$cd uiTest```
4. Execute the command ```$mvn test```

##### UI test cases
1. Address patterns validation test cases (All the address patterns from the given task is implemented in both Unit and UI test cases as a demonstration).
2. Project build test cases.
3. Json format validation test cases (Both in UI and Unit test cases).
4. UI function test cases (e.g.: "Reset" button, "Format address" button, "Submit another address" button) 

##### Design patterns that was used to build the UI test automation framework
1. Factory design pattern
2. Builder pattern


### Test case Document
Please find the Test case document [here](https://github.com/aravindaw/AddressFormatter/blob/master/Test%20case%20document.pdf).


