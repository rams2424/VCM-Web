package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.TransactionPage;
import com.framework.Pages.Transaction.Exchange.InvestmentSelectionPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExchangeWithNewFundScenario {
	
	InvestmentSelectionPage investMentSelePage = new InvestmentSelectionPage(DriverFactory.getInstance().getDriver());
	TransactionPage tranpage = new TransactionPage(DriverFactory.getInstance().getDriver());
	Logger log = LoggerHelper.getLogger(ExchangeWithNewFundScenario.class);
	@When("^Select New Fund \"([^\"]*)\"$")
	public void select_New_Fund(String fundName) throws Throwable {
		log.info("Fund Name"+fundName);
		investMentSelePage.clickOnNewFund(fundName);
		tranpage.clickOnNextBtn();		
	}
	
	@Then("^click on eConsent Check$")
	public void click_on_eConsent_Check() throws Throwable {
		tranpage.clickOnNextBtn();	
		investMentSelePage.clickOnProspectCheckBox();
		
	}
}
