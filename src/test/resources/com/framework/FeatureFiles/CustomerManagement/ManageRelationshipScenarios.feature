Feature: Customer Management:Manage Relationship Scenarios

@Sanity @CustomerManagement
Scenario Outline: Verify Customer can add relationship
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
And verify Customer can see details "<perinfo>" and "<contactinfo>","<phoneinfo>","<emailinfo>"
And "<financial>","<emp>","<military>","<manageinfo>"
Then User is logged Out

	@SIT
    Examples: 
      | onlineid    | password | perinfo              | contactinfo         | phoneinfo         | emailinfo         | financial             | emp                    | military             | manageinfo          |
      | onlineid140 | Pass@123 | Personal Information | Contact Information | Phone Information | Email Information | Financial Information | Employment Information | Military Information | Manage relationship |

	@UAT
    Examples: 
      | onlineid    | password | perinfo              | contactinfo         | phoneinfo         | emailinfo         | financial             | emp                    | military             | manageinfo          |
      |uatuser070 | Pass@1234  | Personal Information | Contact Information | Phone Information | Email Information | Financial Information | Employment Information | Military Information | Manage relationship |

  @Regression @CustomerManagement
  Scenario Outline: Verify Customer can add  relationship  for relationship
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage RelationShip Tab
    And enter "<fname>","<lname>","<dob>","<gender>"
    And enter "<maritalStatus>","<citizen>","<phoneNo>","<email>","<address>","<zipCode>"
    And click On Save Button
    Then Information should be saved
    Then User should navigate back to Basic information page
    And verify "<fname>" is updated and visible
    And verify "<lname>" is updated and visible
    And verify "<maritalStatus>" is updated and visible
    And verify "<gender>" is updated and visible
    And verify "<maskedemail>" is updated and visible
    Then User is logged Out
	@SIT
    Examples: 
      | onlineid    | password | fname | lname | dob        | gender | maritalStatus | citizen | phoneNo    | email            | address              | zipCode | maskedemail      |
      | onlineid35 | Pass@1234 | abc   | xyz   | 11/20/1997 | Female | Married       | U.S     | 6516004960 | vcmqea@gmail.com | 145 West 44th Street |   10036 | vcxxxx@gmail.com |
	
@UAT
 Examples: 
      | onlineid    | password | fname | lname | dob        | gender | maritalStatus | citizen | phoneNo    | email            | address              | zipCode | maskedemail      |
      |uatuser070 | Pass@1234  | abc   | xyz   | 11/20/1997 | Female | Married       | U.S     | 6516004960 | vcmqea@gmail.com | 145 West 44th Street |   10036 | vcxxxx@gmail.com |

  @Regression @CustomerManagement
  Scenario Outline: Verify Customer click on Cancel Button User Should be navigate To Basic Information Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage RelationShip Tab
    And Click On Cancel Button
    Then User should navigate to Basic information page
    Then User is logged Out
	@SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Pass@123 |
      
      @UAT
    Examples: 
      | onlineid    | password |
      |uatuser070 | Pass@1234  |

  @Regression @CustomerManagement
  Scenario Outline: Verify When Invalid Primary phone no is given error message should be display
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage RelationShip Tab
    And Enter primary phone no "<phoneNo>"
    Then Error message should be display for invalid phone no as "<errorMsg>"
    Then User is logged Out

	@SIT
    Examples: 
      | onlineid    | password | phoneNo | errorMsg             |
      | onlineid35 | Pass@1234 |    1111 | Invalid Phone Number |

	@UAT
    Examples: 
      | onlineid    | password | phoneNo | errorMsg             |
      |uatuser070 | Pass@1234  |    1111 | Invalid Phone Number |

  @Regression @CustomerManagement
  Scenario Outline: Verify When Invalid Primary email  address is given error message should be display
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage RelationShip Tab
    Then error message should be display for invalid email "<msg>"
    Then User is logged Out
@SIT
    Examples: 
      | onlineid    | password | msg                               |
      | onlineid67  | Pass@123 | Please enter valid Email Address. |


@UAT
    Examples: 
      | onlineid    | password | msg                               |
      | uatuser070 | Pass@1234  | Please enter valid Email Address. |
  @Regression @CustomerManagement
  Scenario Outline: Verify When Invalid Zip code is given error message should be display
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage RelationShip Tab
    Then error message should be display for invalid zip code "<msg>"
    Then User is logged Out

@SIT
    Examples: 
      | onlineid    | password | msg              |
      | onlineid35 | Pass@1234 | Invalid Zip code |
    @UAT  
      Examples: 
      | onlineid    | password | msg              |
      |uatuser070 | Pass@1234  | Invalid Zip code |

  @Regression @CustomerManagement
  Scenario Outline: Verify All Address Type Should be display
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage RelationShip Tab
    Then Address Type should be display as  "<US or US Territories>","<APO (Army or Air Force Post Office)>","<FPO (Fleet Post Office)>","<DPO (Diplomatic Post Office)>"
    Then User is logged Out
@SIT
    Examples: 
      | onlineid    | password |
      | onlineid141 | Pass@123 |
@UAT
Examples: 
      | onlineid    | password |
      |uatuser070 | Pass@1234  |
  @Regression @CustomerManagement
  Scenario Outline: Verify When Blank Page is saved error messages should be display for all mandatory information
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And Click On Manage RelationShip Tab
    And click On Save Button
    Then error message should be display for "<fnameError>","<lnameError>","<dobError>","<genderError>"
    And Also display error message for "<maritalStatusError>","<citizanShipError>","<AddressLine1Error>","<zipCodeError>"
    Then User is logged Out
	@SIT
    Examples: 
      | onlineid    | password | fnameError              | lnameError             | dobError                    | genderError            | maritalStatusError             | citizanShipError            | AddressLine1Error           | zipCodeError         |
      | onlineid140 | Pass@123 | Please enter first name | Please enter last name | Please select date of birth | Please select a gender | Please select a marital status | Please select a citizenship | Please enter Address Line 1 | Zip code is required |

   	 @UAT  
      Examples: 
      | onlineid    | password | fnameError              | lnameError             | dobError                    | genderError            | maritalStatusError             | citizanShipError            | AddressLine1Error           | zipCodeError         |
      |uatuser070 | Pass@1234  | Please enter first name | Please enter last name | Please select date of birth | Please select a gender | Please select a marital status | Please select a citizenship | Please enter Address Line 1 | Zip code is required |
      