package com.framework.Pages.ProfileAndPreferences.Profile;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.DropDownHelper.DropDownHelper;
import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class ManageMilitaryInformationPage  extends BasePage{
	
	WebDriverWait wait;
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(ManageMilitaryInformationPage.class);
	DropDownHelper dropdownHelper = new DropDownHelper();
	public ManageMilitaryInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1//span[contains(text(),'Manage Military Information')]")
	WebElement militaryInfoPagetxt;
	
	public void verifyManageMilitaryInfoPage(String expected) {
		log.info("expected"+expected);
		log.info("Actual"+militaryInfoPagetxt.getText());
		Assert.assertTrue(expected.equalsIgnoreCase(militaryInfoPagetxt.getText()));
	}
	
	@FindBy(css="div#vcm-cms-is-currently-serving-military")
	WebElement currentlyServingChkBox;
	public void clickOnCurrentlyServingCheckBox() {
        if(currentlyServingChkBox.getAttribute("aria-checked").equalsIgnoreCase("false")){
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(currentlyServingChkBox));
        currentlyServingChkBox.click();
        }
	}
	@FindBy(css="button#vcm-cms-military-status-select")
	WebElement militarystatusDropdn;
	@FindBy(xpath="//div[@role='listbox']//span")
	List<WebElement> statusValues;
	
	public void verifyMilitaryStatusDropDown1(String activedut, String retiredfromactiveduty, String separatedmilitary, String reservefulltime ) {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(militarystatusDropdn));
	    militarystatusDropdn.click();
		List<String>expected = new ArrayList<>();
		for(WebElement e:statusValues) {
			expected.add(e.getText());
		}
		List<String>list = new ArrayList<String>();
		list.add(activedut);
		list.add(retiredfromactiveduty);
		list.add(separatedmilitary);
		list.add(reservefulltime);
		Assert.assertTrue(expected.contains(list));
	}
	@FindBy(css="button#vcm-cms-branch-of-service-select")
	WebElement branchOfserviceDrpDn;
	public void verifyServiceDropDown(String army, String navy, String marinecorp, String airforce, String coastguard, String other) {
	    wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(branchOfserviceDrpDn));
	    branchOfserviceDrpDn.click();
		List<String>expected = new ArrayList<>();
		for(WebElement e:statusValues) {
			expected.add(e.getText());
		}
		List<String>list = new ArrayList<String>();
		list.add(army);
		list.add(navy);
		list.add(marinecorp);
		list.add(airforce);
		list.add(coastguard);
		list.add(other);
		Assert.assertTrue(expected.contains(list));	 
	}
	
	public void clickOnMilitaryStatusDropDn(String value) {
		log.info("value"+value);
		militarystatusDropdn.click();
		driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
	}
	
	public void clickOnBranchOfServiceDropDn(String value) throws InterruptedException {
		log.info("value"+value);
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", branchOfserviceDrpDn); 
		driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
		
	}
	@FindBy(css="button#vcm-cms-rank-select")
	WebElement rankDropDn;
	public void clickOnRankDropDn(String value) throws InterruptedException {
		log.info("value"+value);
		Thread.sleep(1000);
		//rankDropDn.click();
		//wait = new WebDriverWait(driver, 3000);
        //wait.until(ExpectedConditions.elementToBeClickable(rankDropDn));		
		rankDropDn.click();
	//	this.clickOnElement(rankDropDn);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();		
	}
    @FindBy(css="input[name='fromDate']")
    WebElement fromDate;
    
    @FindBy(css="input[name='toDate']")
    WebElement toDate;
    
    public void enterFromDate(String date) {
    	log.info("Date"+date);
    	fromDate.clear();
    	fromDate.sendKeys(date);
    }
    
    public void enterToDate(String date) {
    	log.info("Date"+date);
    	toDate.clear();
    	toDate.sendKeys(date);
    	toDate.sendKeys(Keys.TAB);
    }
    @FindBy(css="input#vcm-cms-commission-source")
    WebElement commissionSourceTxt;
    
    public void enterCommissionSource(String txt) {
    	commissionSourceTxt.sendKeys(txt);
    }
    @FindBy(xpath="//*[contains(text(),'Successfully updated Military Information.')]")
    WebElement updateMsg;
    public void verifyInformationIsUpdated(String expected) {
    	log.info("Expected"+expected);
    	log.info("Actual"+updateMsg.getText());
    	Assert.assertTrue(expected.equalsIgnoreCase(updateMsg.getText()));
    	
    }

}
