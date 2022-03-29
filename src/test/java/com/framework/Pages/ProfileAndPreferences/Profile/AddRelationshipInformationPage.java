package com.framework.Pages.ProfileAndPreferences.Profile;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class AddRelationshipInformationPage extends BasePage {
	
	Logger log = LoggerHelper.getLogger(AddRelationshipInformationPage.class);
	WebDriverWait wait;
	WebDriver driver;
	public AddRelationshipInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#vcm-cms-relation-firstname")
	WebElement fname;
	public void enterFirstName(String fName) {
		fname.sendKeys(fName);
	}
	
	@FindBy(css="input#vcm-cms-relation-lastname")
	WebElement lname;
	
	public void enterLastName(String lName) {
		lname.sendKeys(lName);
	}
	
	@FindBy(css="input#vcm-cms-relation-prefix")
	WebElement prefixDropDown;
	
	@FindBy(xpath="//div[@role='listbox']//span")
	List<WebElement> list;
	
	@FindBy(css="input#vcm-cms-relation-sufix")
	WebElement sufixDropDown;
	
	@FindBy(css="input#vcm-cms-relation-date-of-birth")
	WebElement dob;
	
	public void enterDob(String DOB) {
		dob.sendKeys(DOB);
	}
	
	
	@FindBy(xpath="//*[contains(text(),'Female')]/..")
	WebElement femaleRadioBtn;
	@FindBy(xpath="//*[contains(text(),'Male')]/..")
	WebElement maleRadioBtn;
	public void clickOnGender(String expected) {
		if(expected.equalsIgnoreCase("Female")) {
		    this.clickOnButtonUsingJs(femaleRadioBtn);
		} else {
		    this.clickOnButtonUsingJs(maleRadioBtn);
		}
	}
	@FindBy(css="input#vcm-ssn-area-number")
	WebElement ssn1;
	
	@FindBy(css="input#vcm-ssn-group-number")
	WebElement ssn2;
	
	@FindBy(css="input#vcm-ssn-serial-number")
	WebElement ssn3;
	
	
	@FindBy(css="button#vcm-cms-relation-marital-status-select")
	WebElement maritalStatusDrpDn;
	
	public void clickOnMaritalStatusDropDn(String value) {
	    maritalStatusDrpDn.click();
	    driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
	}
	
	public void clickOnCitizanShipBtn(String value) {
	    wait = new WebDriverWait(driver, 40);
	    if(value.equalsIgnoreCase("U.S")) {
	        WebElement element = driver.findElement(By.xpath("//span[text()='U.S.']/.."));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        this.clickOnButtonUsingJs(element);
	    } else {
	        driver.findElement(By.xpath("//span[text()='Non U.S.']/..")).click();
	    }
	}
	
	@FindBy(css="input#vcm-cms-phone-number-0")
	WebElement primaryPhoneNo;
	public void enterPrimaryPhoneNo(String phNo) {
		log.info("Primary Phone No"+phNo);
		primaryPhoneNo.sendKeys(phNo);
	}
	
	@FindBy(css="input#vcm-cms-relation-primary-email")
	WebElement primaryEmail;
	
	public void enterPrimaryMail(String email) {
		log.info("Primary email"+email);
		primaryEmail.sendKeys(email);
	}
	@FindBy(css="input#vcm-address-line1-mailingAddress")
	WebElement addressLine1;
	public void enterAddressLine1(String add) {
		log.info("Address Line1"+add);
		addressLine1.sendKeys(add);
	}
	
	@FindBy(css="input#vcm-address-zipcode-mailingAddress")
	WebElement zipCode1;
	
	public void enterZipCode(String zipCode) {
		log.info("Zip Code"+zipCode);
		zipCode1.sendKeys(zipCode);
		zipCode1.sendKeys(Keys.TAB);
	}
	@FindBy(xpath="//span[text()='Use this address']")
	WebElement useThisAddressBtn;
	
	public void clickOnUseThisAddressBtn() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(useThisAddressBtn));
		useThisAddressBtn.click();
	}
	
	@FindBy(xpath="//*[text()='Save']")
	WebElement saveBtn;
	
	public void clickOnSaveBtn() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
	}

	@FindBy(xpath="//*[text()='Cancel']")
	WebElement cancelBtn;
	
	public void clickOnCancelBtn() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
		cancelBtn.click();
	}
	@FindBy(css="input#vcm-cms-relation-relationship-to-you")
	WebElement relationDropDn;
	public void clickOnrelationDropDown() {
		relationDropDn.click();
		driver.findElement(By.xpath("//span[text()='Aunt/Uncle']")).click();
	}
	
	@FindBy(xpath="//*[contains(text(),'Successfully added Relationship')]")
	WebElement updateDetailsMsg;
	public void verifyInformationIssaved() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(updateDetailsMsg));

		Assert.assertTrue(updateDetailsMsg.isDisplayed());
	}

	public void verifySaveBtn() {
		log.info(saveBtn.isDisplayed());
		Assert.assertTrue(saveBtn.isDisplayed());
	}
	public void verifyCancelBtnIsDisplayed() {
		log.info(cancelBtn.isDisplayed());
		Assert.assertTrue(cancelBtn.isDisplayed());
	}
	@FindBy(xpath="//span[text()='US or US Territories']")
	WebElement addressTypeRadioBtn;
	public void clickOnAddressTypeRadioBtn() {
	    wait = new WebDriverWait(driver, 40);
	    wait.until(ExpectedConditions.elementToBeClickable(addressTypeRadioBtn));
	    addressTypeRadioBtn.click();
	}
	@FindBy(css="button#vcm-cms-relation-relationship-to-you-select")
	WebElement relationShipDropDn;
	public void clickOnRelationDropDown() {
	    relationShipDropDn.click();
	    driver.findElement(By.xpath("//*[contains(text(),'Aunt/Uncle')]")).click();
	}
	@FindBy(xpath="//*[text()='Manage relationship']/../../following-sibling::div[1]")
	WebElement tab;
	public void clickOneditTab() {
	    wait = new WebDriverWait(driver, 40);
	    wait.until(ExpectedConditions.elementToBeClickable(tab));
	    tab.click();
	}
}

