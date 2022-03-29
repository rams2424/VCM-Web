package com.framework.StepDefinations.ProfileNPreferances;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.ProfileAndPreferences.AccountPreference;
import com.framework.Pages.ProfileAndPreferences.BasicInformation;
import com.framework.Pages.ProfileAndPreferences.DeliverySettings;
import com.framework.Pages.ProfileAndPreferences.ProfilePage;
import com.framework.Pages.ProfileAndPreferences.SecurityPreferences;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileNPreferancesNavigations {
    HomePage home=new HomePage(DriverFactory.getInstance().getDriver());
    ProfilePage profile;
    AccountPreference accPreference;
    BasicInformation baseInf;
    DeliverySettings delSett;
    SecurityPreferences secPref;
    @When("^User clicks on User dropdown$")
    public void user_clicks_on_User_dropdown() throws Throwable {
        home.clickOn_Dropdown();
    }
    
    @When("^User Clicks on \"([^\"]*)\" from dropdown$")
    public void user_Clicks_on_from_dropdown(String arg1) throws Throwable {
        home.clickOn_DropdownValue(arg1);
    }
    
    @Then("^User should be navigated to Profile page$")
    public void user_should_be_navigated_to_Profile_page() throws Throwable {
        profile=home.navigateToProfilePage();
        profile.verifyProfilePage();
    }
    
    @When("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String arg1) throws Throwable {
        profile.clickOn(arg1);
    }
    
    @Then("^User should navigate to Basic information page$")
    public void user_should_navigate_to_Basic_information_page() throws Throwable {
        baseInf=profile.navigateToBasicInformation();
    	baseInf.verifyBasicInformationPage();
        
    }
    
    @Then("^User should navigate to Delivery Settings page$")
    public void user_should_navigate_to_Delivery_Settings_page() throws Throwable {
        delSett=profile.navigateToDeliverySettings();
        delSett.verifyDeliverySettingsPage();
    }
    
    @Then("^User should navigate to Account Preference page$")
    public void user_should_navigate_to_Account_Preference_page() throws Throwable {
        accPreference=profile.navigateToAccountPreference();
        accPreference.verifyAccountPreferencePage(); 
    }
    
    @Then("^User should navigate to Security Preferences page$")
    public void user_should_navigate_to_Security_Preferences_page() throws Throwable {
        secPref=profile.navigateToSecurityPreferences();
        secPref.verifySecurityPreferencePage();
    }
    
}
