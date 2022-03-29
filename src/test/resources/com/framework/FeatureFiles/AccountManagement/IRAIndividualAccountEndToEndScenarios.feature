Feature: IRA Accounts End To End Scenario

@Regression @AccountOpening 
Scenario Outline: Create  IRA  Account
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Then User Should be navigate to open Account Page
And Click on IRA Account
And Click On Next
And User should be navigated to Account type page
When User selects type "<accountType>"
And Verify PersonalInfo Page is displaying
Then Enter Personal informations "<benefeciaryType>" "<relation>" "<distributionPercentage>" "<fname>" "<lname>"
And Click On Next
Then verify fund selection page is displaying
And Click on "<fund1>","<fund2>","<fund3>","<fund4>" and "<fund5>"
And Click On Next
Then Verify fund your account page is displaying
And select Fund Source  as "<fundSource>" and "<type>","<AccountNo>","<RoutingNo>"
Then Select ira contribution
And Click On Next
Then dialog pop up box should be displayed
And click on proceed
Then Verify preference page is displaying
And verify divident and gain radio buttons are displaying
And statement and prospectus is displaying with 2 radio buttons
And click on delivery option as"<deliveryOption>"
And Click On Next
Then verify Verify page is displaying
And verify "<accountType>"
And Click On Next
Then Verify EConsent page is displaying
And click on review checkbox
Then User is logged Out

@SIT
Examples: 
| onlineid    | password | accountType     | benefeciaryType | relation   | distributionPercentage | fname | lname | fund1                      | fund2                      | fund3                       | fund4                    | fund5                            | fundSource     | deliveryOption | confirmationTxt     | type    | AccountNo         | RoutingNo | holdingGroup        |
| onlineid140 | Pass@123 | Traditional IRA | Individuals     | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | Roth IRA        | Individuals     | Non Spouse |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | SEP IRA         | Individuals     | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | Traditional IRA | Individuals     | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | Roth IRA        | Individuals     | Non Spouse |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | SEP IRA         | Individuals     | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |



@UAT
Examples: 
| onlineid    	| password | accountType     | benefeciaryType | relation   | distributionPercentage | fname | lname | fund1                      | fund2                      | fund3                       | fund4                    | fund5                            | fundSource     | deliveryOption | confirmationTxt     | type    | AccountNo         | RoutingNo | holdingGroup        |
|uatuser070 	|Pass@1234 | Traditional IRA | Individuals     | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| uatuser070 	|Pass@1234 | Roth IRA        | Individuals     | Non Spouse |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| uatuser070 	|Pass@1234 | SEP IRA         | Individuals     | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
|uatuser070 	|Pass@1234 | Traditional IRA | Individuals     | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| uatuser070	|Pass@1234 | Roth IRA        | Individuals     | Non Spouse |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| uatuser070 	|Pass@1234 | SEP IRA         | Individuals     | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |

@Regression @AccountOpening 
Scenario Outline: Create  IRA Non Individual benefeciary Account
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Then User Should be navigate to open Account Page
And Click on IRA Account
And Click On Next
And User should be navigated to Account type page
When User selects type "<accountType>"
And Verify PersonalInfo Page is displaying
Then Enter Personal informations "<benefeciaryType>" "<relation>" "<distributionPercentage>" "<fname>" "<lname>"
And Click On Next
Then verify fund selection page is displaying
And Click on "<fund1>","<fund2>","<fund3>","<fund4>" and "<fund5>"
And Click On Next
Then Verify fund your account page is displaying
And select Fund Source  as "<fundSource>" and "<type>","<AccountNo>","<RoutingNo>"
Then Select ira contribution
And Click On Next
Then dialog pop up box should be displayed
And click on proceed
Then Verify preference page is displaying
And verify divident and gain radio buttons are displaying
And statement and prospectus is displaying with 2 radio buttons
And click on delivery option as"<deliveryOption>"
And Click On Next
Then verify Verify page is displaying
And verify "<accountType>"
And Click On Next
Then Verify EConsent page is displaying
And click on review checkbox
Then User is logged Out

@SIT
Examples:  
| onlineid    | password | accountType     | benefeciaryType | relation   | distributionPercentage | fname | lname | fund1                      | fund2                      | fund3                       | fund4                    | fund5                            | fundSource     | deliveryOption | confirmationTxt     | type    | AccountNo         | RoutingNo | holdingGroup        |
| onlineid140 | Pass@123 | Traditional IRA | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | Roth IRA        | Non-Individual  | Non Spouse |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | SEP IRA         | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |           
| onlineid140 | Pass@123 | Traditional IRA | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | Roth IRA        | Non-Individual  | Non Spouse |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| onlineid140 | Pass@123 | SEP IRA         | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |

@UAT
Examples:  
| onlineid    	| password | accountType     | benefeciaryType | relation   | distributionPercentage | fname | lname | fund1                      | fund2                      | fund3                       | fund4                    | fund5                            | fundSource     | deliveryOption | confirmationTxt     | type    | AccountNo         | RoutingNo | holdingGroup        |
| uatuser070 |Pass@1234 | Traditional IRA | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| uatuser070 |Pass@1234 | Roth IRA        | Non-Individual  | Non Spouse |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| uatuser070 |Pass@1234 | SEP IRA         | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |           
| uatuser070 |Pass@1234 | Traditional IRA | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| uatuser070 |Pass@1234 | Roth IRA        | Non-Individual  | Non Spouse |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |
| uatuser070 |Pass@1234 | SEP IRA         | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Wire Transfer  | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |


@Sanity @AccountOpening @ira
Scenario Outline:Verify When Click on cancel button User should be navigate to AccountHolding page
Given User is on VCM login page with "<onlineid>" and "<password>"
When click on open a new Account button
Then User Should be navigate to open Account Page
And Click on IRA Account
And Click On Next
And User should be navigated to Account type page
When User selects type "<accountType>"
When Click on Cancel button
And Verify User is navigated to HomePage
Then User is logged Out

@SIT
Examples:

| onlineid    | password | accountType     | benefeciaryType | relation   | distributionPercentage | fname | lname | fund1                      | fund2                      | fund3                       | fund4                    | fund5                            | fundSource     | deliveryOption | confirmationTxt     | type    | AccountNo         | RoutingNo | holdingGroup        |
| onlineid140 | Pass@123 | Traditional IRA | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |

@UAT
Examples:

| onlineid    	| password | accountType     | benefeciaryType | relation   | distributionPercentage | fname | lname | fund1                      | fund2                      | fund3                       | fund4                    | fund5                            | fundSource     | deliveryOption | confirmationTxt     | type    | AccountNo         | RoutingNo | holdingGroup        |
| uatuser070 	|Pass@1234  | Traditional IRA | Non-Individual  | Spouse     |                    100 | ABC   | ZXY   | USAA 500 Index Fund Member | USAA 500 Index Fund Reward | USAA Aggressive Growth Fund | USAA Capital Growth Fund | USAA Cornerstone Aggressive Fund | Personal Check | Paper          | Congratulations !!! | Savings | 11111111111111111 | 000000016 | Retirement Accounts |

