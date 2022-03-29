package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.TransactionPage;

import io.cucumber.java.en.And;

public class ExchangeVerifyAllFieldsScenario {
	
	TransactionPage tranpage = new TransactionPage(DriverFactory.getInstance().getDriver());
	@And("^Verify Back Button,Cancel And Next Button is displaying$")
	public void verify_back_buttoncancel_and_next_button_is_displaying() throws Throwable {
		tranpage.checkVisibilityOfNextButton();
		tranpage.verifyBackButtonIsDisplayed();
		tranpage.verifyCancelButtonIsDisplayed();	
	}

}
