package com.framework.Pages.ProfileAndPreferences.Profile;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class PersonalInformationPage extends BasePage {
    
    WebDriver driver;
    Logger log = LoggerHelper.getLogger( PersonalInformationPage.class);

    public PersonalInformationPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait;
    @FindBy(xpath="//p[@id='vcm-cms-fullname']/span[1]")
    WebElement FullName;
    public void checkName(){
        Assert.assertTrue(FullName.getAttribute("aria-hidden").toString().equals("true"));
    }
    
    @FindBy(xpath="//p[@id='vcm-cms-member-id']/span[1]")
    WebElement MemberId;
    public void Member(){
    	 Assert.assertTrue(MemberId.getAttribute("aria-hidden").toString().equals("true"));
    }
    
//    @FindBy(xpath="//span[normalize-space()='+1 (800) 235-8396']")
//    WebElement SSN;
//    public void SocialSN(){
//    	Assert.assertFalse(SSN.isEnabled());
//    }
//    
//   
//    
    
    @FindBy(xpath="//button[@id='vcm-cms-prefix-select']")
    WebElement Prefix;
    
    public void ChoosePrefix(String arg){
    	  
        Prefix.click();

    	wait = new WebDriverWait(driver, 40);
       
        WebElement clickonprefix= driver.findElement(By.xpath("//a//span[contains(normalize-space(),'"+arg+"')]"));
        
        
    	wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(clickonprefix));
         
         clickonprefix.click();
      
    	 
        
    }
    
    
    @FindBy(xpath="//button[@id='vcm-cms-suffix-select']")
    WebElement Suffix;
    
    public void ChooseSuffix(String arg1){
        Suffix.click();
        
        
        
        WebElement clickonSuffix= driver.findElement(By.xpath("//a//span[contains(normalize-space(),'"+arg1+"')]"));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(clickonSuffix));
        clickonSuffix.click();
        
    }
    
    
    
    
    
    public void SelectGender(){
        
        WebElement chooseGender=driver.findElement(By.xpath("//div[@role='radio' and @aria-checked='false' and @data-listener='true']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", chooseGender); 
        
        
    }
    
    @FindBy(xpath="//button[@id='vcm-cms-marital-status-select']")
    WebElement Maritalstatus;
    public void SelectMaritalStatus(String arg3){
        Maritalstatus.click();
        WebElement chooseStatus=driver.findElement(By.xpath("//span[contains(normalize-space(),'"+arg3+"')]"));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(chooseStatus));        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", chooseStatus); 
    }
    @FindBy(id="vcm-cms-citizenship-radio-group-rb1")
    WebElement Citizenship;
    public void CheckCitizanship(){
    	Assert.assertTrue(Citizenship.getAttribute("aria-disabled").toString().equals("true"));
        Citizenship.isEnabled();
    }
    
    @FindBy(xpath="//span[contains(normalize-space(),'800-235-8396')]")
    WebElement Serviceno;
    public void ServiceNoVisibility(){
        this.elementVisible(Serviceno);
    }
    @FindBy(xpath="//button[@id='vcm-bottom-nav-section-primary']//span")
    WebElement Save;
    public BasicInformation ClickOnSaveBtn(){
    	this.clickOnButtonUsingJs(Save);
    	return new BasicInformation(driver);
    }




	@FindBy(xpath="//*[contains(text(),'Successfully updated Personal Information.')]")
    WebElement updateMsg;
    public void verifyInformationIsUpdated(String expected) {
        log.info("Expected"+expected);
        log.info("Actual"+updateMsg.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(updateMsg.getText()));
}
}
