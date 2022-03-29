package com.framework.StepDefinations.TransactionStepDefinations.Liquidation;
import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.Liquidation.FundSelectionPage;
import com.framework.Pages.Transaction.Liquidation.FundingOptionPage;
import com.framework.Pages.Transaction.Liquidation.SellPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FundSelectionStepDefination {
	
	Logger log = LoggerHelper.getLogger(FundSelectionStepDefination.class);
	HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
	SellPage sellpage= new SellPage(DriverFactory.getInstance().getDriver());
	FundSelectionPage fundselection;
	FundingOptionPage fundingoption;
	
	@Then("^Click On Back To SellPage$")
	public void click_On_Back_To_SellPage() throws Throwable {
		fundselection.ClickBack();
		sellpage.verifySellPage();
		
	}
	
	@When("^Verify FundSelection Page$")
	public void Verify_FundSelection_Page() throws Throwable{
		fundselection.verifyFundSelection();
		fundselection.checkVisibilityOfbackBtn();
	}
	@Then("^Click On Fund \"([^\"]*)\"$")
	public void click_On_Fund(String fundName) throws Throwable {
		log.info("Fund Name"+fundName);
		fundselection.FundSelect(fundName);
	}
	 
	@And("^Click On AllShares \"([^\"]*)\"$")
	public void Click_On_AllShares(String arg1) throws Throwable{
		log.info("Fund Name"+arg1);
		fundselection.clickOnAllShares(arg1);
	}
	@When("^Click On Next For Deposite Account$")
	public void Click_On_Next_For_Deposite_Account() throws Throwable{
		fundselection.ClickOnNext();			 
	}
	@Then("^Click On Dollar \"([^\"]*)\"$")
	public void click_On_Dollar(String arg1) throws Throwable {
		fundselection.EnterDollarAmount(arg1);
	}
	
	@Then("^Check Suggestions$")
	public void check_Suggestions() throws Throwable {
		fundselection.SuggestAllShares();
		
	}
	@Then("^Check Maximum Amount$")
	public void check_Maximum_Amount() throws Throwable {
		fundselection.checkmaxAmt();
		
	} 
	@Then("^Click On Next$")
	public void click_on_next() throws Throwable {
		fundselection = sellpage.navigatetoFundSelection();
	}

	@Then("^Verify message \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_message_something_for_something(String errormessage, String fundName) throws Throwable {log.info("Fund Selection Error Message"+errormessage);
        log.info("Fund Name"+fundName);
       // WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+fundName+"')]/../div[3]//div[4]//div"));
       // log.info("Actual Text"+element.getText());
       // Assert.assertTrue(element.getText().contains(errormessage));
       
    }
}
