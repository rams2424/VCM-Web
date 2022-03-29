package com.framework.Pages.AccountServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;
import com.framework.Pages.AccountServices.BankAccounts.BankAccount;

public class AccountServicesPage extends BasePage{
	   
    static WebDriver driver;
    WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(AccountServicesPage.class);
    public AccountServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="BankAccounts")
	WebElement bankAccnts;
	 public BankAccount  navigateToBankAccount() {
	     wait =new WebDriverWait(driver, 40);
	        wait.until(ExpectedConditions.elementToBeClickable(bankAccnts));
	        this.clickOnButtonUsingJs(bankAccnts);
	        return new BankAccount(driver);
	    }
	 
	    @FindBy(id="RequiredMinimumDistribution")
		WebElement rmd;
		 public BankAccount  navigateToRMD() {
		     wait =new WebDriverWait(driver, 40);
		        wait.until(ExpectedConditions.elementToBeClickable(rmd));
		        this.clickOnButtonUsingJs(rmd);
		        return new BankAccount(driver);
		    }
}
