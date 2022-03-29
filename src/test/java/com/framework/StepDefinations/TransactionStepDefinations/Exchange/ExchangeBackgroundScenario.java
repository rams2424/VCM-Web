package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.FundSelectionPage;
import com.framework.Pages.Transaction.TransactionPage;
import com.framework.Pages.Transaction.Exchange.ExchangePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ExchangeBackgroundScenario {
	
    Logger log = LoggerHelper.getLogger(ExchangeBackgroundScenario.class);
    HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());
    TransactionPage tranPage = new TransactionPage(DriverFactory.getInstance().getDriver());
    ExchangePage exchangePage = new ExchangePage(DriverFactory.getInstance().getDriver());
    FundSelectionPage fundselectionPage = new FundSelectionPage(DriverFactory.getInstance().getDriver());
    @When("^Click On Exchange Button$")
    public void click_on_exchange_button() throws Throwable {
    	tranPage.clickOnExchangeBtn();
    	try {Thread.sleep(4000);}catch(Exception ex) {}
    }
    @When("^Select \"([^\"]*)\" Account Type$")
    public void select_something_account_type(String accountType) throws Throwable {
    	log.info("Account type"+accountType);
    	System.out.println(accountType);
    	tranPage.clickOnAccountType(accountType);  
    }

    @And("^Click On Next Button$")
    public void click_on_next_button() throws Throwable {
    	tranPage.clickOnNextBtn(); 
    }
    @Then("^User Should be Navigated to Fund Selection Page$")
    public void user_should_be_navigated_to_fund_selection_page() throws Throwable {
    	fundselectionPage = exchangePage.navigateToFundSelectionPage();
    	fundselectionPage.verifyFundSelectionPage();
    }
    
    @When("^Click on \"([^\"]*)\" fund$")
    public void click_on_something_fund(String fundName) throws Throwable {
    	log.info("Fund Name"+fundName);
    	fundselectionPage.selectFund(fundName);
    }

    @And("^Enter \"([^\"]*)\" for \"([^\"]*)\" fund Name$")
    public void enter_something_for_something_fund_name(String amount, String fundName) throws Throwable {
    	log.info("$Amount"+amount);
        log.info("Fund Name"+fundName);
        fundselectionPage.clickOnEnterAmountRadioBtn(fundName);
        fundselectionPage.enterDollerAmt(amount, fundName);   
    }
    @When("^click on Next$")
    public void click_on_Next() throws Throwable {
    	tranPage.clickOnNextBtn(); 
    }
}
