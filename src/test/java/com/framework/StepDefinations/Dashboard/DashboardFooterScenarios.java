package com.framework.StepDefinations.Dashboard;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.GenericFunctions.AccessForm.AccesiblityPage;
import com.framework.Pages.GenericFunctions.AccessForm.AccessFormPage;
import com.framework.Pages.GenericFunctions.AccessForm.ETFProspectusPage;
import com.framework.Pages.GenericFunctions.AccessForm.FAQPage;
import com.framework.Pages.GenericFunctions.AccessForm.LegalAndPrivacyPage;
import com.framework.Pages.GenericFunctions.AccessForm.MFProspectusPage;
import com.framework.Pages.Login.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardFooterScenarios {
	
	HomePage HP = new HomePage (DriverFactory.getInstance().getDriver());
	AccesiblityPage Access = new AccesiblityPage (DriverFactory.getInstance().getDriver());
	AccessFormPage Forms = new AccessFormPage (DriverFactory.getInstance().getDriver());
	ETFProspectusPage ETF = new ETFProspectusPage (DriverFactory.getInstance().getDriver());
	LegalAndPrivacyPage LAP = new LegalAndPrivacyPage(DriverFactory.getInstance().getDriver());
	FAQPage FAQ = new FAQPage(DriverFactory.getInstance().getDriver());
	MFProspectusPage MF = new MFProspectusPage (DriverFactory.getInstance().getDriver());
	LoginPage LP = new LoginPage(DriverFactory.getInstance().getDriver());
	
    @Then("^Scroll down to the page and Verify that footer is present$")
    public void scroll_down_to_the_page_and_Verify_that_footer_is_present() { 
    	HP.VerifyFooter();    
    }
    
    @Then("^Verify Forms , Mutual Fund Prospectuses and ETF Prospect options are dispalyed$")
    public void verify_Forms_Mutual_Fund_Prospectuses_and_ETF_Prospect_options_are_dispalyed() throws Throwable {
        HP.VerifyFormsIcon();
        HP.verifyMFProspectuses();
        HP.verifyETFProspectuses();
    }
    
    @Then("^Verify Legal & Privacy , Accessiblity and Support FAQs options are displayed$")
    public void verify_Legal_Privacy_Accessiblity_and_Support_FAQs_options_are_displayed() throws Throwable {
        HP.verifyLegalAndPrivacy();
        HP.verifyAccessibility();
        HP.verifySupportFAQs();
        
    }
    
    @Then("^Verify that the disclaimer \"([^\"]*)\" is  displayed at the bottom of the page$")
    public void verify_that_the_disclaimer_is_displayed_at_the_bottom_of_the_page(String arg1) throws Throwable {
    	HP.verifyDisclaimerText(); 
    }
    
    @Then("^Verify if Victory Capital logo is displayed$")
    public void verify_if_Victory_Capital_logo_is_displayed() throws Throwable {
    	HP.verifyVictoryCapitalLogo();
        
    }
    
    @Then("^Connect with us option is available$")
    public void connect_with_us_option_is_available() throws Throwable {
    	HP.verifyConnectWithUs();
        
    }
    
  
    
    @When("^Click on Forms option$")
    public void click_on_Forms_option() throws Throwable {
    	HP.clickOnForms();
        
    }
    
    @Then("^Verify that forms post login page is displayed in the same tab$")
    public void verify_that_forms_post_login_page_is_displayed_in_the_same_tab() throws Throwable {
        Forms.verifyAccessFormPage();
       
    }
    
    @When("^Click on Mutual Fund Prospectuses$")
    public void click_on_Mutual_Fund_Prospectuses() throws Throwable {
    	HP.clickOnMFProspectuses();
        
    }
    
    @Then("^Verify that Fund Literature page is displayed in a new tab$")
    public void verify_that_Fund_Literature_page_is_displayed_in_a_new_tab() throws Throwable {
        MF. verifyMFProspectusPage();
        
    }
    
    @When("^Click on ETF Prospectuses$")
    public void click_on_ETF_Prospectuses() throws Throwable {
        HP.clickOnETFProspectuses();
    }
    
    @Then("^Verify VictoryShares ETFs Literature page is displayed in a new tab$")
    public void verify_VictoryShares_ETFs_Literature_page_is_displayed_in_a_new_tab() throws Throwable {
        ETF.verifyETFProspectusPage();
        
    }
    
    @When("^Click on Legal & Privacy option$")
    public void click_on_Legal_Privacy_option() throws Throwable {
    	HP.clickOnLegalAndPrivacy();
        
    }
    
    @Then("^Verify that user Aggreement page is displayed$")
    public void verify_that_user_Aggreement_page_is_displayed() throws Throwable {
        LAP.verifyLegalAndPrivacyPage();


    }
    
    @When("^Click on Accessiblity$")
    public void click_on_Accessiblity() throws Throwable {
    	HP.clickOnAccessibility();
        
    }
    
    @Then("^Verify that user navigates to the accessiblity page$")
    public void verify_that_user_navigates_to_the_accessiblity_page() throws Throwable {
    	Access.verifyAccesiblityPage();
    	
        
    }
    
    @When("^Click on Support FAQs$")
    public void click_on_Support_FAQs() throws Throwable { 
    	HP.clickOnSupportFAQs();
        
    }
    
    @Then("^Verify \"([^\"]*)\" FAQ page should be navigated\\.$")
    public void verify_FAQ_page_should_be_navigated(String arg1) throws Throwable {
    	FAQ.verifyFAQPage(arg1);
    	
        
    }
    
    @Then("^Verify Facebook, Instagram, Linkedin, Twitter and YouTube icons are displayed$")
    public void verify_Facebook_Instagram_Linkedin_Twitter_and_YouTube_icons_are_displayed() throws Throwable {
        HP.CheckVisibilityOf_fbContact();
        HP.CheckVisibilityOf_twitterContact();
        HP.CheckVisibilityOf_linkedinContact();
        HP.CheckVisibilityOf_youtubeContact();
    }
    @Then("^Verify that user is navigated to the Facebook Login page$")
    public void verify_that_user_is_navigated_to_the_Facebook_Login_page() throws Throwable { 
    	
        LP.clickOn_FBContact();  
    }
    @Then("^Verify that user is navigated to Linkedin Page$")
    public void verify_that_user_is_navigated_to_Linkedin_Page() throws Throwable {
        LP.clickOn_linkedinContact();
    }
    
    @Then("^Verify that user is navigated to Twitter Page$")
    public void verify_that_user_is_navigated_to_Twitter_Page() throws Throwable {
        LP.clickOn_twitterContact();
    }
    
    @Then("^Verify that user is navigated to Youtube\\.com HomePage$")
    public void verify_that_user_is_navigated_to_Youtube_com_HomePage() throws Throwable {
        LP.clickOn_youtubeContact();   
    }    
}
