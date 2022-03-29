Feature: 90 Days inactivity Scenarios

@Regression @UserManagement
Scenario Outline:Verify Error message when user tried to login after 90 days from last login
Given User is on VCM login page with "<onlineid>" and "<password>" 
When User Clicks On Sign In Button
Then Error message should be display as "<msg>"

Examples: 
    | onlineid 	 	| password 	|  msg |
    |onlineid78		|Pass@123	|For your security, your account has been locked. Please call a Member Service Representative (800) 235-8396. At the prompt say “Security”..|
    |guestuser1		|Pass@123	|For your security, your account has been locked. Please call a Member Service Representative (800) 235-8396. At the prompt say “Security”..|
    



   