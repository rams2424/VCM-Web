package com.framework.StepDefinations.CustomerManagement;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.ProfileAndPreferences.Profile.AddRelationshipInformationPage;
import com.framework.Pages.ProfileAndPreferences.Profile.BasicInformation;
import com.framework.Pages.ProfileAndPreferences.Profile.ManageMilitaryInformationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageMilitaryInfoScenario {
	
	BasicInformation basicInformationPage = new BasicInformation(DriverFactory.getInstance().getDriver());
	ManageMilitaryInformationPage militaryinfoPage;
	AddRelationshipInformationPage relationshipinfoPage = new AddRelationshipInformationPage(DriverFactory.getInstance().getDriver());
	@When("^Click On Manage Military Information Tab$")
	public void click_on_manage_military_information_tab() throws Throwable {
		militaryinfoPage = basicInformationPage.navigateToMilitaryInfo();
	}

    @Then("^User Should be Navigate To Manage Military Information Page$")
    public void user_should_be_navigate_to_manage_military_information_page() throws Throwable {
       militaryinfoPage.verifyManageMilitaryInfoPage("Manage Military Information");
    }
    @Then("^Cancel And Save button should be display$")
    public void cancel_and_save_button_should_be_display() throws Throwable {
    	relationshipinfoPage.verifySaveBtn(); 
    	relationshipinfoPage.verifyCancelBtnIsDisplayed();
    }
    @And("^Click On Military Serving check Box$")
    public void click_on_military_serving_check_box() throws Throwable {
       militaryinfoPage.clickOnCurrentlyServingCheckBox();
    }
    @Then("^Verify Military status dropdown with values \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void verify_military_status_dropdown_with_values_somethingsomethingsomethingsomething(String activedut, String retiredfromactiveduty, String separatedmilitary, String reservefulltime) throws Throwable {
      militaryinfoPage.verifyMilitaryStatusDropDown1(activedut, retiredfromactiveduty, separatedmilitary, reservefulltime); 
    }
    @Then("^verify Service dropdown \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void verify_service_dropdown_somethingsomethingsomethingsomethingsomethingsomething(String army, String navy, String marinecorp, String airforce, String coastguard, String other) throws Throwable {
       militaryinfoPage.verifyServiceDropDown(army, navy, marinecorp, airforce, coastguard, other);
    }
    @Then("^Click On Rank Dropdown with value \"([^\"]*)\"$")
    public void click_on_rank_dropdown_with_value_something(String secondlieutenant) throws Throwable {
    	militaryinfoPage.clickOnRankDropDn(secondlieutenant);
    }

    @And("^Click on military status dropdown with \"([^\"]*)\"$")
    public void click_on_military_status_dropdown_with_something(String activedutymilitary) throws Throwable {
        militaryinfoPage.clickOnMilitaryStatusDropDn(activedutymilitary);
    }

    @And("^Click on branch of service dropdown with \"([^\"]*)\"$")
    public void click_on_branch_of_service_dropdown_with_something(String army) throws Throwable {
    	Thread.sleep(2000);
        militaryinfoPage.clickOnBranchOfServiceDropDn(army);
    }
    @And("^Enter from and to date as \"([^\"]*)\",\"([^\"]*)\"$")
    public void enter_from_and_to_date_as_somethingsomething(String fromdate, String todate) throws Throwable {
    	militaryinfoPage.enterFromDate(fromdate);
    	militaryinfoPage.enterToDate(todate);
    }

    @And("^Enter Commission of source \"([^\"]*)\"$")
    public void enter_commission_of_source_something(String txt) throws Throwable {
       militaryinfoPage.enterCommissionSource(txt);
    }

    @Then("^Information should be saved with message as \"([^\"]*)\"$")
    public void information_should_be_saved_with_message_as(String msg) throws Throwable {
    	 militaryinfoPage.verifyInformationIsUpdated(msg);
    }


}
