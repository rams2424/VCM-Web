package com.framework.Pages.AccountServices.BankAccounts;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class AddBankAccount extends BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(AddBankAccount.class);
    public AddBankAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h1[text()='Add Bank Account']")
	WebElement AddbankTitle;
	public void visibilityOfTitle() {
		this.elementVisible(AddbankTitle);
	}
	@FindBy(xpath="//label[@for='Savings']")
	WebElement savings;
	@FindBy(xpath="//label[@for='Checking']")
	WebElement checking;
	public void visibilityOfRadioBttns() {
		Assert.assertTrue(savings.isDisplayed());
		Assert.assertTrue(checking.isDisplayed());
	}
    @FindBy(id="transitRoutingNumber")
	WebElement transitRoutingNumber;	
    @FindBy(id="accountNumber")
 	WebElement accountNumber;	
			
	public void visibilityOfTextFields() {
		this.elementVisible(transitRoutingNumber);
		this.elementVisible(accountNumber);	
	}
    @FindBy(xpath="//small[text()='Please select a bank account type.']")
	WebElement accntTypeError;	
    @FindBy(id="transitRoutingNumberinputErrorText")
 	WebElement transitRoutingNumberinputErrorText;
    @FindBy(id="accountNumberinputErrorText")
 	WebElement accountNumberinputErrorText;
    
    public void visibilityOfErrorMsg() {
    	this.elementVisible(accntTypeError);
		this.elementVisible(accountNumberinputErrorText);
		this.elementVisible(transitRoutingNumberinputErrorText);	
	}
    @FindBy(id="nextButton")
    WebElement nextBtn;
    @FindBy(id="cancelButton")
    WebElement cancelButton;
    
	public void visibilityOfCancelAndNextBttn() {
		this.elementVisible(cancelButton);
		this.elementVisible(nextBtn);
	}

	public void enterTransitRoutingNumber(String string) {
		transitRoutingNumber.sendKeys(string);
		AddbankTitle.click();
	}
	public void enterAccountNumber(String string) {
		accountNumber.sendKeys(string);
		AddbankTitle.click();
	}

	public void verifyNextButtonisDisabled() {
		Assert.assertTrue(nextBtn.getAttribute("aria-disabled").equals("true"));
	}

	public void enterReqValues(String type, String transit, String accNum) {
		if(type.equals("Savings")){
			savings.click();
		}
		else if(type.equals("Checkings")){
			checking.click();
		}
		transitRoutingNumber.sendKeys(transit);
		accountNumber.sendKeys(accNum);
	}

	public void verifySavedDetails(String type, String transit, String accNum) {
		WebElement verifyBankDetails=driver.findElement(By.xpath("//h1[text()='Verify Bank Details']"));
		this.elementVisible(verifyBankDetails);
		
		WebElement Acctype=driver.findElement(By.xpath("//div[text()='Type of Account']/following-sibling::div"));
		Assert.assertTrue(Acctype.getText().equalsIgnoreCase(type));
		
		WebElement transitNum=driver.findElement(By.xpath("//div[text()='Transit Routing Number']/following-sibling::div"));
		Assert.assertTrue(transitNum.getText().equalsIgnoreCase(transit));
		
		WebElement acc=driver.findElement(By.xpath("//div[text()='Account Number']/following-sibling::div"));
		Assert.assertTrue(acc.getText().equalsIgnoreCase(accNum));
	}

}
