package com.framework.StepDefinations.TransactionStepDefinations.Exchange;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ExchangeWithNewFundWithAllSharesScenario {

	Logger log = LoggerHelper.getLogger(ExchangeWithNewFundWithAllSharesScenario.class);
	@And("^click on All share Button$")
	public void click_on_all_share_button() throws Throwable {
	   
	}

	@And("^Select \"([^\"]*)\" Fund and click on it$")
	public void select_something_fund_and_click_on_it(String newfund) throws Throwable {
   
	}

	@And("^Navigate to review and confirm page$")
	public void navigate_to_review_and_confirm_page() throws Throwable {
   
	}

	@And("^submit exchange transaction$")
	public void submit_exchange_transaction() throws Throwable {
   
	}

	@Then("^verify exchange in with new fund shoul be successful\"([^\"]*)\"$")
	public void verify_exchange_in_with_new_fund_shoul_be_successfulsomething(String confirmationmsg) throws Throwable {
		
	}
	@And("^Select Account from view positions $")
	public void select_account_from_view_positions() throws Throwable {
	        
    }

    @And("^click on View Account Activity$")
    public void click_on_view_account_activity() throws Throwable {
     
    }

    @And("^Click on cancel button$")
    public void click_on_cancel_button() throws Throwable {
    
    }

    @And("^Transaction should be cancel$")
    public void transaction_should_be_cancel() throws Throwable {
    	
    }
}
