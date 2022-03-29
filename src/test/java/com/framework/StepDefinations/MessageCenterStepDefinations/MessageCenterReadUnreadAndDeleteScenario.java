package com.framework.StepDefinations.MessageCenterStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.MessageCenter.MessageCenterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MessageCenterReadUnreadAndDeleteScenario {
	
	MessageCenterPage messageCenterPage = new MessageCenterPage (DriverFactory.getInstance().getDriver());
	
	@Given("^Click on a Read Message Check box$")
	public void click_on_a_Read_Message_Check_box() throws Throwable {
		messageCenterPage.clickOnSingleCheckBox();
	}
	@Given("^then click on Mark as UnRead button$")
	public void then_click_on_Mark_as_UnRead_button() throws Throwable {
		messageCenterPage.clickOnMarkAsUnReadBtn();
	}

	@Then("^Verify Whether Message is Highligted$")
	public void verify_Whether_Message_is_Highligted() throws Throwable {
		messageCenterPage.verifyMessageIsHighlighted();
		
	}

	@Then("^Click on a Unread Message Check box$")
	public void click_on_a_Unread_Message_Check_box() throws Throwable {
		messageCenterPage.clickOnSingleCheckBox();	    
	}

	@Then("^Click on Mark as Read button$")
	public void click_on_Mark_as_Read_button() throws Throwable {
	   messageCenterPage.clickOnMarkAsReadBtn();
	}

	@Then("^Verify that the Message is not Highlighted$")
	public void verify_that_the_Message_is_not_Highlighted() throws Throwable {
		messageCenterPage.verifyMessageIsNotHighlighted();
		
	} 
	
	@When("^Click on Second message Check box$")
	public void click_on_Second_message_Check_box() throws Throwable { 
		messageCenterPage.clickOnSecondmsgCheckBox();
	    
	}
	@Then("^Click on Delete button$")
	public void click_on_Delete_button() throws Throwable { 
		messageCenterPage.clickOnDeleteButton();
		messageCenterPage.deleteMsgConfirmationBox();
	}

	@When("^Click on first message$")
	public void click_on_first_message() throws Throwable {
		messageCenterPage.clickOnfirstMessage();
	}

	@Then("^Verify that Multiple messages are read$")
	public void verify_that_Multiple_messages_are_read() throws Throwable {
		messageCenterPage.VerifyMultipleMessagesAreNotHighlighted();
		
	}

	@Then("^Select first four Checkboxes$")
	public void select_first_four_Checkboxes() throws Throwable {
		messageCenterPage.ClickOnFirstFourCheckBox();
    
	}

	@Then("^Verify that Multiple messages are Unread$")
	public void verify_that_Multiple_messages_are_Unread() throws Throwable {
		messageCenterPage.VerifyMultipleMessagesAreHighlighted();
		
	}

	@Then("^Click on Multiple Check box$")
	public void click_on_Multiple_Check_box() throws Throwable {
		messageCenterPage.ClickonlastFourCheckBox();
    }

	@Then("^Verify that message is deleted with \"([^\"]*)\"$")
	public void verify_that_message_is_deleted_with(String msg) throws Throwable { 
		messageCenterPage.verifyDeleteMessageisDisplayed(msg);
		
	}

	@Then("^Verify that messages are deleted with \"([^\"]*)\"$")
	public void verify_that_messages_are_deleted_with(String msg) throws Throwable {
		messageCenterPage.verifyDeleteMessageisDisplayed(msg);
		
	}
	@Then("^Verify that all the messages are deleted with \"([^\"]*)\"$")
	public void verify_that_all_the_messages_are_deleted_with(String arg1) throws Throwable {
		messageCenterPage.VerifyAllMessagesAreDeleted(arg1);
		
	}
}
	    
	    
	


