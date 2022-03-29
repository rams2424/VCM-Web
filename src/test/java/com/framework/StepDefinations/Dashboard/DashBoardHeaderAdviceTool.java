package com.framework.StepDefinations.Dashboard;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DashBoardHeaderAdviceTool {
	
	HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
	
	 @Then("^Click On AdviceTools Check Visibility of AdviceTools$")
	    public void Click_On_AdviceTools_Check_Visibility_of_AdviceTools() throws Throwable {
		 homePage.checkVisibiltyAdviceTools();
		
	    }
	 @And("^Click On Military Finance$")
	    public void Click_On_Military_Finance() throws Throwable {
		 homePage.NavigatetoMilitaryFinance();
		
	    }
	 @And("^Click On Investor Learnings$")
	    public void Click_On_Investor_Learnings() throws Throwable {
		 homePage.NavigatetoInvestorLearningPage();
		
	    }
	 @And("^Click On FAQs$")
	    public void Click_On_FAQs() throws Throwable {
		 homePage.NavigatetoFaqPage();
		
	    }
	

}
