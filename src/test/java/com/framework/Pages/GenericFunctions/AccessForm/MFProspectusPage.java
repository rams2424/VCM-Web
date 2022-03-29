package com.framework.Pages.GenericFunctions.AccessForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Pages.BasePage;

public class MFProspectusPage extends BasePage  {
	WebDriverWait wait;
	
	WebDriver driver;
	public MFProspectusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Fund Literature')]")
	WebElement FundLiteratureTxt;
	public void verifyMFProspectusPage() {
		//this.elementVisible(FundLiteratureTxt); 
		 Assert.assertTrue(driver.getCurrentUrl().contains("mutual-fund-prospectuses"));
	}
	
	@FindBy(xpath="//a[@class='navbar-brand postlogin-logo']") 
	WebElement VCMLogo;
	public void clickOnVictoryLogo() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(VCMLogo));
        VCMLogo.click();
   }
}
