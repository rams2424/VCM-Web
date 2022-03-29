package com.framework.StepDefinations.TransactionStepDefinations.Exchange.FundRules;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.FundSelectionPage;
import com.framework.Pages.Transaction.Exchange.FundRulesPage;

import io.cucumber.java.en.Then;

public class ExchangeFundRuleWith3000AmountScenario {
	Logger log = LoggerHelper.getLogger(ExchangeFundRuleWith3000AmountScenario.class);
	
	FundSelectionPage fundselectionPage = new FundSelectionPage(DriverFactory.getInstance().getDriver());
	FundRulesPage fundRules = new FundRulesPage(DriverFactory.getInstance().getDriver());
	HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());
	
    @Then("^All 3000 amount funds should be display$")
    public void all_3000_amount_funds_should_be_display() throws Throwable {
    	homePage.clickOnLoadMore();
    	fundRules.verifyFundsWith3000Amount();
    	
    }

}
