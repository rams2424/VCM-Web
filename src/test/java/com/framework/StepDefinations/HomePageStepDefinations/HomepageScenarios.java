package com.framework.StepDefinations.HomePageStepDefinations;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageScenarios {
    
    HomePage homepage = new HomePage(DriverFactory.getInstance().getDriver());
    Logger log = LoggerHelper.getLogger(HomepageScenarios.class);
    @And("^Verify total portfolio percentage as \"([^\"]*)\"$")
    public void verify_total_portfolio_percentage_as_something(String per) throws Throwable {
        homepage.verifyTotalPercentage(per);
    }

    @And("^Amount is dispaying in doller format$")
    public void amount_is_dispaying_in_doller_format() throws Throwable {
       homepage.verifyDollerAmount();
    }
    @Then("^Verify Victory capital logo$")
    public void verify_victory_capital_logo() throws Throwable {
        homepage.verifyVictoryLogo();
    }
    @And("^Verify Last Sign in Message  as\"([^\"]*)\"$")
    public void verify_last_sign_in_message_assomething(String msg) throws Throwable {
        homepage.verifyLastLoginMsg(msg);
    }
    @And("^Verify that feature section is displaying$")
    public void verify_that_feature_section_is_displaying() throws Throwable {
        homepage.verifyFeatureTxt();
    }

    @And("^Options are displaying as \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void options_are_displaying_as_somethingsomething_and_something(String mutualfund, String collegesavingplan, String securityretirement) throws Throwable {
        log.info("Mutual Funds"+mutualfund);
        log.info("Collage saving planes"+collegesavingplan);
        log.info("Security Retirement"+securityretirement);
        homepage.verifyMutualFund(mutualfund);
        homepage.verifyUSAASaving(collegesavingplan);
        homepage.verifySecurityRetirement(securityretirement);
    }
    
    @When("^Click on mutual fund link$")
    public void click_on_mutual_fund_link() throws Throwable {
        homepage.clickOnMutualFundLink();
    }

    @Then("^User should be navigate to mutual fund page$")
    public void user_should_be_navigate_to_mutual_fund_page() throws Throwable {
        homepage.verifyMutualFundPage();
    }
    @When("^Click on college saving plan link$")
    public void click_on_college_saving_plan_link() throws Throwable {
       homepage.clickOnUSAASavingLink();
    }

    @When("^click on planning for secure retirement$")
    public void click_on_planning_for_secure_retirement() throws Throwable {
       homepage.clickOnSecureRetirement();
    }

    @Then("^User should be navigate to Planning For Retirement Pre Login page $")
    public void user_should_be_navigate_to_planning_for_retirement_pre_login_page() throws Throwable {
        homepage.verifySecureRetirementPage();
    }
   

    @And("^options are displaying \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void options_are_displaying_somethingsomething_and_something(String portfolioplanner, String ourproducts, String yourgoals) throws Throwable {
       homepage.verifyportfolioPlanner(portfolioplanner);
       homepage.verifyLearnLink(ourproducts);
       homepage.verifyAchiveYourGoalsTab(yourgoals);
    }

    @Then("^User should be navigate to Marstone page$")
    public void user_should_be_navigate_to_marstone_page() throws Throwable {
       homepage.verifyMarstonePage();
    }

    @Then("^User should be navigate to Product page$")
    public void user_should_be_navigate_to_product_page() throws Throwable {
       homepage.verifyProductPage();
    }
    @When("^Click on Achieve You Goals$")
    public void click_on_achieve_you_goals() throws Throwable {
        homepage.clickonAchiveGoals();
    }

    @Then("^User should be navigate to investor learning page$")
    public void user_should_be_navigate_to_investor_learning_page() throws Throwable {
       homepage.verifyInvestorLeaningPage();
    }
    @Then("^User should be navigate to All About College Savings Pre Login page$")
    public void user_should_be_navigate_to_All_About_College_Savings_Pre_Login_page() throws Throwable {
        homepage.verifyUSAASavingPage();
    }

    @Then("^User should be navigate to Planning For Retirement Pre Login page$")
    public void user_should_be_navigate_to_Planning_For_Retirement_Pre_Login_page() throws Throwable {
       
    }

    @When("^Click on Portfolio Planner$")
    public void click_on_Portfolio_Planner() throws Throwable {
        homepage.clickOnPortfolioPlanner();
    }

    @When("^Click on  Learn more about our products$")
    public void click_on_Learn_more_about_our_products() throws Throwable {
        homepage.clickOnLearnAboutProduct();
    }
    @Then("^Verify tools and resource section is displaying$")
    public void verify_tools_and_resource_section_is_displaying() throws Throwable {
        homepage.verifyResourecAndToolsTxt();
    }
    @When("^I click on Account Services$")
    public void i_click_on_Account_Services() throws Throwable {
    	homepage.navigateToAccountServices();
    }

}
