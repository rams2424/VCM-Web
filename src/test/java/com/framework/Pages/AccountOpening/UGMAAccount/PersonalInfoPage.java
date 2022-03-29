package com.framework.Pages.AccountOpening.UGMAAccount;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class PersonalInfoPage extends BasePage {
	WebDriver driver;
	public PersonalInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	Logger log = LoggerHelper.getLogger(PersonalInfoPage.class);
	@FindBy(xpath="//input[contains(@id,'primaryOwnerMarital')]")
	WebElement primaryOwnerMarital;
	
	@FindBy(xpath="//label[contains(@for,'Male')]")
	WebElement maleRadioBtn;
	
	@FindBy(xpath="//label[contains(@for,'Female')]")
	WebElement femaleRadioBtn;
	
	@FindBy(xpath="//*[contains(@name,'Address Line 2')]")
	WebElement addressline1;
	
	@FindBy(xpath="//*[contains(@name,'zipCode')]")
	WebElement zipCodetxt;
	
	@FindBy(xpath="//*[contains(@name,'empStatus')]")
	WebElement empStatusDropDown;
	
	@FindBy(xpath="//input[@id='childFirstName']")
	WebElement childFirstName;
	
	public void enterName(String name) {
	    childFirstName.sendKeys(name);
	}
	@FindBy(xpath="//input[@id='childLastName']")
	WebElement childLastName;
	
	public void enterLastName(String name) {
	    childLastName.sendKeys(name);
    }
	@FindBy(xpath="//input[@id='childBeneficiaryDOB']")
	WebElement childBenifiDob;
	
	public void enterDob(String dob) {
	    childBenifiDob.sendKeys(dob);
	    childBenifiDob.sendKeys(Keys.ENTER);
	}
	@FindBy(xpath="//input[@id='childrelationshipToCustodian']")
	WebElement relationShipDropDwn;
	public void enterRelationShip(String relation) {
	    this.clickOnButtonUsingJs(relationShipDropDwn);
	    driver.findElement(By.xpath("//span[text()='"+relation+"']")).click();
	}
	
	@FindBy(css="input#childssnOne")
	WebElement childSsn1;
	
	@FindBy(css="input#childssnTwo")
	WebElement childSsn2;
	
	@FindBy(css="input#childssnThree")
	WebElement childSsn3;
	
	public void enterChildSSN(String ssn1,String ssn2,String ssn3) {
		log.info("SSn1"+ssn1);
		childSsn1.sendKeys(ssn1);
		log.info("SSn2"+ssn2);
		childSsn2.sendKeys(ssn2);
		log.info("SSn3"+ssn3);
		childSsn3.sendKeys(ssn3);
	}

}
