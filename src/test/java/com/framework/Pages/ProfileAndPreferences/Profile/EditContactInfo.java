package com.framework.Pages.ProfileAndPreferences.Profile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Pages.BasePage;

public class EditContactInfo extends BasePage {
	WebDriverWait wait;
	WebDriver driver;
	public EditContactInfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(normalize-space(),'APO (Army or Air Force Post Office)')]/..")
	WebElement AddType;
	public void SelectAddType(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AddType);
	}
	@FindBy(xpath="//input[@id='vcm-address-line1-address']")
	WebElement addressLine1;
	public void AddL1(String address){
	    this.verifyPageIsLoaded();
	    System.out.println(address);
	    addressLine1.clear();
	    addressLine1.sendKeys(address);
		
	}
	
	@FindBy(xpath="//input[@id='vcm-address-zipcode-address']")
	WebElement Zipcode;
	@FindBy(xpath="//div[@class='sc-gleUXh iUJHNH']")
	WebElement Random;
	public void EnterZipCd(String Arg1){
	    this.verifyPageIsLoaded();
		Zipcode.clear();
		this.verifyPageIsLoaded();
		Zipcode.sendKeys(Arg1);
		
	}
	
	@FindBy(xpath="//span[contains(normalize-space(),'Use this address')]")
	WebElement UseAddress;
	public void UseAdd() throws InterruptedException {
	    if(driver.findElement(By.xpath("//span[contains(normalize-space(),'Use this address')]")).isDisplayed()) {
    		JavascriptExecutor js = (JavascriptExecutor)driver;
    		js.executeScript("arguments[0].click();", UseAddress);
    		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    }
	}
	@FindBy(xpath="//input[@id='vcm-check-option-text']")
	WebElement Check;
	public void ClickCheck(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Check);
	}
	@FindBy(xpath="//span[text()='Save']")
	WebElement Save;
	public ContactInformationPage ClickOnSave(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Save);
		return new ContactInformationPage(driver);
	}
	

}
