package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.FundingOption;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FundingOptionStepdefinations {
	FundingOption fundOpt= new FundingOption(DriverFactory.getInstance().getDriver());
	Logger log = LoggerHelper.getLogger(FundingOptionStepdefinations.class);
	@Then("^Verify That it is navigated to Fund Source Page$")
	public void verify_That_it_is_navigated_to_Fund_Source_Page() throws Throwable {
		fundOpt.verifyFundSource();
	}
    @When("^Select \"([^\"]*)\" as fund sourcewith \"([^\"]*)\"$")
    public void select_something_as_fund_sourcewith_something(String fundSource, String accno) throws Throwable {
		log.info("Fund Source"+fundSource);
		log.info(accno);
    	fundOpt.selectFundSource(fundSource,accno);
	}
	@When("^Select \"([^\"]*)\" as IRA contribution$")
	public void select_as_IRA_contribution(String ira) throws Throwable {
		fundOpt.selectIraContribution(ira);
	}
	@Then("^verify Dividends and Capital Gains Preferences section is displayed or not$")
	public void verify_Dividends_and_Capital_Gains_Preferences_section_is_displayed_or_not() throws Throwable {
		fundOpt.verifyDividentAndCapitalGains();
	}

	@Then("^Verify the Radio buttons in Dividends and Capital Gains Preferences section$")
	public void verify_the_Radio_buttons_in_Dividends_and_Capital_Gains_Preferences_section() throws Throwable {
		fundOpt.verifyDividentAndCapitalGainsRadioButtons();
	}

	@Then("^verify by default selected on Yes I want to reinvest radio button$")
	public void verify_by_default_selected_on_Yes_I_want_to_reinvest_radio_button() throws Throwable {
		fundOpt.verifyDefaultRadioButton();
	}

	@Then("^Check it is not clickable on No I dont want to reinvest radio button for \"([^\"]*)\" Check and Wire Tranfer$")
	public void check_it_not_clickable_on_No_I_dont_want_to_reinvest_radio_button_for_Check_and_Wire_Tranfer(String fundType) throws Throwable {
		fundOpt.verifyNonClickableRadioButton(fundType);
	}

@When("^Select IRA contributions \"([^\"]*)\"$")
public void select_IRA_contributions(String ira) throws Throwable {
	fundOpt.selectIraContribution(ira);
}

@Then("^Verify pop up dialog box is displayed$")
public void verify_pop_up_dialog_box_is_displayed() throws Throwable {
	fundOpt.verifyDialogbox();
}

@Then("^Click on proceed$")
public void click_on_proceed() throws Throwable {
	fundOpt.clickOnProceed();
}


	
}
