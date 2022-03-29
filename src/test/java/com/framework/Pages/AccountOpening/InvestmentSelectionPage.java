package com.framework.Pages.AccountOpening;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.BasePage;

public class InvestmentSelectionPage extends BasePage {
	
	WebDriverWait wait;
	Logger log = LoggerHelper.getLogger(InvestmentSelectionPage.class);
	WebDriver driver;
	public InvestmentSelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    public void selectFundSource(String fundSource,String type,String accoutNo,String routingNo) {
    	log.info("Fund Source"+fundSource);
    	switch(fundSource) {
    	case "Add Bank Account":
    			this.addBankAccount(type,accoutNo,routingNo);
    		break;
    	case "Bank Account":
    			this.clickOnExistingBankAccount();
    		break;
    	case "Personal Check":
    			this.clickOnPersonalCheck();
    		break;
    	case "Wire Transfer":
    			this.clickOnWireTransfer();
    		break;
    	}
    }
    @FindBy(xpath="//div//div[text()='Wire Transfer']")
    WebElement wireTransfer;
    public void clickOnWireTransfer() {
        new WebDriverWait(driver, 40)
        .ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div[text()='Wire Transfer']")));
        driver.findElement(By.xpath("//div//div[text()='Wire Transfer']")).click();
    }

    public void clickOnPersonalCheck() {
        new WebDriverWait(driver, 40)
        .ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Personal Check')]")));
    	driver.findElement(By.xpath("//*[contains(text(),'Personal Check')]")).click();
    }
    @FindBy(xpath="//div[contains(@id,'add_bnk')]/../../following-sibling::div[1]//label//child::div//span[@id='mask-text']")
    WebElement clickOnexistingBankAccount;
    public void clickOnExistingBankAccount() {
    	clickOnexistingBankAccount.click();	
    }
    @FindBy(xpath="//*[contains(text(),'Add Bank Account')]")
    WebElement bankAccountBtn;
    
    @FindBy(xpath="//*[contains(text(),'Checking')]")
    WebElement checkingradioBtn;
    
    @FindBy(xpath="//label[@for='Savings']//span[contains(text(),'Savings')]")
    WebElement savingradioBtn;
    
    public void addBankAccount(String type,String accoutNo,String routingNo) {
    	wait = new WebDriverWait(driver, 40);
    	wait.until(ExpectedConditions.elementToBeClickable(bankAccountBtn));
    	bankAccountBtn.click();	
    	if(type.equalsIgnoreCase("Savings")) {
    		if(!savingradioBtn.isSelected()) {
    			savingradioBtn.click();
    		}
    	} else if(type.equalsIgnoreCase("Checking")) {
    		if(!checkingradioBtn.isSelected()) {
    			checkingradioBtn.click();
    		}
    	}
    	enterAccountNo(accoutNo);
    	enterRoutingNo(routingNo);
    	clickOnAddAccountBtn();
    }
    
    @FindBy(css="input[name='bankAccountNumber']")
    WebElement accountNo;
    
    public void enterAccountNo(String accNo) {
    	log.info("Account No"+accNo);
    	accountNo.sendKeys(accNo);
    }
    @FindBy(css="input[name='bankTransitRoutingNumber']")
    WebElement routingNo;
    
    public void enterRoutingNo(String routingno) {
    	log.info("Routing No"+routingno);
    	routingNo.sendKeys(routingno);
    }
    @FindBy(xpath="//span[contains(text(),'Add Bank Account')]")
    WebElement addBankAccountBtn;
    public void clickOnAddAccountBtn() {
    	wait = new WebDriverWait(driver, 40);
    	wait.until(ExpectedConditions.elementToBeClickable(addBankAccountBtn));
    	addBankAccountBtn.click();
    }
	@FindBy(xpath="//span[contains(text(),'3.  Investment Selection')]")
	WebElement fundSourceTxt;
	public void verifyFundSelectionPage() {
		Assert.assertTrue(fundSourceTxt.isDisplayed());
	}
	

	@FindBy(id="iracontribution")
 	WebElement iracontribution; 
	 public void selectIraContribution(){
		 this.clickOnelement(iracontribution);
		 WebElement select=driver.findElement(By.xpath("//span[text()='Current Year']"));
		 this.clickOnButton(select);
	 }
	 @FindBy(xpath="//div[@role='dialog']")
	 	WebElement dialogBox; 
	
	public void verifyPopup() {
		 if(this.isElementPresent(By.xpath("//div[@role='dialog']")) && DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@role='dialog']")).isDisplayed()) {
			 this.elementVisible(dialogBox);
	        }
	}
	@FindBy(xpath="//button[@buttontext='Proceed']")
 	WebElement proceedBtn; 
	
	public void clickOnProceed() {
		if(this.isElementPresent(By.xpath("//div[@role='dialog']")) && DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@role='dialog']")).isDisplayed()) {
			this.clickOnButton(proceedBtn);
	        }
		
	}
	
}
