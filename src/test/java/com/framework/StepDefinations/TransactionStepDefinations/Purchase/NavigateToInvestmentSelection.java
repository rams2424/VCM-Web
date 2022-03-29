package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.FundSelectionPage;
import com.framework.Pages.Transaction.Purchase.PurchasePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateToInvestmentSelection {
    PurchasePage purchase=new PurchasePage(DriverFactory.getInstance().getDriver());
    FundSelectionPage fundselection;
    
    
    @When("^Click on the Account Number \"([^\"]*)\"$")
    public void click_on_the_Account_Number(String arg1) throws Throwable {
        purchase.clickOnAccountType(arg1);
    }
    
    @Then("^verify Next button is enabled$")
    public void verify_Next_button_is_enabled() throws Throwable {
        purchase.CheckNextButton("enable");
        
    }
    
    @When("^click on Next button$")
    public void click_on_Next_button() throws Throwable {
        purchase.clickOnNextBtn();
    }
    
    @Then("^Verify it navigates to Investment Selection$")
    public void verify_it_navigates_to_Investment_Selection() throws Throwable {
        fundselection=purchase.navigateToFundsSelectionPage();
        fundselection.verifyFundSelection();
    }
    
}
