package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.EconsentPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EconsentPageStepDefinations  {

	EconsentPage consent =new EconsentPage(DriverFactory.getInstance().getDriver());
	@Then("^E-consent Page should be displayed$")
	public void e_consent_Page_should_be_displayed() throws Throwable {
		consent.verifyConsentPage();
	}

	@Then("^Click on terms acceptance checkbox$")
	public void click_on_terms_acceptance_checkbox() throws Throwable {
		consent.clickOnTermsAcceptanceCheckbox();
	}

	@When("^Click on Submit button$")
	public void click_on_Submit_button() throws Throwable {
		consent.clickOnSubmit();
	}


}
