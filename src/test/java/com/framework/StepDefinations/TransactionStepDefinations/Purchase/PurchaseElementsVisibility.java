package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.Purchase.PurchasePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseElementsVisibility {

		HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
	    PurchasePage purchase;
	    Logger log = LoggerHelper.getLogger(PurchaseElementsVisibility.class);

	    @When("^User Click On Buy button From Place An Order$")
	    public void user_Click_On_Buy_button_From_Place_An_Order() throws Throwable {
	    	purchase=homePage.navigateToPurchasePage();
	    }

	    @Then("^Verify That it is navigated to Buy Page$")
	    public void verify_That_it_is_navigated_to_Buy_Page() throws Throwable {
	    	purchase.ClosePopup();
	    	purchase.verifyPurchasePage();
	    }

	    @Then("^verify Cancel and next button are visible$")
	    public void verify_Cancel_and_next_button_are_visible() throws Throwable {
	    	purchase.checkVisibilityOfCancelButton();
	    	purchase.checkVisibilityOfNextButton();
	    }

	    @Then("^verify Next button is disabled$")
	    public void verify_Next_button_is_disabled() throws Throwable {
	    	purchase.CheckNextButton("disable");
	    	
	    }
}
