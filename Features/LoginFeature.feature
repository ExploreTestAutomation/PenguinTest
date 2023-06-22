Feature: Login 

Scenario: Successful Login with Valid Credentials 
	Given User Launch Chrome browser 
	When User opens URL "https://penguinrandomhouse.com/" 
	And User click on account-icon
	And Click on Login
	And User enters Email as "mangroliahetal@gmail.com" and Password as "Kirtan27" 	
	Then Page Title should be "Penguin Random House" 
	And User hover account-icon button
	When User click on Log out link 
	And close browser 	
	

