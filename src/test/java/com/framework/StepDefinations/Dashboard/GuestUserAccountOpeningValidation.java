package com.framework.StepDefinations.Dashboard;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;

import io.cucumber.java.en.Then;

public class GuestUserAccountOpeningValidation {

	HomePage home=new HomePage(DriverFactory.getInstance().getDriver());

	
	@Then("^verify Open an Account tab is displayed$")
	public void verify_Open_an_Account_tab_is_displayed() throws Throwable {
		home.verifyGuestOpenAccountTab();
	}

	@Then("^verify \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" openings are displayed$")
	public void verify_openings_are_displayed(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		home.verifyGuestAccountOpeningsFor(arg1);
		home.verifyGuestAccountOpeningsFor(arg2);
		home.verifyGuestAccountOpeningsFor(arg3);
		home.verifyGuestAccountOpeningsFor(arg4);
	}	
}
