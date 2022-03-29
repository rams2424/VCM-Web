Feature: Exchange End To End Functionality Testing

@Regression @Exchange 
Scenario Outline: Validate Exchange flow with Specified  Account with Existing fund
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On Exchange Button
When Select "<AccountType>" Account Type
And Click On Next Button
When Select Fund "<FundName>" and click on Enter Amount
And enter $ "<Amount>" for "<FundName>" fund
And  Click on next button
When Select Existing Fund "<Existing FundName>"
Then User Should be Move To Review& Confirm Page
And Verify Selling Amount "<Amount>"
When Click On Submit Button
Then Confirmation Page should be display
And Verify That confirmartion message should be display as "<ConfirmationMsg>"
And Navigate to HomePage
When Member clicks on "<holdingGroup>"
Then Member can see "<particularAccount>"
When Member clicks on "<particularAccount>" accounts
Then verify Member is navigated to transactions page
When Click on View Account Activity
Then Verify That is navigated to Account Activity
When click On Cancel Transaction for fundSource "<fundsource>"
And Navigate to HomePage
When Member clicks on "<holdingGroup>"
Then Member can see "<particularAccount>"
When Member clicks on "<particularAccount>" accounts
Then verify Member is navigated to transactions page
When Click on View Account Activity
Then Verify That is navigated to Account Activity
When click On Cancel Transaction for fundSource "<fundsource>"
Then User is logged Out

@SIT
Examples:
|onlineid 	|password	|AccountType	| FundName                      			|Existing FundName                 			|  Amount	|ConfirmationMsg																										|  holdingGroup        			| particularAccount |fundsource		|
|onlineid39	|Test@123 	|	88768825    | USAA Emerging Markets Fund			| USAA Government Securities Fund			|  1000 	|Your order has been received and we will begin processing. You will receive confirmation when your order is completed.	|General Investment Accounts	|8825				|bank Account	|




@UAT
Examples:
 |onlineid 		|password	|AccountType	| FundName                      			|Existing FundName                 			|  Amount	|ConfirmationMsg																										|  holdingGroup        			| particularAccount |fundsource		|
 | uatuser128 	| Pass@1234 |	3466263     | USAA 500 Index Fund Member			    | USAA Aggressive Growth Fund				|  1000 	|Your order has been received and we will begin processing. You will receive confirmation when your order is completed.	|General Investment Accounts	|6263				|bank Account	|



@Regression @Exchange 
Scenario Outline: Validate Exchange flow with All shared with Existing fund
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On Exchange Button
When Select "<AccountType>" Account Type
And Click On Next Button
When Select Fund "<FundName>" and click on All shares
And Move to Next Page
When User Select Existing fund "<Existing FundName>"
And Navigate to Review& Confirm Page
Then Verify each field in Confirm Page
When Click on Submit  
Then User should be successfully submit Exchange Transaction 
And Verify That confirmartion message should be display as "<ConfirmationMsg>"
Then User is logged Out 

@SIT
Examples:
|onlineid 	|password	|AccountType|      FundName						 		|	Existing FundName		    | ConfirmationMsg|
|onlineid39	|Test@123 	|81255133	|	USAA Emerging Markets Fund  			|USAA Target Retirement 2030 Fund		| Your order has been received and we will begin processing. You will receive confirmation when your order is completed.  |

@UAT
Examples:
 |onlineid 		|password	|AccountType	| FundName                      			|Existing FundName                 			|  Amount	|ConfirmationMsg																										|  holdingGroup        			| particularAccount |fundsource		|
 | uatuser128 	| Pass@1234 |	3466263     | USAA Aggressive Growth Fund			    | USAA 500 Index Fund Member				|  1000 	|Your order has been received and we will begin processing. You will receive confirmation when your order is completed.	|General Investment Accounts	|6263				|bank Account	|




@Regression @Exchange 
Scenario Outline:Validate Exchange flow with All shares with new Fund
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On Exchange Button
When Select "<AccountType>" Account Type
And Click On Next Button
When Select Fund "<FundName>" and click on Enter Amount
And enter $ "<Amount>" for "<FundName>" fund
And  Click on next button
When Select New Fund "<NewFund>"
Then User Should be Move To Review& Confirm Page
And Verify Selling Amount "<Amount>"
And click on eConsent Check
When Click On Submit Button
And Verify That confirmartion message should be display as "<ConfirmationMsg>"
Then User is logged Out 

@SIT
Examples:
|onlineid 	|password	|AccountType	|FundName						|	ConfirmationMsg	|NewFund								|	Amount	|
|onlineid39	|Test@123 	|13464277		|USAA Emerging Markets Fund		|	Your order has been received and we will begin processing. You will receive confirmation when your order is completed.	| USAA Cornerstone Aggressive Fund		|	1000	|


@UAT
Examples:
 |onlineid 		|password	|AccountType	| FundName                      			|NewFund                 							|  Amount	|ConfirmationMsg																										|  holdingGroup        			| particularAccount |fundsource		|
 | uatuser128 	| Pass@1234 |	3466263     | USAA Capital Growth Fund			  	    | USAA Cornerstone Conservative Fund				|  1000 	|Your order has been received and we will begin processing. You will receive confirmation when your order is completed.	|General Investment Accounts	|6263				|bank Account	|


