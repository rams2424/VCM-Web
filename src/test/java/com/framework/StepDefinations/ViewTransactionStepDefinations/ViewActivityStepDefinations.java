package com.framework.StepDefinations.ViewTransactionStepDefinations;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.TransactionPage;
import com.framework.Pages.Transaction.ViewTransactions.ViewAccountActivityPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewActivityStepDefinations  {
    
    
    ViewAccountActivityPage activity=new ViewAccountActivityPage(DriverFactory.getInstance().getDriver());
    Logger log = LoggerHelper.getLogger(ViewAccountActivityPage.class);
    @Then("^Verify That is navigated to Account Activity$")
    public void verify_That_is_navigated_to_Account_Activity() throws Throwable {
        activity.verifyActivityPage();
    }
    @Then("^Verify transaction activity table is displayed$")
    public void verify_transaction_activity_table_is_displayed() throws Throwable {
        activity.verifyTransActivity();
    }
    
    @When("^Click on range Dropdown$")
    public void click_on_range_Dropdown() throws Throwable {
        activity.clickOnRangeCombo();
    }
    
    @Then("^verify four options are displayed$")
    public void verify_four_options_are_displayed() throws Throwable {
        activity.verifyCombobox();
    }
    
    @When("^Select \"([^\"]*)\" from dropdown$")
    public void select_from_dropdown(String arg1) throws Throwable {
        activity.selectCombo(arg1);
    }
    
    @Then("^verify stardate and endate is displayed$")
    public void verify_stardate_and_endate_is_displayed() throws Throwable {
        activity.verifytranActivityStartDate();
        activity.verifytranActivityEndDate();
    }
    
    @Then("^verify Apply filter button is diplayed$")
    public void verify_Apply_filter_button_is_diplayed() throws Throwable {
        activity.verifyApplyFilterButton();
    }
    
    @Then("^verify Apply filter is disabled by default$")
    public void verify_Apply_filter_is_disabled_by_default() throws Throwable {
        activity.checkapplyFilterBtn("disable");
    }
    
    @When("^Blank start date is set$")
    public void blank_start_date_is_set() throws Throwable {
        activity.setBlankStartDate();
    }
    
    @Then("^verify Start date error message is displayed$")
    public void verify_Start_date_error_message_is_displayed() throws Throwable {
        activity.verifyStartDateError();
    }
    
    @When("^Blank end date is set$")
    public void blank_end_date_is_set() throws Throwable {
        activity.setBlankEndDate();
    }
    
    @Then("^verify End date error message is displayed$")
    public void verify_End_date_error_message_is_displayed() throws Throwable {
        activity.verifyEndDateError();
    }
    
    @When("^Valid date is given for startdate$")
    public void valid_date_is_given_for_startdate() throws Throwable {
        activity.settranActivityStartDate();
    }
    
    @When("^Valid date is given for enddate$")
    public void valid_date_is_given_for_enddate() throws Throwable {
        activity.settranActivityEndDate();
    }
    
    @Then("^verify Apply filter button is enabled$")
    public void verify_Apply_filter_button_is_enabled() throws Throwable {
        activity.checkapplyFilterBtn("enable");
    }
    
    @When("^click on Apply filter button$")
    public void click_on_Apply_filter_button() throws Throwable {
        activity.clickOnapplyFilterBtn();
    }
    
    @Then("^Validate Back to Account button is displayed$")
    public void validate_Back_to_Account_button_is_displayed() throws Throwable {
        activity.verifyBacktoAccountButton();
    }
    
    @When("^Click on Back to Account button$")
    public void click_on_Back_to_Account_button() throws Throwable {
        activity.clickOnBackToAcc();
    }
    
    @Then("^Verify it is navigated back to transactions page$")
    public void verify_it_is_navigated_back_to_transactions_page() throws Throwable {
        TransactionPage transaction=new TransactionPage(DriverFactory.getInstance().getDriver());
        transaction.verifyTransactionPage();
    }
    
    @When("^Click on \"([^\"]*)\" link$")
    public void click_on_link(String arg1) throws Throwable {
        	activity.clickOnAccountLink(arg1);
    }
    @When("^click on cancel transaction status$")
    public void click_on_cancel_transaction_status() throws Throwable {
        activity.clickOnCancelTransaction();
    }
    
    @Then("^Pop up is displayed$")
    public void pop_up_is_displayed() throws Throwable {
    activity.verifyDialogbox();
    }
    
    @When("^Click on confirm pop up$")
    public void click_on_confirm_pop_up() throws Throwable {
        activity.clickOnConfirm();
    }
    
    @Then("^Transaction is cancelled$")
    public void transaction_is_cancelled() throws Throwable {
        activity.confirmCancellation();
        
    }
    @And("^verify Transaction is cancelled for \"([^\"]*)\" and\"([^\"]*)\" should be display$")
    public void verify_transaction_is_cancelled_for_something_andsomething_should_be_display(String initialvalue, String cancelmsg) throws Throwable {
        activity.clickOnCancelTransaction();
        activity.verifyTransactionIsCancelled(initialvalue,cancelmsg);
    }
    @Then("^verify format of text \"([^\"]*)\"$")
    public void verify_format_of_text(String arg1) throws Throwable {
        activity.verifyDateFormat(arg1);
    }
    
    @When("^click On Cancel Transaction for fundSource \"([^\"]*)\"$")
    public void click_on_cancel_transaction_for_fundsource_something(String fundsource) throws Throwable {
        log.info("Fund Source"+fundsource);
        activity.cancelTransaction(fundsource);
    } 
}
