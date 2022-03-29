package com.framework.Pages.Transaction.Exchange;

import java.util.ArrayList;
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

public class FundRulesPage extends BasePage{
    
    Logger log = LoggerHelper.getLogger(FundRulesPage.class);
  
    WebDriver driver;
    public FundRulesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;
    @FindBy(css="button.sc-enOJk.klNStP")
    List<WebElement> listOfFunds;
    
    public void verifyTotalFunds(String totalFunds) {
        log.info("Total funds"+totalFunds);
        int actualCount = listOfFunds.size();
        String actual = String.valueOf(actualCount);
        log.info("Actual Count"+actualCount);
        Assert.assertTrue(totalFunds.equalsIgnoreCase(actual));
    }
    
    public List<String> FundNames() {
        List<String> fundList = new ArrayList<String>();
        fundList.add("USAA Intermediate-Term Bond");
        fundList.add("USAA Science & Technology");
        fundList.add("USAA S&P 500 Index Member Shares");
        fundList.add("USAA Income Stock");
        fundList.add("USAA Short-Term Bond ");
        fundList.add("USAA Growth & Income");
        fundList.add("USAA Aggressive Growth");
        fundList.add("USAA Income");
        fundList.add("USAA Growth");
        fundList.add("USAA Tax Exempt Long-Term");
        fundList.add("USAA Tax Exempt Intermediate-Term");
        fundList.add("USAA Tax Exempt Short-Term");
        fundList.add("USAA Precious Metals and Minerals");
        fundList.add("USAA International");
        fundList.add("USAA Growth and Tax Strategy");
        fundList.add("USAA World Growth");
        fundList.add("USAA Emerging Markets");
        fundList.add("USAA Government Securities");
        fundList.add("USAA Capital Growth");
        fundList.add("USAA Extended Market Index");
        fundList.add("USAA Nasdaq-100 Index");
        fundList.add("USAA Global Equity Income");
        fundList.add("USAA Value");
        fundList.add("USAA Ultra Short-Term Bond");
        fundList.add("USAA High Income");
        fundList.add("USAA Small Cap Stock");
        fundList.add("USAA Global Managed Volatility");
        fundList.add("USAA Cornerstone Aggressive Fund");
        fundList.add("USAA Cornerstone Conservative Fund");
        fundList.add("USAA Cornerstone Equity Fund");
        fundList.add("USAA Cornerstone Moderate Fund");
        fundList.add("USAA Cornerstone Moderately Aggressive Fund");
        fundList.add("USAA Cornerstone Moderately Conservative Fund");
        fundList.add("USAA Money Market Fund");
        fundList.add("USAA Target Retirement 2020 Fund");
        fundList.add("USAA Target Retirement 2030 Fund");
        fundList.add("USAA Target Retirement 2040 Fund");
        fundList.add("USAA Target Retirement 2050 Fund");
        fundList.add("USAA Target Retirement 2060 Fund");
        fundList.add("USAA Target Retirement Income Fund");
        fundList.add("USAA Tax Exempt Money Market Fund");
        fundList.add("USAA Treasury Money Market Trust");
        return fundList;
    }
    @FindBy(xpath="//button[contains(text(),'Investment Selection')]")
    WebElement clickOnInvestmentSel;
    
