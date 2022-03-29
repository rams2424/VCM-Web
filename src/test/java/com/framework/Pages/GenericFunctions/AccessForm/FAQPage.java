package com.framework.Pages.GenericFunctions.AccessForm;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;

public class FAQPage {
	WebDriver driver;
	 Logger log = LoggerHelper.getLogger(FAQPage.class); 
	 WebDriverWait wait;
	public FAQPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath="//h1[contains(text(),'How can we help you ?')]")
	    WebElement FAQTitle;
	    public void verifyFAQPage(String expected) {
	        String url = "https://victory:L@unch123@qa.investor.vcm.com/tools-resources/faq";
	        driver.get(url);
	        Assert.assertTrue(driver.getCurrentUrl().contains("/tools-resources/faq"));
	    }
	 
	    @FindBy(xpath=" //a[@class='navbar-brand postlogin-logo']")
		WebElement VCMLogo;
		public void clickOnVictoryLogo() {
	        wait = new WebDriverWait(driver, 40);
	        wait.until(ExpectedConditions.elementToBeClickable(VCMLogo));
	        VCMLogo.click();
	   }
}

