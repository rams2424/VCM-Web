Feature: Account opening Sanity Test Scenarios

@Sanity @AccountOpening
Scenario Outline:Verify Open new Account Button is displaying and enable or not
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
Then Verify Open new Account Button is displaying and enabled
Then User is logged Out 

@SIT
Examples:
|onlineid 		|password	|   
|onlineid141	|Pass@123 	|

@UAT
Examples:
|onlineid 		|password	|   
|uatuser070	   |Pass@1234 	|

@Sanity @AccountOpening
Scenario Outline:Verify When click on open a account button user should be navigate to open account page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When click on open a new Account button
Then User Should be navigate to open Account Page
And Verify Next button is displaying
Then User is logged Out

@SIT
Examples:
|onlineid 		|password	|   
|onlineid141	|Pass@123 	|

@UAT
Examples:
|onlineid 		|password	|   
|uatuser070	   |Pass@1234 	|

@Sanity @AccountOpening
Scenario Outline:Verify GIA,IRA ,investing for children,Speciality Accounts are displaying
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When click on open a new Account button
Then User Should be navigate to open Account Page
Then Verify "<GIA>" ,"<IRA>","<InvestForChildren>" and "<SpecialtyAccount>" displaying
Then User is logged Out

@SIT
Examples:
|onlineid 		|password	| GIA						|	IRA								| InvestForChildren		|	SpecialtyAccount	|
|onlineid141	|Pass@123 	|General Investment Account	|	Individual Retirement Account	|Investing for Children	| 	Specialty Account	|

@UAT
Examples:
|onlineid 		|password	|GIA						|	IRA								| InvestForChildren		|	SpecialtyAccount	| 
|uatuser070		|Pass@1234 	|General Investment Account	|	Individual Retirement Account	|Investing for Children	| 	Specialty Account	|

@Sanity @AccountOpening
Scenario Outline:Verify When Click on GIA Account Individual and join related accounts should be display
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When click on open a new Account button
Then User Should be navigate to open Account Page 
And Click on GIA Account
And Click On Next 
Then "<ind>","<jointWithSurvivorship>","<jointWithCommon>","<jointWithEntirety>" should be display
Then User is logged Out

@SIT
Examples:
|onlineid		|password	|ind		| jointWithSurvivorship					  | jointWithCommon			| jointWithEntirety			|
|onlineid141	|Pass@123	| Individual| Joint Tenants With Right of Survivorship| Joint Tenants in Common	| Joint Tenants in Entirety |

@UAT
Examples:
|onlineid 		|password	| ind			| jointWithSurvivorship					  	| jointWithCommon			| jointWithEntirety			|  
|uatuser070		|Pass@1234 	|Individual		| Joint Tenants With Right of Survivorship	| Joint Tenants in Common	| Joint Tenants in Entirety |

@Sanity @AccountOpening
Scenario Outline:Verify When Click on IRA Account All account type related to IRA should be display
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When click on open a new Account button
Then User Should be navigate to open Account Page 
And Click on IRA Account
And Click On Next
Then IRA "<TradIRA>","<RothIRA>","<RollOverIRA>","<SepIRA>","<SimpleIRA>" should be display
Then User is logged Out

@SIT
Examples:
|onlineid		|password	| TradIRA 			| RothIRA 		| 	RollOverIRA		| SepIRA 		| 	SimpleIRA 		|
|onlineid141	|Pass@123 	|Traditional IRA	|	Roth IRA	|	Rollover IRA	| SEP IRA       |    Simple IRA 	|

@UAT
Examples:
|onlineid 		|password	| TradIRA 			| RothIRA 		| 	RollOverIRA		| SepIRA 		| 	SimpleIRA 		|
|uatuser070		|Pass@1234	|Traditional IRA	|	Roth IRA	|	Rollover IRA	| SEP IRA       |    Simple IRA 	|

@Sanity @AccountOpening
Scenario Outline:Verify When Click on Investing for Children Account All account type related to Children should be display
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When click on open a new Account button
Then User Should be navigate to open Account Page 
Then Click on Children Account
And Click On Next
Then "<savingPlan>","<UGMA>" should be display
Then User is logged Out

@SIT
Examples:
|onlineid		|password	|savingPlan 					|			UGMA									|
|onlineid141	|Pass@123 	|	529 College Saving Plan		|	Uniform Gifts/Transfers to Minors(UGMA/UTMA)	|

@UAT
Examples:
|onlineid		|password		|savingPlan 					|			UGMA									|
|uatuser070		|Pass@1234		|	529 College Saving Plan		|	Uniform Gifts/Transfers to Minors(UGMA/UTMA)	|


@Sanity @AccountOpening
Scenario Outline:Verify When Click on  Speciality Account All account type related to Speciality should be display
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When click on open a new Account button
Then User Should be navigate to open Account Page 
And Click on Specility Account
And Click On Next
Then "<Trust>","<Estate>","<Guardian>","<Beneficiary>","<403>","<Trsansfer on death>","<ORP>","<Business/Organization>" and 
And "<Conservatorship>","<Guardianship>","<Pension>","<ProfitSharingPlan>","<SoleProprietorshipDBA>","<InvestmentClub>" and 
And "<BrokerDealer>","<FinancialInstitution>" And "<BusinessCorporation>" should be display
Then User is logged Out

@SIT
Examples:
|onlineid		|password	| Trust	|	Estate	|Guardian		| Beneficiary	  | 403	|	Trsansfer on death	|ORP								|	Business/Organization	|Conservatorship	|Guardianship	|	Pension	|	ProfitSharingPlan	|SoleProprietorshipDBA	|	InvestmentClub	|	BrokerDealer	|FinancialInstitution	|	BusinessCorporation		|
|onlineid141	|Pass@123 	| Trust	|	Estate	|Guardian IRA	| Beneficiary IRA |403B	|	Transfer on Death	|Optional Retirement Program (ORP)	|	Business/Organization	|Conservatorship	|Guardianship	|	Pension	|	Profit Sharing Plan	|Sole Proprietorship/DBA|	Investment Club	|	Broker Dealer	|Financial Institution	|	Business Corporation	|

@UAT
Examples:
|onlineid		|password		| Trust	|	Estate	|Guardian		| Beneficiary	  | 403	|	Trsansfer on death	|ORP								|	Business/Organization	|Conservatorship	|Guardianship	|	Pension	|	ProfitSharingPlan	|SoleProprietorshipDBA	|	InvestmentClub	|	BrokerDealer	|FinancialInstitution	|	BusinessCorporation		|
|uatuser070		|Pass@1234		| Trust	|	Estate	|Guardian IRA	| Beneficiary IRA |403B	|	Transfer on Death	|Optional Retirement Program (ORP)	|	Business/Organization	|Conservatorship	|Guardianship	|	Pension	|	Profit Sharing Plan	|Sole Proprietorship/DBA|	Investment Club	|	Broker Dealer	|Financial Institution	|	Business Corporation	|


@Sanity @AccountOpening
Scenario Outline:Verify When Click On GIA Account Back Cancel and Next Button should be display
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When click on open a new Account button
Then User Should be navigate to open Account Page 
And Click on GIA Account
And Click On Next
Then Verify Cancel,back and next button is displaying

@SIT
Examples:
|onlineid		|password	|
|onlineid141	|Pass@123 	|


@UAT
Examples:
|onlineid 		|password	|   
|uatuser070		|Pass@1234	|

