package com.framework.Pages.AccountOpening.SpecialtyAccount;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.BasePage;

public class AccountApplicationFormsPage  extends BasePage{
    
    WebDriver driver;
    WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(AccountApplicationFormsPage.class);
    public AccountApplicationFormsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[contains(text(),'Download the Form')]")
    WebElement downloadFormField;
    public void verifyDownladFormDisplay() {
        this.elementVisible(downloadFormField);
    }
    
    @FindBy(xpath="//span[contains(text(),'Your Member Number')]")
    WebElement yourMemberTxt;
    public void verifyMemberNoDisplay() {
        this.elementVisible(yourMemberTxt);
    }
    
    @FindBy(xpath="//span[contains(text(),'Submit Your Form and Supporting Documents')]")
    WebElement submitFormTxt;
    public void verifysubmitFormDisplay() {
        this.elementVisible(submitFormTxt);
    }
    
    @FindBy(xpath="//span[contains(text(),'Back')]")
    WebElement backBtn;
    public void verifyBackBtnIsdisplayed() {
        this.elementVisible(backBtn);
    }
    @FindBy(xpath="//span[contains(text(),'Download the Form')]/../following-sibling::div[2]//span//span[1]")
    WebElement downloadBtn;
    public void verifyFormIsDownloaded() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        By dowloadLink= By.xpath("//span[contains(text(),'Download the Form')]/../following-sibling::div[2]//span//span[1]");
        Assert.assertTrue(this.isElementPresent(dowloadLink));
        downloadBtn.click();
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("blob:https:"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);     
    }
    @FindBy(xpath="//h2[contains(text(),'Specialty Account')]")
    WebElement specialityTxt;
    public void verifySpecialityAccountPage() {
        Assert.assertTrue(specialityTxt.isDisplayed());
    }
    @FindBy(xpath="//a[@href='/openAccount']")
    WebElement openAccLink;
    public void clickOnOpenAccLink() {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.elementToBeClickable(openAccLink));
        openAccLink.click();
    }
}
