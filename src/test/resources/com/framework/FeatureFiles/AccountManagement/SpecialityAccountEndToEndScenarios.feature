Feature: Speciality Account End To End Scenarios

@Regression @AccountOpening
Scenario Outline:Create Speciality Accounts
Given User is on VCM login page with "<onlineid>" and "<password>"
Then Verify Open new Account Button is displaying and enabled
When click on open a new Account button
Then User Should be navigate to open Account Page 
And Click on Specility Account
And Click On Next
And click on "<AccountType>"
And Click On Next
Then Verify DownLoadForm , yourMemberApp and supportingDoc fields are displaying
And click on download form ,form should be open in new tab
Then User is logged Out 
@SIT
Examples: 
|onlineid		|password	| AccountType				|
|onlineid140    |Pass@123   |	Trust					|
|onlineid140    |Pass@123   |	Estate					|
|onlineid140    |Pass@123   |	Guardian IRA			|
|onlineid140    |Pass@123   |	Beneficiary IRA			|
|onlineid140    |Pass@123   |	403B					|
|onlineid140    |Pass@123   |	Transfer on Death		|
|onlineid140    |Pass@123   |	Optional Retirement Program (ORP)		|
|onlineid140    |Pass@123   |	Guardianship			|



@UAT
Examples: 
|onlineid		|password	 | AccountType				|
|uatuser070  	| Pass@1234  |	Trust					|
|uatuser070  	| Pass@1234  |	Estate					|
|uatuser070     | Pass@1234  |	Guardian IRA			|
|uatuser070   	| Pass@1234  |	Beneficiary IRA			|
|uatuser070  	| Pass@1234  |	403B					|
|uatuser070  	| Pass@1234  |	Transfer on Death		|
|uatuser070  	| Pass@1234  |	Optional Retirement Program (ORP)		|
|uatuser070  	| Pass@1234  |	Guardianship			|

@Regression @AccountOpening
Scenario Outline:Verify Back Button Functionality for Speciality Type Account
Given User is on VCM login page with "<onlineid>" and "<password>"
Then Verify Open new Account Button is displaying and enabled
When click on open a new Account button
Then User Should be navigate to open Account Page 
And Click on Specility Account
And Click On Next
And click on "<AccountType>"
And Click On Next
When Click on back button
Then user should be navigate to speciality Account Page
When Click on back button
Then User Should be navigate to open Account Page
Then User is logged Out 
@SIT
Examples: 
|onlineid		|password	| AccountType				|
|onlineid140    |Pass@123   |	Trust					|
|onlineid140    |Pass@123   |	Estate					|
|onlineid140    |Pass@123   |	Guardian IRA			|
|onlineid140    |Pass@123   |	Beneficiary IRA			|
|onlineid140    |Pass@123   |	403B					|
|onlineid140    |Pass@123   |	Transfer on Death		|
|onlineid140    |Pass@123   |	Optional Retirement Program (ORP)		|
|onlineid140    |Pass@123   |	Guardianship			|


@UAT
Examples: 
|onlineid		 |password	 | AccountType				|
|uatuser070   |Pass@1234   |	Trust					|
|uatuser070   |Pass@1234   |	Estate					|
|uatuser070   |Pass@1234   |	Guardian IRA			|
|uatuser070   |Pass@1234   |	Beneficiary IRA			|
|uatuser070   |Pass@1234   |	403B					|
|uatuser070   |Pass@1234   |	Transfer on Death		|
|uatuser070   |Pass@1234   |	Optional Retirement Program (ORP)		|
|uatuser070   |Pass@1234   |	Guardianship			|

@Regression @AccountOpening
Scenario Outline:Verify When click on open an account link user should be navigate to open account page
Given User is on VCM login page with "<onlineid>" and "<password>"
Then Verify Open new Account Button is displaying and enabled
When click on open a new Account button
Then User Should be navigate to open Account Page 
And Click on Specility Account
And Click On Next
And click on "<AccountType>"
And Click On Next
When click on open an account link
Then User Should be navigate to open Account Page
Then User is logged Out 

@SIT
Examples: 
|onlineid		|password	| AccountType				|
|onlineid140    |Pass@123   |	Trust					|
|onlineid140    |Pass@123   |	Estate					|
|onlineid140    |Pass@123   |	Guardian IRA			|
|onlineid140    |Pass@123   |	Beneficiary IRA			|
|onlineid140    |Pass@123   |	403B					|
|onlineid140    |Pass@123   |	Transfer on Death		|
|onlineid140    |Pass@123   |	Optional Retirement Program (ORP)		|
|onlineid140    |Pass@123   |	Guardianship			|


@UAT
Examples: 
|onlineid		 |password	 | AccountType				|
|uatuser070   |Pass@1234  |	Trust					|
|uatuser070   |Pass@1234  |	Estate					|
|uatuser070   |Pass@1234  |	Guardian IRA			|
|uatuser070   |Pass@1234  |	Beneficiary IRA			|
|uatuser070   |Pass@1234  |	403B					|
|uatuser070   |Pass@1234  |	Transfer on Death		|
|uatuser070   |Pass@1234  |	Optional Retirement Program (ORP)		|
|uatuser070   |Pass@1234  |	Guardianship			|