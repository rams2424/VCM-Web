package com.framework.Pages.GenericFunctions.AccessForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Pages.BasePage;

public class ETFProspectusPage extends BasePage  {
	WebDriverWait wait;
	
	WebDriver driver;
	public ETFProspectusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[contains(text(),'ETF Literature')]")
	WebElement ETFLiteratureTxt;
	public void verifyETFProspectusPage() {
		//this.elementVisible(ETFLiteratureTxt); 
		 Assert.assertTrue(driver.getCurrentUrl().contains("etf-prospectuses"));
	}
	
	

}
