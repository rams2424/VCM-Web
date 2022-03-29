Feature: Create Secure Message

@Regression @GenericFunctions
Scenario Outline:Verify Create Secure Messages
   Given User is on VCM login page with "<onlineid>" and "<password>"
  When Click On Message From Message Center Dashboard
	 And Click On Create_Secure_Messages
	 And Click On Topic "<TopicName>"
	 And  Choose Account "<AccountNumber>" and "<AccountType>"
	 And Write "<Subject>"
	 Then Write a Message "<MessageBody>"
   Then ClickOnSubmit
   Then User is logged Out

@SIT   
Examples:
|onlineid 	|password	|Subject |MessageBody |TopicName |AccountNumber |AccountType |     
|onlineid39 |Test@123|Testing123 |Messages1 |Account Opening |40110313	 |Individual |

@UAT
Examples:
|onlineid 	|password	|Subject 	|MessageBody 	|TopicName 		|AccountNumber |AccountType |
|uatuser070 |Pass@1234	|Testing123 |Messages1 		|Account Opening |83227323	 	|Individual |


@Regression @GenericFunctions
Scenario Outline: Verify Create Secure Messages in Sent Items Page
   Given User is on VCM login page with "<onlineid>" and "<password>"
   When Click On Message From Message Center Dashboard
	 And Click On Create_Secure_Messages
	 And Click On Topic "<TopicName>"
	And  Choose Account "<AccountNumber>" and "<AccountType>"
	 And Write "<Subject>"
	 Then Write a Message "<MessageBody>"
   Then ClickOnSubmit For Checking Error
   And Cancel The Popup
   And Click Sent Items
   And Verify Last Message "<Subject>"
   Then User is logged Out

@SIT   
   Examples:
|onlineid 	|password	|Subject |MessageBody |TopicName |AccountNumber |AccountType |
     
|onlineid39 |Test@123|Testing3 |Messages3 |Account Opening |85013928 |Roth IRA |

@UAT
  Examples:
|onlineid 	|password	|Subject |MessageBody |TopicName |AccountNumber |AccountType |
|uatuser090 |Pass@1234	|Testing123 |Messages1 |Account Opening |83227323	 |Individual |

@Regression @GenericFunctions
Scenario Outline: Verify Error Messages are displaying on Create secure message page
   Given User is on VCM login page with "<onlineid>" and "<password>"
   When Click On Message From Message Center Dashboard
	 And Click On Create_Secure_Messages
	 Then ClickOnSubmit For Checking Error
	 And Check Error Message for Topic "<TopicError>"
	 And Check Error Message for Subject "<SubjectError>"
	 And Check Error Message for MessageBody "<MessageBodyError>"
	 Then User is logged Out

@SIT	 
Examples:
|onlineid 	|password |TopicError |SubjectError |MessageBodyError |
|onlineid39 |Test@123 |Please select Topic |Please enter minimum 2 characters |Please enter minimum 5 characters |


@UAT

Examples:
|onlineid 	|password |TopicError |SubjectError |MessageBodyError |
|uatuser179 |Pass@1234 |Please select Topic |Please enter minimum 2 characters |Please enter minimum 5 characters |


@Regression @GenericFunctions
Scenario Outline: Check Error Messages For Subject And Message Body
   Given User is on VCM login page with "<onlineid>" and "<password>"
   When Click On Message From Message Center Dashboard
	 And Click On Create_Secure_Messages
	 And Click On Topic "<TopicName>"
 	  Then ClickOnSubmit For Checking Error
	 And Check Error Message for Subject "<SubjectError>"
	 And Check Error Message for MessageBody "<MessageBodyError>"
	 Then User is logged Out

@SIT	 
Examples:
|onlineid 	|password |TopicName |SubjectError |MessageBodyError |
     
|onlineid39 |Test@123 |Account Opening |Please enter minimum 2 characters |Please enter minimum 5 characters |	 
	
	
	
	@UAT
Examples:
|onlineid 	|password |TopicName |SubjectError |MessageBodyError |
     
|uatuser091 |Pass@1234 |Account Opening |Please enter minimum 2 characters |Please enter minimum 5 characters |	 
	  
	 
	 
@Regression @GenericFunctions
Scenario Outline: Check Error Messages For Message Body
   Given User is on VCM login page with "<onlineid>" and "<password>"
   When Click On Message From Message Center Dashboard
	 And Click On Create_Secure_Messages
	 And Click On Topic "<TopicName>"
	 And Write "<Subject>"
 	  Then ClickOnSubmit For Checking Error
	 And Check Error Message for MessageBody "<MessageBodyError>"
	 Then User is logged Out
	 
	 @SIT
	 Examples:
|onlineid 	|password |TopicName |Subject |MessageBodyError |
     
|onlineid39 |Test@123 |Account Opening |Test123 |Please enter minimum 5 characters |	 
	 	 
	 
	 
	  @UAT
	 Examples:
|onlineid 	|password |TopicName |Subject |MessageBodyError |
     
|uatuser033 |Pass@1234 |Account Opening |Test123 |Please enter minimum 5 characters |	 
	 	 
	 
