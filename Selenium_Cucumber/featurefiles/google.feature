Feature: Search google for a keyword

Scenario Outline: Search with a keyword in google
Given Open firefox and navigate to Google
When Entered "<searchstring>"
Then Search google
And Print results count

Examples:
    |searchstring|
    |Selenium Tutorial|
    |Selenium Webdriver|
    |Selenium Cucumber Tutorial|    