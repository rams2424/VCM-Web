Feature: Guest Account Opening

  @Sanity @Dashboard
  Scenario Outline: Validate Guest Account Opening page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then verify Open an Account tab is displayed
    And verify "General Investment Account", "Individual Retirement Account", "Investing for Children", "Specialty Account" openings are displayed
    Then User is logged Out
@SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
       @UAT
      Examples: 
      | onlineid        | password |
      | uatguest1 		| Pass@123 |
