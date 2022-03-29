package com.framework.StepDefinations.TransactionStepDefinations.Purchase;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.Transaction.Purchase.Review;

import io.cucumber.java.en.Then;

public class ReviewPageStepDefinations {
	
	Review review = new Review(DriverFactory.getInstance().getDriver());
	
	@Then("^It should be on Review & confirm Page$")
	public void it_should_be_on_Review_confirm_Page() throws Throwable {
		review.verifyReviewPage();
	}

	@Then("^Verify Trade type is \"([^\"]*)\"$")
	public void verify_Trade_type_is(String TradeType) throws Throwable {
		review.verifyTradeType(TradeType);
	}

	@Then("^Verify \"([^\"]*)\" amount is \"([^\"]*)\"$")
	public void verify_amount_is(String investment,String initialValue) throws Throwable {
		review.verifyInitialInvestment(investment,initialValue);
	}

	@Then("^Verify funding Source is \"([^\"]*)\"$")
	public void verify_funding_Source_is(String fundSource) throws Throwable {
		review.verifyFundingSource(fundSource);
	}
	@Then("^Verify Total Investment is \"([^\"]*)\"$")
	public void verify_Total_Investment_is(String Total) throws Throwable {
		review.verifyTotalInvestment(Total);
	}
	@Then("^Verify Total Investment for monthly is sum of \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_total_investment_for_monthly_is_sum_of(String initial,String monthly) throws Throwable {
		int Total=Integer.parseInt(initial)+Integer.parseInt(monthly);
		String pass=""+Total;
		review.verifyTotalInvestment(pass);
	}

	@Then("^Verify IRA contribution is \"([^\"]*)\"$")
	public void verify_IRA_contribution_is(String ira) throws Throwable {
		review.verifyIra(ira);
	
	}

	
}
