package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.TransactionPage;
import com.framework.Pages.Transaction.Exchange.ExchangePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExchangeBackButtonScenario {
	Logger log = LoggerHelper.getLogger(ExchangeBackButtonScenario.class);
	
	TransactionPage transactionPage = new TransactionPage(DriverFactory.getInstance().getDriver());
	ExchangePage exchangePage = new ExchangePage(DriverFactory.getInstance().getDriver());
	@When("^Click on back button$")
	public void click_on_back_button() throws Throwable {
		transactionPage.clickOnBackBtn();
	}

    @Then("^user should be navigate back to Account Selection page$")
    public void user_should_be_navigate_back_to_account_selection_page() throws Throwable {
    	exchangePage.verifyAccountSelectioPage("1. Account Selection");
    }

}
