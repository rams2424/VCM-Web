Feature: Customer Management:Manage Email Information

@Regression @CustomerManagement 
Scenario Outline: Verify User is able to  navigate to Basic Information Page from profile page 
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
Then User is logged Out

@SIT
Examples: 
| onlineid    | password | 
| onlineid140 | Pass@123 | 

@UAT
Examples: 
| onlineid     | password |
|uatuser070 | Pass@1234 | 


@Regression @CustomerManagement 
Scenario Outline: Verify User is able to  navigate to email information Page 
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
And Click On Manage "<manage>" Tab
Then User should be navigate to manage Email Information
And verify Customer can see details "<primaryEmailInfo>"
Then User is logged Out

@SIT
Examples: 
| onlineid    | password | primaryEmailInfo | manage                   | 
| onlineid141 | Pass@123 | Primary Email    | Manage email information | 

@UAT
Examples: 
| onlineid     | password | primaryEmailInfo | manage                  |
|uatuser070 | Pass@1234 | Primary Email    | Manage email information | 



@Regression @CustomerManagement  
Scenario Outline: Verify Error message should be display for incorrect email address
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
And Click On Manage "<manage>" Tab
Then User should be navigate to manage Email Information
Given Verify add email button is displayed
When Click on add email button
Then Verify navigated to Add email page
Then Verify email address field is displayed
And Save button should be disabled
When User enters email address "<invalidEmailAdd>"
Then verify error msg for email address is displayed
Then User is logged Out
@SIT
Examples: 
| onlineid    | password | primaryEmailInfo | manage                   | invalidEmailAdd | validEmailAdd    | secondaryEmailInfo | succesmsg                            | maskedEmail      |delMsg|
| onlineid67  | Pass@123 | Primary Email    | Manage email information | abc             | vcm123@gmail.com | Secondary Email    | Successfully saved Email Information | vcxxxx@gmail.com |Email Information Deleted successfully|

@UAT
Examples: 
| onlineid     | password | primaryEmailInfo | manage                   | invalidEmailAdd | validEmailAdd    | secondaryEmailInfo | succesmsg                            | maskedEmail      |delMsg|
|uatuser070 | Pass@1234 | Primary Email    | Manage email information | abc             | vcm123@gmail.com | Secondary Email    | Successfully saved Email Information | vcxxxx@gmail.com |Email Information Deleted successfully |



@Regression @CustomerManagement 
Scenario Outline: Verify User is able to  navigate to Basic Information Page When click on Back Button from Email Information Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
And Click On Manage "<manage>" Tab
Then User should be navigate to manage Email Information
When Click on back button
Then User should navigate back to Basic information page
Then User is logged Out
@SIT
Examples: 
| onlineid    | password | primaryEmailInfo | manage                   | 
| onlineid140 | Pass@123 | Primary Email    | Manage email information | 

@UAT
Examples: 
| onlineid     | password | primaryEmailInfo | manage                 | 
|uatuser070 | Pass@1234 | Primary Email    | Manage email information | 


@Regression @CustomerManagement 
Scenario Outline: Validate cancel button
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
And Click On Manage "<manage>" Tab
Then User should be navigate to manage Email Information
Given Verify add email button is displayed
When Click on add email button
Then Verify navigated to Add email page
And Verify cancel button is displayed
When Click on Cancel
Then User should be navigate to manage Email Information
Then User is logged Out

@SIT
Examples: 
  | onlineid    | password | manage                   |
  | onlineid35 | Pass@1234 | Manage email information |


@UAT
Examples: 
  | onlineid    	| password 	| manage                   |
  |uatuser070 	|  Pass@1234 | Manage email information |
 
@Regression @CustomerManagement 
Scenario Outline: Validate back button
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
And Click On Manage "<manage>" Tab
Then User should be navigate to manage Email Information
When Click on back button
Then User should navigate back to Basic information page
Then User is logged Out

@SIT
Examples: 
  | onlineid    | password | manage                   |
  |onlineid35 | Pass@1234 | Manage email information |
  
@UAT
Examples: 
  | onlineid    	| password | manage                   |
  |uatuser070 	| Pass@1234 | Manage email information |

