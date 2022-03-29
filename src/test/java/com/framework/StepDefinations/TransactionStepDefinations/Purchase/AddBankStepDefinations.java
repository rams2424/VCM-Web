package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.FundingOption;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBankStepDefinations {
	FundingOption fundOpt=new FundingOption(DriverFactory.getInstance().getDriver());
	
	@Then("^Verify two radio buttons Savings and Checking are displayed$")
	public void verify_two_radio_buttons_Savings_and_Checking_are_displayed() throws Throwable {
		fundOpt.verifyAddBankRadios();
	}


	@Then("^Verify error message for blank account number is diplayed$")
	public void verify_error_message_for_blank_account_number_is_diplayed() throws Throwable {
		fundOpt.verifyErrorMsgBlankAccntNum();
	}

	@Then("^Verify error message for blank router number is diplayed$")
	public void verify_error_message_for_blank_router_number_is_diplayed() throws Throwable {
		fundOpt.verifyErrorMsgBlankRouterNum();
	}


	@Then("^Verify minimum digit error message for Account number is diplayed$")
	public void verify_minimum_digit_error_message_for_Account_number_is_diplayed() throws Throwable {
		fundOpt.verifyErrorMsgMinAccntNum();
	}
	
	@Then("^Verify minimum digit error message for Routing number is diplayed$")
	public void verify_minimum_digit_error_message_for_Routing_number_is_diplayed() throws Throwable {
		fundOpt.verifyErrorMsgMinRouterNum();
	}
	
	@When("^User checks on \"([^\"]*)\" radio button$")
	public void user_checks_on_radio_button(String radio) throws Throwable {
		fundOpt.seelectRadio(radio);
	}


	@When("^User enters \"([^\"]*)\" as account number$")
	public void user_enters_as_account_number(String accNumber) throws Throwable {
		fundOpt.enterAccountNum(accNumber);
	}

	@When("^User enters \"([^\"]*)\" as routing number$")
	public void user_enters_as_routing_number(String routerNumber) throws Throwable {
		fundOpt.enterRouterNum(routerNumber);
	}



	@Then("^Verify add bank account button is enabled$")
	public void verify_add_bank_account_button_is_enabled() throws Throwable {
		fundOpt.checkAddBankButton("enable");
		
	}
	@Then("^Click on add bank account button$")
	public void click_on_add_bank_account_button() throws Throwable {
		fundOpt.clickOnAddBankAccount();
	}
}
