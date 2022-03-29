package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.Purchase.PurchasePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyNavigations {

	HomePage home;
	PurchasePage purchase= new PurchasePage(DriverFactory.getInstance().getDriver());

@When("^Click on the Portfolio from Buy Page$")
public void click_on_the_Portfolio_from_Buy_Page() throws Throwable {
	home=purchase.navigateToHomePage();
}
@Then("^Verify it is on the portfolio dashboard page$")
public void verify_it_is_on_the_portfolio_dashboard_page() throws Throwable {
	home.verifyHomePageLink();
	
}
}
