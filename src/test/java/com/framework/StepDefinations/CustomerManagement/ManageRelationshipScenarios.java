package com.framework.StepDefinations.CustomerManagement;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.ProfileAndPreferences.Profile.AddRelationshipInformationPage;
import com.framework.Pages.ProfileAndPreferences.Profile.BasicInformation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ManageRelationshipScenarios {
	
	AddRelationshipInformationPage relationShipPage =new AddRelationshipInformationPage(DriverFactory.getInstance().getDriver());
	BasicInformation basicInformationPage = new BasicInformation(DriverFactory.getInstance().getDriver());
	Logger log = LoggerHelper.getLogger(ManageRelationshipScenarios.class);
    @And("^verify Customer can see details \"([^\"]*)\" and \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void verify_customer_can_see_details_something_and_somethingsomethingsomething(String perinfo, String contactinfo, String phoneinfo, String emailinfo) throws Throwable {
    	log.info("PersonalInfo Tab"+perinfo);
    	basicInformationPage.verifyPersonalTab(perinfo);
    	log.info("Contact Information Page"+contactinfo);
    	basicInformationPage.verifyContactInfoTab(contactinfo);
    	log.info("Phone Info"+phoneinfo);
    	basicInformationPage.verifyPhoneInfoTab(phoneinfo);
    	log.info("Email Info"+emailinfo);
    	basicInformationPage.verifyEmpInfoTab(emailinfo);
    }

    @And("^\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void somethingsomethingsomethingsomething(String financial, String emp, String military, String manageinfo) throws Throwable {
    	log.info("Financial Info"+financial);
    	basicInformationPage.verifyFinancialInfoTab(financial);
    	log.info("Employee Info"+emp);
    	basicInformationPage.verifyEmpInfoTab(emp);
    	log.info("Military Info"+military);
    	basicInformationPage.verifyMilitaryInfoTab(military);
    	log.info("Manage RelationsShip Info"+manageinfo);
    	basicInformationPage.verifyRelationShipInfoTab(manageinfo);
    }
    @And("^Click On Manage RelationShip Tab$")
    public void click_on_manage_relationship_tab() throws Throwable {
    	relationShipPage = basicInformationPage.navigateToAddRelationshipPage(); 
    }
    @And("^enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enter_somethingsomethingsomethingsomething(String fname, String lname, String dob, String gender) throws Throwable {
    	log.info("First Name"+fname);
    	relationShipPage.clickOnRelationDropDown();
    	relationShipPage.enterFirstName(fname);
    	log.info("Last Name"+lname);
    	relationShipPage.enterLastName(lname);
    	log.info("DOB"+dob);
    	relationShipPage.enterDob(dob);
    	log.info("Gender"+gender);
    	relationShipPage.clickOnGender(gender);
    }

    @And("^enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enter_somethingsomethingsomethingsomethingsomethingsomething(String maritalstatus, String citizen, String phoneno, String email, String address, String zipcode) throws Throwable {
        log.info("marital Status"+maritalstatus);
        log.info("citizen"+citizen);
        log.info("Phone No"+phoneno);
        log.info("Email Address"+email);
        log.info("Address"+address);
        log.info("zip Code"+zipcode);
        relationShipPage.clickOnMaritalStatusDropDn(maritalstatus);
        relationShipPage.clickOnCitizanShipBtn(citizen);
        relationShipPage.enterPrimaryPhoneNo(phoneno);
        relationShipPage.enterPrimaryMail(email);
        relationShipPage.clickOnAddressTypeRadioBtn();
        relationShipPage.enterAddressLine1(address);
        relationShipPage.enterZipCode(zipcode);
        relationShipPage.clickOnUseThisAddressBtn();
    }

    @And("^click On Save Button$")
    public void click_on_save_button() throws Throwable {
       relationShipPage.clickOnSaveBtn();
    }
    
    @Then("^Information should be saved$")
    public void information_should_be_saved() throws Throwable {
       relationShipPage.verifyInformationIssaved();
    }
    @And("^Click On Cancel Button$")
    public void click_on_cancel_button() throws Throwable {
    	relationShipPage.clickOnCancelBtn();
    }

    @Then("^Error message should be display for invalid phone no as \"([^\"]*)\"$")
    public void error_message_should_be_display_for_invalid_phone_no_as_something(String errormsg) throws Throwable {
       
    }

    @And("^Enter primary phone no \"([^\"]*)\"$")
    public void enter_primary_phone_no_something(String phoneno) throws Throwable {
       
    }
    
    @Then("^error message should be display for invalid email \"([^\"]*)\"$")
    public void error_message_should_be_display_for_invalid_email_something(String msg) throws Throwable {
       
    }

    @Then("^error message should be display for invalid zip code \"([^\"]*)\"$")
    public void error_message_should_be_display_for_invalid_zip_code_something(String msg) throws Throwable {
       
    }
    
    @Then("^Address Type should be display as  \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void address_type_should_be_display_as_somethingsomethingsomethingsomething(String usorusterritories, String apoarmyorairforcepostoffice, String fpofleetpostoffice, String dpodiplomaticpostoffice) throws Throwable {
        
    }
    
    @Then("^error message should be display for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void error_message_should_be_display_for_somethingsomethingsomethingsomething(String fnameerror, String lnameerror, String doberror, String gendererror) throws Throwable {
       
    }

    @And("^Also display error message for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void also_display_error_message_for_somethingsomethingsomethingsomething(String maritalstatuserror, String citizanshiperror, String addressline1error, String zipcodeerror) throws Throwable {
       
    }
    @Then("^User Should be navigate to Basic Information Page$")
    public void user_should_be_navigate_to_basic_information_page() throws Throwable {
        basicInformationPage.verifyBasicInformationPage("Basic Information");
    }
}
