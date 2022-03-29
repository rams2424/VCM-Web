package com.framework.Pages.DocumentCenter;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;


public class FilterdocumentsPage extends BasePage{
    WebDriver driver;	  
    public  FilterdocumentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logger log = LoggerHelper.getLogger(FilterdocumentsPage.class);
    
    @FindBy(xpath="//span[contains(text(),'APPLY FILTER')]")
    WebElement applyFilterBtn;
    public void CheckApplyButton() {
        if(!this.ElementEnable(applyFilterBtn)){
            Assert.assertFalse(applyFilterBtn.isEnabled(),"Apply Button is disabled");
        }
        else{
            log.error(applyFilterBtn+" is enabled");
        }
    }
    public DocumentCenterPage ClickOnApplyFilterBtn(){
        applyFilterBtn.click();
        return new DocumentCenterPage(driver);
    }
    @FindBy(xpath="//span[contains(text(),'Clear Filters')]")
    WebElement clearFiltersBtn;
    public void ClickOnClearFilterBtn(){
        clearFiltersBtn.click();
    }
    
    @FindBy(xpath="//input[@id='Start Date']")
    WebElement startDate;
    
    public void from_Date(String Day,String MonthwithDate,String year, String MonthYear) throws InterruptedException {
        startDate.click();    
        while(true) {
            if(MonthYear.contains(driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]")).getText())) {
                WebElement dat=driver.findElement(By.xpath("//div[@aria-label='Choose "+Day+", "+MonthwithDate+", "+year+"']"));
                dat.click();
                break;
            } else {
                driver.findElement(By.xpath("//button[@aria-label='Previous Month']")).click();
            }
        }           
       
    }
    
    @FindBy(xpath="//*[contains(text(),'End Date')]/../div[2]//input")
    WebElement endDate;
    public void End_Date(String Day,String MonthwithDate,String year, String MonthYear) throws InterruptedException {
        endDate.click();
        WebElement Currentmonth=driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));    
        while(true) {
            if(MonthYear.contains(driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]")).getText())){
                WebElement dat=driver.findElement(By.xpath("//div[@aria-label='Choose "+Day+", "+MonthwithDate+", "+year+"']"));
                dat.click();
                break;
            } else {
                driver.findElement(By.xpath("//button[@aria-label='Previous Month']")).click();
            }
        }           
    }
    public void TaxDocumentDateRange() {
        String Start=  startDate.getText();
        String End= endDate.getText();
        log.info("Start Date is"+Start);
        log.info("End Date is"+End);
    }
    @FindBy(xpath="//*[@id='Category']/../div//div//div//label")
    List<WebElement>filterCategory;
    
    public void verifyAllFilterCatoryIsDisplaying(String st,String trade,String tax,String acc,String general,String other) {
        List<String> expected = new ArrayList<String>();
        log.info(st);
        expected.add(st);
        log.info(trade);
        expected.add(trade);
        log.info(tax);
        expected.add(tax);
        expected.add(acc);
        log.info(acc);
        expected.add(general);
        log.info(general);
        expected.add(other);
        log.info(other);
        List<String>actual = new ArrayList<>();
        for(WebElement w:filterCategory) {
            actual.add(w.getText());
        }
        Assert.assertTrue(expected.equals(actual));   
    }
    @FindBy(xpath="//h2[contains(text(),'Filter Documents')]")
    WebElement filterDocTxt;
    public void verifyFilterDocumentPopup(String expected) {
        log.info("Expected"+expected);
        log.info("Actual"+filterDocTxt.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(filterDocTxt.getText()));
    }
    public void verifyApplyFilterButton() {
        Assert.assertTrue(applyFilterBtn.isDisplayed());
    }
    public void verifyClearFiltersBtnIsDisplaying() {
        Assert.assertTrue(clearFiltersBtn.isDisplayed());
    }
    public void verifyStartDateField() {
        Assert.assertTrue(startDate.isDisplayed());
    }
    public void verifyEndDateField() {
        Assert.assertTrue(endDate.isDisplayed());
    }
    @FindBy(xpath="//label[contains(text(),'* We are working to provide access to your histori')]")
    WebElement documentRangeTxt;
    public void verifyDocumentRangeMsg(String expected) {
        log.info("Expected"+expected);
        log.info("Actual" +documentRangeTxt.getText());
        Assert.assertTrue(documentRangeTxt.getText().contains(expected));
    }
    public void clickOnSpecificCategory(String catName) {
        log.info("Category Name"+catName);
        for(WebElement e :filterCategory) {
            if(e.getText().equalsIgnoreCase(catName)) {
                WebElement element =  e.findElement(By.xpath("//*[@id='Category']/../div//div//div//label/../input[@name='"+catName+"']")) ;  
                element.click();
            }
        }
    }
    public void verifyStartDate(String expected) {
        log.info("Expected"+expected);
        String dateTxt = startDate.getAttribute("value");
        log.info("Actual"+dateTxt);
        Assert.assertTrue(expected.equalsIgnoreCase(dateTxt));
    }
    public void verifyEndDate(String expected) {
        log.info("Expected"+expected);
        String dateTxt = endDate.getAttribute("value");
        log.info("Actual"+dateTxt);
        Assert.assertTrue(expected.equalsIgnoreCase(dateTxt));
    }
    public void enterStartDate(String txt) {
        startDate.sendKeys(txt);
        startDate.sendKeys(Keys.ENTER);
    }
    public void enterEndDate(String txt){
        endDate.sendKeys(txt);
        endDate.sendKeys(Keys.ENTER);
    }
    @FindBy(css="span.errorMsgInputStyle")
    WebElement errorMessageTxt;
    public void verifyErrorMessageForMoreThan1Year(String expected) {
        log.info("Expected"+expected);
        log.info("Actual"+errorMessageTxt.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(errorMessageTxt.getText()));
    }
}