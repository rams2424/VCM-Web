Feature: Manage Military Info Test Scenarios

@Sanity @CustomerManagement
Scenario Outline: Verify When Click On Manage Military Information tab user should be navigate to Manage Military Information Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
When Click On Manage Military Information Tab
Then User Should be Navigate To Manage Military Information Page
Then User is logged Out

@SIT
Examples: 
  | onlineid    | password |
  | onlineid140 | Pass@123 |
  

@UAT
Examples: 
  | onlineid    	| password |
  | uatuser070 	|  Pass@1234 |

@Sanity @CustomerManagement
Scenario Outline: Verify Cancel And Save Button should be display on Manage Military Information Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
When Click On Manage Military Information Tab
Then Cancel And Save button should be display
Then User is logged Out

@SIT
Examples: 
  | onlineid    | password |
  | onlineid35 | Pass@1234 |
  

@UAT
Examples: 
  | onlineid    	| password |
  | uatuser070 	|  Pass@1234 |

 @Sanity @CustomerManagement
Scenario Outline: Verify When click On Cancel Button User should be on Basic Information Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
When Click On Manage Military Information Tab
And Click On Cancel Button
Then User Should be navigate to Basic Information Page
Then User is logged Out

@SIT
Examples: 
| onlineid    | password |
| onlineid141 | Pass@123 |

@UAT
Examples: 
  | onlineid    	| password |
  | uatuser070 	|  Pass@1234 |
  
@Sanity @CustomerManagement
Scenario Outline: Verify Military status Dropdown Values
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
When Click On Manage Military Information Tab
And Click On Military Serving check Box
And Click on military status dropdown with "<ActiveDut>"
Then User is logged Out

@SIT
Examples: 
  | onlineid    | password | ActiveDut            | RetiredActivDuty         | SeparatedMilitary  | ReserveFull-time    | ReservePart-time    | Reserve - Retired | Reserve - Inactive | National Guard - Full-time | National Guard - Part-time | National Guard - Retired | National Guard - Inactive | Precommissioning Program | Other |
  | onlineid67 | Pass@123 | Active Duty Military | Retired from Active Duty | Separated Military | Reserve - Full-time | Reserve - Part-time | Reserve - Retired | Reserve - Inactive | National Guard - Full-time | National Guard - Part-time | National Guard - Retired | National Guard - Inactive | Precommissioning Program | Other |


@UAT
Examples: 
  | onlineid    | password | ActiveDut            | RetiredActivDuty         | SeparatedMilitary  | ReserveFull-time    | ReservePart-time    | Reserve - Retired | Reserve - Inactive | National Guard - Full-time | National Guard - Part-time | National Guard - Retired | National Guard - Inactive | Precommissioning Program | Other |
  |uatuser070 | Pass@1234 | Active Duty Military | Retired from Active Duty | Separated Military | Reserve - Full-time | Reserve - Part-time | Reserve - Retired | Reserve - Inactive | National Guard - Full-time | National Guard - Part-time | National Guard - Retired | National Guard - Inactive | Precommissioning Program | Other |


 @Sanity @CustomerManagement
Scenario Outline: Verify Branch Of Service  Dropdown Values
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
When Click On Manage Military Information Tab
And Click On Military Serving check Box
And Click on military status dropdown with "<ActiveDut>"
And Click on branch of service dropdown with "<Army>"
Then User is logged Out

@SIT
Examples: 
| onlineid    | password | Army | Navy |ActiveDut            | 
| onlineid140 | Pass@123 | Army | Navy | Active Duty Military |


@UAT
Examples: 
| onlineid     | password | Army | Navy |ActiveDut            | 
| uatuser070 | Pass@1234 | Army | Navy | Active Duty Military |

@Sanity @CustomerManagement
Scenario Outline: Verify Rank  Dropdown Values
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
When Click On Manage Military Information Tab
And Click On Military Serving check Box
And Click on military status dropdown with "<Active Duty Military>"
And Click on branch of service dropdown with "<Army>"
Then Click On Rank Dropdown with value "<Second Lieutenant>"
Then User is logged Out

@SIT
Examples: 
  | onlineid    | password | Active Duty Military | Army | Second Lieutenant |
  | onlineid35 | Pass@1234 | Active Duty Military | Army | Second Lieutenant |


@UAT
Examples: 
  | onlineid    | password | Active Duty Military | Army | Second Lieutenant |
  | uatuser070| Pass@1234 | Active Duty Military | Army | Second Lieutenant |

@Sanity @CustomerManagement
Scenario Outline: Verify Military information should be saved and message should be display
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When User clicks on User dropdown
And User Clicks on "Profile & Preferences" from dropdown
Then User should be navigated to Profile page
When User clicks on "Profile"
Then User should navigate to Basic information page
When Click On Manage Military Information Tab
And Click On Military Serving check Box
And Enter Commission of source "<txt>"
And click On Save Button
Then Information should be saved with message as "<msg>"
Then User should navigate back to Basic information page
And verify "<Active Duty Military>" is updated and visible
And verify "<Army>" is updated and visible
And verify "<fromDate>" is updated and visible
And verify "<toDate>" is updated and visible
And verify "<txt>" is updated and visible
Then User is logged Out

@SIT
Examples: 
| onlineid    | password | Active Duty Military | Army | Second Lieutenant | fromDate   | toDate     | txt  | msg                                        |
| onlineid140 | Pass@123 | Active Duty Military | Army | Second Lieutenant | 10/11/2019 | 10/13/2019 | Test | Successfully updated Military Information. |

@UAT
Examples: 
| onlineid     | password | Active Duty Military | Army | Second Lieutenant | fromDate   | toDate     | txt  | msg                                        |
| uatuser070 | Pass@1234 | Active Duty Military | Army | Second Lieutenant | 10/11/2019 | 10/13/2019 | Test | Successfully updated Military Information. |
