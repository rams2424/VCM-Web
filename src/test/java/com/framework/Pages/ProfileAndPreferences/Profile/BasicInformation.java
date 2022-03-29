package com.framework.Pages.ProfileAndPreferences.Profile;
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

public class BasicInformation extends BasePage{
    
    WebDriver driver;
    public BasicInformation(WebDriver driver) {  
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    Logger log = LoggerHelper.getLogger(BasicInformation.class);
    WebDriverWait wait;
    
    @FindBy(xpath="//li//*[text()='Basic Information']")
    WebElement basicInfoPagetxt;
    
    public void verifyBasicInformationPage(String expected) {
        log.info("expected"+expected);
        log.info("Actual"+basicInfoPagetxt.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(basicInfoPagetxt.getText()));
    }
    @FindBy(xpath="//*[text()='Manage relationship']/../a//span[2]")
    WebElement manageRelationShipTab;
    @FindBy(xpath="//*[@role='application']//button")
    WebElement btn;
    public void clickOnManageRelationShipTab() throws InterruptedException {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(manageRelationShipTab));
        Assert.assertTrue(manageRelationShipTab.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(manageRelationShipTab));
        this.verifyPageIsLoaded();
        manageRelationShipTab.click();
    }
    
    public AddRelationshipInformationPage navigateToAddRelationshipPage() throws InterruptedException {
        this.clickOnManageRelationShipTab();
        return new AddRelationshipInformationPage(driver);
    }
    
    public void selectManage(String manage) {
        this.verifyPageIsLoaded();
        WebElement clickManage=driver.findElement(By.xpath("//a[contains(@aria-label,'"+manage+"')]"));
        this.scrollIntoViewAndClick(clickManage);
    }
    @FindBy(xpath="//*[contains(text(),'Personal')]")
    WebElement personalTxt;
    public void verifyPersonalTab(String expected) {
        log.info("Expected"+expected);
        Assert.assertTrue(expected.equalsIgnoreCase(personalTxt.getText()));
    }
    
    @FindBy(xpath="//*[contains(text(),'Contact')]")
    WebElement contactTxt;
    public void verifyContactInfoTab(String expected) {
        log.info("Expected"+expected);
        Assert.assertTrue(expected.equalsIgnoreCase(contactTxt.getText()));
    }
    @FindBy(xpath="//*[contains(text(),'Phone Information')]")
    WebElement phoneTxt;
    public void verifyPhoneInfoTab(String expected) {
        log.info("Expected"+expected);
        Assert.assertTrue(expected.equalsIgnoreCase(phoneTxt.getText()));
    }
    
    @FindBy(xpath="//*[contains(text(),'Financial ')]")
    WebElement financialTxt;
    public void verifyFinancialInfoTab(String expected) {
        log.info("Expected"+expected);
        Assert.assertTrue(expected.equalsIgnoreCase(financialTxt.getText()));
    }
    @FindBy(xpath="//*[contains(text(),'Employment Information')]")
    WebElement empTxt;
    public void verifyEmpInfoTab(String expected) {
        log.info("Expected"+expected);
    }
    
    @FindBy(xpath="//*[contains(text(),'Military Information')]")
    WebElement militaryTxt;
    public void verifyMilitaryInfoTab(String expected) {
        log.info("Expected"+expected);
    }
    
    @FindBy(xpath="//*[contains(text(),'Manage relationship')]")
    WebElement manageRelationshipTxt;
    public void verifyRelationShipInfoTab(String expected) {
        log.info("Expected"+expected);
    }
    @FindBy(xpath="//*[contains(text(),'Military Information')]/../a//span[2]")
    WebElement manageMiliTaryInfoTab;
    
    public void clickOnManageMilitaryInfoTab() {
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.elementToBeClickable(manageMiliTaryInfoTab));
        this.verifyPageIsLoaded();
        manageMiliTaryInfoTab.click();
    }
    public ManageMilitaryInformationPage navigateToMilitaryInfo() {
        clickOnManageMilitaryInfoTab();
        return new ManageMilitaryInformationPage(driver);
    }

	public void verifyUpdated(String arg) {
		WebElement updatedDetail=driver.findElement(By.xpath("//*[contains(text(),'"+arg+"')]"));
		this.elementVisible(updatedDetail);
	}
	
	public void VerifyAdd(String arg1){
		WebElement UpdtedAdd = driver.findElement(By.xpath("//p[normalize-space()='"+arg1+"']"));
		UpdtedAdd.isDisplayed();
	}
	
    
}
