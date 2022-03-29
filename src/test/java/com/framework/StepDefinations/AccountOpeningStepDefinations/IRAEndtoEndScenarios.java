package com.framework.StepDefinations.AccountOpeningStepDefinations;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.BasePage;
import com.framework.Pages.HomePage;
import com.framework.Pages.AccountOpening.ConfirmAccountOpeningPage;
import com.framework.Pages.AccountOpening.EConsentPage;
import com.framework.Pages.AccountOpening.FundSelectionPage;
import com.framework.Pages.AccountOpening.InvestmentSelectionPage;
import com.framework.Pages.AccountOpening.PersonalInfoPage;
import com.framework.Pages.AccountOpening.PreferencesPage;
import com.framework.Pages.AccountOpening.VerifyPage;
import com.framework.Pages.AccountOpening.IndividualRetirementAccount.IndividualRetirementAccountPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IRAEndtoEndScenarios extends BasePage {
    
    IndividualRetirementAccountPage ira =new IndividualRetirementAccountPage(DriverFactory.getInstance().getDriver());
    PersonalInfoPage personalInfo=new PersonalInfoPage(DriverFactory.getInstance().getDriver());
    FundSelectionPage fundSelectionPage=new FundSelectionPage(DriverFactory.getInstance().getDriver());
    PreferencesPage preferencePage=new PreferencesPage(DriverFactory.getInstance().getDriver());
    VerifyPage verifyPage = new VerifyPage(DriverFactory.getInstance().getDriver());
    EConsentPage econsentPage = new EConsentPage(DriverFactory.getInstance().getDriver());
    HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());
    ConfirmAccountOpeningPage  confirmPage = new ConfirmAccountOpeningPage(DriverFactory.getInstance().getDriver());
    InvestmentSelectionPage investmentSelectionPage=new InvestmentSelectionPage(DriverFactory.getInstance().getDriver());
    static String accountNo;
    
    @Then("^User should be navigated to Account type page$")
    public void user_should_be_navigated_to_Account_type_page() throws Throwable {
        ira.verifyAccountTypePage();
    }
    
    @When("^User selects type \"([^\"]*)\"$")
    public void user_selects_type(String type) throws Throwable {
        switch(type){
            case "Simple IRA":{
                ira.clickOnSimpleIRA();
                break;
            }
            case "Traditional IRA":{
                ira.clickOnTradIRA();
                break;
            }
            case "Rollover IRA":{
                ira.clickOnRollOver();
                break;
            }
            case "Roth IRA":{
                ira.clickOnRothIRA();
                break;
            }
            case "SEP IRA":{
                ira.clickOnSepIRA();
                break;
            }
        }
    }
    
    
    @Then("^Enter Personal informations \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void enter_Personal_informations(String benType,String relation, String percentage, String fname, String lname) throws Throwable {
        personalInfo.enterInfo(benType, relation, percentage, fname, lname);
    }
    @Then("^Select ira contribution$")
    public void select_ira_contribution() throws Throwable {
        investmentSelectionPage.selectIraContribution();
    }
    
    @Then("^dialog pop up box should be displayed$")
    public void dialog_pop_up_box_should_be_displayed() throws Throwable {
        investmentSelectionPage.verifyPopup();
    }
    @Then("^click on proceed$")
    public void click_on_proceed() throws Throwable {
        investmentSelectionPage.clickOnProceed();
        
    }
    
}
