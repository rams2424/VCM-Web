Feature: Purchase Field level Validation Scenarios

  @Sanity @Purchase
  Scenario Outline: Visibility of buttons
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    Then verify Cancel and next button are visible
    And verify Next button is disabled
    Then User is logged Out

    Examples: 
      | onlineid   | password |
      | onlineid39 | Test@123 |

  @Sanity @Purchase
  Scenario Outline: Verify Cancel button
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click On The Cancel button
    Then Verify Cancel Transaction popup is displayed
    When Click On Yes
    Then Verify It is navigated to home page
    Then User is logged Out

    Examples: 
      | onlineid   | password |
      | onlineid39 | Test@123 |

  @Sanity @Purchase
  Scenario Outline: Verify Cancel button
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click On The Cancel button
    Then Verify Cancel Transaction popup is displayed
    When Click On No
    Then Verify It is on the same Purchase page
    Then User is logged Out

    Examples: 
      | onlineid   | password |
      | onlineid39 | Test@123 |

  @Sanity @Purchase
  Scenario Outline: Verify navigation to Home page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Portfolio from Buy Page
    Then Verify it is on the portfolio dashboard page
    Then User is logged Out

    Examples: 
      | onlineid   | password |
      | onlineid39 | Test@123 |

  @Sanity @Purchase
  Scenario Outline: Verify navigation to Investment Selection
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    Then verify Next button is enabled
    Then User is logged Out

    Examples: 
      | onlineid   | password | Number   |
      | onlineid39 | Test@123 | 40110313 |
