Feature: Dashboard Scenarios

  @Sanity @Dashboard
  Scenario Outline: Verify Total portfolio as 100% in My Portfolio
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    And Verify total portfolio percentage as "<per>"
    And Amount is dispaying in doller format

    @SIT
    Examples: 
      | onlineid   | password  | per  |
      | onlineid65 | Test@1234 | 100% |

    @UAT
    Examples: 
      | onlineid     | password | per  |
      | uatuser070 | Pass@1234 | 100% |

  @Sanity @Dashboard
  Scenario Outline: Verify Victory Capital logon on Home Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    Then Verify Victory capital logo

    @SIT
    Examples: 
      | onlineid   | password  |
      | onlineid65 | Test@1234 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser085 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verify Last Sign in message on Home Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    And Verify Last Sign in Message  as"<msg>"

    @SIT
    Examples: 
      | onlineid   | password  | msg          |
      | onlineid65 | Test@1234 | Last sign in |

    @UAT
    Examples: 
      | onlineid     | password | msg          |
      | uatuser451  | Pass@1234 | Last sign in |

  @Sanity @Dashboard
  Scenario Outline: Verify Feature Section is displaying on Home Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    And Verify that feature section is displaying
    And Options are displaying as "<mutualfund>","<collegeSavingPlan>" and "<securityRetirement>"

    @SIT
    Examples: 
      | onlineid   | password  | mutualfund   | collegeSavingPlan        | securityRetirement               |
      | onlineid65 | Test@1234 | Mutual Funds | 529 College Savings Plan | Planning for a Secure Retirement |

    @UAT
    Examples: 
      | onlineid     | password | mutualfund   | collegeSavingPlan        | securityRetirement               |
      | uatuser070 | Pass@1234 | Mutual Funds | 529 College Savings Plan | Planning for a Secure Retirement |

  @Sanity @Dashboard
  Scenario Outline: Verify When click on mutual fund link user should be navigate to Mutual Fund Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    And Verify that feature section is displaying
    When Click on mutual fund link
    Then User should be navigate to mutual fund page

    @SIT
    Examples: 
      | onlineid   | password  |
      | onlineid65 | Test@1234 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser016 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verify When click on USAA 529 College Savings Plan link user should be navigate to User should be navigated to All About College Savings Pre Login page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    And Verify that feature section is displaying
    When Click on college saving plan link
    Then User should be navigate to All About College Savings Pre Login page

    @SIT
    Examples: 
      | onlineid   | password  |
      | onlineid65 | Test@1234 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser070 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verify When click on  Planning for a Secure Retirement User should be navigate to Planning For Retirement Pre Login page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    And Verify that feature section is displaying
    When click on planning for secure retirement
    Then User should be navigate to Planning For Retirement Pre Login page

    @SIT
    Examples: 
      | onlineid   | password  |
      | onlineid65 | Test@1234 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser070 | Pass@1234 |

  @Sanity @Dashboard 
  Scenario Outline: Verify tools and resources section is displaying
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    Then Verify tools and resource section is displaying
    And options are displaying "<Portfolioplanner>","<Our products>" and "<your goals>"

    @SIT
    Examples: 
      | onlineid   | password  | Portfolioplanner  | Our products                                     | your goals         |
      | onlineid65 | Test@1234 | Portfolio Planner | Estimated Income and Capital Gains Distributions | Achieve Your Goals |

    @UAT
    Examples: 
      | onlineid     | password | Portfolioplanner  | Our products                                     | your goals         |
      | uatuser090 | Pass@1234 | Portfolio Planner | 2020 Income and Capital Gains Distributions | Achieve Your Goals |

  @Sanity @Dashboard
  Scenario Outline: Verify When Click on Portfolio Planner User should be navigate to Marstone page on entering marstone credential
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    Then Verify tools and resource section is displaying
    When Click on Portfolio Planner
    Then User should be navigate to Marstone page

    @SIT
    Examples: 
      | onlineid   | password  |
      | onlineid65 | Test@1234 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser179 | Pass@1234 |

  @Sanity @Dashboard 
  Scenario Outline: Verify When  Click on  Learn more about our products  User should be navigate to Product page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    Then Verify tools and resource section is displaying
    When Click on  Learn more about our products
    Then User should be navigate to Product page

    @SIT
    Examples: 
      | onlineid   | password  |
      | onlineid65 | Test@1234 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser091 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verify When  Click on  Achive your goals User should be navigate to investor-learning-center Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    Then User should be navigate to home page
    Then Verify tools and resource section is displaying
    When Click on Achieve You Goals
    Then User should be navigate to investor learning page

    @SIT
    Examples: 
      | onlineid   | password  |
      | onlineid65 | Test@1234 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser333 | Pass@1234 |
