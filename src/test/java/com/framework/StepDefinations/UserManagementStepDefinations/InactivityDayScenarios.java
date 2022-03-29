package com.framework.StepDefinations.UserManagementStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Login.LoginPage;

import io.cucumber.java.en.Then;

public class InactivityDayScenarios {
    
    LoginPage loginpage = new LoginPage(DriverFactory.getInstance().getDriver());
    
    @Then("^Error message should be display as \"([^\"]*)\"$")
    public void error_message_should_be_display_as_something(String expected) throws Throwable {
        loginpage.verifyAccountLockedMsg(expected);
    }
    
    @Then("^Verify Error message should be display as \"([^\"]*)\"$")
    public void verify_error_message_should_be_display_as_something(String errormsg) throws Throwable {
        loginpage.verifyIncorrectLogin(errormsg);
    }
}
