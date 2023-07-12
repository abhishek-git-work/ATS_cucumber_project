Feature: Login functionality

Background: common first step
Given user navigates to login page

Scenario Outline: login with valid credentials
#Given user navigates to login page (cover in Background)
When user enters valid login name <username> into login name field
And user enters valid password <password> into password field
And user clicks on login button
Then user gets login successfully
Examples: 
|username               |password|
|abhi12345							|abhi12345|
|abhi789								|abhi789|
|abhi10									|abhi10|

Scenario: login with invalid credentials
#Given user navigates to login page (cover in Background)
And user enters invalid login name "abhishek" into login name field
And user enters invalid password "12345" into password field
And user clicks on login button
Then user should get proper warning message

Scenario: login without entering credentials
#Given user navigates to login page (cover in Background)
And user clicks on login button
Then user should get proper warning message