    public void clickOnInvestMentSelBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(clickOnInvestmentSel));
        clickOnInvestmentSel.click();
    }
    public void clickOnFund(String fundName) {
        log.info("Fund Name"+fundName);
        wait = new WebDriverWait(driver, 40);
        WebElement fundLink = driver.findElement(By.xpath("//button[contains(text(),'"+fundName+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(fundLink));
        fundLink.click();
    }
    
    @FindBy(xpath="//h2[contains(text(),'Dividends and Capital')]")
    WebElement dividentAndCapitalTxt;
    
    public void verifyDividentAndCapitalBlock(String expected) {
        String txt = dividentAndCapitalTxt.getText();
        log.info("Divident And Capital Gain:"+txt);
        log.info("Expected Text"+expected);
        Assert.assertTrue(expected.equalsIgnoreCase(txt));
    }
    
    @FindBy(css="input#no-reinvest")
    WebElement noReinvestRadio;
    
    private void clickOnNoReinvestBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(noReinvestRadio));
        this.selectCheckBox(noReinvestRadio);
    }
    @FindBy(css="input#yes-reinvest")
    WebElement reinvestRadioBtn;
    
    private void clickOnReInvestBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(reinvestRadioBtn));
        this.selectCheckBox(reinvestRadioBtn);
    }
    public void clickOnbackBtn(){
    	this.scrollIntoViewAndClick(backBtn);
    }
    
    @FindBy(xpath="//button[@buttontext='Back']")
	WebElement backBtn;
	
    public void checkVisibilityOfbackBtn() {
        wait = new WebDriverWait(driver, 40);
        this.scrollIntoView(backBtn);
        this.elementVisible(backBtn);
    }

    @FindBy(xpath="//h2[contains(text(),'Select your Mutual Fund')]/../../../following-sibling::div//p")
    WebElement warningMsgForLessThan50Amt;
    
    public void verifyWarningMsgForLessthan50(String msg) {
    	log.info("Warning msg"+msg);
    	wait = new WebDriverWait(driver, 40);
    	wait.until(ExpectedConditions.visibilityOf(warningMsgForLessThan50Amt));
    	log.info("Actual warning msg" +warningMsgForLessThan50Amt.getText());
    	Assert.assertTrue(msg.equalsIgnoreCase(warningMsgForLessThan50Amt.getText()));
    }
    
    public void verifyFundsWith$500Amt() {
    	log.info("Expected"+this.getFundsBy$500Amount().size());
    	log.info("Actual"+this.getFundsof500Amt().size());
    	Assert.assertEquals(this.getFundsof500Amt().size(), this.getFundsBy$500Amount().size());
    }
    
    @FindBy(xpath="//span[contains(text(),'$ 500 / $ 50 with $ 50 monthly')]/../../../..//button[contains(text(),'USAA')]")
    List<WebElement> list;
    public List<WebElement> getFundsof500Amt() {
    	log.info("Size of list"+list.size());
    	return list;
    }
    public List<String>getFundsBy$500Amount() {
    	List<String>list = new ArrayList<>();
    	list.add("USAA Cornerstone Aggressive Fund");
    	list.add("USAA Cornerstone Conservative Fund");
    	list.add("USAA Cornerstone Equity Fund");
    	list.add("USAA Cornerstone Moderate Fund");
    	list.add("USAA Cornerstone Moderately Aggressive Fund");
    	list.add("USAA Cornerstone Moderately Conservative Fund");
    	list.add("USAA Target Retirement 2020 Fund");
    	list.add("USAA Target Retirement 2030 Fund");
    	list.add("USAA Target Retirement 2040 Fund");
    	list.add("USAA Target Retirement 2050 Fund");
    	list.add("USAA Target Retirement 2060 Fund");
    	list.add("USAA Target Retirement Income Fund");
    	return list;
    }
    @FindBy(xpath="//span[contains(text(),'$ 1,000 / $ 50 with $ 50 monthly')]/../../../..//button")
    WebElement fundName;
    public void verifyFundWith$1000AmountisDisplayed() {
    	log.info("Actual"+fundName.getText());
    	log.info("Expected"+getFundsBy$1000Amount());
    	Assert.assertTrue(fundName.getText().contains(getFundsBy$1000Amount()));    	
    }
    public String getFundsBy$1000Amount() {
    	return "USAA Money Market Fund";    	
    }
    @FindBy(xpath="//span[contains(text(),'$ 3000 / $ 3000 with $ 50 monthly')]/../../../..//button")
    List<WebElement>fundList; 
    
    public List<String>getFundswith$3000Amount() {
    	List<String>list = this.fundsListBy$3000Amount();
    	for(int i=0;i<fundList.size();i++) {
    		list.add(fundList.get(i).getText());
    	}
    	return list;
    }
    public List<String> fundsListBy$3000Amount() {
    	List<String> list= new ArrayList<>();
    	list.add("USAA Intermediate-Term Bond");
    	list.add("USAA Science & Technology");
    	list.add("USAA S&P 500 Index Member Shares");
    	list.add("USAA Income Stock");
    	list.add("USAA Short-Term Bond ");
    	list.add("USAA Growth & Income");
    	list.add("USAA Aggressive Growth");
    	list.add("USAA Income");
    	list.add("USAA Growth");
    	list.add("USAA Tax Exempt Long-Term");
    	list.add("USAA Tax Exempt Intermediate-Term");
    	list.add("USAA Tax Exempt Short-Term");
    	list.add("USAA Precious Metals and Minerals");
    	list.add("USAA International");
    	list.add("USAA Growth and Tax Strategy");
    	list.add("USAA World Growth");
    	list.add("USAA Emerging Markets");
    	list.add("USAA Government Securities");
    	list.add("USAA Capital Growth");
    	list.add("USAA Extended Market Index");
    	list.add("USAA Nasdaq-100 Index");
    	list.add("USAA Global Equity Income");
    	list.add("USAA Value");
    	list.add("USAA Ultra Short-Term Bond");
    	list.add("USAA High Income");
    	list.add("USAA Small Cap Stock");
    	list.add("USAA Global Managed Volatility");
    	return list;	
    }
    public void verifyFundsWith3000Amount() {
    	List<String> actual = this.getFundswith$3000Amount();
    	List<String>expected = this.fundsListBy$3000Amount();
    	for(int i =0;i<actual.size();i++) {
    		for(int j=0;j<expected.size();j++)
    		if(actual.get(i).contains(expected.get(j))) {
    			log.info("Actual"+actual.get(i));
    			log.info("Expected"+expected.get(j));
    		}
    	}
    }
    
    public void verifyFundWithAmount(String fundName) {
    	log.info("Fund Name"+fundName);
    	WebElement element =driver.findElement(By.xpath("//*[text()='"+fundName+"']"));
    	Assert.assertTrue(element.isDisplayed());
    	log.info(element.isDisplayed());
    }
}
