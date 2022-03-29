package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.Purchase.PurchasePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCancelButton {

	HomePage home;
	PurchasePage purchase= new PurchasePage(DriverFactory.getInstance().getDriver());
@When("^Click On The Cancel button$")
public void click_On_The_Cancel_button() throws Throwable {
	purchase.clickOnCancelBtn();
}

@Then("^Verify Cancel Transaction popup is displayed$")
public void verify_Cancel_Transaction_popup_is_displayed() throws Throwable {
	purchase.checkVisibilityOfCancelPopup();
}

@When("^Click On Yes$")
public void click_On_Yes() throws Throwable {
	home=purchase.clickOnyes();
}

@Then("^Verify It is navigated to home page$")
public void verify_It_is_navigated_to_home_page() throws Throwable {
	home.verifyHomePageLink();
	
}

@When("^Click On No$")
public void click_On_No() throws Throwable {
	purchase.clickOnNo();
}

@Then("^Verify It is on the same Purchase page$")
public void verify_It_is_on_the_same_Purchase_page() throws Throwable {
	purchase.verifyReturn();
	
}
}
