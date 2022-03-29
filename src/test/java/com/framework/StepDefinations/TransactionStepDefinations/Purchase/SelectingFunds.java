package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.FundSelectionPage;
import com.framework.Pages.Transaction.Purchase.TransactionPage;

import io.cucumber.java.en.When;

public class SelectingFunds {
	
	FundSelectionPage fundSelection=new FundSelectionPage(DriverFactory.getInstance().getDriver());
	TransactionPage transPage = new TransactionPage(DriverFactory.getInstance().getDriver());
	Logger log = LoggerHelper.getLogger(SelectingFunds.class);
	@When("^User Click on \"([^\"]*)\" Fund$")
    public void user_click_on_something_fund(String fundName) throws Throwable {
		log.info("Fund Name"+fundName);
		transPage.clickOnExistingFund(fundName);
    }

}