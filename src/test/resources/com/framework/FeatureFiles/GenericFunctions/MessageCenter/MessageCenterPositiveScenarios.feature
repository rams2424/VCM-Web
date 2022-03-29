Feature: Message Center Postive Scenarios

@Regression @GenericFunctions @MsgCenter
Scenario Outline: Verify the count of unread messages in dashbord should be equal to message center icon
Given User is on VCM login page with "<onlineid>" and "<password>"
Then Verify that Notification count of both msg icon and dashboard icon are the same 
Then User is logged Out 

@SIT
Examples: 
| onlineid 	| password |
| merrilluser11 | Pass@123 |

@UAT
Examples: 
| onlineid 	| password |
| uatuser179 | Pass@1234 |
    
@Regression @GenericFunctions @MsgCenter
Scenario Outline: Verifying That Load More Should Be Present if there are more than ten messages
Given User is on VCM login page with "<onlineid>" and "<password>"
When Click on Message Center Header icon and then click View all button
Then User should be on Message Center Page
Then  Verify That Load more icon is present if there are more than ten messages
Then User is logged Out 
   @SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser090 | Pass@1234 |
    
   
@Regression @GenericFunctions @MsgCenter
Scenario Outline: Verifying Select all Functionality with Mark as unread.
Given User is on VCM login page with "<onlineid>" and "<password>"
When Click on Message Center Header icon and then click View all button
Then User should be on Message Center Page
And  Click on first message
Then Click on Select All button
When Click on Mark as Unread
Then Verify that all Messages are Highlighted
Then User is logged Out 

@SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser091 | Pass@1234 |
    
    
@Regression @GenericFunctions @MsgCenter
Scenario Outline: Verifying Select all Functionality with Mark as Read.
Given User is on VCM login page with "<onlineid>" and "<password>"
When Click on Message Center Header icon and then click View all button
Then User should be on Message Center Page
Then Click on Select All button
When Click on Mark as Read 
Then Verify that all the Messages are not Highlighted
Then User is logged Out 

@SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser090 | Pass@1234 |
    

