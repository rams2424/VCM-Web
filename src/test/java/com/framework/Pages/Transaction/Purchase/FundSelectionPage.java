package com.framework.Pages.Transaction.Purchase;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class FundSelectionPage extends BasePage{
    
    Logger log = LoggerHelper.getLogger(FundSelectionPage.class);
    WebDriverWait wait;
    WebDriver driver;
    
    public FundSelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//span[contains(text(),'2.  Investment Selection')]")
    WebElement verifyFundAccountPage; 
    
    public void verifyFundSelection() {
        Assert.assertEquals(verifyFundAccountPage.getText(), "2. Investment Selection","Verified Fund Your Account Page");
        log.info("Verified Fund Your Account Page");   
    }
    
    @FindBy(xpath="//button[@buttontext='Back']")
    WebElement backBtn;
    
    public void checkVisibilityOfbackBtn() {
        wait = new WebDriverWait(driver, 40);
        this.scrollIntoView(backBtn);
        this.elementVisible(backBtn);
    }
    
    public void clickOnbackBtn(){
        this.scrollIntoViewAndClick(backBtn);
    }
    
    By MutualFundType=By.xpath("//button[@role='radio']");
    
    
    
    @FindBy(xpath="//div[@id='Select your Mutual Fund']//span[text()='Existing Fund']/../../following-sibling::div//div//div[5]//span[2]")
    List<WebElement> ExistingFund;
    
    
    public void clickOnExistingFund() {		
        this.clickOnButton(ExistingFund.get(0));
        log.info("Clicked on Existing Fund");
        ExistingFund.get(0).sendKeys(Keys.TAB);
    }
    @FindBy(id="fundingOption")
    WebElement fundingOption;
    public void verifyDropdown(String arg1, String arg2) {
        this.elementVisible(fundingOption);
        this.clickOnButton(fundingOption);
        List<WebElement> dropdownValues=driver.findElements(By.xpath("//span[@role='option']"));
        if(dropdownValues.get(0).getText().equalsIgnoreCase(arg1) && dropdownValues.get(1).getText().equalsIgnoreCase(arg2)){
            Assert.assertTrue(true, "Dropdown Verified");
            log.info("Verified Dropdowns");
        }
        else{
            Assert.assertTrue(false, "Dropdown Verified");
            log.error("Verification of dropdown failed");
        }
        
        this.clickOnButton(VerifyRemoveBttn);
    }
    
    public void selectFromDropdown(String arg1) {
        this.clickOnButton(fundingOption);
        WebElement dropdownValues=driver.findElement(By.xpath("//span[text()='"+arg1+"']"));
        this.clickOnButton(dropdownValues);
    }
    
    
    @FindBy(id="#initialInvest")
    WebElement initialInvest;
    
    
    
    @FindBy(id="#initialInvestinputErrorText")
    WebElement initialInvestinputErrorText;
    
    
    public void verifyMinAmountErrorMessage() {
        this.sendKeys(initialInvest, "10");
        
        this.clickOnButton(VerifyRemoveBttn);
        this.elementVisible(initialInvestinputErrorText);
    }
    
    @FindBy(id="#monthlyInvest")
    WebElement monthlyInvest;
    
    
    @FindBy(id="#monthlyInvestinputErrorText")
    WebElement monthlyInvestinputErrorText;
    
    public void verifyMinAmountMonthlyErrorMessage() {
        this.sendKeys(monthlyInvest, "10");
        
        this.clickOnButton(VerifyRemoveBttn);
        this.elementVisible(monthlyInvestinputErrorText);
    }
    
    @FindBy(xpath="//button[@data-test='remove-fund']")
    WebElement removeBttn;
    
    @FindBy(xpath="//td[@class='fundUrInvCol1']")
    WebElement VerifyRemoveBttn;
    
    public void verifyRemoveBtnClick() {
        try{
            if(VerifyRemoveBttn.isDisplayed()){
                Assert.assertTrue(false,"Remove Button Verification failed");
                log.error("Remove Button Verification failed");
            }
        }
        catch(Exception e){
            Assert.assertTrue(true,"Verified remove button");
            log.info("Verified remove button");
        }
    }
    
    public void clickOnRemoveBtn() {
        this.clickOnButton(removeBttn);
    }
    @FindBy(id="startDate")
    WebElement startDate;
    
    @FindBy(xpath="//div[@tabindex='-1']/button[2]")
    WebElement prevDateBttn;
    
    @FindBy(xpath="//button[text()='Ok']")
    WebElement okBttn;
    
    @FindBy(id="startDate-error")
    WebElement startDateerror;
    
    public void setPastDate(){
        this.clickOnButton(startDate);
        this.clickOnButton(VerifyRemoveBttn);  	
    }
    public void verifyPastDateError(){	
        this.elementVisible(startDateerror);	
    }
    
    public void enterInitialValue(String arg1) {
        this.clearAndSendKeys(initialInvest, arg1);
    }
    public void enterMonthlyValue(String arg1) {
        this.clearAndSendKeys(monthlyInvest, arg1);
    }
    
    public void verifyTotalfield(String arg1, String arg2) {
        this.elementVisible(driver.findElement(By.xpath("//div[@class='dollar1' and contains(text(),'"+arg1+".00')]")));
        this.elementVisible(driver.findElement(By.xpath("//div[@class='dollar1' and contains(text(),'"+arg2+".00')]")));
    }
    
    @FindBy(xpath="//img[@alt='Load More']")
    WebElement viewMore;
    public void checkVisibilityOfViewmore() {
        this.scrollIntoView(viewMore);
        this.elementVisible(viewMore);
    }
    public void clickOnViewMore(){
        this.scrollIntoViewAndClick(viewMore);
    }
    public void clickOnNonExistingFund() {
        this.clickOnViewMore();
        try{
            List<WebElement> nonExistingFund=driver.findElements(By.xpath("//button[contains(@aria-label,'Fund Name')][not(contains(.//span, 'Existing'))]"));
            this.clickOnButton(nonExistingFund.get(0));
            log.info("Selected new funds");
        }
        catch(Exception e){
            log.info(e.getMessage());
            this.clickOnNonExistingFund();
        }
    }
    
    public void checkMonthlyAndStarDate() {
        this.elementVisible(startDate);
        this.elementVisible(monthlyInvest);
    }
    @FindBy(css="button[buttontext='Next']")
    WebElement nextBtn;
    public void clickOnNextBtn(){
        this.scrollIntoViewAndClick(nextBtn);
    }	
    public FundingOption navigateToFundingOption(){
        this.clickOnNextBtn();
        return new FundingOption(driver);
    }
    
    @FindBy(xpath="//div[@aria-disabled='false'][1]")
    WebElement validDate;
    
    public void setValidDate() {
        this.clickOnButton(startDate);
        this.clickOnButton(validDate);
    }
    @FindBy(css="input#startDate")
    WebElement startDateField;
    public void enterStartDate(String date) {
        startDateField.sendKeys(date);
        startDateField.sendKeys(Keys.ENTER);
    }
    
}
