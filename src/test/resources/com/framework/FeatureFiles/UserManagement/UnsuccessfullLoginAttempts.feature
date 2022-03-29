Feature: Verify Unsuccessfull Member and guest verification

@Regression @UserManagement @Test123
Scenario Outline:Verify Unsuccessful Logon attempts_User Id and Password for member
Given User is on VCM login page with "<onlineid>" and "<password>" for unsuccessfull scenario
When User Clicks On Sign In Button
Then Verify Error message should be display as "<errorMsg>"

@SIT
Examples: 
    | onlineid 	 	| password 	|errorMsg	|
    |onlineid79		|pass1222	|	User ID or password you entered doesn't match our records, please try again.|
    |guestautouser1 |aaaaa		|User ID or password you entered doesn't match our records, please try again.|
    
@UAT
Examples: 
| onlineid 	 	| password 	|errorMsg	|
| uatuser033 | pass1222	| Please enter valid credentials. |
| uatuser627 | aaaaa | Please enter valid credentials. |

@Regression @UserManagement @Test123
Scenario Outline: This scenario will avoid locking of user accounts
Given User is on VCM login page with "<onlineid>" and "<password>"
When User Clicks On Sign In Button
And Verify User is navigated to HomePage
Then User is logged Out

@UAT
Examples: 
| onlineid 	| password 	|
| uatuser033	| Pass@1234	|
| uatuser627    | Pass@1234 |
