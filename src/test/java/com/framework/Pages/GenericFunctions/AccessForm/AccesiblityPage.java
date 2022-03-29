package com.framework.Pages.GenericFunctions.AccessForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Pages.BasePage;

import junit.framework.Assert;

public class AccesiblityPage  extends BasePage  {
	WebDriverWait wait;
	
	WebDriver driver;
	public AccesiblityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[contains(text(),'Accessibility')]")
	WebElement AccessibilityTxt;
	public void verifyAccesiblityPage() {
		Assert.assertTrue(driver.getCurrentUrl().contains("vcm.com/accessibility"));

	}
	
	@FindBy(xpath="//a[@class='navbar-brand postlogin-logo']//img")
	WebElement VCMLogo;
	public void clickOnVictoryLogo() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(VCMLogo));
        VCMLogo.click();
   }

}
