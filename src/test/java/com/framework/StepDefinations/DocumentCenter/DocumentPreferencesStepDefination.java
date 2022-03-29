package com.framework.StepDefinations.DocumentCenter;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.DocumentCenter.DocumentCenterPage;
import com.framework.Pages.DocumentCenter.DocumentPreferencesPage;
import com.framework.Pages.DocumentCenter.ProfileAndPreferencesPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DocumentPreferencesStepDefination {
    
    HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
    DocumentPreferencesPage documentpreferences =new DocumentPreferencesPage(DriverFactory.getInstance().getDriver());
    DocumentCenterPage documentcenter=new DocumentCenterPage(DriverFactory.getInstance().getDriver());
    ProfileAndPreferencesPage profileandpreferences=new ProfileAndPreferencesPage(DriverFactory.getInstance().getDriver());
    
    @And("^Click On Document Preference$")
    public void click_On_Document_Preference() throws Throwable {
        documentpreferences = documentcenter.navigateToDocumentPreferences();
    }
    @And("^Verify Member is On AccountPreferences Page$")
    public void  Verify_Member_is_On_AccountPreferences_Page() throws Throwable{
        documentpreferences.VerifyAccountPreference();
    }
    @And("^Click On Online Documents$")
    public void Click_On_Online_Documents() throws Throwable{
        documentpreferences.ClickonOnline();
        documentpreferences.closepopup();
    }
    @And("^Click On Paper Documents$")
    public void Click_On_Paper_Documents() throws Throwable{
        documentpreferences.ClickonPaper();
        documentpreferences.closepopup();
    }
    @Then("^Click On Profile and Preferences$")
    public void Click_On_Profile_and_Preferences() throws Throwable{
        documentpreferences.navigateToProfileAndPreferences();
    }
    @And("^Click On HomePage$")
    public void Click_On_HomePage() throws Throwable{
        profileandpreferences.navigateToHomePage();
    }
}
