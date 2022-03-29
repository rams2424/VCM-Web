Feature: Fund Field Level Validation For Liquidation

  @Liquidation @Sanity
  Scenario Outline: Verify when Click on Back Button it should be navigate to Sell Page from Account selection Page
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When Click On SellPage button
    Then Verify SellPage
    When Select "<AccountNumber>" Account Type
    Then Click On Next
    When Verify FundSelection Page
    Then Click On Back To SellPage
    Then User is logged Out

@SIT
    Examples: 
      | onlineid   | password | AccountNumber |
      | onlineid39 | Test@123 |      40110313 |
      
      @UAT
    Examples: 
      | onlineid   | password | AccountNumber |
      | uatuser091 |Pass@1234 |      500230149 |

  @Liquidation @Sanity 
  Scenario Outline: Validating All shares
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When Click On SellPage button
    Then Verify SellPage
    When Select "<AccountNumber>" Account Type
    Then Click On Next
    When Verify FundSelection Page
    When Select Fund "<FundName>" and click on All shares
    When Click On Next For Deposite Account
    Then User is logged Out

@SIT
    Examples: 
      | onlineid   | password | AccountNumber | FundName                   |
      | onlineid39 | Test@123 |      40110313 | USAA Emerging Markets Fund |


@UAT
    Examples: 
      | onlineid   | password 	| AccountNumber | FundName                   |
      | uatuser091 | Pass@1234 	|     500230149	| USAA Income Stock Fund	 |

  @Liquidation @Regression
  Scenario Outline: Verifying Minimum Amount Message should be display for Dollar amount
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When Click On SellPage button
    Then Verify SellPage
    When Select "<AccountNumber>" Account Type
    Then Click On Next
    When Verify FundSelection Page
    And enter $ "<Amount>" for "<FundName>" fund
    Then Verify message "<ErrorMessage>" for "<FundName>"
    Then User is logged Out

@SIT
    Examples: 
      | onlineid   | password | AccountNumber | FundName                   | Amount | ErrorMessage                |
      | onlineid39 | Test@123 |      40110313 | USAA Emerging Markets Fund |   0.00 | Please enter a valid amount |


	@UAT
    Examples: 
      	| onlineid   	| password 		| AccountNumber | FundName                   | Amount | ErrorMessage                |
       	| uatuser091 	| Pass@1234 	|     500230149	| USAA Income Stock Fund	 |   0.00 | Please enter a valid amount |

  @Liquidation @Regression
  Scenario Outline: Validate When Available Balance for sell is equal to doller amount then error message should be display
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When Click On SellPage button
    Then Verify SellPage
    When Select "<AccountNumber>" Account Type
    Then Click On Next
    When Verify FundSelection Page
    And enter $ "<Amount>" for "<FundName>" fund
    Then Verify message "<ErrorMessage>" for "<FundName>"
    Then User is logged Out

@SIT
    Examples: 
      | onlineid   | password | AccountNumber | FundName                   | Amount  | ErrorMessage                                                                                                          |
      | onlineid39 | Test@123 |      40110313 | USAA Emerging Markets Fund | 3215.94 | Your liquidation amount is equal to your current fund value. Please select “all shares” to ensure a successful trade. |


   @UAT
    Examples: 
      | onlineid    | password      | AccountNumber | FundName                   | Amount   | ErrorMessage                                                                                                          |
      | uatuser091 	| Pass@1234 	|     500230149	| USAA Income Stock Fund     | 54000.00 | Your liquidation amount is equal to your current fund value. Please select “all shares” to ensure a successful trade. |

  @Liquidation @Regression
  Scenario Outline: Validate When Amount is entered which is greater than Available balance then error message should be display
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    When Click On SellPage button
    Then Verify SellPage
    When Select "<AccountNumber>" Account Type
    Then Click On Next
    When Verify FundSelection Page
    And enter $ "<Amount>" for "<FundName>" fund
    Then Verify message "<ErrorMessage>" for "<FundName>"
    Then User is logged Out
@SIT
    Examples: 
      | onlineid   | password | AccountNumber | FundName                   | Amount    | ErrorMessage                                                |
      | onlineid39 | Test@123 |      40110313 | USAA Emerging Markets Fund | 800000.00 | Please enter amount less than or equal to available balance |

      
      @UAT
    Examples: 
      | onlineid    | password      | AccountNumber | FundName                    | Amount     | ErrorMessage                                                            |
      | uatuser091 	| Pass@1234 	|     500230149	|   USAA Income Stock Fund	  |  700000.00 | ErrorPlease enter an amont less than or equal to the available balance. |
      