package com.framework.StepDefinations.TransactionStepDefinations.Liquidation;
import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.TransactionPage;
import com.framework.Pages.Transaction.Liquidation.SellPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class liquidationVisibilityStepDefination  {
	
    HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
	SellPage sellpage=new SellPage(DriverFactory.getInstance().getDriver());
	Logger log =LoggerHelper.getLogger(liquidationVisibilityStepDefination.class);
	TransactionPage transactions;
	
	@When("^Click On SellPage button$")
    public void Click_On_SellPage_button() throws Throwable {
		sellpage=homePage.navigateToSellPage();
	}
	
	@Then("^Verify SellPage$")
	public void verify_SellPage()  throws Throwable {
		sellpage.verifySellPage();
	}
	
	@Then("^verify Cancel and next button are visible or not$")
	public void verify_Cancel_and_next_button_are_visible_or_not() throws Throwable {
	    sellpage.checkVisibilityOfCancelButton();
		sellpage.checkVisibilityOfNextButton();
		
    }
    @And("^verify Next button is disabled or not$")
    public void verify_next_button_is_disabled_or_not() throws Throwable {
		sellpage.CheckNextButton();
		 
	}
	@When("^Click On the cancel button$")
    public void click_on_the_cancel_button() throws Throwable {
		sellpage.ClosePopup();
		sellpage.clickOnCancelBtn();
	}

	@Then("^Verify Cancel Transaction popup is displayed or not$")
	public void verify_Cancel_Transaction_popup_is_displayed_or_not() throws Throwable {
		sellpage.checkVisibilityOfCancelPopup();
	}

    @When("^Click On Yes Button$")
	public void click_on_yes_button() throws Throwable {
	 	homePage=sellpage.clickOnyes();
	}

	@Then("^Verify user should be  navigated to home page$")
	public void verify_user_should_be_navigated_to_home_page() throws Throwable {
	 	homePage.verifyHomePageLink();
        
	}
	 
	@When("^Click On No Button$")
	public void click_on_no_button() throws Throwable {
	    sellpage.clickOnNo();
	}

	@Then("^Verify It is on the same Sell page$")
	public void verify_It_is_on_the_same_Sell_page() throws Throwable {
	 	sellpage.verifyReturn();
	 	
	}
	
	@When("^Click on the Transactions from Sell Page$")
	public void click_on_the_Transactions_from_Buy_Page() throws Throwable {
	 	transactions=sellpage.navigateToTransactionPage();
	}

	@Then("^Verify User should be navigate to  transaction dashboard page$")
	public void verify_user_should_be_navigate_to_transaction_dashboard_page() throws Throwable {
	    transactions.verifyTransactionPage();
	 	
	}

	@When("^Click on the Portfolio from Sell Page$")
	public void click_on_the_Portfolio_from_Buy_Page() throws Throwable {
		homePage=sellpage.navigateToHomePage();
	}
	
	@Then("^Verify User should be navigate to portfolio dashboard page$")
	public void verify_user_should_be_navigate_to_portfolio_dashboard_page() throws Throwable {
	    homePage.verifyHomePageLink();
	 	
	}
	 
	@When("^Click On One Account ?(\\d+)?$")
	public void click_On_One_Account(int accountType) throws Throwable {
		sellpage.ClosePopup();
	    log.info("Account Type"+accountType);
	    sellpage.SelectAccount(accountType);
    }
	 
	@Then("^verify Next button is enabled or not$")
	public void verify_Next_button_is_enabled_or_not() throws Throwable {
        sellpage.CheckNextButton();
			 
	}
}
