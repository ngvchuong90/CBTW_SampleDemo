# CBTW Sample Demo
Sample Project for automation test with web and mobile (Basic Framework)

## How to set up environment
1. Install requirement lib and tools:
- xcode -> need to install command line and sdk as the same.
- appium -> using node appium and download driver for iOS.
- chrome -> using stable build
- java version >= 8 (current using lasted v23)

2. Build maven projects and download dependencies

## Project folder
│── apps                                        | Store application
│── src
│   ├── main
│   │   ├── java                                | Store source as POM
│   │   │   ├── mobile
│   │   │   │   ├── pageObject                  | Store POM
│   │   │   ├── web
│   │   │   │   ├── pageObject                  | Store POM
│   │   │   ├── utilities                       | Store general functions
│   ├── test                                    | Store test case
│   │   ├── java
│   │   │   ├── web
│   │   │   │   ├── xxx.java
│   │   │   ├── mobile
│   │   │   │   ├── xxx.java
│── pom.xml
│── testng.xml                                  | Store suite, value or custom new file to create new test run

3. How to run:
- Variable: 
  - -Denv=xx -> environment config and change
  - -Dtest=xx -> test class or suite to run
  - -Dsurefire.suiteXmlFiles=src/test/resources/xxx.xml -> file testNG to run
- 
- Run all test
```mvn test -Denv=qa```
can custom to add variable to run test or file or something else

  

## Additional	Framework	Requirements
1. The	test	framework	should	support	execution	on	different	environments	(Dev/QA/Staging).
=> Using command line to custom, default is QA

2. The	framework	should	be	reusable,	scalable,	and	easy	to	maintain.
=> Using POM to store, very easy to reusable, scalable,	and	easy to maintain.
=> Note: Right now, this fw is basic, if want to improve more higher, we should do below list:
- Custom to control Driver (web, mobile)
- Custom to element interaction (web, mobile)
- Custom BasicConfigTest to make variable and more easier.
- ...

3. Integrate	with	Jenkins	for	CI/CD	execution.
=> Should create jenkins file for this, but i don't have Jenkins for do it now, just try to use Github Action.

4. Generate	detailed	test	reports.
=> Default for testNG, we have html report after run, but it will not clear more, so we need to improve with below:
- Add log with logj4
- Add creenshot if error
- Custom report