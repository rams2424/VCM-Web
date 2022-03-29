package com.framework.Pages.ProfileAndPreferences.Profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSeasonalAddress {
	
	WebDriver driver;
	public AddSeasonalAddress(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='vcm-address-line1-address']")
	WebElement AddLine1;
	public void EnterAddLine1(String arg){
		AddLine1.sendKeys(arg);
	}
	@FindBy(xpath="//input[@id='vcm-address-zipcode-address']")
	WebElement ZipCode;
	@FindBy(xpath="//*[text()='Zip Code']")
	WebElement Random;
	public void EnterZipCode(String arg1) throws InterruptedException{
		ZipCode.sendKeys(arg1);
		Random.click();		
	}
	
	@FindBy(xpath="//span[contains(normalize-space(),'Use this address')]")
	WebElement UseAdd;
	public void UseThisAdd() throws InterruptedException{
		UseAdd.click();
	}
	
	@FindBy(xpath="//input[@id='vcm-cms-seasonal-start-date']")
	WebElement startDate;
	
	public void from_Date(String Day,String MonthwithDate,String year, String MonthYear) throws InterruptedException {
		startDate.click();    
		while(true) {
			if(MonthYear.contains(driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText())) {
				WebElement dat=driver.findElement(By.xpath("//div[contains(@aria-label,'"+Day+", "+MonthwithDate+", "+year+"')]"));
				dat.click();
		        break;
	        } else {
	        	driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
		    }
		}           
	}
	
	@FindBy(xpath="//input[@id='vcm-cms-seasonal-end-date']")
	WebElement EndDate;
	public void End_Date(String Day,String MonthwithDate,String year, String MonthYear) throws InterruptedException {
		EndDate.click();    
		while(true) {
			if(MonthYear.contains(driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText())) {
				WebElement dat=driver.findElement(By.xpath("//div[contains(@aria-label,'"+Day+", "+MonthwithDate+", "+year+"')]"));
				dat.click();
		        break;
	        } else {
	        	driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
		    }
		}           
	}
	
	@FindBy(xpath="//span[text()='Save']")
	WebElement Save;
	public void ClickOnSave(){
		Save.click();
	}
	

}
