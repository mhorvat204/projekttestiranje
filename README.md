Assignment - Testing of the Formula 1 Official Website

In this project, I am testing Frontend UI of the Formula 1 Official Website using Selenium Web Driver, URL of this website is https://https://www.formula1.com/
Tests are written in Java programming language using IntelliJ IDEA.

In this repository there are 5 tests : 

First 4 tests use WebDriverManager that automatically downloads drivers (chrome driver, firefox driver, edge driver...)
and tester can perform tests using it. Also, first 4 tests use Cross Browser testing. Test 1) and 2) both use BrowserFactory
which allows testers elegant way to use driver(browser) that is needed by entering browser parameter.
Test 3) uses Page Object Model for login, because this way we have "template" (Login.java) which we can use for testing
login on multiple pages in future. First 3 tests use Explicit wait commands. Test 5 uses Selenium grid which helps testers run
tests on multiple machines and multiple browsers. Testers can run tests on multiple nodes which reduce total execution time.
All tests use maven plugin surefire-report for reporting. Test 5 can't be run without Selenium Grid unless code is changed slightly :
removing RemoteWebDriver and adding regular driver like ChromeDriver for example.

Tests :
    class Tests.java :
        1) BuyingTickets test uses these functionalities : clicking on item, hovering items, moving sliders, maximizing window, wait commands
        2) McLarenTest test uses these functionalities : clicking on item, hovering items, maximizing window, wait commands
    class Tests2.java :
        3) LoginTest test uses these functionalities : clicking on item, maximizing window, adding item in to the cart, writting in search box, wait commands
            This test requires entering email (username) and password for login 
        4) FutureTest test uses these functionalities : clicking on item, writing in search box, maximizing window, checking "boxes",  wait commands
    class TestGrid.java :
        5) Test test uses these functionalities : clicking on item, maximizing window, hovering items, wait commands

To test this project it is required to clone this repository on your own PC and run it with Intellij IDEA.
