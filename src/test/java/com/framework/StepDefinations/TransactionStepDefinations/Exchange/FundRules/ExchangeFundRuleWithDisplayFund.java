package com.framework.StepDefinations.TransactionStepDefinations.Exchange.FundRules;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Exchange.FundRulesPage;

import io.cucumber.java.en.Then;

public class ExchangeFundRuleWithDisplayFund {
	
	Logger log = LoggerHelper.getLogger(ExchangeFundRuleWithDisplayFund.class);
	FundRulesPage fundRule = new FundRulesPage(DriverFactory.getInstance().getDriver());
	
	@Then("^Verify \"([^\"]*)\" should be display with \"([^\"]*)\" value$")
    public void verify_something_should_be_display_with_something_value(String fundName, String fundValue) throws Throwable {
		log.info("fund name"+fundName);
		log.info("Fund Value"+fundValue);
		fundRule.verifyFundWithAmount(fundName);
		
	}


}
