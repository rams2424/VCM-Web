package com.framework.StepDefinations.TransactionStepDefinations.Liquidation;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Liquidation.ConfirmationPage;
import com.framework.Pages.Transaction.Liquidation.FundSelectionPage;
import com.framework.Pages.Transaction.Liquidation.FundingOptionPage;
import com.framework.Pages.Transaction.Liquidation.ReviewPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiquidationEndToEndWithBankAccount {
	
	Logger log = LoggerHelper.getLogger(LiquidationEndToEndWithBankAccount.class);
	FundingOptionPage fundingoption = new FundingOptionPage(DriverFactory.getInstance().getDriver());
	FundSelectionPage fundselection = new FundSelectionPage(DriverFactory.getInstance().getDriver());
	ReviewPage review = new ReviewPage(DriverFactory.getInstance().getDriver());
	ConfirmationPage confirmation=new ConfirmationPage(DriverFactory.getInstance().getDriver());
	
	@And("^Click On Next For Navigate To Funding Option$")
    public void click_On_Next_For_Navigate_To_Funding_Option() throws Throwable {
	    fundingoption=fundselection.navigatetoFundingOption();
	}
	@When("^Click On Check$")
	public void Click_On_Check() throws Throwable{
	    fundingoption.ClickOnCheck();
	}
	@Then("^Delivery Adress is Visible$")
	public void Delivery_Address_is_Visible() throws Throwable{
	    fundingoption.CheckDeliveryAddress();
	}
	@And("^Select Bank Account \"([^\"]*)\"$")
	public void Select_Bank_Account(String BankName) throws Throwable  {
	    fundingoption.SelectBank(BankName);
    }
	@When("^Click On Next For Review$")
	public void Click_On_Next_For_Review() throws Throwable{
		review= fundingoption.navigatetoReview();
	}
	@Then("^Click On Submit$")
	public void Click_On_Submit() throws Throwable{
		review.VisibilityBackAndCancelButton();
	    confirmation=review.navigateToConfirmation();
    }
	
	@And("^Navigate to Confirmation Page \"([^\"]*)\"$")	 
    public void Navigate_to_Confirmation_Page(String expectedTxt) throws Throwable{
        confirmation.verifyConfirmationTxt(expectedTxt);
	}
}
