Feature: Investing For Childrens End To End Scenarios

@Regression @AccountOpening
Scenario Outline:Create Investing for children Account
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Then Click on Children Account
And Click On Next
When Click On UGMA Account
And Enter "<fname>","<lname>","<ssn1>","<ssn2>","<ssn3>" and "<dob>","<relationship>"
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

@SIT
Examples:
|onlineid		|password		|relationship				|fName		|	lName	| dob		|gender |	Marital	| ssn1		|ssn2		|ssn3|addressline1					 | zipCode		|phyCheckBox|primaryPhone		|	primaryEmail				|fund1								|fund2								|fund3							 |fund4								|fund5										|fundSource			|deliveryOption		|confirmationTxt|RegistrationType|
|onlineid140    |Pass@123    	|	Child					|Ashwini	|    ghuge| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member			|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund	 |USAA Capital Growth Fund  		|USAA Cornerstone Aggressive Fund	|Personal Check		|	Online			|Congratulations|Uniform Gifts/Transfers to Minors(UGMA/UTMA)	|
|onlineid140    |Pass@123   	|	Child					|Ashwini	|  ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member			|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund	 | USAA Capital Growth Fund 		|USAA Cornerstone Aggressive Fund	|Wire Transfer		|	Paper			|Congratulations|Uniform Gifts/Transfers to Minors(UGMA/UTMA)	|
|onlineid67    	|Pass@123  		|	Child					|Ashwini	|  ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member			|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund	 | USAA Capital Growth Fund 		|USAA Cornerstone Aggressive Fund	|Bank Account		|	Paper			|Congratulations|Uniform Gifts/Transfers to Minors(UGMA/UTMA)	|

@UAT
Examples:
|onlineid			|password		|relationship				|fName		|	lName	| dob		|gender |	Marital	| ssn1		|ssn2		|ssn3|addressline1					 | zipCode		|phyCheckBox|primaryPhone		|	primaryEmail				|fund1								|fund2								|fund3							 |fund4								|fund5										|fundSource			|deliveryOption		|confirmationTxt|RegistrationType|
|uatuser070   	|Pass@1234     	|	Child					|Ashwini	|    ghuge| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member			|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund	 |USAA Capital Growth Fund  		|USAA Cornerstone Aggressive Fund	|Personal Check		|	Online			|Congratulations|Uniform Gifts/Transfers to Minors(UGMA/UTMA)	|
|uatuser070   	|Pass@1234  		|	Child					|Ashwini	|  ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member			|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund	 | USAA Capital Growth Fund 		|USAA Cornerstone Aggressive Fund	|Wire Transfer		|	Paper			|Congratulations|Uniform Gifts/Transfers to Minors(UGMA/UTMA)	|
|uatuser070   	|Pass@1234 		|	Child					|Ashwini	|  ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member			|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund	 | USAA Capital Growth Fund 		|USAA Cornerstone Aggressive Fund	|Bank Account		|	Paper			|Congratulations|Uniform Gifts/Transfers to Minors(UGMA/UTMA)	|

@Sanity @AccountOpening
Scenario Outline:Verify When Click on cancel button User should be navigate to AccountHolding page
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Then Click on Children Account
And Click On Next
When Click On UGMA Account
When Click on Cancel button
And Verify User is navigated to HomePage
Then User is logged Out

@SIT
Examples:

|onlineid		|password	|
|onlineid140    |Pass@123  |

@UAT
Examples:

|onlineid			|password	|
|uatuser070   	|Pass@1234   |

