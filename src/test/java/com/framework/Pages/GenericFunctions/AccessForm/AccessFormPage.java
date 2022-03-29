package com.framework.Pages.GenericFunctions.AccessForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Pages.BasePage;

public class AccessFormPage extends BasePage  {
	WebDriverWait wait;
	
	WebDriver driver;
	public AccessFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@data-testid='form-title']//h1")
	WebElement accessFormTxt;
	public void verifyAccessFormPage() {
		this.elementVisible(accessFormTxt); 
	}
	
	@FindBy(xpath="//img[@alt='VCM Logo']")
	WebElement VCMLogo;
	public void clickOnVictoryLogo() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(VCMLogo));
        VCMLogo.click();
        
   }
	
}
