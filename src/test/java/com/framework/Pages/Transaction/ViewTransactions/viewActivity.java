package com.framework.Pages.Transaction.ViewTransactions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class viewActivity  extends BasePage{
    
    Logger log = LoggerHelper.getLogger(viewActivity.class);
    WebDriver driver;
    public viewActivity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyActivityPage(){
        this.verifyPageIsLoaded();
        Assert.assertTrue(driver.getCurrentUrl().contains("accountholder/activity"));
    }
    @FindBy(xpath="//a[contains(text(),'Back')]")
    WebElement backToAccBttn;
    
    public void clickOnBackToAcc(){
        this.clickOnButton(backToAccBttn);
    }
    
    By cancel=By.id("cancel-transaction-0");
    @FindBy(id="cancel-transaction-0")
    WebElement cancelTransaction;
    @FindBy(id="confirmation-modal-primary-btn")
    WebElement confirmBtn;
    public void clickOnCancelTransaction(){
        Assert.assertTrue(this.isElementPresent(cancel),"No Transactions available to cancel");
        this.clickOnButton(cancelTransaction);
        
    }
    
    @FindBy(xpath="//div[@role='dialog']")
    WebElement dialogBox; 
    
    public void verifyDialogbox(){
        this.elementVisible(dialogBox);
    }
    
    public void clickOnConfirm(){
        this.clickOnButton(confirmBtn);
    }
    
    @FindBy(xpath="//input[@role='combobox']")
    WebElement rangeCombo;
    
    public void clickOnRangeCombo(){
        this.clickOnButton(rangeCombo);
    }
    @FindBy(xpath="//span[contains(text(),'Year')]")
    WebElement year;
    @FindBy(xpath="//span[contains(text(),'Month')]")
    WebElement month;
    @FindBy(xpath="//span[contains(text(),'Week')]")
    WebElement week;
    @FindBy(xpath="//span[contains(text(),'Custom')]")
    WebElement custom;
    public void verifyCombobox(){
        this.elementVisible(year);
        this.elementVisible(month);
        this.elementVisible(week);
        this.elementVisible(custom);
    }
    
    public void selectCombo(String opt){
        switch(opt){
            case "Year" :{
                this.clickOnButton(year);
                break;
            }
            case "Month" :{
                this.clickOnButton(month);
                break;
            }
            case "Week" :{
                this.clickOnButton(week);
                break;
            }
            case "Custom" :{
                this.clickOnButton(custom);
                break;
            }
        }
    }
    @FindBy(xpath="//div[@class='transActivity row']")
    WebElement transActivity;
    public void verifyTransActivity(){
        this.elementVisible(transActivity);
    }
    
    @FindBy(id="filterStartDate")
    WebElement tranActivityStartDate;
    
    public void verifytranActivityStartDate(){
        this.elementVisible(tranActivityStartDate);
    }
    public void settranActivityStartDate(){
        this.setValidDate(tranActivityStartDate);
    }
    
    
    @FindBy(id="tranActivityStartDate-error")
    WebElement startDateerror;
    
    
    public void setBlankDate(WebElement element){
        this.clickOnButton(element);
        this.clickOnButton(tranActivityStartDatehint);
    }
    public void setBlankStartDate(){
        this.setBlankDate(tranActivityStartDate);
    }
    public void setBlankEndDate(){
        this.setBlankDate(tranActivityEndDate);
    }
    
    public void verifyStartDateError(){	
        this.elementVisible(startDateerror);	
    }
    @FindBy(id="tranActivityStartDate-error")
    WebElement EndDateerror;
    
    @FindBy(id="filterEndDate")
    WebElement tranActivityEndDate;
    public void verifytranActivityEndDate(){
        this.elementVisible(tranActivityEndDate);
    }
    
    public void verifyEndDateError(){	
        this.elementVisible(EndDateerror);	
    }
    
    @FindBy(xpath="//div[@aria-disabled='false'][1]")
    WebElement validDate;
    
    public void setValidDate(WebElement element) {
        this.clickOnButton(element);
        this.clickOnButton(validDate);
    }
    public void settranActivityEndDate(){
        this.setValidDate(tranActivityEndDate);	
    }
    
    @FindBy(xpath="//button[@buttontext='Apply Filter']")
    WebElement applyFilterBtn;
    public void checkapplyFilterBtn(String status){    	
        if(status.equalsIgnoreCase("enable"))
            Assert.assertTrue(applyFilterBtn.isEnabled(),"Apply filter is enabled");
        else
            Assert.assertFalse(applyFilterBtn.isEnabled(),"Apply filter is disabled");
    }
    public void clickOnapplyFilterBtn(){
        this.clickOnButton(applyFilterBtn);
        this.verifyPageIsLoaded();
    }
    
    
    public void verifyApplyFilterButton() {
        this.elementVisible(applyFilterBtn);
    }
    
    
    public void verifyBacktoAccountButton() {
        this.elementVisible(backToAccBttn);
    }
    
    public void verifyAccountLink(String account){
        WebElement accLink=driver.findElement(By.xpath("//a[contains(text(),'"+account+"')]"));
        this.elementVisible(accLink);
    }
    
    public void clickOnAccountLink(String account){
        WebElement accLink=driver.findElement(By.xpath("//a[contains(text(),'"+account+"')]"));
        this.clickOnButton(accLink);
    }
    public void confirmCancellation() {
        try{
            WebElement cancelStatus=driver.findElement(By.xpath("//span[text()='cancelled']"));
            Assert.assertTrue(cancelStatus.isDisplayed(),"cancellation updated");
        }
        catch(Exception e){
            Assert.assertTrue(false,"cancellation is not updated");
        }
    }
    @FindBy(id="Start Date-hint")
    WebElement tranActivityStartDatehint;
    @FindBy(id="tranActivityEndDate-hint")
    WebElement tranActivityEndDatehint;
    
    public void verifyDateFormat(String arg1) {
        Assert.assertEquals(tranActivityStartDatehint.getText(), arg1);
        Assert.assertEquals(tranActivityEndDatehint.getText(), arg1);
    }
    
}
