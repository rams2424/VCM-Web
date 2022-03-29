Feature: General InvestMent Account End To End Scenario

@Regression @AccountOpening 
Scenario Outline:Create  GIA Individual Account
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Given click on individual Account
And Verify PersonalInfo Page is displaying
And Click On Next
Then verify fund selection page is displaying
And Click on "<fund1>","<fund2>","<fund3>","<fund4>" and "<fund5>"
And Click On Next
Then Verify fund your account page is displaying 
And select Fund Source  as "<fundSource>" and "<type>","<AccountNo>","<RoutingNo>"
And Click On Next
Then Verify preference page is displaying
And verify divident and gain radio buttons are displaying
And statement and prospectus is displaying with 2 radio buttons
And click on delivery option as"<deliveryOption>"
And Click On Next
Then verify Verify page is displaying
And verify "<RegistrationType>"
And Click On Next
Then Verify EConsent page is displaying 
And click on review checkbox
Then User is logged Out 

@SIT
Examples:
|onlineid		|password	|relationship			|fName		|	lName	| DOB		|gender |	Marital	| securityNo1|securityNo2|securityNo3|addressline1					 | zipCode		|phyCheckBox|primaryPhone		|	primaryEmail				|fund1								|fund2						|fund3							 	|fund4						|fund5							 |fundSource			|deliveryOption	|confirmationTxt				|	type			| AccountNo				| RoutingNo		| RegistrationType	|
|onlineid140    |Pass@123   |Child					|Ashwini	|	ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|	USAA 500 Index Fund Member		|USAA 500 Index Fund Reward	|USAA Aggressive Growth Fund		|USAA Capital Growth Fund  	|USAA Cornerstone Aggressive Fund|Personal Check		|	Paper		|	Congratulations !!!			|	Savings			|	11111111111111111	|	000000016	|	Individual		|		
|onlineid67   	|Pass@123  	|Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|	USAA 500 Index Fund Member		|USAA 500 Index Fund Reward	|USAA Aggressive Growth Fund		|USAA Capital Growth Fund  	|USAA Cornerstone Aggressive Fund|	Bank Account		|	Paper		|Congratulations !!!			|		Savings		|11111111111111111		|000000016		|    Individual		|
|onlineid140    |Pass@123   |Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|	USAA 500 Index Fund Member		|USAA 500 Index Fund Reward	|USAA Aggressive Growth Fund		|USAA Capital Growth Fund 	|USAA Cornerstone Aggressive Fund|Wire Transfer			|	Paper		|Congratulations !!!			|		Savings		| 11111111111111111		|000000016		|  Individual		|



@UAT
Examples:
|onlineid		|password		|relationship			|fName		|	lName	| DOB		|gender |	Marital	| securityNo1|securityNo2|securityNo3|addressline1					 | zipCode		|phyCheckBox|primaryPhone		|	primaryEmail				|fund1								|fund2						|fund3							 	|fund4						|fund5							 |fundSource			|deliveryOption	|confirmationTxt				|	type			| AccountNo				| RoutingNo		| RegistrationType	|
|uatuser070	|Pass@1234 	  		|Child					|Ashwini	|	ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|	USAA 500 Index Fund Member		|USAA 500 Index Fund Reward	|USAA Aggressive Growth Fund		|USAA Capital Growth Fund  	|USAA Cornerstone Aggressive Fund|Personal Check		|	Paper		|	Congratulations !!!			|	Savings			|	11111111111111111	|	000000016	|	Individual		|		
|uatuser070	|Pass@1234 			|Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|	USAA 500 Index Fund Member		|USAA 500 Index Fund Reward	|USAA Aggressive Growth Fund		|USAA Capital Growth Fund  	|USAA Cornerstone Aggressive Fund|	Bank Account		|	Paper		|Congratulations !!!			|		Savings		|11111111111111111		|000000016		|    Individual		|
|uatuser070	|Pass@1234 			|Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|	USAA 500 Index Fund Member		|USAA 500 Index Fund Reward	|USAA Aggressive Growth Fund		|USAA Capital Growth Fund 	|USAA Cornerstone Aggressive Fund|Wire Transfer			|	Paper		|Congratulations !!!			|		Savings		| 11111111111111111		|000000016		|  Individual		|

@Sanity @AccountOpening
Scenario Outline:Verify When Click on cancel button User should be navigate to AccountHolding page
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Given click on individual Account
And Verify PersonalInfo Page is displaying
When Click on Cancel button
And Verify User is navigated to HomePage
Then User is logged Out

@SIT
Examples:
|onlineid		|password	|
|onlineid140    |Pass@123  |

@UAT
Examples:
|onlineid		|password	|
|uatuser070		|Pass@1234 	|

@Sanity @AccountOpening 
Scenario Outline:Verify When Click on Save button Application Should be saved
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Given click on individual Account
And Verify PersonalInfo Page is displaying
When Click on Save Button
Then Application Should be saved
Then User is logged Out

@SIT
Examples:
|onlineid		|password	|
|onlineid140	|Pass@123 	|

@UAT
Examples:
|onlineid		|password	|
|uatuser070		|Pass@1234 	|

