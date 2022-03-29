package com.framework.StepDefinations.TransactionStepDefinations.Exchange.FundRules;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.FundSelectionPage;
import com.framework.Pages.Transaction.TransactionPage;
import com.framework.Pages.Transaction.Exchange.FundRulesPage;

import io.cucumber.java.en.Then;

public class ExchangeFundRuleWith1000AmountScenario {

	Logger log = LoggerHelper.getLogger(ExchangeFundRuleWith1000AmountScenario.class);
	
	TransactionPage tranpage = new TransactionPage(DriverFactory.getInstance().getDriver());
	FundSelectionPage fundselectionPage = new FundSelectionPage(DriverFactory.getInstance().getDriver());
	FundRulesPage fundRules = new FundRulesPage(DriverFactory.getInstance().getDriver());
	HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());
	@Then("^All funds with 500,1000 amount should be display$")
	public void all_funds_with_5001000_amount_should_be_display() throws Throwable {
		homePage.clickOnLoadMore();
	    fundRules.verifyFundWith$1000AmountisDisplayed();
		
	}
}
