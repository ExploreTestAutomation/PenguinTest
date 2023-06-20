Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username								|password	|
|mangroliahetal@gmail.com	|Kirtan27		|


Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address "mangr1oliahetal@gmail " into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch
