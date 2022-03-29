package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.ConfirmationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ConfirmationStepDefinations {
	ConfirmationPage confirm=new ConfirmationPage(DriverFactory.getInstance().getDriver());
	
	 
	 @Then("^confirmation Message Should be display as \"([^\"]*)\"$")
	 public void confirmation_message_should_be_display_as_something(String confirmationmsg) throws Throwable {
		 confirm.verifyConfirmationText(confirmationmsg);   
	 }

	@And("^Navigate to HomePage$")
	public void navigate_to_homepage() throws Throwable {
		confirm.clickToHomeLink();
	}
	
}
