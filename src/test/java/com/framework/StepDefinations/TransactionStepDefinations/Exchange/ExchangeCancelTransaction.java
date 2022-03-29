package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.TransactionPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ExchangeCancelTransaction {
	Logger log = LoggerHelper.getLogger(ExchangeCancelTransaction.class);

	TransactionPage tranPage = new TransactionPage(DriverFactory.getInstance().getDriver());
	HomePage homepage;
    @When("^Click on Cancel button$")
    public void click_on_cancel_button() throws Throwable {
    	tranPage.cancelTransaction();
    }
    @And("^User should be navigate to Account Holding page$")
    public void user_should_be_navigate_to_account_holding_page() throws Throwable {
    	homepage.verifyHomePageLink(); 	
    }


}
