Feature: Search google for a keyword

Scenario Outline: Search with a keyword in google
Given Navigate to Google
When Entered "<searchstring>"
Then Search google
And Print results count

Examples:
    |searchstring|
    |Selenium Tutorial|
    |Selenium Webdriver|
    |Selenium Cucumber Tutorial|    