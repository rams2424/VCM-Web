package com.framework.Pages.ProfileAndPreferences.Profile.PhoneInfo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class PhoneInfoPage extends BasePage {
    Logger log = LoggerHelper.getLogger(PhoneInfoPage.class);
    WebDriverWait wait;
    WebDriver driver;
    public PhoneInfoPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(xpath="//h1[contains(text(),'Phone Information')]")
    WebElement verifyPhoneInfo;
    
    @FindBy(xpath="//button[contains(@aria-label,'More Options on Primary Phone Number ')]")
    WebElement moreOptPrimaryPhn;
    
    @FindBy(xpath="//button[contains(@aria-label,'More Options on Secondary Phone Number ')]")
    WebElement moreOptSecPhn;
    
    @FindBy(id="vcm-menu-item-Edit")
    WebElement editButton;
    @FindBy(id="vcm-menu-item-Delete")
    WebElement deleteButton;
    
    @FindBy(xpath="//a[contains(@aria-label,'Add phone')]")
    WebElement addPhnBttn;
    @FindBy(id="vcm-alert-dialog-0")
    WebElement alertDialog;
    @FindBy(id="vcm-modal-primary-btn-0")
    WebElement primaryDel;
    
    
    
    public void verifyPhoneInfoPage() {
        this.elementVisible(verifyPhoneInfo);
    }
    
    
    public void visibiltyOfPhn(String arg1) {
        WebElement phoneType=driver.findElement(By.xpath("//*[text()='"+arg1+"']"));
        this.elementVisible(phoneType);
    }
    
    public void visibiltyOf(String arg1) {
        WebElement Type=driver.findElement(By.xpath("//*[text()='"+arg1+"']"));
        this.elementVisible(Type);
        
    }
    
    public void verifyAddPhnBttn() {
        this.elementVisible(addPhnBttn);
    }
    
    public void clickOnAddPhnBttn() {
        this.clickOnButton(addPhnBttn);
    }
    
    public void clickOnOptionsFor(String arg1) {
        if(arg1.equalsIgnoreCase("Primary Phone Number")){
            this.clickOnButton(moreOptPrimaryPhn);
        }
        else{
            this.clickOnButton(moreOptSecPhn);
        }
    }
    
    public void verifyEditOpt() {
        this.elementVisible(editButton);
    }
    
    public void verifyDeleteOpt() {
        this.elementVisible(deleteButton);
        
        
    }
    
    public void clickOnDeleteBttn() {
        this.clickOnButton(deleteButton);
    }
    
    public void verifyPopup() {
        this.elementVisible(alertDialog);
    }
    
    public void confirmDelete() {
        this.clickOnButton(primaryDel);
    }
    
    public void verifyDeletion() {
        By newPhn= By.xpath("//button[contains(@aria-label,'More Options on - Secondary Phone Number ')]");
        Assert.assertFalse(this.isElementPresent(newPhn));
    }
    
    public void clickOnEditBttn() {
        this.clickOnButton(editButton);
    }
    
    public void verifyMsg(String arg1) {
    	By msg1=By.xpath("//*[contains(text(),'"+arg1+"')]");
        Assert.assertTrue(this.isElementPresent(msg1),"Not Success");
        WebElement msg=driver.findElement(By.xpath("//*[contains(text(),'"+arg1+"')]"));
        this.elementVisible(msg);
    }
    
    @FindBy(id="vcm-bottom-nav-section-back")
    WebElement backBtn;
    
    public void clickOnBackBttn() {
        this.clickOnButton(backBtn);
    }
    
    
}
