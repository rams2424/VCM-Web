package com.framework.StepDefinations.TransactionStepDefinations.Liquidation;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.Liquidation.ConfirmationPage;
import com.framework.Pages.Transaction.Liquidation.FundSelectionPage;
import com.framework.Pages.Transaction.Liquidation.FundingOptionPage;
import com.framework.Pages.Transaction.Liquidation.ReviewPage;
import com.framework.Pages.Transaction.Liquidation.SellPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SellPageStepDefination{
	
	HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
	SellPage sellpage= new SellPage(DriverFactory.getInstance().getDriver());
	FundSelectionPage fundselection = new FundSelectionPage(DriverFactory.getInstance().getDriver());
	FundingOptionPage fundingoption = new FundingOptionPage(DriverFactory.getInstance().getDriver());
	ReviewPage review = new ReviewPage(DriverFactory.getInstance().getDriver());
	
	ConfirmationPage confirmation=new ConfirmationPage(DriverFactory.getInstance().getDriver());
	
	 @When("^Click On Next For Funding Option$")
	 public void Click_On_Next_For_Funding_Option() throws Throwable{
		 fundselection.ClickOnNext();
	 }	 
	 @When("^Enter Federal Tax Value \"([^\"]*)\"$")
	 public void Enter_Federal_Tax_Value(String arg1) throws Throwable{
		 fundingoption.ChekTaxholdingoption(arg1);
	 }
	 
	 @Then("^Error Message shown$")
	 public void Error_Message_shown() throws Throwable{
		 fundingoption.ErrormessageforFederalTax();
		 
	 }

	
		 
}
