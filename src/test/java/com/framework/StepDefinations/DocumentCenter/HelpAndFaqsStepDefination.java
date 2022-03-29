package com.framework.StepDefinations.DocumentCenter;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.DocumentCenter.DocumentCenterPage;
import com.framework.Pages.DocumentCenter.FAQPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class HelpAndFaqsStepDefination  {
    HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
    DocumentCenterPage documentcenter=new DocumentCenterPage(DriverFactory.getInstance().getDriver());
    FAQPage helpandfaqs=new FAQPage(DriverFactory.getInstance().getDriver());
    
    @And("^Click On HelpAndFaqs$")
    public void Click_On_HelpAndFaqs() throws Throwable {
        documentcenter.verifyPageIsLoaded();
        documentcenter.clickOnFaqLink();        
    }
    @Then("^Check Visibility of All HelpAndFaqs$")
    public void Check_Visibility_of_All_HelpAndFaqs() throws Throwable{
        helpandfaqs.ShowAllFaqs();
        helpandfaqs.UsingVCM();
        helpandfaqs.RegistrationAndAccount();
        helpandfaqs.Investing();
    }
    
    @And("^Click On HomePage from faqPage$")
    public void Click_On_HomePage_from_faqPage() throws Throwable{
        
        helpandfaqs.navigateToHomePage();
        
        
    }
    
    @And("^Verify HomePage$")
    public void Verify_HomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.verifyHomePageLink();
        
    }
    @Then("^verify User Should be navigate to Help And FAQ Page$")
    public void verify_user_should_be_navigate_to_help_and_faq_page() throws Throwable {
        helpandfaqs.verifyFAQPageIsDisplaying("FAQs");
    }
    
    
}
