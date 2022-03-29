Feature: Simple IRA Account End To End Scenario


 @Regression @AccountOpening

  Scenario Outline: Create Simple and Rollover IRA Account
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When click on open a new Account button
    Then User Should be navigate to open Account Page
    And Click on IRA Account
    And Click On Next
    And User should be navigated to Account type page
    When User selects type "<accountType>"
    Then Verify DownLoadForm , yourMemberApp and supportingDoc fields are displaying
		And click on download form ,form should be open in new tab
		Then User is logged Out   

	@SIT
    Examples: 
      | onlineid    | password | accountType  |
      | onlineid140 | Pass@123 | Simple IRA   |
      | onlineid140 | Pass@123 | Rollover IRA |


	@UAT
    Examples: 
      | onlineid     | password  | accountType  |
      | uatuser070 	 | Pass@1234 | Simple IRA   |
      | uatuser070 	 | Pass@1234 | Rollover IRA |

