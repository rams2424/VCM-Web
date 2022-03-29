Feature: Exchange Fund Rules validation

  @Sanity @Exchange 
  Scenario Outline: Verify When less than $50 Amount is given
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Click On Exchange Button
    When Select "<AccountType>" Account Type
    And Click On Next Button
    When Click on "<FundName>" fund
    And Enter "<Amount>" for "<FundName>" fund Name
    And click on Next
    Then User is logged Out

@SIT
    Examples: 
      | onlineid    | password | AccountType | Amount | FundName                   |
      | onlineid140 | Test@123 |    72320416 |     20 | USAA Emerging Markets Fund |

      
      @UAT
    Examples: 
      | onlineid    | password 		| AccountType 	| Amount | FundName                   |
      | uatuser451	 |Pass@1234 	|    500000021 	|     20 | USAA Intermediate-Term Bond Fund |
      