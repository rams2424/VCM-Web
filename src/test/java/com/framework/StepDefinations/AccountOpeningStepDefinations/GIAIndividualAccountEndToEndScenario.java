package com.framework.StepDefinations.AccountOpeningStepDefinations;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.AccountOpening.ConfirmAccountOpeningPage;
import com.framework.Pages.AccountOpening.EConsentPage;
import com.framework.Pages.AccountOpening.FundSelectionPage;
import com.framework.Pages.AccountOpening.InvestmentSelectionPage;
import com.framework.Pages.AccountOpening.OpenAccountPage;
import com.framework.Pages.AccountOpening.PersonalInfoPage;
import com.framework.Pages.AccountOpening.PreferencesPage;
import com.framework.Pages.AccountOpening.VerifyPage;
import com.framework.Pages.AccountOpening.GeneralInvestmentAccount.GeneralInvestmentAccountPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GIAIndividualAccountEndToEndScenario {
    
    GeneralInvestmentAccountPage giaPage = new GeneralInvestmentAccountPage(DriverFactory.getInstance().getDriver());
    PersonalInfoPage personalInfoPage = new PersonalInfoPage(DriverFactory.getInstance().getDriver());
    OpenAccountPage openAccountPage = new OpenAccountPage(DriverFactory.getInstance().getDriver());
    FundSelectionPage fundSelectionPage=new FundSelectionPage(DriverFactory.getInstance().getDriver());
    PreferencesPage preferencePage=new PreferencesPage(DriverFactory.getInstance().getDriver());
    VerifyPage verifyPage = new VerifyPage(DriverFactory.getInstance().getDriver());
    EConsentPage econsentPage = new EConsentPage(DriverFactory.getInstance().getDriver());
    HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());
    ConfirmAccountOpeningPage  confirmPage = new ConfirmAccountOpeningPage(DriverFactory.getInstance().getDriver());
    InvestmentSelectionPage investPage = new InvestmentSelectionPage(DriverFactory.getInstance().getDriver());
    Logger log = LoggerHelper.getLogger(GIAIndividualAccountEndToEndScenario.class);
    static String accountNo;
    @Given("^click on individual Account$")
    public void click_on_individual_account() throws Throwable {
        openAccountPage.clickOnGIAAccount();
        openAccountPage.clickOnNextButton();
        giaPage.clickOnIndividualAccount();
        openAccountPage.clickOnNextButton();
    }
    
    @And("^Verify PersonalInfo Page is displaying$")
    public void verify_personalinfo_page_is_displaying() throws Throwable {
        personalInfoPage = giaPage.redirectToPersonalInfoPage();
        personalInfoPage.verifyPersonalInfoPageIsDisplaying();
    }
    @Then("^verify fund selection page is displaying$")
    public void verify_fund_selection_page_is_displaying() throws Throwable { 
        investPage.verifyFundSelectionPage();
    }
    
    @And("^Click on \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void click_on_somethingsomethingsomethingsomething_and_something(String fund1, String fund2, String fund3, String fund4, String fund5) throws Throwable {
        
        fundSelectionPage.clickOnFund(fund1);
    }
    
    @Then("^Verify fund your account page is displaying$")
    public void verify_fund_your_account_page_is_displaying() throws Throwable {
        fundSelectionPage.verifyFundSourceSelectionPage();
    }
    @And("^select Fund Source  as \"([^\"]*)\" and \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void select_fund_source_as_something_and_somethingsomethingsomething(String fundsource, String type, String accountno, String routingno) throws Throwable {
        log.info("Fund Source"+fundsource);
        log.info("Type"+type);
        log.info("Account No"+accountno);
        log.info("Routing no"+routingno);
        investPage.selectFundSource(fundsource, type,accountno, routingno);
    }
    
    @Then("^Verify preference page is displaying$")
    public void verify_preference_page_is_displaying() throws Throwable {
        preferencePage.verifyPreferencePage();
    }
    
    @And("^verify divident and gain radio buttons are displaying$")
    public void verify_divident_and_gain_radio_buttons_are_displaying() throws Throwable {
        preferencePage.verifyDidiventAndCapitalPref();
    }
    
    @And("^statement and prospectus is displaying with 2 radio buttons$")
    public void statement_and_prospectus_is_displaying_with_2_radio_buttons() throws Throwable {
        preferencePage.verifydeliveryPreference();
    }
    @And("^click on delivery option as\"([^\"]*)\"$")
    public void click_on_delivery_option_assomething(String deliveryoption) throws Throwable {
        log.info(deliveryoption);
        preferencePage.clickOndeliveryPreferenceBtn(deliveryoption);
    }
    
    @Then("^verify Verify page is displaying$")
    public void verify_verify_page_is_displaying() throws Throwable {
        verifyPage.verifyPage();
    }
    @And("^verify \"([^\"]*)\"$")
    public void verify_something(String registrationtype) throws Throwable {
        verifyPage.verifyRegistrationType(registrationtype);
    }
    
    @Then("^Verify EConsent page is displaying$")
    public void verify_EConsent_page_is_displaying() throws Throwable {
        econsentPage.verifyEconcentPage();
    }
    
    @And("^click on review checkbox$")
    public void click_on_review_checkbox() throws Throwable {
        econsentPage.clickOnEsign();
    }
    
    @And("^click on Submit Button$")
    public void click_on_submit_button() throws Throwable {
        econsentPage.clickOnSubmitBtn();
    }
    
    @Then("^verify \"([^\"]*)\" is displaying$")
    public void verify_is_displaying(String confirmationtxt) throws Throwable {
        log.info("ConfirmationTxt"+confirmationtxt);
        confirmPage.verifyConfirmationTxt(confirmationtxt);
    }    
    
    @And("^verify Account No is displaying$")
    public void verify_account_no_is_displaying() throws Throwable {
        accountNo = confirmPage.getAccountNo();
        confirmPage.verifyAccountNo();
    }
    
    @Then("^click on Ok Button$")
    public void click_on_ok_button() throws Throwable {
        confirmPage.clickOnOkBtn();
    }
    
    @Then("^user should be navigate to Home Page$")
    public void user_should_be_navigate_to_home_page() throws Throwable {
        homePage.verifyHomePageLink();
    }
    
    @And("^Click on Holding group$")
    public void click_on_holding_group() throws Throwable {
        
    }
    
    @Then("^verify Acount no with (\\d+) balance is displaying$")
    public void verify_Acount_no_with_balance_is_displaying(int arg1) throws Throwable {
        homePage.verifyNewZeroBalAccount();   
    }
    
    @When("^Click on Save Button$")
    public void click_on_save_button() throws Throwable {
        personalInfoPage.clickOnSaveBtn();
    }
    @Then("^Application Should be saved$")
    public void application_should_be_saved() throws Throwable {
       personalInfoPage.verifyMySavedItemPopup();
    }

}
