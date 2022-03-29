package com.framework.Pages.ProfileAndPreferences.Profile;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.DropDownHelper.DropDownHelper;
import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;


public class EmpIoymentInfoPage  extends BasePage{
	
	DropDownHelper dropDownHelper = new DropDownHelper();
	
	Logger log = LoggerHelper.getLogger( EmpIoymentInfoPage.class);

	private WebDriver driver;
	
	public EmpIoymentInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@id='vcm-cms-employment-status-select']")
	WebElement EmploymentStatus;
	
	public void ChooseEmploymentStatus(String arg){
		EmploymentStatus.click();
	     WebElement clickonEmpStatus= driver.findElement(By.xpath("//span[contains(normalize-space(),'"+arg+"')]"));
		 this.clickOnButton(clickonEmpStatus);
	}
	
	@FindBy(xpath="//button[@id='vcm-cms-primary-source-of-income-select']")
	WebElement PrimarySourceOfIncome;
	
	public void ChoosePrimarySourceOfIncome(String arg){
		this.clickOnButton(PrimarySourceOfIncome);
	    WebElement SourceOfIncome= driver.findElement(By.xpath("//span[contains(normalize-space(),'"+arg+"')]"));
		this.clickOnButton(SourceOfIncome);
	}
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement SaveButton;
	
	public void ClickonSave() {
		 this.clickOnButton( SaveButton);
		
	} 
	
	@FindBy(xpath="//*[contains(text(),'Successfully updated Employment Information.')]")
    WebElement updateMsg;
    public void verifyInformationIsUpdated(String expected) {
        log.info("Expected"+expected);
        log.info("Actual"+updateMsg.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(updateMsg.getText()));
}
    
    @FindBy(xpath="//div[@id='vcm-cms-employment-status-select-option-container']//span")
    List<WebElement> statusValues;
    
    public void verifyEmpStatusDropDown(String range1,String range2,String range3,String range4 ,String range5,String range6,String range7,String range8){
        log.info(range1);
        log.info(range2);
        log.info(range3);
        log.info(range4);
        log.info(range5);
        log.info(range6);
        log.info(range7);
        log.info(range8);
        EmploymentStatus.click();
        List<String>list = new ArrayList<>();
        for(WebElement e:statusValues) {
            list.add(e.getText());
        }
        List<String>expected = new ArrayList<String>();
        expected.add(range1);
        expected.add(range2);
        expected.add(range3);
        expected.add(range4);
        expected.add(range5);
        expected.add(range6);
        expected.add(range7);
        expected.add(range8);
        Assert.assertTrue(list.containsAll(expected));   
}
    public void ChooseEmploymentStatusMilitary(String arg){
    	this.clickOnButton(EmploymentStatus);
	    WebElement clickonEmpStatus= driver.findElement(By.xpath("//span[contains(normalize-space(),'"+arg+"')]"));
	    this.clickOnButton(clickonEmpStatus);
}
  
    @FindBy(xpath="//button[@id='vcm-cms-industry-select']")
	WebElement Industry;
	
	public void ChooseIndustry(String arg){
		this.clickOnButtonUsingJs(Industry);
	     WebElement clickonEmpStatus= driver.findElement(By.xpath("//a/span[contains(normalize-space(),'"+arg+"')]"));
		 this.clickOnButton(clickonEmpStatus);
    }
	
	@FindBy(xpath="//input[@id='vcm-cms-occupation']")
	WebElement Occupation;
	
	@FindBy(xpath="//input[@id='vcm-cms-employerName']")
	WebElement employerName; 
	
	@FindBy(xpath="//input[@id='vcm-address-line1-address']")
	WebElement AdressLine1;
	
	@FindBy(xpath="//input[@id='vcm-address-line2-address']")
	WebElement AdressLine2; 
	
	@FindBy (id="vcm-address-zipcode-address")
	WebElement ZipCode;
	
	public void SelectOccupation(String oId) {
    	this.sendKeys(Occupation, oId);
    }
	public void SelectEmpName(String oId) {
    	this.sendKeys(employerName, oId);
    }
	public void SelectAdressLine1(String oId) {
    	this.sendKeys(AdressLine1, oId);
    }
	public void SelectAdressLine2(String oId) {
    	this.sendKeys(AdressLine2, oId);
	}
	public void SelectZipCode(String oId) {
    	this.sendKeys(ZipCode, oId);
    }

}
