package com.framework.StepDefinations.UserManagementStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuestLoginScenatios {
    
    HomePage homepage = new HomePage(DriverFactory.getInstance().getDriver());
    @Then("^User should be landed to Guest User Dashboard$")
    public void user_should_be_landed_to_guest_user_dashboard() throws Throwable {
        homepage.verifyGuestUserDashboard();
    }
    
    @When("^User clicks on Logout option$")
    public void user_clicks_on_logout_option() throws Throwable {
        homepage.clickOnSignOutBtn();
    }
    
    @Then("^Verify User should be able to see Logoff notification$")
    public void verify_user_should_be_able_to_see_logoff_notification() throws Throwable {
        homepage.verifySignOutWarningMsg();
    }
    
}
