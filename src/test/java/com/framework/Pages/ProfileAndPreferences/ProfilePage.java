package com.framework.Pages.ProfileAndPreferences;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Pages.BasePage;


public class ProfilePage extends BasePage{
	
	WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickOn(String arg1) {
		
		WebElement opt=driver.findElement(By.xpath("//a[contains(text(),'"+arg1+"')]"));
		opt.isEnabled();
		this.clickOnButton(opt);
		
	}
	public BasicInformation navigateToBasicInformation() {
		return new BasicInformation(driver);
	}
    public AccountPreference navigateToAccountPreference(){
    	return new AccountPreference(driver);
    }
    
    public DeliverySettings navigateToDeliverySettings(){
    	return new DeliverySettings(driver);
    }
    
    public  SecurityPreferences navigateToSecurityPreferences(){
    	return new SecurityPreferences(driver);
    }
    
    @FindBy(xpath="//h1//span[contains(text(),'Profiles & Preferences')]")
    WebElement profilePageTxt;
    public void verifyProfilePage() throws InterruptedException {
       // this.verifyPageIsLoaded();
        Assert.assertTrue(profilePageTxt.isDisplayed());
	}  
}
