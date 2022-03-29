Feature: Finacial and Employment Information Validation

  @Regression @CustomerManagement
  Scenario Outline: Manage Financial Information Fields and Dropdown Verification
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And User Click On Manage Financial Information
    And Verify Annnual Drop has the values "$0-$9700","$9701-$39475", "$39476-$84200","$84201-$160725", "$160726-$204100","$204101-$510300", "$510301 and above" Displayed.
    And Verify Networth Dropdown is dispalyed with "$0-$34999" ,"$35000-$49999" , "$50000-$249999" ,"$250000 and above" Values.
    And Verify Tax Filing Status DropDown is dispalyed with Five options "<Option1>" , "<Option2>" , "<Option3>","<Option4>","<Option5>".
    Then User is logged Out
@SIT
    Examples: 
      | onlineid    | password | Option1           | Option2                                           | Option3                          | Option4           | Option5                                      |
      | onlineid140 | Test@123 | Single individual | Married person filing jointly or surviving spouse | Married person filing separately | Head of household | Qualifying widow(er) with dependent children |

@UAT
    Examples: 
      | onlineid    | password | Option1           | Option2                                           | Option3                          | Option4           | Option5                                      |
      | uatuser046 |Pass@1234 |Single individual | Married person filing jointly or surviving spouse | Married person filing separately | Head of household | Qualifying widow(er) with dependent children |


  @Regression @CustomerManagement
  Scenario Outline: Manage Financial Information
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And User Click On Manage Financial Information
    And Choose Annual Income "<Annual Income>"
    Then Verify Tax bracket "<Tax Bracket>"
    And Choose Net worth "<Net Worth>"
    And Choose Tax filing Status "<Tax Status>"
    And Click on Save button in the Financial Information Page
    Then Verify that Success message "Successfully updated Financial Information." is Displayed.
    Then User should navigate back to Basic information page
    And verify "<Annual Income>" is updated and visible
    And verify "<Tax Bracket>" is updated and visible
    And verify "<Net Worth>" is updated and visible
    And verify "<Tax Status>" is updated and visible
    And User Click On Manage Financial Information
    And Choose Annual Income "<Annual Income1>"
    Then Verify Tax bracket "<Tax Bracket1>"
    And Choose Net worth "<Net Worth1>"
    And Choose Tax filing Status "<Tax Status1>"
    And Click on Save button in the Financial Information Page
    Then User is logged Out
@SIT
    Examples: 
      | onlineid    | password | Annual Income | Tax Bracket | Net Worth     | Tax Status                                        | Annual Income1 | Tax Bracket1 | Net Worth1     | Tax Status1                                        |
      | onlineid140 | Test@123 | $9701-$39475  | 12%         | $35000-$49999 | Married person filing jointly or surviving spouse |$39476-$84200 | 22%         | $35000-$49999 | Married person filing jointly or surviving spouse |
@UAT
    Examples: 
      | onlineid    | password | Annual Income | Tax Bracket | Net Worth     | Tax Status                                        | Annual Income1 | Tax Bracket1 | Net Worth1     | Tax Status1                                        |
      | uatuser046 |Pass@1234 | $9701-$39475  | 12%         | $35000-$49999 | Married person filing jointly or surviving spouse |$39476-$84200 | 22%         | $35000-$49999 | Married person filing jointly or surviving spouse |


  @Regression @CustomerManagement
  Scenario Outline: Manage Employment Information Fields and Dropdown Verification
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And User Click On Manage Employment Information
    Then Verify Employment Status DropDown has values "Full Time Military Service" ,"Government (non Military) Public Sector","Private Sector or non Government" ,"Retired" , "Self-Employed" ,"Student" ,"Unemployed" , "Other".
    And Choose Military Employment Status as "Full Time Military Service"
    And Select Industry Type As "Accounting"
    And Select Occupation As "Accountant"
    And Select Employer Name as "Andrew"
    And Select AdressLineOne as "200 E"
    And Select AdressLineTwo as "MAIN ST"
    And Select Zip Code as "14604"
    And Click on Save button in the Employment Information Page
    Then Verify that Employment Information is Updated with"Successfully updated Employment Information."message .
    Then User should navigate back to Basic information page
    And verify "Accounting" is updated and visible
    And verify "Accountant" is updated and visible
    And verify "Andrew" is updated and visible
    And verify "200 E" is updated and visible
    And verify "MAIN ST" is updated and visible
    And verify "14604" is updated and visible
    And User Click On Manage Employment Information
    And Choose Employment Status as "Retired" .
    And Choose Primary Source of Income as "Pension".
    And Click on Save button in the Employment Information Page
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser046 |Pass@1234 |
