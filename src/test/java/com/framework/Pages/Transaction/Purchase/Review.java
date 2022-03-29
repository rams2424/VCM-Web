package com.framework.Pages.Transaction.Purchase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;

public class Review {
    Logger log = LoggerHelper.getLogger(Review.class);
    
    WebDriver driver;
    
    public Review(WebDriver driver) {
        log.info("Inside Review Page");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[text()='4.  Review & Confirm']")
    WebElement reviewAndConfirmPage;
    public void verifyReviewPage() {
        log.info("Review And Confirm Page"+reviewAndConfirmPage.getText());
        Assert.assertEquals(reviewAndConfirmPage.getText(), "4. Review & Confirm","Verified Review Page");
        log.info("Verified Review Page");
    }
    
    public void verifyTradeType(String tradeType) {
        WebElement verify=driver.findElement(By.xpath("//div[text()='"+tradeType+"']"));
        log.info("Expected"+tradeType);
        log.info("Actual"+verify.getText());
        Assert.assertTrue(tradeType.equalsIgnoreCase(verify.getText()));
    }
    
    public void verifyInitialInvestment(String investment, String initialValue) {
        WebElement verify=driver.findElement(By.xpath("//div[text()='"+investment+"']/following-sibling::div"));
        Assert.assertTrue(verify.getText().contains(initialValue),"Verified "+investment);
        log.info("Verified Initial Investments");
    }
    
    public void verifyFundingSource(String fundSource) {
        WebElement verify=driver.findElement(By.xpath("//div[contains(text(),'"+fundSource+"')]"));
        log.info("Expected"+fundSource);
        log.info("Actual"+verify.getText());
        Assert.assertTrue(fundSource.equalsIgnoreCase(verify.getText()));
    }
    public void verifyTotalInvestment(String total) {
        WebElement verify=driver.findElement(By.xpath("//div[text()='Total Investment']/following-sibling::div"));
        Assert.assertTrue(verify.getText().contains(total),"Verified Total Investments");
        log.info("Verified Total Investments");
    }

    public void verifyIra(String ira) {
        WebElement verify=driver.findElement(By.xpath("//div[text()='Contribution for IRA Account']/following-sibling::div"));
        Assert.assertTrue(verify.getText().contains(ira),"Verified Total Investments");
        log.info("Verified Total Investments");
    }
}
