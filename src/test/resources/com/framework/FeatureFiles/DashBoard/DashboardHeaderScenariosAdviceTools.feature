Feature: Header Verification Scenario

  @Sanity @Dashboard
  Scenario Outline: Visibility of Advice Tools
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On AdviceTools Check Visibility of AdviceTools

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      |uatuser070 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verify Navigation to Military Finance Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On AdviceTools Check Visibility of AdviceTools
    And Click On Military Finance

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser085 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verify Navigation to Investor Learnings Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On AdviceTools Check Visibility of AdviceTools
    And Click On Investor Learnings

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser451 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Verify Navigation to FAQs Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On AdviceTools Check Visibility of AdviceTools
    And Click On FAQs

    @SIT
    Examples: 
      | onlineid    | password |
      | onlineid140 | Test@123 |

    @UAT
    Examples: 
      | onlineid     | password |
      | uatuser016 | Pass@1234 |

  @Sanity @Dashboard
  Scenario Outline: Visibility of Advice Tools For guest User
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On AdviceTools Check Visibility of AdviceTools

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
      
         @UAT
      Examples: 
      | onlineid        | password |
      | uatguest1 		| Pass@123 |

  @Sanity @Dashboard
  Scenario Outline: Navigate to Military Finance For guest User
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On AdviceTools Check Visibility of AdviceTools
    And Click On Military Finance

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
      @UAT
      Examples: 
      | onlineid        | password |
      | uatuser727 		| Pass@1234 |
      

  @Sanity @Dashboard
  Scenario Outline: Navigate to Investor Learnings For guest User
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On AdviceTools Check Visibility of AdviceTools
    And Click On Investor Learnings

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
       @UAT
       Examples: 
      | onlineid        | password |
      | uatuser730 		| Pass@1234 |
      

  @Sanity @Dashboard
  Scenario Outline: Navigate to FAQs For guest User
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Click On AdviceTools Check Visibility of AdviceTools
    And Click On FAQs

    @SIT
    Examples: 
      | onlineid        | password     |
      | guestusersit102 | Victory@1234 |
      
      @UAT
       Examples: 
      | onlineid        | password     |
      | uatuser401 		| Pass@1234 |
      
