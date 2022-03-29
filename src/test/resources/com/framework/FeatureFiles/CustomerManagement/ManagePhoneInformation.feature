Feature: Customer Management:Manage Phone Information

@Regression @CustomerManagement
Scenario Outline: Navigate to  Manage Information page and validate add phone number
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
And Click On Manage "<manage>" Tab
Then User should be navigate to manage Phone Information
And verify Customer can see details "<primaryPhoneInfo>"
Given Verify add phone number button is displayed
When Click on add phone number button
Then Verify navigated to Add Phone Number page
Then Verify country code and phone number field is displayed
Then mobile number radio is displayed
And Save button should be disabled
When User enters blank country Code
Then verify error msg for country code is displayed
When User enters blank phone Number
Then verify error msg for phone number is displayed
When User enters phone number "<invalidPhoneNumber>"
Then verify error msg for phone number is displayed
When User enters code "<countryCode>"
And User enters phone number "<validPhoneNumber>"
And Click on mobile number radio
Then Save button should be enabled
When Click on Save button
Then verify Customer can see details "<secondaryPhoneInfo>"
Then User should get "<succesmsg>"
Then verify Customer can see details "<maskedPhn>"
 When Click on back button
Then User should navigate back to Basic information page
And verify "<maskedPhn>" is updated and visible
And Click On Manage "<manage>" Tab
Then User should be navigate to manage Phone Information
When Click on "<primaryPhoneInfo>" number options
Then Verify edit option is displayed
When Click on "<secondaryPhoneInfo>" number options
Then Verify edit and delete option is displayed
When Click on delete option
Then delete confirmation popup should be displayed
And Confirm delete
Then verify Secondary phone number is deleted
Then User should get "<delmsg>"
Then User is logged Out
@SIT
Examples: 
  | onlineid    | password | primaryPhoneInfo     | manage                   | invalidPhoneNumber | validPhoneNumber | countryCode | secondaryPhoneInfo     | succesmsg                            | maskedPhn         |delmsg|
  | onlineid140 | Pass@123| Primary Phone Number | Manage phone information |            6516060 |       6516004960 |           1 | Secondary Phone Number | Successfully saved Phone Information | +1 (XXX) XXX-4960 |Successfully removed Phone Information|


@UAT
Examples: 
  | onlineid     | password | primaryPhoneInfo     | manage                   | invalidPhoneNumber | validPhoneNumber | countryCode | secondaryPhoneInfo     | succesmsg                            | maskedPhn         |delmsg|
  | uatuser070 | Pass@1234 | Primary Phone Number | Manage phone information |            6516060 |       6516004960 |           1 | Secondary Phone Number | Successfully saved Phone Information | +1 (XXX) XXX-4960 |Successfully removed Phone Information|

   @Sanity @CustomerManagement
  Scenario Outline: Validate cancel button
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage "<manage>" Tab
    Then User should be navigate to manage Phone Information
    Given Verify add phone number button is displayed
    When Click on add phone number button
    Then Verify navigated to Add Phone Number page
    And Verify cancel button is displayed
    When Click on Cancel
    Then User should be navigate to manage Phone Information
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid    | password | manage                   |
      | onlineid140 | Pass@123| Manage phone information |
      
        @UAT
    Examples: 
      | onlineid    | password | manage                   |
      |uatuser070 | Pass@1234 | Manage phone information |

   @Sanity @CustomerManagement
  Scenario Outline: Validate edit option
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage "<manage>" Tab
    Then User should be navigate to manage Phone Information
    When Click on "<primaryPhoneInfo>" number options
    Then Verify edit option is displayed
    When Click on edit option
    Then Verify navigated to Edit Phone Number page
    And User edit phone number "<phoneNumber>"
    And Click on mobile number radio
    When Click on Save button
    Then User should get "<succesmsg>"
    Then verify Customer can see details "<maskedPhn>"
    Then User is logged Out

	@SIT
    Examples: 
      | onlineid    | password | manage                   | primaryPhoneInfo     | phoneNumber | succesmsg                            | maskedPhn         |
      | onlineid140 | Pass@123| Manage phone information | Primary Phone Number |  6516004961 | Successfully saved Phone Information | +1 (XXX) XXX-4961 |

	@UAT
    Examples: 
      | onlineid     | password | manage                   | primaryPhoneInfo     | phoneNumber | succesmsg                            | maskedPhn         |
      | uatuser070 | Pass@1234 | Manage phone information | Primary Phone Number |  6516004961 | Successfully saved Phone Information | +1 (XXX) XXX-4961 |

 @Sanity @CustomerManagement
  Scenario Outline: Validate back button
    Given User is on VCM login page with "<onlineid>" and "<password>"
   	And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage "<manage>" Tab
    Then User should be navigate to manage Phone Information
    When Click on back button
    Then User should navigate back to Basic information page
    Then User is logged Out
     @SIT
    Examples: 
      | onlineid    | password | manage                   |
      | onlineid140 | Pass@123| Manage phone information |
      
      @UAT
    Examples: 
      | onlineid    | password | manage                   |
      |uatuser070 | Pass@1234 | Manage phone information |
