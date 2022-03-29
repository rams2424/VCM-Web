package com.framework.StepDefinations.CustomerManagement;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.ProfileAndPreferences.Profile.EmailInfo.AddEmailPage;
import com.framework.Pages.ProfileAndPreferences.Profile.EmailInfo.EditEmailPage;
import com.framework.Pages.ProfileAndPreferences.Profile.EmailInfo.EmailInfoPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageEmailInformations  {
    
    EmailInfoPage email=new EmailInfoPage(DriverFactory.getInstance().getDriver());
    AddEmailPage addEmail=new AddEmailPage(DriverFactory.getInstance().getDriver());
    EditEmailPage editEmail=new EditEmailPage(DriverFactory.getInstance().getDriver());
    @Then("^User should be navigate to manage Email Information$")
    public void user_should_be_navigate_to_manage_Email_Information() throws Throwable {
        email.verifyEmailInfoPage();
    }
    
    @Given("^Verify add email button is displayed$")
    public void verify_add_email_button_is_displayed() throws Throwable {
        email.verifyAddEmailBttn();
    }
    
    @When("^Click on add email button$")
    public void click_on_add_email_button() throws Throwable {
        email.clickOnAddEmailBttn();
    }
    
    @Then("^Verify navigated to Add email page$")
    public void verify_navigated_to_Add_email_page() throws Throwable {
        addEmail.verifyAddEmailPage();
    }
    
    @Then("^Verify email address field is displayed$")
    public void verify_email_address_field_is_displayed() throws Throwable {
        addEmail.verifyEmailIdField();
    }
    
    @When("^User enters blank email address$")
    public void user_enters_blank_email_address() throws Throwable {
        addEmail.enterEmailId("");
    }
    
    @Then("^verify error msg for email address is displayed$")
    public void verify_error_msg_for_email_address_is_displayed() throws Throwable {
        addEmail.verifyEmailIdErrorMsg();
    }
    
    @When("^User enters email address \"([^\"]*)\"$")
    public void user_enters_email_address(String emailID) throws Throwable {
        addEmail.enterEmailId(emailID);
    }
    
    @Then("^Verify navigated to Edit Email page$")
    public void Verify_navigated_to_Edit_Email_page() throws Throwable {
        editEmail.verifyEditEmailPage();
        
    }
    
    @Then("^User edit email \"([^\"]*)\"$")
    public void user_edit_email(String arg1) throws Throwable {
        editEmail.enterEmailid(arg1);
    }
    @When("^Click on \"([^\"]*)\" email options$")
    public void click_on_number_options(String arg1) throws Throwable {
        email.clickOnOptionsFor(arg1);
    }
    @Then("^verify Secondary email is deleted$")
    public void verify_Secondary_phone_number_is_deleted() throws Throwable {
    	email.verifyDeletion();
    }
}
