package com.framework.Pages.Transaction;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;
import com.framework.Pages.Transaction.Exchange.InvestmentSelectionPage;


public class FundSelectionPage extends BasePage{

    Logger log = LoggerHelper.getLogger(FundSelectionPage.class);
    WebDriver driver;
    public FundSelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;
	@FindBy(xpath="//div[@pagename='Investment Selection']")
	WebElement verifyInvestmentSelection;
	
	public void verifyFundSelection() {
		wait = new WebDriverWait(driver, 40);
		this.elementVisible(verifyInvestmentSelection);
	}

    
    @FindBy(xpath="//button[@buttontext='Back']")
	WebElement backBtn;
	
    public void checkVisibilityOfbackBtn() {
    	wait = new WebDriverWait(driver, 40);
        this.scrollIntoView(backBtn);
        this.elementVisible(backBtn);
    }
    
    public void clickOnbackBtn(){
    	this.scrollIntoViewAndClick(backBtn);
    }
 
  	
    
    @FindBy(id="47")
	WebElement ExistingFund;
	
	public void clickOnExistingFund() {
		this.clickOnButton(ExistingFund);
		log.info("Clicked on Existing Fund");
	}

    
    @FindBy(id="fundingOption")
	WebElement fundingOption;
	public void verifyDropdown(String arg1, String arg2) {
		this.elementVisible(fundingOption);
		this.clickOnButton(fundingOption);
		List<WebElement> dropdownValues=driver.findElements(By.xpath("//span[@role='option']"));
		if(dropdownValues.get(0).getText().equalsIgnoreCase(arg1) && dropdownValues.get(1).getText().equalsIgnoreCase(arg2)){
			Assert.assertTrue(true, "Dropdown Verified");
			log.info("Verified Dropdowns");
		}
		else{
			Assert.assertTrue(false, "Dropdown Verified");
			log.error("Verification of dropdown failed");
		}
		 this.clickOnButton(VerifyRemoveBttn);
	}

	public void selectFromDropdown(String arg1) {
		this.clickOnButton(fundingOption);
		WebElement dropdownValues=driver.findElement(By.xpath("//span[text()='"+arg1+"']"));
		this.clickOnButton(dropdownValues);
	}
	@FindBy(id="#initialInvest")
	WebElement initialInvest;
		
	
	@FindBy(xpath="//span[@class='maxValplaceholder']")
	WebElement maxValplaceholder;
	
	@FindBy(id="#initialInvestinputErrorText")
	WebElement initialInvestinputErrorText;
		

	public void verifyMinAmountErrorMessage() {
		 this.elementVisible(maxValplaceholder);
		 initialInvest.sendKeys("10");
		 this.clickOnButton(VerifyRemoveBttn);
		 this.elementVisible(initialInvestinputErrorText);
	}
	
	@FindBy(id="#monthlyInvest")
	WebElement monthlyInvest;
		
	@FindBy(id="#monthlyInvestinputErrorText")
	WebElement monthlyInvestinputErrorText;
		
	public void verifyMinAmountMonthlyErrorMessage() {
		monthlyInvest.sendKeys("10");
		this.clickOnButton(VerifyRemoveBttn);
		this.elementVisible(monthlyInvestinputErrorText);
	}

	@FindBy(xpath="//button[@data-test='remove-fund']")
	WebElement removeBttn;
	
	@FindBy(xpath="//td[@class='fundUrInvCol1']")
	WebElement VerifyRemoveBttn;

	public void verifyRemoveBtnClick() {
		try{
			if(VerifyRemoveBttn.isDisplayed()){
				Assert.assertTrue(false,"Remove Button Verification failed");
				log.error("Remove Button Verification failed");
			}
		}
		catch(Exception e){
			Assert.assertTrue(true,"Verified remove button");
			log.info("Verified remove button");
		}
	}

