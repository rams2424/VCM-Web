Feature: Document center Regression Scenarios
@Regression @DocumentCenter1
Scenario Outline: Verify When User is On home Page the user see Document related message and can access documents
Given User is on VCM login page with "<onlineid>" and "<password>"
Then Verify Document Center Message "<DocumentMess>"
And Verify Document Format Message "<DocumentFormatMess>"
Then Click On Access Document
And Verify It is Navigating to Document Center Page
Then User is logged Out  

@SIT
Examples:
|onlineid 	|password	| DocumentMess | DocumentFormatMess |
|onlineid65 |Test@1234 	| The Document Center has your account documents, such as tax forms, statements, confirms, account updates and other general documents | Documents are in PDF format and can be read with Adobe Acrobat Reader. |

@UAT
Examples:
|onlineid 	|password	| DocumentMess | DocumentFormatMess |
|uatuser085 |Pass@1234 	| The Document Center has your account documents, such as tax forms, statements, confirms, account updates and other general documents | Documents are in PDF format and can be read with Adobe Acrobat Reader. |


@Sanity @GenericFunctions @DocumentCenter
Scenario Outline: Verify User should be navigate to document center By Dashboard
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
Then Click On Access Document
And Verify It is Navigating to Document Center Page
Then User is logged Out

@SIT
Examples:
|onlineid 	|password	|
|onlineid65 |Test@1234 	|



@Sanity @GenericFunctions @DocumentCenter
Scenario Outline: Verify When Guest User Click on Back Button Then it should be navigate to Guest Dashboard Page
Given User is on VCM login page with "<onlineid>" and "<password>"
When User is on Guest Dashboard 
Then Click On Access Document
And Verify It is Navigating to Document Center Page
And Click on back button
Then User should be Navigate to Guest dashboard
Then User is logged Out

@SIT
Examples:
|onlineid 			|password		|
|guestusersit102	|Victory@1234	|

@Sanity @GenericFunctions @DocumentCenter
Scenario Outline:Verify When Click on Home Link from document center user should be navigate to guest dashboard
Given User is on VCM login page with "<onlineid>" and "<password>"
When User is on Guest Dashboard 
Then Click On Access Document
And Verify It is Navigating to Document Center Page
And Click on Home link
Then User should be Navigate to Guest dashboard
Then User is logged Out
@SIT
Examples:
|onlineid 		|password		|
|guestusersit102|Victory@1234	|


