package com.framework.StepDefinations.ContactInfo;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.MessageCenter.CreateSecureMessage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactInfoSanityScenarios {
    
    HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());
    CreateSecureMessage secureMsgPage = new CreateSecureMessage(DriverFactory.getInstance().getDriver());
    @When("^User is on Home Page$")
    public void user_is_on_home_page() throws Throwable {
        homePage.verifyHomePageLink();
    }
    @Then("^Verify  Contact Us option is displaying$")
    public void verify_contact_us_option_is_displaying() throws Throwable {
        homePage.verifyFlotingContactInfo();
    }
    @Then("^Verify Send us a secure message,Phone  icon with toll free number and live chat agent is displaying$")
    public void verify_send_us_a_secure_messagephone_icon_with_toll_free_number_and_live_chat_agent_is_displaying() throws Throwable {
        homePage.verifySendsecureMsgOptionIsDisplaying();
        homePage.verifyTollFreeNo();
        homePage.verifyInternationalNo();
        homePage.verifyEnableCoBrowsingLink();
    }

    @And("^Click on Contact Us icon$")
    public void click_on_contact_us_icon() throws Throwable {
       homePage.clickOnContactUsOption();
    }


    @And("^Click on Send us a secure message$")
    public void click_on_send_us_a_secure_message() throws Throwable {
       homePage.clickOnSecureMsgLink();
    }
    
    @When("^Click on enable cobrowsing link$")
    public void click_on_enable_cobrowsing_link() throws Throwable {
        homePage.clickOnEnableCoBrowsing();
    }

    @Then("^CoBrowsing window should be display$")
    public void cobrowsing_window_should_be_display() throws Throwable {
        homePage.verifyCoBrowsingWindowTitle();
    }
    
    @And("^Message should be display \"([^\"]*)\"$")
    public void message_should_be_display_something(String msg) throws Throwable {
        homePage.verifyCoBrowsingWindowTxt(msg);
    }
    @And("^security key and share your screen option should be display$")
    public void security_key_and_share_your_screen_option_should_be_display() throws Throwable {
        homePage.verifyShareYourScreen();
        homePage.verifySecurityKey();
    }
    @And("^Close contact Us icon$")
    public void close_contact_us_icon() throws Throwable {
       homePage.clickOncloseContactUseOption();
    }
    @Then("^Verify User is On Create Secure Message Page \"([^\"]*)\"$")
    public void verify_User_is_On_Create_Secure_Message_Page(String arg1) throws Throwable {
        secureMsgPage.verifyCreateSecureMessage(arg1);
    }
    
}
