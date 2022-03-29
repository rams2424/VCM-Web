Feature: Footer Field Verification Scenarios

  @Sanity @Dashboard @Test
  Scenario Outline: Verification that footer and all its components are displayed for VCM account holders
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    And Verify Forms , Mutual Fund Prospectuses and ETF Prospect options are dispalyed
    And Verify Legal & Privacy , Accessiblity and Support FAQs options are displayed
    Then Verify that the disclaimer "Investing involves risk including loss of principal " is  displayed at the bottom of the page
    Then Verify if Victory Capital logo is displayed
    Then Connect with us option is available

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser070 | Pass@1234 |

  @Sanity @Dashboard  @Test
  Scenario Outline: Verification that footer and all its components are displayed for Guest Users
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    And Verify Forms , Mutual Fund Prospectuses and ETF Prospect options are dispalyed
    And Verify Legal & Privacy , Accessiblity and Support FAQs options are displayed
    Then Verify that the disclaimer "Investing involves risk including loss of principal " is  displayed at the bottom of the page
    Then Verify if Victory Capital logo is displayed
    Then Connect with us option is available

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
     @UAT
    Examples: 
      | onlineid     | password |
      | uatuser603 | Pass@1234 |

  @Sanity @Dashboard  @Test
  Scenario Outline: Verification of the footer link forms
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Forms option
    #Then Verify that forms post login page is displayed in the same tab

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser091 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of the footer link Mutual Fund prospectus
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Mutual Fund Prospectuses
    Then Verify that Fund Literature page is displayed in a new tab

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser152 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of the footer link ETF Prospectus
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on ETF Prospectuses
    Then Verify VictoryShares ETFs Literature page is displayed in a new tab

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser184 | Pass@1234 |

  @Sanity @Dashboard 
  Scenario Outline: Verification of all the footer link Legal and privacy
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Legal & Privacy option
    Then Verify that user Aggreement page is displayed

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser128 | Pass@1234 |

  @Sanity @Dashboard 
  Scenario Outline: Verification of the footer link Accessiblity
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Accessiblity
    Then Verify that user navigates to the accessiblity page

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser333 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of all the footer link Support FAQ
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Support FAQs
    Then Verify "How can we help you ?" FAQ page should be navigated.

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser016 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of the footer link forms for guest user
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Forms option
    #Then Verify that forms post login page is displayed in the same tab

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
    @UAT
    Examples:
    | onlineid | password |
    | uatuser602 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of the footer link Mutual Fund prospectus for guest user
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Mutual Fund Prospectuses
    Then Verify that Fund Literature page is displayed in a new tab

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
    @UAT
    Examples:
    | onlineid | password |
    | uatuser420 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of the footer link ETF Prospectus for guest user
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on ETF Prospectuses
    Then Verify VictoryShares ETFs Literature page is displayed in a new tab

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
    @UAT
    Examples:
    | onlineid | password |
    | uatuser402 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of all the footer link Legal and privacy for guest user
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Legal & Privacy option
    Then Verify that user Aggreement page is displayed

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
    @UAT
    Examples:
    | onlineid | password |
    | uatuser401 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of the footer link Accessiblity for guest user
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Accessiblity
    Then Verify that user navigates to the accessiblity page

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
      
    @UAT
    Examples:
    | onlineid | password |
    | uatuser730 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of all the footer link Support FAQ for guest user
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    When Click on Support FAQs
    Then Verify "How can we help you ?" FAQ page should be navigated.

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
    @UAT
    Examples:
    | onlineid | password |
    | uatuser727 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verification of all the Social Media icons under Connect with Us in the footer
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    Then Verify Facebook, Instagram, Linkedin, Twitter and YouTube icons are displayed

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser451 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verifying the Navigation of all the Social Media icons under Connect with Us in the footer
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Scroll down to the page and Verify that footer is present
    Then Verify that user is navigated to the Facebook Login page
    Then Verify that user is navigated to Linkedin Page
    Then Verify that user is navigated to Twitter Page
    Then Verify that user is navigated to Youtube.com HomePage

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser085 | Pass@1234 |
