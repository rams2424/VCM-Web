package com.framework.StepDefinations.AccountServices;

import com.framework.Hook.DriverFactory;
import com.framework.Hook.Hooks;
import com.framework.Pages.AccountServices.AccountServicesPage;
import com.framework.Pages.AccountServices.RMD.RMDPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RMD {

	AccountServicesPage accServices=new AccountServicesPage(DriverFactory.getInstance().getDriver());
	RMDPage rmd=new RMDPage(DriverFactory.getInstance().getDriver());
	@When("^I click on RMD$")
	public void i_click_on_RMD() throws Throwable {
		accServices.navigateToRMD();
	}

	@Then("^I should see page title, RMD distribution rules, card listing section$")
	public void i_should_see_page_title_RMD_distribution_rules_card_listing_section() throws Throwable {
		rmd.visibilityOfTitleRulesCard();
	}

	@Then("^I should see retirement article section with read article button$")
	public void i_should_see_retirement_article_section_with_read_article_button() throws Throwable {
		rmd.visibilityOfRetirementArticleSectionandReadArticleButtn();
	}

	@Then("^I should see RMD Calculators section with current year and future buttons$")
	public void i_should_see_RMD_Calculators_section_with_current_year_and_future_buttons() throws Throwable {
		rmd.visibilityOfRMDCalcAndCurrentAndFutureBttn();
	}

	@Then("^I should see all retirement button$")
	public void i_should_see_all_retirement_button() throws Throwable {
		rmd.visibilityOfRetirementBttn();
	}

	@Then("^I should see the back button and disclaimer footer in RMD page$")
	public void i_should_see_the_back_button_and_disclaimer_footer_in_RMD_page() throws Throwable {
		rmd.visibilityOfBackButtonAndFooter();
	}

	@Then("^I should see page title, RMD distribution rules$")
	public void i_should_see_page_title_RMD_distribution_rules() throws Throwable {
		rmd.visibilityOfDistributionRules();
	}

	@Then("^I should not see card listing section$")
	public void i_should_not_see_card_listing_section() throws Throwable {
		rmd.NonvisibilityOfCardListing();
	}


}
