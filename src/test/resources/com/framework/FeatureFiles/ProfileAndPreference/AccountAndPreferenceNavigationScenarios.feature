Feature: Profile & Preference Navigatation Scenarios


@Sanity @CustomerManagement
  Scenario Outline: Navigate to Profile
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
      | onlineid140 | Test@123 |

 @UAT
   Examples: 
   | onlineid 		| password|
   | uatuser070		|Pass@1234|

@Sanity @CustomerManagement
  Scenario Outline: Navigate to Delivery Settings
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Delivery Settings"
    Then User should navigate to Delivery Settings page
    Then User is logged Out
@SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |
 @UAT
   Examples: 
   | onlineid 		| password|
   | uatuser070	|Pass@1234|

@Sanity @CustomerManagement
  Scenario Outline: Navigate to Account Messaging
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Account Messaging"
    Then User should navigate to Account Preference page
    Then User is logged Out
@SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

 @UAT
   Examples: 
   | onlineid 		| password|
   | uatuser070	|Pass@1234|

@Sanity @CustomerManagement
  Scenario Outline: Navigate to Security Preferences
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Security Preferences"
    Then User should navigate to Security Preferences page
    Then User is logged Out
@SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |
 @UAT
   Examples: 
   | onlineid 		| password|
   | uatuser070	|Pass@1234|