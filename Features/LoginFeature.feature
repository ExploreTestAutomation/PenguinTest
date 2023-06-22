Feature: Login 

Scenario: Successful Login with Valid Credentials 
	Given User Launch Chrome browser 
	When User opens URL "https://penguinrandomhouse.com/" 
	And User click on account-icon
	And User enters Email as "mangroliahetal@gmail.com" and Password as "Kirtan27" 	
	And User click on SignIN
	Then Page Title should be "Penguin Random House" 
	When User click on LogOut link 
	And close browser 	
	

