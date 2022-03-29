package com.framework.StepDefinations.CustomerManagement;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.ProfileAndPreferences.Profile.BasicInformation;
import com.framework.Pages.ProfileAndPreferences.Profile.PhoneInfo.AddPhonePage;
import com.framework.Pages.ProfileAndPreferences.Profile.PhoneInfo.EditPhoneNumberPage;
import com.framework.Pages.ProfileAndPreferences.Profile.PhoneInfo.PhoneInfoPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagePhoneInformations {
    BasicInformation basicInfo=new BasicInformation(DriverFactory.getInstance().getDriver());
    PhoneInfoPage phone=new PhoneInfoPage(DriverFactory.getInstance().getDriver());
    AddPhonePage addPhn=new AddPhonePage(DriverFactory.getInstance().getDriver());
    EditPhoneNumberPage editPhn=new EditPhoneNumberPage(DriverFactory.getInstance().getDriver());
    BasicInformation baseInf=new BasicInformation(DriverFactory.getInstance().getDriver());
    
    @When("^Click On Manage \"([^\"]*)\" Tab$")
    public void click_On_Manage_Tab(String manage) throws Throwable {	
        basicInfo.selectManage(manage);
    }
    
    @Then("^User should be navigate to manage Phone Information$")
    public void user_should_be_navigate_to_manage_Phone_Information() throws Throwable {
        phone.verifyPhoneInfoPage();
    }
    
    @Then("^verify Customer can see details \"([^\"]*)\"$")
    public void verify_Customer_can_see_details(String arg1) throws Throwable {
        phone.visibiltyOfPhn(arg1);
        phone.visibiltyOf(arg1);   
    }
    
    @Given("^Verify add phone number button is displayed$")
    public void verify_add_phone_number_button_is_displayed() throws Throwable {
        phone.verifyAddPhnBttn();
    }
    
    @When("^Click on add phone number button$")
    public void click_on_add_phone_number_button() throws Throwable {
        phone.clickOnAddPhnBttn();
    }
    
    @Then("^Verify navigated to Add Phone Number page$")
    public void verify_navigated_to_Add_Phone_Number_page() throws Throwable {
        addPhn.verifyAddPhonePage();
    }
    
    @Then("^Verify country code and phone number field is displayed$")
    public void verify_country_code_and_phone_number_field_is_displayed() throws Throwable {
        addPhn.verifyCountryCode();
        addPhn.verifyPhoneNumber();
    }
    
    @Then("^mobile number radio is displayed$")
    public void mobile_number_radio_is_displayed() throws Throwable {
        addPhn.verifyIsMobileRadio();
    }
    
    @Then("^Save button should be disabled$")
    public void save_button_should_be_disabled() throws Throwable {
        addPhn.verifySave("disable");
    }
    
    @When("^User enters blank country Code$")
    public void user_enters_blank_country_Code() throws Throwable {
        addPhn.enterCountryCode("");
    }
    
    @Then("^verify error msg for country code is displayed$")
    public void verify_error_msg_for_country_code_is_displayed() throws Throwable {
        addPhn.verifyCountryCodeErrorMsg();
    }
    
    @When("^User enters blank phone Number$")
    public void user_enters_blank_phone_Number() throws Throwable {
        addPhn.enterPhoneNumber("");
    }
    
    @Then("^verify error msg for phone number is displayed$")
    public void verify_error_msg_for_phone_number_is_displayed() throws Throwable {
        addPhn.verifyPhoneErrorMsg();
    }
    
    @When("^User enters code \"([^\"]*)\"$")
    public void user_enters_code(String arg1) throws Throwable {
        addPhn.enterCountryCode(arg1);
    }
    @When("^User enters phone number \"([^\"]*)\"$")
    public void user_enters_phone_number(String arg1) throws Throwable {
        addPhn.enterPhoneNumber(arg1);
    }
    
    @When("^Click on mobile number radio$")
    public void click_on_mobile_number_radio() throws Throwable {
        addPhn.clickOnMobileNoRadio();
    }
    
    @Then("^Save button should be enabled$")
    public void save_button_should_be_enabled() throws Throwable {
        addPhn.verifySave("enable");
    }
    
    @When("^Click on Save button$")
    public void click_on_Save_button() throws Throwable {
        addPhn.clickOnSaveBttn();
    }
    
    @When("^Click on \"([^\"]*)\" number options$")
    public void click_on_number_options(String arg1) throws Throwable {
        phone.clickOnOptionsFor(arg1);
    }
    
    @Then("^Verify edit option is displayed$")
    public void verify_edit_option_is_displayed() throws Throwable {
        phone.verifyEditOpt();
        
    }
    
    @Then("^Verify edit and delete option is displayed$")
    public void verify_edit_and_delete_option_is_displayed() throws Throwable {
        phone.verifyEditOpt();
        phone.verifyDeleteOpt();
    }
    
    @When("^Click on delete option$")
    public void click_on_delete_option() throws Throwable {
        phone.clickOnDeleteBttn();
    }
    
    @Then("^delete confirmation popup should be displayed$")
    public void delete_confirmation_popup_should_be_displayed() throws Throwable {
        phone.verifyPopup();
        
    }
    
    @Then("^Confirm delete$")
    public void confirm_delete() throws Throwable {
        phone.confirmDelete();
    }
    
    @Then("^verify Secondary phone number is deleted$")
    public void verify_Secondary_phone_number_is_deleted() throws Throwable {
        phone.verifyDeletion();
    }
    
    @Then("^Verify cancel button is displayed$")
    public void verify_cancel_button_is_displayed() throws Throwable {
        addPhn.verifyCancelBttn();
    }
    @Then("^Click on Cancel$")
    public void click_on_Cancel() throws Throwable {
        addPhn.clickOnCancelBttn();
    }
    
    @Then("^Verify navigated to Edit Phone Number page$")
    public void Verify_navigated_to_Edit_Phone_Number_page() throws Throwable {
        editPhn.verifyEditPhnPage();
        
    }
    
    
    @When("^Click on edit option$")
    public void click_on_edit_option() throws Throwable {
        phone.clickOnEditBttn();
    }
    
    @Then("^User edit phone number \"([^\"]*)\"$")
    public void user_edit_phone_number(String arg1) throws Throwable {
        editPhn.enterPhoneNumber(arg1);
    }
    @Then("^User should get \"([^\"]*)\"$")
    public void user_should_get(String arg1) throws Throwable {
        phone.verifyMsg(arg1);
    }
    
    @Then("^User should navigate back to Basic information page$")
    public void user_should_navigate_back_to_Basic_information_page() throws Throwable {
        baseInf.verifyBasicInformationPage("Basic Information");
    }
    
    @Then("^verify \"([^\"]*)\" is updated and visible$")
    public void verify_is_updated_and_visible(String arg) throws Throwable {
        baseInf.verifyUpdated(arg);
    }
}
