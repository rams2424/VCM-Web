package com.framework.Pages.Transaction.Purchase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class FundingOption extends BasePage{
    Logger log = LoggerHelper.getLogger(FundingOption.class);
    WebDriver driver;
    public FundingOption(WebDriver driver) {
        log.info("Inside Funding Option Page");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;
    
    @FindBy(xpath="//span[contains(text(),'3.  Funding Source')]")
 	WebElement verifyPage; 
	public void verifyFundSource() {
		Assert.assertEquals(verifyPage.getText(), "3. Funding Source","Verified Fund Source Page");
		log.info("Verified Fund Source Page");	
	}
	 @FindBy(id="iracontribution")
	 	WebElement iracontribution; 
	 @FindBy(xpath="//div[@role='dialog']")
	 	WebElement dialogBox; 
	
	 public void verifyDialogbox(){
		 this.elementVisible(dialogBox);
	 }
	 @FindBy(id="confirmation-modal-primary-btn")
	 	WebElement proceedBtn; 
	 
	 public void clickOnProceed(){
		 try{
		 proceedBtn.click();
		 }
		 catch(Exception e)
		 {
			 log.info("Handled pop up exception");
		 }
	 }
	 public void selectIraContribution(String ira){
		 this.verifyPageIsLoaded();
		 this.clickOnelement(iracontribution);
		 WebElement select=driver.findElement(By.xpath("//span[text()='"+ira+"']"));
		 this.clickOnButton(select);
	 }
	
	public void selectFundSource(String fundSource,String accNo) throws InterruptedException {
		log.info("Fund source"+fundSource);
		switch(fundSource) {
		case "Check":
			this.clickOnCheckOption();
			break;
		case "Wire Transfer":
			this.clickOnWireTransferOption();
			break;
		case "bank Account":
			this.clickOnExistingBank(accNo);
			break;
		case "Add Bank Account":
			this.clickOnBankButton();
			break;
		}
	}
	@FindBy(xpath="//*[contains(text(),'Check')]")
	WebElement check;
	private void clickOnCheckOption() throws InterruptedException {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(check));
		 this.verifyPageIsLoaded();
		this.clickOnelement(check);
	}
	@FindBy(xpath="//*[contains(text(),'Wire Transfer')]")
	WebElement wireTransferOption;
	private void clickOnWireTransferOption() throws InterruptedException {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(wireTransferOption));
		 this.verifyPageIsLoaded();
		this.clickOnelement(wireTransferOption);
	}
	
	public void clickOnExistingBank(String accNo) {
		log.info("Account No"+accNo);
		wait = new WebDriverWait(driver, 40);
		WebElement existingBankAccount = driver.findElement(By.xpath("//div[contains(text(),'"+accNo+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(existingBankAccount));
		existingBankAccount.click();
	}
	@FindBy(xpath="//div[@data-test='reinvest-component']")
	WebElement dividentAndCapitalGainsSection;
	public void verifyDividentAndCapitalGains() {
		Assert.assertTrue(dividentAndCapitalGainsSection.isDisplayed());
		this.elementVisible(dividentAndCapitalGainsSection);
	}
	
	@FindBy(xpath="//span[@for='no-reinvest']")
	WebElement noRadio;
	@FindBy(xpath="//span[@for='yes-reinvest']")
	WebElement yesRadio;

	public void verifyDividentAndCapitalGainsRadioButtons() {
		Assert.assertTrue(yesRadio.isDisplayed(),"Savings is displayed");
		log.info("yesRadio is displayed");
		Assert.assertTrue(noRadio.isDisplayed(),"Checking is displayed");
		log.info("noRadio is displayed");
	}

	public void verifyDefaultRadioButton() {
		WebElement yesR=driver.findElement(By.id("yes-reinvest"));
		Assert.assertTrue(yesR.isSelected(),"Verified default Radio button->"+yesR+" is checked");
	}

	public void verifyNonClickableRadioButton(String fundSource) {
		WebElement noR=driver.findElement(By.id("no-reinvest"));
		if(fundSource.equalsIgnoreCase("Check") || fundSource.equalsIgnoreCase("Wire Transfer")){
		Assert.assertFalse(noR.isEnabled(),"Verified-> "+noR+" is disabled");
		}
		else
			Assert.assertTrue(noR.isEnabled(),"Verified-> "+noR+" is enabled");
	}

	@FindBy(xpath="//label[@for='Savings']")
	WebElement savingsRadio;
	@FindBy(xpath="//label[@for='Checking']")
	WebElement checkingRadio;
	
	@FindBy(id="bankAccountNumber")
	WebElement bankAccountNumber;
	
	@FindBy(id="bankAccountNumberinputErrorText")
	WebElement bankAccountNumberinputErrorText;
	
	@FindBy(id="bankTransitRoutingNumber")
	WebElement bankTransitRoutingNumber;
			
	@FindBy(id="bankTransitRoutingNumberinputErrorText")
	WebElement bankTransitRoutingNumberinputErrorText;

	@FindBy(xpath="//label[@for='bankAccountNumber']")
	WebElement labelAccNo;
	
		
	@FindBy(id="add-bank-account")
	WebElement addBankBtn;
	public void verifyAddBankRadios() {
		Assert.assertTrue(savingsRadio.isDisplayed(),"Savings is displayed");
		log.info("Savings is displayed");
		Assert.assertTrue(checkingRadio.isDisplayed(),"Checking is displayed");
		log.info("Checking is displayed");
	}

	public void verifyDefaultAddBankRadioButton() {
		WebElement savings=driver.findElement(By.id("Savings"));
		Assert.assertTrue(savings.isSelected(),"Default Savings radio button is checked");
	}

	public void checkAddBankButton(String status) {
		verifyPageIsLoaded();
		if(status.equalsIgnoreCase("enable")){
			wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(addBankButton));
			Assert.assertTrue(addBankBtn.isEnabled(),"Add Bank Account Button is enabled");		
		}
		else{
			Assert.assertFalse(addBankBtn.isEnabled(),"Add Bank Account is disabled");
		}
	}

	public void verifyErrorMsgBlankAccntNum() {
		this.clickOnButton(labelAccNo);
		this.enterAccountNum("");
		this.clickOnButton(labelAccNo);
		this.elementVisible(bankAccountNumberinputErrorText);
	}
	public void verifyErrorMsgBlankRouterNum() {
		this.enterRouterNum("");
		this.clickOnButton(labelAccNo);
		this.elementVisible(bankTransitRoutingNumberinputErrorText);
	}



	public void verifyErrorMsgMinAccntNum() {
		this.enterAccountNum("1");
		this.clickOnButton(labelAccNo);
		this.elementVisible(bankAccountNumberinputErrorText);}

	public void verifyErrorMsgMinRouterNum() {
		this.enterRouterNum("1");
		this.clickOnButton(labelAccNo);
		this.elementVisible(bankTransitRoutingNumberinputErrorText);
	}

	public void enterAccountNum(String accNumber) {
		this.clearAndSendKeys(bankAccountNumber, accNumber);
		this.clickOnButton(labelAccNo);
	}


	public void enterRouterNum(String routerNumber) {
		this.clearAndSendKeys(bankTransitRoutingNumber, routerNumber);	
		this.clickOnButton(labelAccNo);
		
	}

	public void clickOnAddBankAccount() {
		this.clickOnelement(addBankBtn);
	}
	@FindBy(xpath="//*[text()='Add Bank']")
	WebElement addBankButton;
	
	public void clickOnBankButton() throws InterruptedException {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(addBankButton));
		this.clickOnelement(addBankButton);
		verifyPageIsLoaded();
	}
	public void seelectRadio(String radio) {
		WebElement radioBttn=driver.findElement(By.xpath("//label[@for='"+radio+"']"));
		this.clickOnButton(radioBttn);
	}

}
