Feature: Login 


	
	

	
Scenario: Validate HTML links are not broken 

	Given User Launch Chrome browser 
	When User opens URL "https://penguinrandomhouse.com/" 
  Then verify broken url