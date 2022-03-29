Feature: RMD Automated Tests

  @ui @Regression @AccountServices
  Scenario Outline: Eligible member UI test
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When I click on Account Services
    And I click on RMD
    Then I should see page title, RMD distribution rules, card listing section
    And I should see retirement article section with read article button
    And I should see RMD Calculators section with current year and future buttons
    And I should see all retirement button
    And I should see the back button and disclaimer footer in RMD page
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid   | password |
      | Onlineid36 | Pass@123 |
       @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |

  @ui @Regression @AccountServices
  Scenario Outline: Not Eligible member UI test
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When I click on Account Services
    And I click on RMD
    Then I should see page title, RMD distribution rules
    And I should not see card listing section
    And I should see retirement article section with read article button
    And I should see RMD Calculators section with current year and future buttons
    And I should see all retirement button
    And I should see the back button and disclaimer footer in RMD page
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid    | password |
      | Onlineid101 | Pass@123 |
 @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |