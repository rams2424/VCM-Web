package com.framework.Pages.AccountOpening;

import java.util.List;

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
import com.framework.Pages.BasePage;

public class FundSelectionPage extends BasePage {
    
    WebDriver driver;
	WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(FundSelectionPage.class);
    public FundSelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//input[@type='checkbox']")
    List<WebElement> fundList;
    public void clickOnFund(String fundName) {
        this.verifyPageIsLoaded();
        for(int i=0;i<3;i++) {  
            wait = new WebDriverWait(driver, 2000);
           // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='custom-control-input']")));
        //	this.scrollIntoView(driver.findElements(By.xpath("//input[@class='custom-control-input']")).get(i));
        	this.clickOnButtonUsingJs(driver.findElements(By.xpath("//input[@class='custom-control-input']")).get(i));
        }
    }
    @FindBy(xpath="//*[contains(text(),'Fund Your Investments')]")
    WebElement fundSourceTxt;
    public void verifyFundSourceSelectionPage() {
        wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.visibilityOf(fundSourceTxt));
        Assert.assertTrue(fundSourceTxt.isDisplayed());
    }
}
