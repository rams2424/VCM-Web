Feature: Guest Login Functionality

  @Regression @UserManagement
  Scenario Outline: Verify Guest User should be able to access the VCM portal
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User should be landed to Guest User Dashboard
    When User clicks on Logout option
    Then Verify User should be able to see Logoff notification

    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