	public void clickOnRemoveBtn() {
		this.clickOnButton(removeBttn);
	}
	@FindBy(id="startDate")
	WebElement startDate;
	
	@FindBy(xpath="//div[@tabindex='-1']/button[2]")
		WebElement prevDateBttn;

	@FindBy(xpath="//button[text()='Ok']")
	WebElement okBttn;

	 @FindBy(id="startDate-error")
		WebElement startDateerror;
	
	public void setPastDate(){
		this.clickOnButton(startDate);
		this.clickOnButton(prevDateBttn);
		this.clickOnButton(okBttn);		
	}
	public void verifyPastDateError(){	
		this.elementVisible(startDateerror);	
	}

	public void enterInitialValue(String arg1) {
		this.clearAndSendKeys(initialInvest, arg1);
	}
	public void enterMonthlyValue(String arg1) {
		this.clearAndSendKeys(monthlyInvest, arg1);
	}

	public void verifyTotalfield(String arg1, String arg2) {
		this.elementVisible(driver.findElement(By.xpath("//div[@class='dollar1' and contains(text(),'"+arg1+".00')]")));
		this.elementVisible(driver.findElement(By.xpath("//div[@class='dollar1' and contains(text(),'"+arg2+".00')]")));
	}

	@FindBy(id="88")
	WebElement nonExistingFund;

	@FindBy(xpath="//img[@alt='Load More']")
	WebElement viewMore;
		
	public void checkVisibilityOfViewmore() {
	    this.scrollIntoView(viewMore);
	    this.elementVisible(viewMore);
	}
	    
	public void clickOnViewMore(){
		this.scrollIntoViewAndClick(viewMore);
	}
	public void clickOnNonExistingFund() {
		this.clickOnViewMore();
		this.clickOnButton(nonExistingFund);
		log.info("Selected non existing funds");
	}

	public void checkMonthlyAndStarDate() {
		this.elementVisible(startDate);
		this.elementVisible(monthlyInvest);
	}
	

	@FindBy(xpath="//span[contains(text(),'Fund Selections')][2]")
	WebElement fundSelectionPage;
	public void verifyFundSelectionPage() {
		this.ElementEnable(fundSelectionPage);	
	}

    public void clickOnEnterAmountRadioBtn(String fundName) throws InterruptedException {
        log.info("Fund Name"+fundName);
        WebElement dollerAmtCheckbox = driver.findElement(By.xpath("//*[contains(text(),'"+fundName+"')]/../div/../../../div[3]/div[2]/div/div[2]/div[1]/div//span/label"));
        this.selectCheckBox(dollerAmtCheckbox);
        
    }
    
    public void clickOnAllShares(String fundName) {
        log.info("Fund Name"+fundName);
        WebElement allshareRadio = driver.findElement(By.xpath("//*[contains(text(),'"+fundName+"')]/../div/../../../div[3]/div[2]/div/div[1]/div/div/span/label"));
        this.selectCheckBox(allshareRadio);
    }
    public void enterDollerAmt(String amount,String fundName) throws InterruptedException {
        WebElement element =  driver.findElement(By.xpath("//*[contains(text(),'"+fundName+"')]/../div/../../../div[3]/div[2]/div/div[2]/div[2]/input"));
        log.info("Amount"+amount);
        log.info("Fund Name"+fundName);
        element.clear();
        element.sendKeys(amount);
        element.sendKeys(Keys.TAB);
    }
    
    public void selectFund(String fundName) {
    	log.info("Fund Name"+fundName);
    	wait = new WebDriverWait(driver, 40);
		WebElement element = driver.findElement(By.xpath("//*[@aria-describedby='"+fundName+"']"));
		this.scrollIntoViewAndClick(element);
	}
    public InvestmentSelectionPage navigateToInvestMentSelPage() {
    	return new InvestmentSelectionPage(driver);
    }

	public void setValidDate() {
		this.clickOnButton(startDate);
		this.clickOnButton(okBttn);	
	}
   
}
