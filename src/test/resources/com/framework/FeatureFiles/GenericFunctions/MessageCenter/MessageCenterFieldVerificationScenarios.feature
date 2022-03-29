Feature: Message Center Field Verification

@Sanity @GenericFunctions @MsgCenter
Scenario Outline: Verify User Should be able navigate to Message Center From Dashboard
Given User is on VCM login page with "<onlineid>" and "<password>"
When Click On Message From Message Center Dashboard
Then Verify the "Message Center" text in the Message Center Page
Then User is logged Out 
@SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser016 | Pass@1234 |
    
@Sanity @GenericFunctions @MsgCenter
Scenario Outline: Verify User Should be able to navigate to Messsage Center From Header icon
Given User is on VCM login page with "<onlineid>" and "<password>"
When Click on Message Center Header icon and then click View all button
Then Verify the "Message Center" text in the Message Center Page
Then User is logged Out 


@SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser085 | Pass@1234 |
    
   
@Sanity @GenericFunctions @MsgCenter
Scenario Outline: Verification of all the fields in the Mesage Center page
Given User is on VCM login page with "<onlineid>" and "<password>"
When Click On Message From Message Center Dashboard
Then Verify "Create Secure Message" text and Select all radio button is displayed
Then Delete , Mark as Read and Mark as Unread buttons should be dispalyed
Then "Sort by date:" text and dropdown should be displayed 
And Sort by date dropdown should have "Ascending" and "Descending" field dispalyed
Then Inbox Type dropdown should be displayed with fields "Inbox" , "Sent Items" and "Deleted Items" 
Then User is logged Out 

@SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser451 | Pass@1234 |
    


