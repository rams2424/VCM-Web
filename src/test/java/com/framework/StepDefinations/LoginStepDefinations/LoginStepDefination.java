package com.framework.StepDefinations.LoginStepDefinations;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Login.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefination {

	LoginPage loginPage = new LoginPage(DriverFactory.getInstance().getDriver());
	Logger log = LoggerHelper.getLogger(LoginStepDefination.class);
	@Given("^User is on VCM login page with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_is_on_vcm_login_page_with_something_and_something(String onlineId, String password) throws InterruptedException {
		log.info("online id"+onlineId);
		log.info("Password"+password);
		loginPage.login(onlineId,password);
    }
	
	 @Given("^User is on VCM login page with \"([^\"]*)\" and \"([^\"]*)\" for unsuccessfull scenario$")
	    public void user_is_on_vcm_login_page_with_something_and_something_for_unsuccessfull_scenario(String onlineid, String password) throws Throwable {
		 log.info("online id = > "+onlineid);
			log.info("Password = > "+password);
			loginPage.loginforFail(onlineid,password); 
	    }
	
	@When("^User Clicks On Sign In Button$")
	public void user_clicks_on_sign_in_button() throws Throwable {
		loginPage.clickOnSignInButton();
	}
	
}
