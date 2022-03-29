package com.framework.Pages.ProfileAndPreferences;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Pages.BasePage;
import com.framework.Pages.ProfileAndPreferences.Profile.ContactInformationPage;
import com.framework.Pages.ProfileAndPreferences.Profile.EmpIoymentInfoPage;
import com.framework.Pages.ProfileAndPreferences.Profile.ManageMilitaryInformationPage;
import com.framework.Pages.ProfileAndPreferences.Profile.PersonalInformationPage;

public class BasicInformation extends BasePage{
    
    WebDriverWait wait;
    WebDriver driver;
    
    public BasicInformation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[contains(text(),'Basic Information')]")
    WebElement basicInfoTxt;
    public void verifyBasicInformationPage() {
        this.verifyPageIsLoaded();
        Assert.assertTrue(basicInfoTxt.isDisplayed());
    }  
    
    @FindBy(xpath="//a[@aria-label='Manage Financial Information']")
    WebElement FinancialInformationEdit;
    
    public PersonalInformationPage ClickOnPersonalInformation() {
        WebElement ClickOnManage=driver.findElement(By.xpath("//a[@aria-label='Manage personal information']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", ClickOnManage);
        return new PersonalInformationPage(driver);
    }
    
    
    @FindBy(xpath="//*[@aria-label='Manage contact information']")
    WebElement ContactInformation;
    
    public ContactInformationPage navigateToContactInformation() throws InterruptedException{
    	JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", ContactInformation);
        
        return new ContactInformationPage(driver);
    }
    
    
    
    
    public FinancialInfoPage ClickOnFinacialInformation()
    {
        this.verifyPageIsLoaded();
        WebElement ClickOnManage=driver.findElement(By.xpath("//a[@aria-label='Manage Financial Information']"));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(ClickOnManage));
        this.clickOnButton(ClickOnManage);
        return new FinancialInfoPage(driver);
    }
    @FindBy(xpath="//a[@aria-label='Manage Military Information']")
    WebElement MilitaryInformationEdit;
    
    public ManageMilitaryInformationPage ClickOnMilitaryInformation()
    {
        this.verifyPageIsLoaded();
        WebElement ClickOnManage=driver.findElement(By.xpath("//a[@aria-label='Manage Military Information']"));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(ClickOnManage));
        this.clickOnButton(ClickOnManage);
        return new ManageMilitaryInformationPage(driver);
        
    } 
    
    @FindBy(xpath="//a[@aria-label='Manage Employment Information']")
    WebElement EmploymentInfoManage;
    
    public EmpIoymentInfoPage ClickOnEmploymentInformation()
    {
        this.verifyPageIsLoaded();
        WebElement ClickOnManage=driver.findElement(By.xpath("//a[@aria-label='Manage Employment Information']"));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(ClickOnManage));
        this.clickOnButton(ClickOnManage);
        return new EmpIoymentInfoPage(driver);
        
    }
    
    
}
