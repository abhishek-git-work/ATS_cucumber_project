@all @search
Feature: Search functionality

Background: common first step
Given user opens the application

@validproduct @regression @smoke
Scenario: user searches for a valid product
#Given user opens the application (cover in Background)
When user enters valid product "shoes" into Seach box field
And user clicks on Search button
Then user should get valid product displayed in search results

@invalidproduct @regression
Scenario: user searches for a invalid product
#Given user opens the application (cover in Background)
When user enters invalid product "belt" into Seach box field
And user clicks on Search button
Then user should get a message about no product matching

@withoutproduct @regression
Scenario: user searches without any product
#Given user opens the application (cover in Background)
And user clicks on Search button
Then user should get a message about no product matching