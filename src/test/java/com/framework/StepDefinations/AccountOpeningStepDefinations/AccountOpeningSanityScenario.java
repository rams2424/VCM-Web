package com.framework.StepDefinations.AccountOpeningStepDefinations;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.AccountOpening.OpenAccountPage;
import com.framework.Pages.AccountOpening.GeneralInvestmentAccount.GeneralInvestmentAccountPage;
import com.framework.Pages.AccountOpening.IndividualRetirementAccount.IndividualRetirementAccountPage;
import com.framework.Pages.AccountOpening.SpecialtyAccount.SpecialtyAccountPage;
import com.framework.Pages.AccountOpening.UGMAAccount.InvestingforChildrenPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountOpeningSanityScenario {
    
    Logger log = LoggerHelper.getLogger(AccountOpeningSanityScenario.class);
    HomePage homepage = new HomePage(DriverFactory.getInstance().getDriver());
    OpenAccountPage openAccountPage=new OpenAccountPage(DriverFactory.getInstance().getDriver());;
    GeneralInvestmentAccountPage giaPage =new GeneralInvestmentAccountPage(DriverFactory.getInstance().getDriver());
    IndividualRetirementAccountPage iraPage;
    InvestingforChildrenPage ugmaPage = new InvestingforChildrenPage(DriverFactory.getInstance().getDriver());
    SpecialtyAccountPage specialityPage;
    @When("^click on open a new Account button$")
    public void click_on_open_a_new_Account_button() throws Throwable {
        homepage.clickOnopenAccountBtn();
    }
    
    @Then("^User Should be navigate to open Account Page$")
    public void user_Should_be_navigate_to_open_Account_Page() throws Throwable {
        openAccountPage = homepage.navigateToAccountOpening();
        openAccountPage.VerifyAccountOpenTitle("Open an account");
    }
    
    @Then("^Verify Next button is displaying$")
    public void verify_Next_button_is_displaying() throws Throwable {
        openAccountPage.verifyNextButtonIsVisible();
    }
    @Then("^Verify Open new Account Button is displaying and enabled$")
    public void Verify_Open_new_Account_Button_is_displaying_and_enabled() throws Throwable {
        homepage.verifyOpenAccountBtnIsEnable();
    }
    
    @Then("^Verify \"([^\"]*)\" ,\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" displaying$")
    public void verify_something_somethingsomething_and_something_displaying(String gia, String ira, String investforchildren, String specialtyaccount) throws Throwable {
        log.info("GIA"+gia);
        log.info("IRA"+ira);
        log.info("Investing for children"+investforchildren);
        log.info("Speciality Account"+specialtyaccount);
        openAccountPage.verifyGIAAccountIsDisplayed(gia);
        openAccountPage.verifyIRAAccountIsDisplayed(ira);
        openAccountPage.verifySpecialityAccountIsDisplaying(specialtyaccount);
        openAccountPage.verifyInvestingForChildrenAccountDisplaying(investforchildren);
    }
    
    @Then("^\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" should be display$")
    public void somethingsomethingsomethingsomething_should_be_display(String ind, String jointwithsurvivorship, String jointwithcommon, String jointwithentirety) throws Throwable {
        log.info("Individual"+ind);
        log.info("jointwithsurvivorship"+jointwithsurvivorship);
        log.info("jointwithcommon"+jointwithcommon);
        log.info("jointwithentirety"+jointwithentirety);
        giaPage.verifyindividualAccount(ind);
        giaPage.verifyjointCommonAccount(jointwithcommon);
        giaPage.verifyjointEntiertyAccount(jointwithentirety);
        giaPage.verifyjointTetantAccount(jointwithsurvivorship);
        
    }
    
    @And("^Click on GIA Account$")
    public void Click_on_GIA_Account() throws Throwable {
        openAccountPage.clickOnGIAAccount();
    }
    
    @And("^Click On Next $")
    public void Click_On_Next() throws Throwable {
        openAccountPage.clickOnNextButton();
    }
    
    @Then("^Verify Save,Back,Cancel,Next Button are  displayed$")
    public void verify_Save_Back_Cancel_Next_Button_are_displayed() throws Throwable {
        openAccountPage.verifysaveBtnIsVisible();
        openAccountPage.verifyBackBtnIsIsVisible();
        openAccountPage.verifyCancelBtn();
        openAccountPage.verifyNextButtonIsVisible();
    }
    
    @Then("^Click on Children Account$")
    public void click_on_Children_Account() throws Throwable {
        openAccountPage.clickOnInvestingForChildrenTab();
    }
    
    
    @Then("^Click on Specility Account$")
    public void click_on_Specility_Account() throws Throwable {
        openAccountPage.clickOnSpecialityAccount();
    }
    
    @And("^Click on IRA Account$")
    public void click_on_ira_account() throws Throwable {
        openAccountPage.clickOnIRATab();
    }
    @Then("^IRA \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" should be display$")
    public void ira_somethingsomethingsomethingsomethingsomething_should_be_display(String tradira, String rothira, String rolloverira, String sepira, String simpleira) throws Throwable {
        log.info("Trad IRA"+tradira);
        log.info("Roth IRA"+rothira);
        log.info("Roll Over IRA"+rolloverira);
        log.info("Sep IRA"+sepira);
        log.info("Simple IRA"+simpleira);
        iraPage = openAccountPage.navigateToIRAPage();
        iraPage.verifyTradIRA(tradira);
        iraPage.verifyRothIRA(rothira);
        iraPage.verifyRollOver(rolloverira);
        iraPage.verifySepIRA(sepira);
        iraPage.verifySimpleIRA(simpleira);
    }
    
    @Then("^\"([^\"]*)\",\"([^\"]*)\" should be display$")
    public void somethingsomething_should_be_display(String savingplan, String ugma) throws Throwable {
        log.info("Saving plan"+savingplan);
        log.info("UGMA "+ugma);
        ugmaPage = openAccountPage.navigateToUGMAPage();
        ugmaPage.verifyClgSavingPlan(savingplan);
        ugmaPage.verifyUGMAAccount(ugma);
    }
    @And("^\"([^\"]*)\",\"([^\"]*)\" And \"([^\"]*)\" should be display$")
    public void somethingsomething_and_something_should_be_display(String brokerdealer, String financialinstitution, String businesscorporation) throws Throwable {
        log.info("brokerdealer"+brokerdealer);   
        log.info("financialinstitution"+financialinstitution); 
        log.info("businesscorporation"+businesscorporation); 
    }
    
    @Then("^\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and$")
    public void and(String trust, String estate, String guardian, String beneficiary, String fourZero, String trsansferondeath, String orp, String communityproperty) throws Throwable {
        log.info("Trust Account"+trust);
        log.info("Estate"+estate);
        log.info("Guardian"+guardian);
        log.info("Beneficiary"+beneficiary);
        log.info("403"+fourZero);
        log.info("Trsansfer On Death"+trsansferondeath);
        log.info("Orp"+orp);
        specialityPage = openAccountPage.navigateToSpecialityPage();
        specialityPage.verifyTrustAccount(trust);
        specialityPage.verifyEstateAccount(estate);
        specialityPage.verifyGuardianAccount(guardian);
        specialityPage.verifyBenifiAccount(beneficiary);
        specialityPage.verifyfourThreeAccount(fourZero);
        specialityPage.verifytransferOnDeathAccount(trsansferondeath);
        specialityPage.verifyorpAccount(orp);
        
    }

    @Then("^\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and$")
    public void and(String conservatorship, String guardianship, String pension, String profitsharingplan, String soleproprietorshipdba, String investmentclub) throws Throwable {
        log.info("conservatorship"+conservatorship);
        log.info("guardianship"+guardianship);
        log.info("pension"+pension);
        log.info("profitsharingplan"+profitsharingplan);
        log.info("soleproprietorshipdba"+soleproprietorshipdba);
        log.info("investmentclub"+investmentclub);
        
    }
    
    @Then("^Verify Cancel,back and next button is displaying$")
    public void verify_cancelback_and_next_button_is_displaying() throws Throwable {
       // openAccountPage.verifyBackBtnIsIsVisible();
        openAccountPage.verifyCancelBtn();
        openAccountPage.verifyNextButtonIsVisible();
    }

}
