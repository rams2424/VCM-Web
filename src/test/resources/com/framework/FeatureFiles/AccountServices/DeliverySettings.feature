Feature: Delivery Settings Feature Tests
@Regression @AccountServices
  Scenario Outline: Delivery Channels Test
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page 
    When  Click on  Delivery Settings Page
   Then Verify get notified by and urgent message and notification text
   Then User is logged Out
@SIT 
 Examples: 
      | onlineid    | password |                  
      | onlineid140 | Test@123 |
      
      
 @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |

  @Regression @AccountServices
  Scenario Outline: Call time Preferences Test
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page 
    When  Click on  Delivery Settings Page
   Then User is logged Out
   
  @SIT 
 Examples: 
      | onlineid    | password |                  
      | onlineid140 | Test@123 |
    
    
 @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |