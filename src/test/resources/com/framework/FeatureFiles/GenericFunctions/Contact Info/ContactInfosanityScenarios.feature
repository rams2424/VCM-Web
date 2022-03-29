Feature: Contact Info Sanity scenarios

@Sanity @GenericFunctions
Scenario Outline:Verify Customer able to see of Contact Us option/icon
Given User is on VCM login page with "<onlineid>" and "<password>"
When User is on Home Page
Then Verify  Contact Us option is displaying
Then User is logged Out 

@SIT
Examples: 
    | onlineid 		| password |
    | onlineid65	| Test@1234|
    |guestusersit102|Victory@1234|
    
          
 @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |

@Sanity @GenericFunctions
Scenario Outline:Verify When click on Contact Us Option Customer should able to see the All mandatory options
Given User is on VCM login page with "<onlineid>" and "<password>"
When User is on Home Page
And Click on Contact Us icon
Then Verify Send us a secure message,Phone  icon with toll free number and live chat agent is displaying
And Close contact Us icon
Then User is logged Out 
@SIT
Examples: 
    | onlineid 	| password |
    | onlineid65| Test@1234|
     
           
 @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |
@Sanity @GenericFunctions
Scenario Outline:Verify When click on Send secute message user should be navigate to create secure message page
Given User is on VCM login page with "<onlineid>" and "<password>"
When User is on Home Page
And Click on Contact Us icon
And Click on Send us a secure message
Then Verify User is On Create Secure Message Page "<CreateMessage>"
Then User is logged Out 
@SIT
Examples: 
    | onlineid 	| password |CreateMessage |
    | onlineid65| Test@1234|Create Secure Message |
    
     @UAT
      Examples: 
      | onlineid     | password |CreateMessage |
      | uatuser046 | Pass@1234 |Create Secure Message |
    
    
@Sanity  @GenericFunctions
Scenario Outline:Verify When click on Enable co browsing cobrowsing window should be open
Given User is on VCM login page with "<onlineid>" and "<password>"
When User is on Home Page
And Click on Contact Us icon
When Click on enable cobrowsing link
And Close contact Us icon
Then User is logged Out 
@SIT
Examples: 
    | onlineid 		| password |
    | onlineid65	| Test@1234|
    |guestusersit102|Victory@1234|
    
     @UAT
      Examples: 
      | onlineid     | password |
      | uatuser046 | Pass@1234 |

     
    
@Sanity @GenericFunctions
Scenario Outline:Verify When Open cobrowsing window  Message should be display
Given User is on VCM login page with "<onlineid>" and "<password>"
When User is on Home Page
And Click on Contact Us icon
When Click on enable cobrowsing link
And Message should be display "<msg>"
And Close contact Us icon
Then User is logged Out 
@SIT
Examples: 
    | onlineid 		| password 		|msg			|
    | onlineid65	| Test@1234		|You will have to be on the phone with Victory Capital Representative to use this|
     |guestusersit102|Victory@1234	|You will have to be on the phone with Victory Capital Representative to use this|
 @UAT
      Examples: 
      | onlineid     | password |msg			|
      | uatuser046 | Pass@1234 |You will have to be on the phone with Victory Capital Representative to use this|

@Sanity @GenericFunctions
Scenario Outline:Verify When Open cobrowsing window  send secret key share your screen shoudl be display
Given User is on VCM login page with "<onlineid>" and "<password>"
When User is on Home Page
And Click on Contact Us icon
When Click on enable cobrowsing link
And Close contact Us icon
Then User is logged Out 
@SIT
Examples: 
 | onlineid 		| password 		|
 | onlineid65		| Test@1234		|
 |guestusersit102	|Victory@1234	| 
 
 @UAT
      Examples: 
      | onlineid     | password |
      | uatuser046 | Pass@1234 |
 
 
