package com.framework.Pages.ProfileAndPreferences.Profile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.Pages.BasePage;

public class ContactInformationPage extends BasePage {

	
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@id='GeneralInvestmentAccounts']//div[1]//div[1]//div[1]//div[3]//div[1]//button[1]")
	WebElement AddSeasonalAddress;
	
	public AddSeasonalAddress navigatetoaddSeasonalAddress() throws InterruptedException{
		AddSeasonalAddress.click();
		return new AddSeasonalAddress(driver);
	}
	@FindBy(xpath="//button[contains(@aria-label,'More Options on Physical Address')]")
	WebElement Addmenu;
	@FindBy(xpath="//span[@id='vcm-menu-item-Edit']")
	WebElement Edit;
	
	public EditContactInfo navigatetoEdit(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Addmenu);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		js.executeScript("arguments[0].click();", Edit);
		return new EditContactInfo(driver);
	}
	
	@FindBy(xpath="//span[text()='Back']")
	WebElement ClickBack;
	public BasicInformation ClickOnBack(){
		this.scrollIntoView(ClickBack);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ClickBack);
		return new BasicInformation(driver);
	}
	
	
}
