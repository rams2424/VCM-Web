package com.framework.Pages.GenericFunctions.AccessForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Pages.BasePage;

public class LegalAndPrivacyPage extends BasePage  {
	WebDriverWait wait;
	
	WebDriver driver;
	public LegalAndPrivacyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Policies')]")
	WebElement PoliciesTxt;
	public void verifyLegalAndPrivacyPage () { 
		String url = "https://victory:L@unch123@qa.investor.vcm.com/policies";
        driver.get(url);
		this.elementVisible(PoliciesTxt); 
	}
	
	@FindBy(xpath="//a[@class='navbar-brand postlogin-logo']")
	WebElement VCMLogo;
	public void clickOnVictoryLogo() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(VCMLogo));
        VCMLogo.click();
   }

}
