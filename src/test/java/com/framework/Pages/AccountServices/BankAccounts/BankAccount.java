package com.framework.Pages.AccountServices.BankAccounts;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.BasePage;

public class BankAccount extends BasePage {
	   
    WebDriver driver;
    WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(BankAccount.class);
    public BankAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h1[text()='Bank Accounts']")
	WebElement bankAccnts;
	public void visibilityOfTitle() {
		this.elementVisible(bankAccnts);
	}
    @FindBy(xpath="//img[@alt='add icon']")
	WebElement addBank;
	public void visibilityOfAddButton() {
		this.elementVisible(addBank);
	}
	@FindBy(id="postLoginFooter")
	WebElement footer;	
	public void visibilityOfBackButtonAndFooter() {
		verifyBackButtonIsDisplayed();
		this.elementVisible(footer);
	}
	public void clickOnAddButton() {
		wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.elementToBeClickable(addBank));
		this.clickOnButtonUsingJs(addBank);
		this.verifyPageIsLoaded();
	}
    
}
