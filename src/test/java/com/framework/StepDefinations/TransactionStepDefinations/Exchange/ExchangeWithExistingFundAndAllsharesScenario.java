package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.ConfirmationPage;
import com.framework.Pages.Transaction.FundSelectionPage;
import com.framework.Pages.Transaction.TransactionPage;
import com.framework.Pages.Transaction.Exchange.ExchangePage;
import com.framework.Pages.Transaction.Exchange.InvestmentSelectionPage;
import com.framework.Pages.Transaction.Exchange.ReviewAndConfirmPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExchangeWithExistingFundAndAllsharesScenario {
	
	Logger log = LoggerHelper.getLogger(ExchangeWithExistingFundAndAllsharesScenario.class);
	ExchangePage exchangePage = new ExchangePage(DriverFactory.getInstance().getDriver());
	TransactionPage tranpage = new TransactionPage(DriverFactory.getInstance().getDriver());
	FundSelectionPage fundselectionPage = new FundSelectionPage(DriverFactory.getInstance().getDriver());
	InvestmentSelectionPage invest=new InvestmentSelectionPage(DriverFactory.getInstance().getDriver());;
	ReviewAndConfirmPage reviewAndConfirmPage;
	ConfirmationPage confirmationPage = new ConfirmationPage(DriverFactory.getInstance().getDriver());
	
    @When("^Select Fund \"([^\"]*)\" and click on All shares$")
    public void select_fund_something_and_click_on_all_shares(String fundName) throws Throwable {
    	log.info("Fund Name"+fundName);
        fundselectionPage.selectFund(fundName);
        fundselectionPage.clickOnAllShares(fundName);
    }

    @And("^Move to Next Page$")
    public void move_to_next_page() throws Throwable {
    	tranpage.clickOnNextBtn();
    }
    
    @Then("^InvestMent Selection Page should be display$")
    public void investment_selection_page_should_be_display() throws Throwable {
    	invest = fundselectionPage.navigateToInvestMentSelPage();
    	invest.verifyInvestMentSelectionPage();
    }
    
    @When("^User Select Existing fund \"([^\"]*)\"$")
    public void user_select_existing_fund_something(String existingfundname) throws Throwable {
    	log.info("Existing Fund"+existingfundname);
    	tranpage.clickOnExistingFund1(existingfundname);
    	tranpage.clickOnNextBtn();
    }
    
    @And("^Navigate to Review& Confirm Page$")
    public void navigate_to_review_confirm_page() throws Throwable {
    	reviewAndConfirmPage = invest.navigateToReviewAndConfirmPage();
    }
    
    @Then("^Verify each field in Confirm Page$")
    public void verify_each_field_in_confirm_page() throws Throwable {
    	reviewAndConfirmPage.verifyAccountSelectionEditBtnDisplayed();
    	reviewAndConfirmPage.verifySellAmtEditBtn();
    	reviewAndConfirmPage.verifyMutualFundEditbtn();
    }
    
    @When("^Click on Submit$")
    public void click_on_Submit() throws Throwable {
    	log.info("Click On Submit Button StepDefinations");
    	reviewAndConfirmPage.clickOnSubmitBtn();
    }

    @Then("^User should be successfully submit Exchange Transaction$")
    public void user_should_be_successfully_submit_Exchange_Transaction() throws Throwable {
    }

    @And("^Verify That confirmartion message should be display as \"([^\"]*)\"$")
    public void verify_that_confirmartion_message_should_be_display_as_something(String confirmationmsg) throws Throwable {
        log.info("Confirmation msg"+confirmationmsg);
        confirmationPage.verifyConfirmationMsg(confirmationmsg);
        
    }
}
