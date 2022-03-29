Feature: Message Center End to End Verification

@Regression @GenericFunctions @MsgCenter
  Scenario Outline: Verify Whether Mark as Unread functionality is working
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Click on Message Center Header icon and then click View all button
    And Click on first message 
    Then Click on a Read Message Check box 
    Given then click on Mark as UnRead button
    Then Verify Whether Message is Highligted 
    Then User is logged Out 
   

 @SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser179 | Pass@1234 |
    
      
 @Regression @GenericFunctions @MsgCenter
  Scenario Outline: Verify Whether Mark as Read is working
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Click on Message Center Header icon and then click View all button
    And Click on first message 
    Then Click on a Read Message Check box 
    Given then click on Mark as UnRead button
    Then Click on a Unread Message Check box
    Then Click on Mark as Read button
    Then Verify that the Message is not Highlighted
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
    Scenario Outline: Verify Whether Delete is working
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Click on Message Center Header icon and then click View all button
    When Click on Second message Check box
    Then Click on Delete button
    Then Verify that message is deleted with "<Conformation Message>"
    Then User is logged Out 
    
     @SIT
    Examples: 
      | onlineid   | password | Conformation Message |
      | onlineid140 | Test@123 |The message(s) have been deleted successfully.|
      
      @UAT
      Examples: 
      | onlineid     | password |Conformation Message |
      | uatuser085 | Pass@1234 |The message(s) have been deleted successfully.|
    
      
      
     @Regression @GenericFunctions @MsgCenter
    Scenario Outline: Verify when click on multiple read messages and click on8 un read button then messages should be  in unread state
    
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Click on Message Center Header icon and then click View all button
    And  Click on first message 
    Then Click on Select All button
    Then Click on Mark as Read button
    Then Select first four Checkboxes
    Given then click on Mark as UnRead button
    Then Verify that Multiple messages are Unread 
    Then User is logged Out 
       @SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser016 | Pass@1234 |
    
 @Regression @GenericFunctions @MsgCenter
    Scenario Outline: Verify when click on multiple unread messages and click on read button then messages should be read.
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Click on Message Center Header icon and then click View all button
    And Click on first message 
    Then Click on Select All button 
    Given then click on Mark as UnRead button
    Then Select first four Checkboxes
    Then Click on Mark as Read button
    Then Verify that Multiple messages are read
    Then User is logged Out 
      @SIT
Examples: 
    | onlineid | password |
    | onlineid140 | Test@123 | 
    
    @UAT
      Examples: 
      | onlineid     | password |
      | uatuser033 | Pass@1234 |
    
    
   @Regression @GenericFunctions @MsgCenter
    Scenario Outline: Verify when selected multiple messages and Deleted , It should not show in the Inbox
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Click on Message Center Header icon and then click View all button 
    Then Click on Multiple Check box 
    Then Click on Delete button
    Then Verify that messages are deleted with "<Conformation Message>"
    Then User is logged Out 
      @SIT
    Examples: 
      | onlineid   | password | Conformation Message |
      | onlineid140 | Test@123 |The message(s) have been deleted successfully.|
      
      @UAT
      Examples: 
      | onlineid     | password |Conformation Message |
      | uatuser128 | Pass@1234 |The message(s) have been deleted successfully.|
    
      
  
      
    
    
