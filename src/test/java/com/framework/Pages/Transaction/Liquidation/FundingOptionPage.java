package com.framework.Pages.Transaction.Liquidation;
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

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.Hooks;
import com.framework.Pages.BasePage;

public class FundingOptionPage extends BasePage {
    Logger log = LoggerHelper.getLogger(FundingOptionPage.class);
    WebDriver driver;
    private Hooks hook;
    WebDriverWait wait;
    public FundingOptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }	    
    @FindBy(xpath="//*[text()='Check']")
    WebElement Check;
    public void ClickOnCheck(){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", Check);
    }
    
    @FindBy(xpath="//*[text()='Delivery Address']")
    WebElement DeliveryAddress;
    public void CheckDeliveryAddress(){
        this.elementVisible(DeliveryAddress);
    }
    
    @FindBy(xpath="//*[text()='Back']")
    WebElement Back;
    public void BackVisibility(){
        this.elementVisible(Back);
    }
    
    @FindBy(xpath="//*[text()='Cancel']")
    WebElement Cancel;
    public void CancelVisibility(){
        this.elementVisible(Cancel);
    }
    public void SelectBank(String BankName){
        log.info("Bank Name"+BankName);
        WebElement SelectingBankName = driver.findElement(By.xpath("//*[text()='"+BankName+"']"));
        this.clickOnButton(SelectingBankName);
    }
    @FindBy(xpath="//button[@id='nextButton']")
    WebElement Next;
    public void navigatetoNext(){
        wait =new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(Next));
        this.clickOnButtonUsingJs(Next);
        
    }
    public ReviewPage navigatetoReview(){
        this.navigatetoNext();
        return new ReviewPage(driver);
    }
    
    @FindBy(xpath="//input[@name='FederalTaxPercent']")
    WebElement FederalTax;
    
    @FindBy(xpath="//*[text()='Federal Tax + State Tax must be less than or equal to 99%']")
    WebElement FederaltaxError;
    
    public void ChekTaxholdingoption(String FederalTaxValue) throws InterruptedException{
        this.verifyPageIsLoaded();
        wait =new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(FederalTax)); 
        FederalTax.clear();
        this.verifyPageIsLoaded(); 
        FederalTax.sendKeys(FederalTaxValue);
        FederalTax.sendKeys(Keys.TAB);
    }
    public void ErrormessageforFederalTax(){
        wait =new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(FederaltaxError));
        this.elementVisible(FederaltaxError);
        
    }
}
