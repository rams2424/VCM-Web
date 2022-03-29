package com.framework.StepDefinations.AccountOpeningStepDefinations;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.AccountOpening.SpecialtyAccount.AccountApplicationFormsPage;
import com.framework.Pages.AccountOpening.SpecialtyAccount.SpecialtyAccountPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpecialityAccountEndToEndScenario{
    
    SpecialtyAccountPage specialityPage = new SpecialtyAccountPage(DriverFactory.getInstance().getDriver());
    AccountApplicationFormsPage accountApplicationForm = new AccountApplicationFormsPage(DriverFactory.getInstance().getDriver());
    Logger log = LoggerHelper.getLogger(SpecialityAccountEndToEndScenario.class);
    
    @And("^click on \"([^\"]*)\"$")
    public void click_on_something(String accountType) throws Throwable {
        log.info("Account type"+accountType);
        specialityPage.clickOnAccountType(accountType);	
    }
    
    @Then("^Verify DownLoadForm , yourMemberApp and supportingDoc fields are displaying$")
    public void verify_downloadform_yourmemberapp_and_supportingdoc_fields_are_displaying() throws Throwable {
        accountApplicationForm.verifyBackBtnIsdisplayed();
        accountApplicationForm.verifyDownladFormDisplay();
        accountApplicationForm.verifyMemberNoDisplay();
        accountApplicationForm.verifysubmitFormDisplay();
        
    }
    @And("^click on download form ,form should be open in new tab$")
    public void click_on_download_form_form_should_be_open_in_new_tab() throws Throwable {
        accountApplicationForm.verifyFormIsDownloaded();
    }
    @Then("^user should be navigate to speciality Account Page$")
    public void user_should_be_navigate_to_speciality_account_page() throws Throwable {
       accountApplicationForm.verifySpecialityAccountPage(); 
    }
    @When("^click on open an account link$")
    public void click_on_open_an_account_link() throws Throwable {
       accountApplicationForm.clickOnOpenAccLink(); 
    }
}
