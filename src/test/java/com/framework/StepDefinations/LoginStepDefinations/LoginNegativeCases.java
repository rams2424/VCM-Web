package com.framework.StepDefinations.LoginStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Login.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginNegativeCases {
    
    LoginPage lp=new LoginPage(DriverFactory.getInstance().getDriver());	
    
    @When("^User Click on Signin button with wrong credentials$")
    public void user_Click_on_Signin_button_with_wrong_credentials() throws Throwable {
        lp.LoginToSITusingWrongCredentials("Wrong", "Wrong");
    }
    
    @Then("^Wrong Credentials Error message should be displayed$")
    public void wrong_Credentials_Error_message_should_be_displayed() throws Throwable {
        lp.CheckVisibilityOf_errorMessage();
        
    }
    
    @When("^User Click on Signin button without any Credentials$")
    public void user_Click_on_Signin_button_without_any_Credentials() throws Throwable {
        lp.LoginToSITwithoutUseridANDpassword();
    }
    
    @Then("^Mandatory error Messages should be displayed$")
    public void mandatory_error_Messages_should_be_displayed() throws Throwable {
        lp.CheckVisibilityOf_userIdMandatoryMessage();
        lp.CheckVisibilityOf_passwordMandatoryMessage();
        
    }
    
}
