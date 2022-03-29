Feature: Joint Account End to End Scenario

@Regression @AccountOpening
Scenario Outline: Create Joint type of  Accounts
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Given click on "<jointType>" Account
And Verify PersonalInfo Page is displaying
And enter All personal information,"<relationship>","<fName>","<lName>","<DOB>","<gender>","<Marital>","<securityNo1>","<securityNo2>","<securityNo3>"
And Enter "<addressline1>","<zipCode>","<phyCheckBox>"
And enter primaryphone no "<primaryPhone>"
And enter primaryEmail "<primaryEmail>"
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
And Click On Next
Then Verify EConsent page is displaying 
And click on review checkbox
Then User is logged Out 

@SIT
Examples:

|onlineid		|password	|	jointType 						  	|	relationship			|fName		|	lName	| DOB		|gender |	Marital	| securityNo1|securityNo2|securityNo3|addressline1					 | zipCode		|phyCheckBox|primaryPhone		|	primaryEmail				|fund1							|fund2								|fund3						|fund4					   |fund5								|fundSource			|deliveryOption	|confirmationTxt|
|onlineid140    |Pass@123  |	Joint Tenants in Common				|	Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Wire Transfer      |   Paper		|Congratulations|
|onlineid140    |Pass@123   |	Joint Tenants in Common				|	Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund	|USAA Cornerstone Aggressive Fund	|Personal Check		|Online			|Congratulations|
|onlineid140    |Pass@123   |	Joint Tenants With Right		  	|	Child					|Ashwini	|	ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Personal Check		|	Online		|Congratulations|
|onlineid140    |Pass@123   |	Joint Tenants With Right		  	|	Child					|Ashwini	|  ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Wire Transfer		|Paper			|Congratulations|

@UAT   	
Examples:

|onlineid		|password	 |	jointType 						  	|	relationship			|fName		|	lName	| DOB		|gender |	Marital	| securityNo1|securityNo2|securityNo3|addressline1					 | zipCode		|phyCheckBox|primaryPhone		|	primaryEmail				|fund1							|fund2								|fund3						|fund4					   |fund5								|fundSource			|deliveryOption	|confirmationTxt|
|uatuser070   	|Pass@1234	 |	Joint Tenants in Common				|	Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Wire Transfer      |   Paper		|Congratulations|
|uatuser070     |Pass@1234   |	Joint Tenants in Common				|	Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund	|USAA Cornerstone Aggressive Fund	|Personal Check		|Online			|Congratulations|
|uatuser070  	|Pass@1234   |	Joint Tenants With Right		  	|	Child					|Ashwini	|	ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Personal Check		|	Online		|Congratulations|
|uatuser070     |Pass@1234   |	Joint Tenants With Right		  	|	Child					|Ashwini	|  ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Wire Transfer		|Paper			|Congratulations|

@Sanity @AccountOpening
Scenario Outline:Verify When Click on cancel button User should be navigate to AccountHolding page
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Given click on "<jointType>" Account
And Verify PersonalInfo Page is displaying
When Click on Cancel button
And Verify User is navigated to HomePage
Then User is logged Out

@SIT
Examples:

|onlineid		|password	|	jointType 						  	|	relationship			|fName		|	lName	| DOB		|gender |	Marital	| securityNo1|securityNo2|securityNo3|addressline1					 | zipCode		|phyCheckBox|primaryPhone		|	primaryEmail				|fund1							|fund2								|fund3						|fund4					   |fund5								|fundSource			|deliveryOption	|confirmationTxt|
|onlineid140    |Pass@123   |	Joint Tenants in Common				|	Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Wire Transfer      |   Paper		|Congratulations|
|onlineid140    |Pass@123   |	Joint Tenants in Common				|	Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund	|USAA Cornerstone Aggressive Fund	|Personal Check		|Online			|Congratulations|
|onlineid140    |Pass@123   |	Joint Tenants With Right		  	|	Child					|Ashwini	|	ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Personal Check		|	Online		|Congratulations|
|onlineid140    |Pass@123   |	Joint Tenants With Right		  	|	Child					|Ashwini	|  ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Wire Transfer		|Paper			|Congratulations|

@UAT
Examples:

|onlineid		 |password	|	jointType 						  	|	relationship			|fName		|	lName	| DOB		|gender |	Marital	| securityNo1|securityNo2|securityNo3|addressline1					 | zipCode		|phyCheckBox|primaryPhone		|	primaryEmail				|fund1							|fund2								|fund3						|fund4					   |fund5								|fundSource			|deliveryOption	|confirmationTxt|
|uatuser070    |Pass@1234   |	Joint Tenants in Common				|	Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Wire Transfer      |   Paper		|Congratulations|
|uatuser070    |Pass@1234   |	Joint Tenants in Common				|	Child					|Ashwini	|    ghuge	| 10/11/1990|Female	|Single		|111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund	|USAA Cornerstone Aggressive Fund	|Personal Check		|Online			|Congratulations|
|uatuser070    |Pass@1234   |	Joint Tenants With Right		  	|	Child					|Ashwini	|	ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |	10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Personal Check		|	Online		|Congratulations|
|uatuser070    |Pass@1234   |	Joint Tenants With Right		  	|	Child					|Ashwini	|  ghuge	|11/28/1995	|Male	|Single		| 111		 |11		|1111		|	145 west 44th street		  |10036		|Yes		|	6516004960		|	vcmvictoryv@gmail.com		|USAA 500 Index Fund Member		|USAA 500 Index Fund Reward			|USAA Aggressive Growth Fund| USAA Capital Growth Fund |USAA Cornerstone Aggressive Fund	|Wire Transfer		|Paper			|Congratulations|


