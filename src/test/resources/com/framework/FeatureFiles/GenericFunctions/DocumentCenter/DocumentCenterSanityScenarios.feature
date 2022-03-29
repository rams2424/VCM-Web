Feature: Document Center Sanity Scenario

@Sanity @GenericFunctions @DocumentCenter
Scenario Outline: Verify Visiblity of all Elements displyed in Document Center
Given User is on VCM login page with "<onlineid>" and "<password>"
And Check Document Center is visible under profile down caret button
Then Click On Document Center 
And Verify It is Navigating to Document Center Page
And Verify Components are Displaying
And Click on back button
And Verify User is navigated to HomePage
Then User is logged Out 
   
@SIT   
Examples:
|onlineid 	|password	|
|onlineid65 |Test@123|

@Sanity @GenericFunctions @DocumentCenter 
Scenario Outline: Verify Navigate to home Page  from Document preference page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Check Document Center is visible under profile down caret button
Then Click On Document Center 
And Verify It is Navigating to Document Center Page
And Click On Document Preference
And Click On HomePage
And Verify User is navigated to HomePage
Then User is logged Out 
   
   @SIT
Examples:
|onlineid 	|password|
|onlineid65 |Test@123|

@Sanity @GenericFunctions @DocumentCenter 
Scenario Outline: Verify Document Preferences Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Check Document Center is visible under profile down caret button
Then Click On Document Center 
And Verify It is Navigating to Document Center Page
And Click On Document Preference
And Verify Member is On AccountPreferences Page
And Click On Online Documents
And Click On Paper Documents
Then Click On Profile and Preferences
And Click On HomePage
And Verify User is navigated to HomePage
   Then User is logged Out 
   
   @SIT
Examples:
|onlineid 	|password|
|onlineid65 |Test@123|

@Sanity @GenericFunctions @DocumentCenter 
Scenario Outline: Verify All FAQ's are displaying in FAQ Page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Check Document Center is visible under profile down caret button
Then Click On Document Center 
And Verify It is Navigating to Document Center Page
And Click On HelpAndFaqs
Then verify User Should be navigate to Help And FAQ Page
And Click On HomePage from faqPage
And Verify User is navigated to HomePage
Then User is logged Out 
   
 @SIT  
Examples:
|onlineid 	|password	|
|onlineid65 |Test@123|
 
@Regression @GenericFunctions @DocumentCenter
Scenario Outline: Verify When User Click On download Documents Documents should be Open in New Tab
Given User is on VCM login page with "<onlineid>" and "<password>"
And Check Document Center is visible under profile down caret button
Then Click On Document Center 
And Verify It is Navigating to Document Center Page
And Click On Download Document link
Then User is logged Out 
   @SIT
Examples:
|onlineid 	|password|
|onlineid65 |Test@123|

   
@Regression @GenericFunctions @DocumentCenter
Scenario Outline:Verify When Click on Download Adobe reader user should be navigate to Download Adobe reader page
Given User is on VCM login page with "<onlineid>" and "<password>"
And Check Document Center is visible under profile down caret button
Then Click On Document Center 
And Verify It is Navigating to Document Center Page
When Click on download Adobe reader 
Then User should be navigate to Download adobe reader page
Then User is logged Out 

@SIT
Examples:
|onlineid 	|password|
|onlineid65 |Test@123|
   
@Regression @GenericFunctions @DocumentCenter
Scenario Outline:Verify Account name,Document date and  category Text is displaying
Given User is on VCM login page with "<onlineid>" and "<password>"
And Check Document Center is visible under profile down caret button
Then Click On Document Center 
And Verify It is Navigating to Document Center Page
Then Verify "<accName>","<DocDate>" and "<cat>" is displaying
Then User is logged Out 


@SIT
Examples:
|onlineid 	|password|accName	|DocDate	  |cat		|
|onlineid65 |Test@123|Account	|Document Date|Category	|

@DocumentCenter
Scenario Outline:Verify Year dropdown Values

Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
Then Click On Access Document
And Verify It is Navigating to Document Center Page
Then Verify year dropdown values
Then User is logged Out 

@SIT
Examples:
|onlineid 		|password	|
|merrilluser12  |Pass@1234	|

@DocumentCenter
Scenario Outline:Verify Document Category Dropdown Values

Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
Then Click On Access Document
And Verify It is Navigating to Document Center Page
And Verify document category dropdown values
Then User is logged Out 

@SIT
Examples:
|onlineid 		|password	|
|merrilluser12  |Pass@1234	|

@DocumentCenter
Scenario Outline:Verify Document Category Dropdown Values for historical year
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
Then Click On Access Document
And Verify It is Navigating to Document Center Page
And Verify document category dropdown values for past dated years
Then User is logged Out 

@SIT
Examples:
|onlineid 		|password	|
|merrilluser12  |Pass@1234	|

