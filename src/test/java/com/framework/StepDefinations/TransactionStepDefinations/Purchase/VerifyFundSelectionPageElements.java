package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.FundSelectionPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyFundSelectionPageElements {
	FundSelectionPage fundSelection=new FundSelectionPage(DriverFactory.getInstance().getDriver());
	

	@Then("^Verify Dropdown \"([^\"]*)\" and \"([^\"]*)\" options$")
	public void verify_Dropdown_and_options(String arg1, String arg2) throws Throwable {
		fundSelection.verifyDropdown(arg1,arg2);
		
	}

	@When("^User Selects \"([^\"]*)\" from dropdown$")
	public void user_Selects_from_dropdown(String arg1) throws Throwable {
		fundSelection.selectFromDropdown(arg1);
	}

	@Then("^verify less than minimum amount in subsequent-error message is displayed$")
	public void verify_less_than_minimum_amount_in_subsequent_error_message_is_displayed() throws Throwable {
		fundSelection.verifyMinAmountErrorMessage();
		
	}

	@Then("^verify less than minimum amount in Subsequent & Monthly Functioning-error message is displayed$")
	public void verify_less_than_minimum_amount_in_Subsequent_Monthly_Functioning_error_message_is_displayed() throws Throwable {
		fundSelection.verifyMinAmountMonthlyErrorMessage();
		
	}

	@When("^User Click on Remove button$")
	public void user_Click_on_Remove_button() throws Throwable {
		fundSelection.clickOnRemoveBtn();
	}

	@Then("^All details should be removed$")
	public void all_details_should_be_removed() throws Throwable {
		fundSelection.verifyRemoveBtnClick();
		
	}

	@When("^User gives past date as starting date$")
	public void user_gives_past_date_as_starting_date() throws Throwable {
		fundSelection.setPastDate();
	
	}
	@When("^User gives a valid date as starting date$")
	public void user_gives_a_valid_date_as_starting_date() throws Throwable {
		fundSelection.enterStartDate("11/11/2021");
	}


	@Then("^past date error message should be displayed$")
	public void past_date_error_message_should_be_displayed() throws Throwable {
		fundSelection.verifyPastDateError();	
	}
	@When("^User gives value \"([^\"]*)\" in Initial$")
	public void user_gives_value_in_Initial(String arg1) throws Throwable {
		fundSelection.enterInitialValue(arg1);
	}

	@When("^User gives value \"([^\"]*)\" in Monthly$")
	public void user_gives_value_in_Monthly(String arg1) throws Throwable {
		fundSelection.enterMonthlyValue(arg1);
	}

	@Then("^total should be updated with \"([^\\\"]*)\" and \"([^\\\"]*)\" and displayed$")
	public void total_should_be_updated_and_displayed(String arg1, String arg2) throws Throwable {
		fundSelection.verifyTotalfield(arg1,arg2);
	}

	@Then("^verify less than minimum amount in Initial Investment-error message is displayed$")
	public void verify_less_than_minimum_amount_in_Initial_Investment_error_message_is_displayed() throws Throwable {
		fundSelection.verifyMinAmountErrorMessage();
	}

	@Then("^verify less than minimum amount in Initial and Monthly Investment-error message is displayed$")
	public void verify_less_than_minimum_amount_in_Initial_and_Monthly_Investment_error_message_is_displayed() throws Throwable {
		fundSelection.verifyMinAmountMonthlyErrorMessage();
	}
	@Then("^Monthly textbox and Start date should be displayed$")
	public void monthly_textbox_and_Start_date_should_be_displayed() throws Throwable {
		fundSelection.checkMonthlyAndStarDate();
	}
	@Then("^date error message should be displayed$")
    public void date_error_message_should_be_displayed() throws Throwable {
        fundSelection.verifyPastDateError();   
    }
 
	@Then("^User gives Blank start date$")
    public void user_gives_Blank_start_date() throws Throwable {
        fundSelection.setPastDate();   
    }
	@Then("^Verify That it is navigated to Investment Page$")
	public void verify_That_it_is_navigated_to_Investment_Page() throws Throwable {
		fundSelection.verifyFundSelection();
	}



}
