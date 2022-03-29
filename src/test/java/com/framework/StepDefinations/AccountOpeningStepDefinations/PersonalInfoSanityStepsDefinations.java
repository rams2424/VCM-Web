package com.framework.StepDefinations.AccountOpeningStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.AccountOpening.PersonalInfoPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalInfoSanityStepsDefinations {
	PersonalInfoPage personal=new PersonalInfoPage(DriverFactory.getInstance().getDriver());	
	@When("^Enter zip code \"([^\"]*)\"$")
	public void enter_zip_code(String zip) throws Throwable {
		personal.enterZip(zip);
	}

	@Then("^Verify error message for zip code is displaying$")
	public void verify_error_message_for_zip_code_is_displaying() throws Throwable {
		personal.verifyZipError();
	}
	@Then("^Verify USPS Recommendation is displaying$")
	public void verify_USPS_Recommendation_is_displaying() throws Throwable {
		personal.verifyRecommendation();
	}	 
	
	@When("^Click on this address button$")
	public void click_on_this_address_button() throws Throwable {
		personal.clickOnAddressBtn();
	}

	@Then("^Verify zip code is accepted$")
	public void verify_zip_code_is_accepted() throws Throwable {
		personal.verifyZipAccepted();
	}

	@When("^Blank benefeciary type is selected$")
	public void blank_benefeciary_type_is_selected() throws Throwable {
		personal.selectBlankBenefeciaryType();
	}

@Then("^Verify error message for benefeciary type is displaying$")
public void verify_error_message_for_benefeciary_type_is_displaying() throws Throwable {
	personal.verifyBeneficiaryTypeerror();
}

@When("^Enter distribution percentage \"([^\"]*)\"$")
public void enter_distribution_percentage(String per) throws Throwable {
	personal.enterDistributionPercentage(per);
}

@Then("^Verify error message for distribution percentage is displaying$")
public void verify_error_message_for_distribution_percentage_is_displaying() throws Throwable {
	personal.verifyDistributionPercentageError();
}

@When("^Enter firstname \"([^\"]*)\"$")
public void enter_firstname(String fname) throws Throwable {
	personal.enterBeneficiaryP1FirstName(fname);
}

@Then("^Verify error message for first name is displaying$")
public void verify_error_message_for_first_name_is_displaying() throws Throwable {
	personal.verifyBeneficiaryP1FirstNameError();
}

@When("^Enter lastname \"([^\"]*)\"$")
public void enter_lastname(String lName) throws Throwable {
	personal.enterBeneficiaryP1LastName(lName);
}

@Then("^Verify error message for last name is displaying$")
public void verify_error_message_for_last_name_is_displaying() throws Throwable {
	personal.verifyBeneficiaryP1LastNameError();
}
@When("^Enter phone number \"([^\"]*)\"$")
public void enter_phone_number(String lName) throws Throwable {
	personal.enterPhoneNumber(lName);
}

@Then("^Verify error message for phone number is displaying$")
public void verify_error_message_for_phone_number_is_displaying() throws Throwable {
	personal.verifyPhoneNumberError();
	

}


}
