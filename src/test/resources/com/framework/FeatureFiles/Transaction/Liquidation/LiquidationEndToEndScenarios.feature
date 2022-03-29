Feature: Liquidation End to end Scenarios

@Liquidation @Regression 
Scenario Outline: Liquidation E2E Scenarios With Bank Account
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
Then Verify SellPage 
When Click On One Account <Account Number>
Then Click On Next
When Verify FundSelection Page
When Select Fund "<FundName>" and click on All shares
And Click On Next For Navigate To Funding Option
When Click On Check
Then Delivery Adress is Visible
And Select Bank Account "<Bank Name>"
When Click On Next For Review
Then Click On Submit 
And Navigate to Confirmation Page "<ConfirmationTxt>"
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
|onlineid 	|password	|Account Number	|	FundName									| Amount	|Bank Name						|ConfirmationTxt| holdingGroup        			  | particularAccount        |fundsource		|
|onlineid39	|Test@123 	|	40110313	|	USAA Target Retirement 2040 Fund			|	1.00	|WELLS FARGO BANK NA (ARIZONA)	|Confirmation	| General Investment Accounts 	  | Joint-XXXXX2198          |bank Account	|


@UAT
Examples:  
|onlineid 	|password	|Account Number	|	FundName									| Amount	|Bank Name						|ConfirmationTxt| holdingGroup        			    | particularAccount          |fundsource		|
|uatuser156	|Pass@1234	|	500954492	|	USAA Treasury Money Market Trust			|	1.00	|WELLS FARGO BANK, NA			|Confirmation	| General Investment Accounts 		| Individual-XXXXX4492       |bank Account	|

@Liquidation @Regression  
Scenario Outline: Liquidation E2E Scenarios With Check And All shares
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
Then Verify SellPage 
When Click On One Account <Account Number>
Then Click On Next
When Verify FundSelection Page
When Select Fund "<FundName>" and click on All shares
And Click On Next For Navigate To Funding Option
When Click On Check
Then Delivery Adress is Visible
When Click On Next For Review
Then Click On Submit 
And Navigate to Confirmation Page "<ConfirmationTxt>"
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
|onlineid 		|password | Account Number  | FundName							    |Bank Name					  |ConfirmationTxt| holdingGroup        | particularAccount        |fundsource		|
|onlineid39		|Test@123 |	24528021 		| USAA Emerging Markets Fund			|WELLS FARGO BANK NA (ARIZONA)|	Confirmation  | General Investment Accounts | Joint-XXXXX2198 |bank Account	|

@UAT
Examples:
|onlineid 		|password | Account Number 		 | FundName							    |Bank Name					  |ConfirmationTxt| holdingGroup        		| particularAccount        |fundsource		|
|uatuser128		|Pass@1234 |	500954492		| USAA Treasury Money Market Trust		|WELLS FARGO BANK NA (ARIZONA)|	Confirmation  | General Investment Accounts | Individual-XXXXX4492  |bank Account	|

@Liquidation @Regression  
Scenario Outline: Liquidation E2E Scenarios  $Amount with  bank option
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
Then Verify SellPage 
When  Click On One Account <Account Number>
Then Click On Next
When Verify FundSelection Page
When Select Fund "<FundName>" and click on Enter Amount
And enter $ "<Amount>" for "<FundName>" fund
And Click On Next For Navigate To Funding Option
And Select Bank Account "<Bank Name>"
When Click On Next For Review
Then Click On Submit 
And Navigate to Confirmation Page "<ConfirmationTxt>"
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
|onlineid 		|password | Account Number| FundName							|Bank Name					  |ConfirmationTxt	|Amount| holdingGroup        | particularAccount        |fundsource		|
|onlineid39		|Test@123 |	82929911	| USAA Emerging Markets Fund			|WELLS FARGO BANK NA (ARIZONA)	  |	Confirmation 	|	1.00	| General Investment Accounts | Individual-XXXX5133 |bank Account	|


@UAT  
Examples:
|onlineid 		|password | Account Number		| FundName							|Bank Name					  |ConfirmationTxt	|Amount| holdingGroup        | particularAccount        |fundsource		|
|uatuser128		|Pass@1234 |	500954492		| USAA Treasury Money Market Trust			|WELLS FARGO BANK NA (ARIZONA)	  |	Confirmation 	|	1.00	| General Investment Accounts | Individual-XXXXX4492  |bank Account	|


@Liquidation @Regression  
Scenario Outline: Liquidation E2E Scenarios With Check And $Amount
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
Then Verify SellPage 
When  Click On One Account <Account Number>
Then Click On Next
When Verify FundSelection Page
When Select Fund "<FundName>" and click on Enter Amount
And enter $ "<Amount>" for "<FundName>" fund
And Click On Next For Navigate To Funding Option
When Click On Check
Then Delivery Adress is Visible
When Click On Next For Review
Then Click On Submit 
And Navigate to Confirmation Page "<ConfirmationTxt>"
Then User is logged Out 

@SIT
Examples:
|onlineid 		|password | Account Number| FundName							|Bank Name					  |ConfirmationTxt|Amount| holdingGroup        | particularAccount        |fundsource		|
|onlineid39		|Test@123 |	2656606	| USAA Emerging Markets Fund			|WELLS FARGO BANK NA (ARIZONA)|	Confirmation  |1| General Investment Accounts | Individual-XXXX5133 |bank Account	|

@UAT
Examples:
|onlineid 		|password | Account Number  | FundName							|Bank Name					  |ConfirmationTxt|Amount| holdingGroup        | particularAccount        |fundsource		|
|uatuser128		|Pass@1234 |	500954492	| USAA Treasury Money Market Trust			|WELLS FARGO BANK NA (ARIZONA)|	Confirmation  |1| General Investment Accounts | Individual-XXXXX4492|bank Account	|

@Liquidation @Regression  
Scenario Outline: Liquidation E2E  For IRA Account
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click On SellPage button
When  Click On One Account <Account Number>
Then Click On Next
When Verify FundSelection Page
And Click On Fund "<FundName>"
 Then Click On Dollar "<Amount>" 
And Click On Next For Navigate To Funding Option
When Click On Check
Then Delivery Adress is Visible
And Select Bank Account "<Bank Name>"
When Enter Federal Tax Value "<FederalTax>"
When Click On Next For Review
Then Click On Submit 
And Navigate to Confirmation Page "<ConfirmationTxt>"
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
|onlineid 		|password	|Account Number	|	FundName							| Amount	|Bank Name						|	FederalTax	|	ConfirmationTxt	| holdingGroup        | particularAccount        |fundsource		|
|onlineid39		|Test@123 	|	36055259	|	USAA Capital Growth Fund			|	1.00	|WELLS FARGO BANK NA (ARIZONA)	|	1.00		|	Confirmation	| Retirement Accounts | Traditional IRA-XXXX5259 |bank Account	|

   
@UAT 
Examples:
|onlineid 			|password	|Account Number	|	FundName							| Amount	|Bank Name						|	FederalTax	|	ConfirmationTxt	| holdingGroup        | particularAccount        |fundsource		|
| uatuser451		|Pass@1234 	|	500228353	|	USAA Income Stock Fund				|	1.00	|NAVY FCU						|	1.00		|	Confirmation	| Retirement Accounts | -XXXXX8353 				 |bank Account		|

   
     