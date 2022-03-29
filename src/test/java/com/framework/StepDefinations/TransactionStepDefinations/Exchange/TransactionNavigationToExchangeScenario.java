package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Exchange.ExchangePage;

import io.cucumber.java.en.Then;



public class TransactionNavigationToExchangeScenario {

    Logger log = LoggerHelper.getLogger(TransactionNavigationToExchangeScenario.class);
    ExchangePage exchangePage = new ExchangePage(DriverFactory.getInstance().getDriver());

    @Then("^User Should be navigate to Exchange Page$")
    public void user_should_be_navigate_to_exchange_page() throws Throwable {
    	exchangePage.verifyExchangePage();   	
    }
    
}
