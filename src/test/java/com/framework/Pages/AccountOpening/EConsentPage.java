package com.framework.Pages.AccountOpening;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class EConsentPage extends BasePage{
    
    WebDriver driver;
    Logger log = LoggerHelper.getLogger(EConsentPage.class);
    WebDriverWait wait;
    public EConsentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css="input#esignCheck")
    WebElement esignCheckbox;
    
    public void clickOnEsign() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(esignCheckbox));
        esignCheckbox.click();
    }
    @FindBy(xpath="//span[contains(text(),'Submit')]")
    WebElement submitBtn;
    
    public void clickOnSubmitBtn() throws InterruptedException {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
        this.verifyPageIsLoaded();
    }
    
    @FindBy(xpath="//*[contains(text(),'7.  E-Consent')]")
    WebElement econsentpage;
    public void verifyEconcentPage() {
        this.elementVisible(econsentpage);
    }
}
