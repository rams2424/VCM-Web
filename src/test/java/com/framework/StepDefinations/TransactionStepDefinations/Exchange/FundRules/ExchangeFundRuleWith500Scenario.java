package com.framework.StepDefinations.TransactionStepDefinations.Exchange.FundRules;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.FundSelectionPage;
import com.framework.Pages.Transaction.TransactionPage;
import com.framework.Pages.Transaction.Exchange.FundRulesPage;

import io.cucumber.java.en.Then;

public class ExchangeFundRuleWith500Scenario{
	
	Logger log = LoggerHelper.getLogger(ExchangeFundRuleWith500Scenario.class);
	TransactionPage tranpage = new TransactionPage(DriverFactory.getInstance().getDriver());
	FundSelectionPage fundselectionPage = new FundSelectionPage(DriverFactory.getInstance().getDriver());
	FundRulesPage fundRules = new FundRulesPage(DriverFactory.getInstance().getDriver());
	HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());
	
    @Then("^All 500 Funds should be display$")
    public void all_500_funds_should_be_display() throws Throwable {
    	homePage.clickOnLoadMore();
        fundRules.verifyFundsWith$500Amt();
        
    }

}
