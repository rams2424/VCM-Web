Feature: Contact Information Navigatation Scenarios

  @Regression @CustomerManagement
  Scenario Outline: Adding Seasonal Address
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When User clicks on User dropdown
    And User Clicks on "Profile & Preferences" from dropdown
    Then User should be navigated to Profile page
    When User clicks on "Profile"
    Then User should navigate to Basic information page
    And User Click On Contact Information
    And Click On Add Seasonal Address
    And Enter Address Line1 "<AddL1>"
    And Enter ZipCode "<code>"
    And Click On Start Date For Add "<StartDay>" and "<StartMonthwithDate>" and "<Startyear>" and "<StartMonthyr>"
    And Click On End Date For Add "<EndDay>" and "<EndMonthwithDate>" and "<Endyear>" and "<EndMonthyr>"
    And Click On Save
    Then User is logged Out
@SIT
    Examples: 
      | onlineid   | password |  | AddL1         |  | code  |  | StartDay |  | StartMonthwithDate |  | Startyear |  | StartMonthyr |  | EndDay |  | EndMonthwithDate |  | Endyear |  | EndMonthyr   |
      | onlineid39 | Test@123 |  | 145 W 44TH ST |  | 10036 |  | Friday   |  | October 29th       |  |      2021 |  | October 2021 |  | Friday |  | October 29th     |  |    2021 |  | October 2021 |
@UAT
 Examples: 
      | onlineid   | password |  | AddL1         |  | code  |  | StartDay |  | StartMonthwithDate |  | Startyear |  | StartMonthyr |  | EndDay |  | EndMonthwithDate |  | Endyear |  | EndMonthyr   |
      | uatuser070	| Pass@1234| | 145 W 44TH ST |  | 10036 |  | Friday   |  | October 29th       |  |      2021 |  | October 2021 |  | Friday |  | October 29th     |  |    2021 |  | October 2021 |


      