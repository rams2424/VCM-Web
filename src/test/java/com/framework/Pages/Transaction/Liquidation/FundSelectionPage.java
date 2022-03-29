package com.framework.Pages.Transaction.Liquidation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.Hooks;
import com.framework.Pages.BasePage;

public class FundSelectionPage extends BasePage {
	WebDriverWait wait;
	Logger log = LoggerHelper.getLogger(FundSelectionPage.class);
	WebDriver driver;
	private Hooks hook;
	public FundSelectionPage( WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	    
	@FindBy(xpath="//*[@class='stepperDiv activepage']")
	WebElement FundSelectionPage;
	public void verifyFundSelection() {
		wait = new WebDriverWait(driver, 40);
		this.elementVisible(FundSelectionPage);
		Assert.assertTrue(FundSelectionPage.isDisplayed());
	}
	public void FundSelect(String FundName){
		log.info("Fund Name"+FundName);
		WebElement PFundName = driver.findElement(By.xpath("//*[text()='"+FundName+"']"));
    	this.clickOnButton(PFundName);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public FundingOptionPage navigatetoFundingOption(){
		this.ClickOnNext();
		return new FundingOptionPage(driver);			
	}
   
    @FindBy(xpath="//div[text()='USAA Cornerstone Moderate Fund']/parent::div//div[3]//div[@class='wradio']//input[@name='liquidationAmt' and @value='All Shares']/..") 
    WebElement SelectingAllShares;
    public void SelectAllShares(){
    	SelectingAllShares.click();
    }

    public void clickOnAllShares(String fundName) {
    	log.info("Fund Name"+fundName);
    	WebElement allshareRadio = driver.findElement(By.xpath("//div[contains(text(),'"+fundName+"')]/../div[3]//div[2]//input[@id='allshare0']/."));
    	this.clickOnButtonUsingJs(allshareRadio);
    	
    }
    public void enterDollerAmt(String amount,String fundName) {
    	WebElement element =  driver.findElement(By.xpath("//div[contains(text(),'"+fundName+"')]/../div[3]//div[@role='radiogroup']//input[@name='liquidationAmt' and@value='$ ']/../../../following-sibling::div/input"));
    	log.info("Amount"+amount);
    	log.info("Fund Name"+fundName);
        element.sendKeys(amount);
    }
 
    @FindBy(xpath="//*[text()='Back']")
    WebElement backBtn;

    public void checkVisibilityOfbackBtn() {
    	wait = new WebDriverWait(driver, 40);
    	this.scrollIntoView(backBtn);
    	this.elementVisible(backBtn);
    }
    @FindBy(xpath="//*[text()='Load More']")
    WebElement LoadMore;

    public void checkVisibilityOfLoadmore() {
    	wait = new WebDriverWait(driver, 40);
    	this.scrollIntoView(LoadMore);
    	this.elementVisible(LoadMore);
    }
    @FindBy(xpath="//*[text()='Next']")
    WebElement Next;
    public void ClickOnNext(){
    	this.scrollIntoViewAndClick(Next);
    }
	 
	@FindBy(xpath="//*[text()='Back']")
	WebElement Back;
	public SellPage ClickBack(){
		this.clickOnButtonUsingJs(Back);
		return new SellPage(driver);	 
	}
	@FindBy(xpath="//div[contains(text(),'52 week Min./ Max. Values')]/../span//div")
	WebElement weekstxt;
	public void verify52WeeksTxt(String expected){
        log.info("Expected"+expected);
        log.info("Actual"+weekstxt.getText());
        Assert.assertTrue(weekstxt.getText().contains(expected));
	}
	
	 @FindBy(xpath="//LABEL[@for='dollaramt0']/../../../..//INPUT[@type='text']")
	 WebElement inputTxt;
	 @FindBy(xpath="//input[@id='dollaramt0']")
	 WebElement Dollar;
	 public void EnterDollarAmount(String Amount) throws InterruptedException{	 
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()", Dollar);
		 inputTxt.click();
		 inputTxt.sendKeys(Amount); 
	     inputTxt.sendKeys(Keys.TAB);	
	     this.verifyPageIsLoaded();
	 }
	 @FindBy(xpath="//div[text()='Please enter a valid amount']")
	 WebElement MinAmount;
	 public void checkminAmt(){
		 wait = new WebDriverWait(driver,30);
	     wait.until(ExpectedConditions.visibilityOf(MinAmount)); 
		 this.elementVisible(MinAmount);
	 }
	 
	 @FindBy(xpath="//div[text()='Please enter amount less than or equal to available balance']")
	 WebElement MaxAmount;
	 
	 public void checkmaxAmt(){
	     wait = new WebDriverWait(driver,30);
	     wait.until(ExpectedConditions.visibilityOf(MaxAmount));
	     this.elementVisible(MaxAmount);
	}
	 
	@FindBy(xpath="//div[text()='Due to market fluctuations, this order may fail during processing. We suggest you sell \"All Shares\"']")
	WebElement SuggestAllShares;
	
	public void SuggestAllShares(){
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(SuggestAllShares));
	    this.elementVisible(SuggestAllShares);
	}
	 
}
