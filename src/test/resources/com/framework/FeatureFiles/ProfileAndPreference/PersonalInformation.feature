Feature: Personal Information Navigatation Scenarios

  @Sanity @CustomerManagement
  Scenario Outline: Navigate to Profile Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And User Click On Personal Information
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      |uatuser046 | Pass@1234 |

  @Regression @CustomerManagement
  Scenario Outline: Personal Information Editing
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And User Click On Personal Information
    And Choose prefix "<Prefix>"
    Then Choose Suffix "<Suffix>"
    And Select Gender
    And Select MaritalStatus "<Status>"
    And Click On save Bttn
    Then Verify that Personal Information is Updated with"Successfully updated Personal Information."message .
    Then User should navigate back to Basic information page
    And verify "<Prefix>" is updated and visible
    And verify "<Suffix>" is updated and visible
    And verify "<Status>" is updated and visible
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid    | password | Prefix | Suffix | Status   |
      | onlineid140 | Test@123 | Dr.    | III    |Divorced |

    @UAT
    Examples: 
      | onlineid     | password | Prefix | Suffix  | Status   |
      |uatuser046 | Pass@1234 | Dr.    | III     | Divorced |

  @Sanity @CustomerManagement
  Scenario Outline: Check NON Editable ELements
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And User Click On Personal Information
    And Check FullName is not Editable
    And Check MemberId is not Editable
    And Check Citizenship is not Editable
    And Check Service Number is visible For Changing SSN DOB Citizenship
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      |uatuser046 | Pass@1234 |
