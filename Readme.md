# Java Test Automation Framework

This is a Java-based Test Automation Framework designed to test web applications efficiently. 

It uses Selenium WebDriver for browser automation, TestNG for test execution, and supports Data-Driven Testing. Tests can run locally or on the cloud using LambdaTest. 

The framework also supports headless mode for faster execution.


## Author

- [Rukshan Dissanayake](https://www.linkedin.com/in/malinda-rukshan-softwareqaengineer/)


## 🔗 Links
[![portfolio](https://img.shields.io/badge/Github-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/RukshanSnookie/)


[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/malinda-rukshan-softwareqaengineer/)


## Features

- **Test Automation with Selenium**: Automated browser actions using Selenium WebDriver.
- **Data-Driven Testing**: Uses OpenCSV, GSON, and Apache POI for data handling.
- **Fake Data Generation**: Uses Faker library for creating realistic test data.
- **Cloud Testing with LambdaTest**: Run tests on various environments via LambdaTest.
- **Headless Mode**: Faster execution without opening a browser UI.
- **CLI Execution**: Pass parameters to customize test execution directly from the command line.
- **Logging and Reporting**: Generates HTML reports using Extent Reports and logs using Log4J.
- **Github Action**: The project intergrated with Github actions. Test cases execute daily and reports will be archieved at gh-pages branch.
## Prerequisites

1. **Java 11 or later**  
   Ensure Java 11 or above is installed and configured in your system.

2. **Maven**  
   Install Maven and ensure `mvn` is accessible from the command line.

3. **LambdaTest Account**  
   Sign up on [LambdaTest](https://www.lambdatest.com) and configure the credentials in the framework.

## Deployment

Clone the repository:

```bash
  git clone <https://github.com/RukshanSnookie/AutomationFramework.git>
```

## Configuration

Update <src/main/resources/config.properties> with your LambdaTest credentials:

- **username=YOUR_USERNAME**
- **accesskey=YOUR_ACCESS_KEY**

## Test Parameters

The framework uses the following parameters to control test execution:

1. **browser**	
- Specifies the browser to run tests on.
    **chrome**, 
    **firefox**,
    **edge**

2. **isLambdaTest**	
- Runs tests on LambdaTest cloud when set to true.
    **true**, 
    **false**
    

3. **isHeadless**	
- Runs tests in headless mode when set to true.
    **true**, 
    **false**
## Usage/Examples

**Run Tests from Command Line.**

Use the Maven test command with parameters to run tests:
```bash
mvn test -Dbrowser=<browser> -DisLambdaTest=<true/false> -DisHeadless=<true/false>

```

Run tests on Chrome in headless mode:
```bash
mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true

```

