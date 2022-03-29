package com.framework.Pages.AccountOpening.GeneralInvestmentAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Pages.BasePage;

public class PersonalInfoPage extends BasePage {
    
    WebDriverWait wait;
    WebDriver driver;
    public PersonalInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[contains(text(),'2. Personal Info')]")
    WebElement perInfoTxt;
    public void verifyPersonalInfoPageIsDisplaying() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(perInfoTxt));
        this.elementVisible(perInfoTxt);
    }	
    public void enterPrimarySourceOfIncome() {
        driver.findElement(By.xpath("//*[@id='primarySourceofIncome']")).click();
        driver.findElement(By.xpath("//*[text()='Social Security']")).click();
    }
    
}
