package com.framework.Pages.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.AlertHelper.AlertHelper;
import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;
import com.framework.Pages.HomePage;
import com.framework.Pages.Transaction.Exchange.ExchangePage;


public class TransactionPage extends BasePage {
    WebDriver driver;
    public TransactionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(TransactionPage.class);
    
    AlertHelper alertHelper = new AlertHelper(driver);
    @FindBy(xpath="//div[@class='trans-table-start']")
    WebElement fundAccounts;
    
    @FindBy(xpath="//a[contains(text(),'Back to My Portfolio')]")
    WebElement backToPortfolio;    
    @FindBy(xpath="//a[text()='Dashboard']")
    WebElement clickOnDashBoardLink;
    
    public void clickOnDashBoardLink() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(clickOnDashBoardLink));
        this.clickOnButton(clickOnDashBoardLink);
    }
    
    
    public void clickOnAccountType(String accountType) {
        log.info("Account Type"+accountType);
        WebElement accountTypeLink = driver.findElement(By.xpath("//div[contains(text(),'"+accountType+"')]"));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(accountTypeLink));
        accountTypeLink.click();
    }
    @FindBy(xpath="//*[contains(text(),'Cancel')]")
    WebElement cancelBtn;
    
    
    @FindBy(xpath="//*[contains(text(),'Next')]")
    WebElement nextBtn;
    public void clickOnNextBtn(){
        wait = new WebDriverWait(driver, 40);
        this.elementVisible(nextBtn);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        nextBtn.click();
    }
    public ExchangePage navigateToExchangePage() {
        return new ExchangePage(driver);
    }
    
    @FindBy(xpath="//*[@href='/exchange']")
    WebElement exchangeBtn;
    
    public void verifyExchangeBtnVisible() {
        wait = new WebDriverWait(driver, 40);
        
    }
    public void clickOnExchangeBtn() throws InterruptedException {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.visibilityOf(exchangeBtn));
        wait.until(ExpectedConditions.elementToBeClickable(exchangeBtn));
        	this.clickOnButtonUsingJs(exchangeBtn);
    }
    
    
    public void verifyNextButtonIsenable() {
        this.ElementEnable(nextBtn);
    }
    
    @FindBy(xpath="//div[@role='dialog']")
    WebElement cancelPopup;
    
    public void checkVisibilityOfCancelPopup() {
        Assert.assertTrue(cancelPopup.isDisplayed());
    }
    
    public void checkVisibilityOfCancelButton() {
        Assert.assertTrue(cancelBtn.isDisplayed());
    }
    
    public void clickOnCancelBtn(){
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(cancelBtn));
        this.scrollIntoViewAndClick(cancelBtn);
    }
    
    public void checkVisibilityOfNextButton() {
        Assert.assertTrue(nextBtn.isDisplayed());
    }
    
    @FindBy(xpath="//a[text()='Portfolio']")
    WebElement PortfolioLink;
    
    public void clickOnPortfolio(){  
        Assert.assertTrue(PortfolioLink.isDisplayed());
        this.clickOnButton(PortfolioLink);
    }
    @FindBy(css="button#statusMsgClose")
    WebElement statusCloseBtn;
    public void clickOnStatusCloseBtn() {
        if(driver.findElement(By.cssSelector("button#statusMsgClose")).isDisplayed()) {
            wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.visibilityOf(statusCloseBtn));
            this.clickOnButton(statusCloseBtn);
        }
    }
    public void CheckNextButton() {
        if(!this.ElementEnable(nextBtn)){
            Assert.assertFalse(nextBtn.isEnabled(),"Next Button is disabled");
        }
        else{
            log.error(nextBtn+" is enabled");
        }
    }
    
    @FindBy(xpath="//div[contains(text(),'52 week Min./ Max. Values')]/../span//div")
    WebElement weekstxt;
    public void verify52WeeksTxt(String expected){
        log.info("Expected"+expected);
        log.info("Actual"+weekstxt.getText());
        Assert.assertTrue(weekstxt.getText().contains(expected));
    }
    
    @FindBy(xpath="//button[@data-analytic-id='confirmation-modal-cancel']")
    WebElement noBtn;
    
    public void clickOnNoBtn() {
        this.clickOnButton(noBtn);
    }
    @FindBy(xpath="//button[@buttontext='Yes']")
    WebElement yesBtn;
    
    public void clickOnCancel() {
        this.clickOnelement(cancelBtn);
    }
    public void cancelTransaction() {
        String parent=driver.getWindowHandle();
        this.clickOnCancel();
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())	{
            String child_window=I1.next();
            if(!parent.equals(child_window))	{
                driver.switchTo().window(child_window);
                log.info(driver.switchTo().window(child_window).getTitle());
                yesBtn.click();
            }
        }
    }
    public HomePage clickOnYesBtn() {
        wait = new WebDriverWait(driver, 40);
        this.elementVisible(yesBtn);
        this.clickOnButton(yesBtn);
        return new HomePage(driver);
    }
    
    public void verifyCancelButtonIsDisplayed() {
        Assert.assertTrue(cancelBtn.isDisplayed());
    }
    @FindBy(xpath="//span[normalize-space()='Show all Funds']")
    WebElement loadMoreBtn;
    public void verifyLoadMoreBtnIsDisplayed() {
        Assert.assertTrue(loadMoreBtn.isDisplayed());
    }
    public HomePage  navigateToHomePage() {
        return new HomePage(driver);
    }
    
    public void CheckVisibilityOf_FundsAccount(){
        this.elementVisible(fundAccounts);
    }
    
    public void clickOn_BacktoPortfolio(){
        this.clickOnButton(backToPortfolio);
    }
    
    public void verifyTransactionPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("transactions"));
        log.info("Navigated to Transaction Page");
    }
    @FindBy(xpath="//div[@class='rectangle']")
    List<WebElement> Ticker;
    
    @FindBy(xpath="//div[contains(text(),'View Details')]")
    WebElement viewDetails;
    @FindBy(xpath="//div[contains(text(),'Buy')]")
    WebElement buy;
    @FindBy(xpath="//div[contains(text(),'Sell')]")
    WebElement sell;
    @FindBy(xpath="//div[contains(text(),'Exchange')]")
    WebElement exchange;
    
    public void verifyTickerDropdown(String arg1, String arg2, String arg3, String arg4) {
        this.elementVisible(buy);
        this.elementVisible(sell);
        this.elementVisible(exchange);
        this.elementVisible(viewDetails);
    }
    
    public void verifyTradeDropdown(String arg1) {
        this.elementVisible(buy);
        By selll= By.xpath("//div[contains(text(),'Sell')]");
        By exch= By.xpath("//div[contains(text(),'Exchange')]");
        Assert.assertFalse(this.isElementPresent(selll));
        Assert.assertFalse(this.isElementPresent(exch));
    }
    public void clickOnTickerBttn() {
        this.clickOnButton(Ticker.get(0));
    }
    
    public void verifyTickerBttn() {
        this.elementVisible(Ticker.get(0));
    }
    @FindBy(id="tradeButton")
    WebElement tradeBttn;
    public void verifyTradeDropdown(String arg1, String arg2, String arg3) {
        this.elementVisible(buy);
        this.elementVisible(sell);
        this.elementVisible(exchange);
    }
    
    public void clickOnTradeBttn() {
        this.clickOnButton(tradeBttn);
    }
    
    public void verifyTradeBttn() {
        this.elementVisible(tradeBttn);
    }
    @FindBy(xpath="//span[contains(text(),'Current Value')]//following::p[1]")
    WebElement curVal;
    public void verifyCurrentValue() {
        Assert.assertTrue(curVal.getText().equals("11"));
    }
    
    public void navigateTo(String option){
        WebElement opt=driver.findElement(By.xpath("//div[contains(text(),'"+option+"')]"));
        this.clickOnButton(opt);
    }
    @FindBy(xpath="//a[@href='#quickFacts']")
    WebElement summary;
    
    public void verifyViewDetails() {
        this.verifyPageIsLoaded();
        this.elementVisible(summary);
    }
    @FindBy(xpath="//a[@href='/accountholder/activity']")
    WebElement viewActivity;
    
    public void clickOnViewActivity(){
        this.clickOnButton(viewActivity);
    }
    public void clickOnExistingFund1(String fundName) {
        log.info("Fund Name"+fundName);
        wait = new WebDriverWait(driver, 40);
        List<WebElement> existingFund =  driver.findElements(By.xpath("//*[text()='"+fundName+"']/../following-sibling::div//div//div[4]//span[1]//div"));	
        wait.until(ExpectedConditions.elementToBeClickable(existingFund.get(0)));
        existingFund.get(0).click();
    }
}
