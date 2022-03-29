package com.framework.Pages.DocumentCenter;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
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
public class DocumentCenterPage extends BasePage{
    WebDriverWait wait;
    WebDriver driver;
    public  DocumentCenterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logger log = LoggerHelper.getLogger(DocumentCenterPage.class);
    
    @FindBy(xpath="//h1[text()='Document Center']")
    WebElement DocumentCenterPage;
    
    public void verifyDocumentCenterPage(String txt) {
        log.info(txt);
        log.info(DocumentCenterPage.getText());
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(DocumentCenterPage));
        Assert.assertTrue(DocumentCenterPage.getText().equalsIgnoreCase(txt));
    }
    @FindBy(xpath="//div[text()='Document Preferences']")
    WebElement DocumentPreferences;
    public void CheckDocumentPreferences(){
        Assert.assertTrue(DocumentPreferences.isDisplayed());
    }
    public DocumentPreferencesPage navigateToDocumentPreferences(){
        this.verifyPageIsLoaded();
        this.clickOnButton(DocumentPreferences);
        return new DocumentPreferencesPage(driver);
    }
    
    @FindBy(xpath="//div[text()='Download Adobe Reader']")
    WebElement DownloadAdobeReader;
    public void CheckDownloadAdobeReader() {
        Assert.assertTrue(DownloadAdobeReader.isDisplayed());
    }
    @FindBy(xpath="//div[normalize-space()='Help & FAQ's']")
    
    WebElement HelpFaqs;
    public void CheckHelpFaqs(){
        Assert.assertTrue(HelpFaqs.isDisplayed());  	  
    }
    public void clickOnFaqLink(){
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(HelpFaqs));
        HelpFaqs.click();
    }
    
    @FindBy(xpath="//*[@id='Sort by Date']")
    WebElement SortbyDate;
    
    @FindBy(xpath="//*[text()='Ascending']")
    WebElement Ascending;
    @FindBy(xpath="//*[text()='Descending']")
    WebElement Descending;
    @FindBy(xpath="//*[contains(text(),'Select')]")
    WebElement selectOption;
    
    public void CheckSortByDateMenu(){
        this.verifyPageIsLoaded();
        Assert.assertTrue(SortbyDate.isDisplayed());
        this.clickOnButtonUsingJs(SortbyDate);
        
        Assert.assertTrue(selectOption.isDisplayed());
        Assert.assertTrue(Ascending.isDisplayed());
        Assert.assertTrue(Descending.isDisplayed());
    }
    
    @FindBy(xpath="//*[text()='Filter Documents']")
    WebElement Filterdocuments;
    public void CheckFilterdocuments() {
        Assert.assertTrue(Filterdocuments.isDisplayed());
    }
    public FilterdocumentsPage Navigatetofilterdocuments(){
        this.verifyPageIsLoaded();
        Filterdocuments.click();
        return new FilterdocumentsPage(driver);
    }
    
    @FindBy(xpath="//h1[contains(text(),'Document Center')]/../following-sibling::div[2]//a//span//span[contains(text(),'Download')]")
    WebElement downloadLink;
    public void verifyDownloadDocuments() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        downloadLink.click();
        new WebDriverWait(driver,40).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))	{
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("blob:https:"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }
    
    @FindBy(xpath="//*[contains(text(),'Category')]//following-sibling::div")
    WebElement categoryTxt;
    public void verifyCategoryField(String expected) {
        log.info("Expected"+expected);
        log.info("Actual" +categoryTxt.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(categoryTxt.getText()));
    }
    @FindBy(xpath="//*[contains(text(),'No Documents')]")
    WebElement noDocumentsAvailableTxt;
    public void verifyDocoumentNotAvailableMsg(String expected) {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(noDocumentsAvailableTxt));
        log.info("Expected"+expected);
        log.info("Actual" +noDocumentsAvailableTxt.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(noDocumentsAvailableTxt.getText()));
    }
    @FindBy(xpath="//*[contains(text(),'Marketing')]/parent::div/parent::div//div[contains(text(),'Document Date')]/following-sibling::div")
    WebElement dateTxt;
    public void verifyDocumentDate(String expected) {
        log.info("Expected"+expected);
        log.info("Actual" +dateTxt.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(dateTxt.getText()));
    }
    @FindBy(xpath="//div[@class='actualdocuments']//div[@role='list']//div[@role='listitem'][1]//div[2]//a")
    WebElement documentIcon;
    
    public void clickOnDocumentIcon() {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.elementToBeClickable(documentIcon));
        this.clickOnButtonUsingJs(documentIcon);
        
    }
    @FindBy(xpath="//*[contains(@class,'document-center-main')]//div[@role='list']//div[1]//div//a//img")
    WebElement documentImage;
    public void clickOnDocumentImage() {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(documentImage));
        documentImage.click();
    }
    public void  verifyDownloadDocImgDisplaying() {
        Assert.assertTrue(documentImage.isDisplayed());
    }
    public void verifyDocumentOpenedInNewTab() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        this.clickOnDocumentImage();
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("blob:https:"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);   
    }
    public void verifyGuestDashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("accountguestview"));
    }
    @FindBy(xpath="//ol//li//a[@href='/accountguestview']")
    WebElement homeLink;
    
    public void clickOnHomeLink() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(homeLink));
        homeLink.click();
    }
    @FindBy(xpath="//*[contains(text(),'Download Adobe Reader')]")
    WebElement downloadAdobeLink;
    public void verifyDownloadAdobeReaderPage() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        this.clickOnButtonUsingJs(downloadAdobeLink);
        
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("https://get2.adobe.com/"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }
    public void verifyDownloadAdobeLink() {
        Assert.assertTrue(downloadAdobeLink.isDisplayed());
    }
    @FindBy(xpath="//h1[contains(text(),'Document Center')]/../following-sibling::div[2]//div[2]//div[contains(text(),'Account')]")
    WebElement accountTitle;
    public void verifyAccountTitle(String expected) {
        log.info("Expected"+expected);
        log.info("Actual" +accountTitle.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(accountTitle.getText())); 
    }
    @FindBy(xpath="//h1[contains(text(),'Document Center')]/../following-sibling::div[2]//div[2]//div[contains(text(),'Document Date')]")
    WebElement documentDateTitle;
    public void verifyDocumentDateTitle(String docdate) {
        log.info("Expected"+docdate);
        log.info("Actual" +documentDateTitle.getText());
        Assert.assertTrue(docdate.equalsIgnoreCase(documentDateTitle.getText())); 
    }
    @FindBy(xpath="//h1[contains(text(),'Document Center')]/../following-sibling::div[2]//div[2]//div[contains(text(),'Category')]")
    WebElement categoryField;
    public void verifycategoryTxt(String cat) {
        log.info("Expected"+cat);
        log.info("Actual" +categoryField.getText());
        Assert.assertTrue(cat.equalsIgnoreCase(categoryField.getText()));   
    }
    
    @FindBy(xpath="//p[contains(text(),'The Document Center has your account')]")
    WebElement docCenterMsg;
    public void verifyDocMessageisDisplayed() {
    	Assert.assertTrue(docCenterMsg.isDisplayed());
    	log.info("Document center message is displayed ......");
    }
    
    @FindBy(xpath="//p[contains(text(),'Documents are in PDF format and can be read')]")
    WebElement docCenterFormatMsg;
    public void verifyDocMessageFormatisDisplayed() {
    	Assert.assertTrue(docCenterFormatMsg.isDisplayed());
    	log.info("Document center message format is displayed ......");
    }
    
    @FindBy(xpath="//span[contains(text(),'Access your Documents')]")
    WebElement accessDocsLink;
    
    public void clickOnAccessDocumentLink() {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.elementToBeClickable(accessDocsLink));
        this.clickOnButtonUsingJs(accessDocsLink);
        
    }
}
