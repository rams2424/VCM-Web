package com.framework.StepDefinations.LoginStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Login.LoginPage;

import io.cucumber.java.en.Then;


public class LoginVisibilityStepDefination {
    
    LoginPage lp=new LoginPage(DriverFactory.getInstance().getDriver());
    @Then("^User should be able to see the Horizontal navigation menu$")
    public void user_should_be_able_to_see_the_Horizontal_navigation_menu() throws Throwable {
        lp.CheckVisibilityOf_linkContactUs();
        lp.CheckVisibilityOf_linkInvestorRelations();
        lp.CheckVisibilityOf_signInRegister();
    }
    
    @Then("^all other elements$")
    public void all_other_elements() throws Throwable {
        lp.CheckVisibilityOf_careers();
        lp.CheckVisibilityOf_dropIcon();
        lp.CheckVisibilityOf_FAB();
        lp.CheckVisibilityOf_fbContact();
        lp.CheckVisibilityOf_forgotPassword();
        lp.CheckVisibilityOf_forgotUserId();
        lp.CheckVisibilityOf_twitterContact();
        lp.CheckVisibilityOf_InvestorsSignIn();
        lp.CheckVisibilityOf_linkContactUs();
        lp.CheckVisibilityOf_linkedinContact();
        lp.CheckVisibilityOf_news();
        lp.CheckVisibilityOf_passwordText();
        lp.CheckVisibilityOf_Policies();
        lp.CheckVisibilityOf_signinButton();
        lp.CheckVisibilityOf_signInRegister();
        lp.CheckVisibilityOf_SignUpBtn();
        lp.CheckVisibilityOf_termsAndConditions();
        lp.CheckVisibilityOf_termsOfUse();
        lp.CheckVisibilityOf_useridText();
        lp.CheckVisibilityOf_youtubeContact();		
    }
    
}
