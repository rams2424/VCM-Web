Feature: Header Verification Scenarios

  @Sanity @Dashboard
  Scenario Outline: Visibility of all products
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On products Check Visibility of All Products

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser070 	 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Navigation to products Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On products Check Visibility of All Products
    And Click On Our Products

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser333 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Navigation to mutual fund Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On products Check Visibility of All Products
    And Click On Mutual Fund

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser128 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Navigation to Saving Plan Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On products Check Visibility of All Products
    And Click On Saving Plan

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser184 | Pass@1234 |

  @Sanity @Dashboard 
  Scenario Outline: Navigation to Victory Share Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On products Check Visibility of All Products
    And Click On VictoryShare

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser152 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Navigation to Retirement Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On products Check Visibility of All Products
    And Click On Retirement

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser091 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Visibility of all products
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On products Check Visibility of All Products

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
           @UAT
      Examples: 
      | onlineid        | password |
      | uatuser916 		| Pass@1234 |
