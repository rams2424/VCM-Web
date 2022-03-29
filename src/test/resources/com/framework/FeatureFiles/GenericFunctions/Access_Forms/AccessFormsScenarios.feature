Feature: Verifying Access form Functionality

@Sanity @GenericFunctions @Forms  
Scenario Outline:Verify customer can Navigate to the forms
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click on Form on footer
Then Verify User is navigating to forms page
Then User is logged Out 

@SIT
Examples: 
    | onlineid | password |
    | onlineid39| Test@123|
    
      
 @UAT
 Examples: 
      | onlineid    | password |                  
      | uatuser085 | Pass@1234 |
    
@Sanity @GenericFunctions @Forms
Scenario Outline:Verify Adobe Reader is displaying to view the form and download the Adobe Reader
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click on Form on footer
Then Verify User is navigating to forms page
And verify Adobe reader link is displaying
Then User is logged Out 

@SIT
Examples: 
    | onlineid | password |
    | onlineid39| Test@123|
    
      
 @UAT
 Examples: 
      | onlineid    | password |                  
      | uatuser451 | Pass@1234 |
@Sanity @GenericFunctions @Forms
Scenario Outline: Verify Forms Page title is displaying correctly
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click on Form on footer
Then Verify User is navigating to forms page
And Verify Form Page title is displaying as "<title>"
Then User is logged Out 

@SIT
Examples: 
    | onlineid | password |title|
    | onlineid39| Test@123|Forms|
    
      
 @UAT
 Examples: 
      | onlineid    | password 	| title|                 
      | uatuser046 | Pass@1234 |Forms|
      

Scenario Outline:Verify customer can see Frequently Used form on VCM Portal
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click on Form on footer
Then Verify User is navigating to forms page
And Verify Customer can see two  option to check Frequently Used and All forms 
When Click on Popular Option
Then Customer should be able to see the popular forms with the description
Then User is logged Out 
@SIT
Examples: 
    | onlineid | password |
    | onlineid39| Test@123|
    
      
 @UAT
 Examples: 
      | onlineid    | password |                  
      | uatuser016 | Pass@1234 |
    
@Regression @GenericFunctions @Forms
Scenario Outline:Verify Customer see all forms when sorted by All forms section with the Form name, Description as well as Category Name
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click on Form on footer
Then Verify User is navigating to forms page
When Click on All Forms
And Customer should be able to see the Form name along with description for each form
Then User is logged Out 
@SIT
Examples: 
    | onlineid | password |
    | onlineid39| Test@123|
    
      
 @UAT
 Examples: 
      | onlineid    | password |                  
      | uatuser727 | Pass@1234 |
    

Scenario Outline:Verify Customer can open the  form in new Tab
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click on Form on footer
Then Verify User is navigating to forms page
When Click on All Forms
Then Document Should be open in next tab
Then User is logged Out 
@SIT
Examples: 
    | onlineid | password |
    | onlineid39| Test@123|
    
      
 @UAT
 Examples: 
      | onlineid    | password |                  
      | uatuser179 | Pass@1234 |
      
@Sanity @GenericFunctions @Forms
Scenario Outline:Verify Customer can Navigate to Home Page when click on Home Link
Given User is on VCM login page with "<onlineid>" and "<password>"
And Verify User is navigated to HomePage
When Click on Home link from Forms page
Then User should be navigate to home page
Then User is logged Out 
@SIT
Examples: 
    | onlineid | password |
    | onlineid39| Test@123|
    
      
 @UAT
 Examples: 
      | onlineid    | password |                  
      | uatuser090 | Pass@1234 |
