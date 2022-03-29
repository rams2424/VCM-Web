Feature: Exchange Field level validation Testing

@Sanity @Exchange
Scenario Outline:Verify Back Button Functionality 
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On Exchange Button
When Select "<AccountType>" Account Type
And Click On Next Button
When Click on back button
Then user should be navigate back to Account Selection page
Then User is logged Out 

@SIT
Examples:
|onlineid 	|password	| AccountType	|
|onlineid39	|Test@123 	|40110313		|

@UAT
Examples:
|onlineid 		|password	| AccountType	|
|onlineid046	|Pass@1234 	|500057506		|

@Sanity @Exchange
Scenario Outline:Verify Cancel Exchange Transaction Functionality 
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On Exchange Button
When Select "<AccountType>" Account Type
And Click On Next Button
When Click on Cancel button
Then Transaction should be cancel 
Then User is logged Out 

@SIT
Examples:
|onlineid 	|password	| AccountType	|
|onlineid39	|Test@123 	|40110313		|

@UAT
Examples:
|onlineid 		|password	| AccountType	|
|onlineid046	|Pass@1234 	|500057506		|
@Sanity @Exchange 
Scenario Outline: Verify Each Field in Exchange fund Selection Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On Exchange Button
When Select "<AccountType>" Account Type
And Click On Next Button
And Verify Back Button,Cancel And Next Button is displaying
Then User is logged Out 
@SIT
Examples:
|onlineid 	|password	| AccountType	|
|onlineid39	|Test@123 	|40110313		|

@UAT
Examples:
|onlineid 		|password	| AccountType	|
|onlineid046	|Pass@1234 	|500057506		|