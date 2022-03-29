package com.framework.StepDefinations.ViewTransactionStepDefinations;
import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.Purchase.FundSelectionPage;
import com.framework.Pages.Transaction.Purchase.TransactionPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TransactionScenario{
    
    Logger log = LoggerHelper.getLogger(TransactionScenario.class);
    public HomePage HPobj = new HomePage(DriverFactory.getInstance().getDriver());
    public TransactionPage TPobj = new TransactionPage(DriverFactory.getInstance().getDriver());
    FundSelectionPage funds=new FundSelectionPage(DriverFactory.getInstance().getDriver());
    @Given("^Member is navigated to the Accounts page$")
    public void member_is_navigated_to_the_Accounts_page() throws Throwable {	
        log.info("Inside  Member is navigated to the Accounts page method ");
    }
    
    @When("^Member clicks on \"([^\"]*)\"$")
    public void member_clicks_on(String holdinggroup) throws Throwable {
        HPobj.ClickOn_HoldingGroup(holdinggroup);
    }
    
    @Then("^Member can see \"([^\"]*)\"$")
    public void member_can_see_master_accounts(String accountType) throws Throwable {
        log.info("Account Type"+accountType);
        HPobj.VisibilityOf_MastersAccount(accountType);
    }
    
    @When("^Member clicks on \"([^\"]*)\" accounts$")
    public void member_clicks_on_accounts(String strArg1) throws Throwable {
        HPobj.ClickOn_MasterAccount(strArg1);
    }
    
    @When("^Member clicks on back to portfolio$")
    public void member_clicks_on_back_to_portfolio() throws Throwable {
        TPobj.clickOn_BacktoPortfolio();
    }
    @Then("^Member is navigated to home page$")
    public void member_is_navigated_to_home_page() throws Throwable {
        HPobj.verifyHomePageLink();
        
    }
    @Then("^verify Member is navigated to transactions page$")
    public void verify_Member_is_navigated_to_transactions_page() throws Throwable {
        TPobj.verifyTransactionPage();
    }	
    
    @Then("^verify the current value$")
    public void verify_the_current_value() throws Throwable {
        TPobj.verifyCurrentValue();
    }
    
    @Then("^verify fund accounts is displayed$")
    public void verify_fund_accounts_is_displayed() throws Throwable {
        TPobj.CheckVisibilityOf_FundsAccount();
    }
    
    @Then("^verify trade button is displayed$")
    public void verify_trade_button_is_displayed() throws Throwable {
        TPobj.verifyTradeBttn();
    }
    
    @When("^click on trade button$")
    public void click_on_trade_button() throws Throwable {
        TPobj.clickOnTradeBttn();
    }
    
    @Then("^Verify \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" is displayed in dropdown$")	
    public void verify_and_is_displayed_in_dropdown(String arg1, String arg2, String arg3) throws Throwable {
        TPobj.verifyTradeBttn();
    }
    
    @Then("^verify ticker is displayed$")
    public void verify_ticker_is_displayed() throws Throwable {
        TPobj.verifyTickerBttn();
    }
    
    @When("^click on ticker$")
    public void click_on_ticker() throws Throwable {
        TPobj.clickOnTickerBttn();
    }
    
    @Then("^Verify \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" is displayed in dropdown$")
    public void verify_and_is_displayed_in_dropdown(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        TPobj.verifyTickerDropdown(arg1,arg2,arg3);
        
    }
    
    @When("^Member clicks on option \"([^\"]*)\"$")
    public void member_clicks_on_option(String opt) throws Throwable {
        TPobj.navigateTo(opt);
    }
    @Then("^Verify that it is navigated to Buy Page$")
    public void verify_that_it_is_navigated_to_Buy_Page() throws Throwable {
        FundSelectionPage fund=new FundSelectionPage(DriverFactory.getInstance().getDriver());
        fund.verifyFundSelection();
        
    }
    
    @Then("^Verify That it is navigated to Sell Page$")
    public void verify_That_it_is_navigated_to_Sell_Page() throws Throwable {
        FundSelectionPage funds =new FundSelectionPage(DriverFactory.getInstance().getDriver());
        funds.verifyFundSelection();
    }
    @Then("^Verify That it is navigated to Exchange Page$")
    public void verify_That_it_is_navigated_to_Exchange_Page() throws Throwable {
        
    }
    @Then("^Verify That it is navigated to View Details Page$")
    public void verify_That_it_is_navigated_to_View_Details_Page() throws Throwable {
        TPobj.verifyViewDetails();
    }
    
    @When("^Click on View Account Activity$")
    public void click_on_View_Account_Activity()throws Throwable {
        TPobj.clickOnViewActivity();
    }
    
    @Then("^Verify only \"([^\"]*)\" is displayed in dropdown$")
    public void verify_only_is_displayed_in_dropdown(String arg1) throws Throwable {
        TPobj.verifyTradeDropdownForIra(arg1);
        
    }
}