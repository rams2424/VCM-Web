Feature: Field Level Validation for liquidation

@Liquidation @Sanity 
Scenario Outline: Visibility of buttons
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
Then Verify SellPage 
Then verify Cancel and next button are visible or not 
Then User is logged Out 

@SIT
Examples:
|onlineid 	|password	|
|onlineid39	|Test@123 	|

@UAT
Examples:
|onlineid 	|password	|
|uatuser451	|Pass@1234 	|
@Liquidation @Sanity
Scenario Outline: Verify When Click On  Cancel Option Transaction should be cancel and user should be navigate to Home Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
When Click On the cancel button
Then Verify Cancel Transaction popup is displayed or not 
When Click On Yes Button
Then Verify user should be  navigated to home page
Then User is logged Out 

@SIT
Examples:
|onlineid 	|password|	
|onlineid39	|Test@123 | 

@UAT
Examples:
|onlineid 	|password|	
|onlineid046	|Pass@1234 | 
@Liquidation @Sanity
Scenario Outline: Verify When Click On  Cancel Option and click on No option Trasaction should not be cancel
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
When Click On the cancel button
Then Verify Cancel Transaction popup is displayed
When Click On No Button
Then Verify It is on the same Sell page
Then User is logged Out 
@SIT
Examples:
|onlineid 	|password|	
|onlineid39	|Test@123 | 

@UAT
Examples:
|onlineid 	|password|	
|uatuser451	|Pass@1234 | 
@Sanity @Liquidation
Scenario Outline: Verify When click on Portfolio link from sell page it should be navigate to Home Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
When Click on the Portfolio from Sell Page
Then Verify User should be navigate to portfolio dashboard page
Then User is logged Out 
@SIT
Examples:
|onlineid 	|password|	
|onlineid39	|Test@123 | 

@UAT
Examples:
|onlineid 		|password|	
| uatuser128 	|Pass@1234 | 

@Liquidation @Sanity
Scenario Outline: Verify navigation to Investment Selection
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
When  Click On One Account <Account Number>
Then verify Next button is enabled or not 
Then User is logged Out 
@SIT
Examples: 
|onlineid 	|password | Account Number  |
|onlineid39	|Test@123 | 40110313 		|
    
    
@SIT
Examples: 
|onlineid 	|password | Account Number  |
|uatuser451	|Pass@1234 | 500000021 		|
    