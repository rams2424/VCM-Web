package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.ConfirmationPage;
import com.framework.Pages.Transaction.FundSelectionPage;
import com.framework.Pages.Transaction.TransactionPage;
import com.framework.Pages.Transaction.Exchange.InvestmentSelectionPage;
import com.framework.Pages.Transaction.Exchange.ReviewAndConfirmPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ExchangWithExistingFundScenario  {
    
    
    TransactionPage tranpage = new TransactionPage(DriverFactory.getInstance().getDriver());
    FundSelectionPage fundselectionPage = new FundSelectionPage(DriverFactory.getInstance().getDriver());
    InvestmentSelectionPage invest =new InvestmentSelectionPage(DriverFactory.getInstance().getDriver());
    ReviewAndConfirmPage reviewAndConfirmPage =new ReviewAndConfirmPage(DriverFactory.getInstance().getDriver());
    ConfirmationPage confirmationPage;
    Logger log = LoggerHelper.getLogger(ExchangWithExistingFundScenario.class);
    
    
    @When("^Select Fund \"([^\"]*)\" and click on Enter Amount$")
    public void select_fund_something_and_click_on_enter_amount(String fundName) throws Throwable {
        log.info("Fund Name"+fundName);
        fundselectionPage.selectFund(fundName);
    }
    @When("^enter \\$ \"([^\"]*)\" for \"([^\"]*)\" fund$")
    public void enter_$_for_fund(String amount, String fundName) throws Throwable {
        log.info("$Amount"+amount);
        log.info("Fund Name"+fundName);
        fundselectionPage.clickOnEnterAmountRadioBtn(fundName);
        fundselectionPage.enterDollerAmt(amount, fundName);     
    }
    
    @When("^Click on next button$")
    public void click_on_next_button() throws Throwable {
        tranpage.clickOnNextBtn();
    }
    
    @Then("^User Should be Navigate To Investment selection Page$")
    public void user_should_be_navigate_to_investment_selection_page() throws Throwable {
        invest = fundselectionPage.navigateToInvestMentSelPage();
        invest.verifyInvestMentSelectionPage();
    }
    
    @When("^Select Existing Fund \"([^\"]*)\"$")
    public void select_existing_fund_something(String existingfundname) throws Throwable {
        log.info("Existing Fund Name"+existingfundname); 
        tranpage.clickOnExistingFund1(existingfundname);
        tranpage.clickOnNextBtn();
    }
    
    
    @Then("^User Should be Move To Review& Confirm Page$")
    public void user_should_be_move_to_review_confirm_page() throws Throwable {
        reviewAndConfirmPage = invest.navigateToReviewAndConfirmPage();
    }
    
    @And("^Verify Selling Amount \"([^\"]*)\"$")
    public void verify_selling_amount_something(String amount) throws Throwable {
        log.info("Selling Amount"+amount);
        reviewAndConfirmPage.verifySellingAmt(amount);
    }
    
    
    @When("^Click On Submit Button$")
    public void click_on_submit_button() throws Throwable {
        log.info("Click On Submit Button StepDefinations");
        reviewAndConfirmPage.clickOnSubmitBtn();
        
    }
    @Then("^Confirmation Page should be display$")
    public void confirmation_page_should_be_display() throws Throwable {
        confirmationPage = new ConfirmationPage(DriverFactory.getInstance().getDriver());
        confirmationPage.verifyConfirmationTxt("Confirmation");
        
    }
    
}
