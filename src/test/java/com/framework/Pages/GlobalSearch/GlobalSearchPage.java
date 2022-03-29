package com.framework.Pages.GlobalSearch;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.ConfigReader.PropertyFileReader;
import com.framework.Pages.BasePage;

public class GlobalSearchPage extends BasePage{
	PropertyFileReader reader = new PropertyFileReader();
    Logger log = Logger.getLogger(GlobalSearchPage.class);
    WebDriver driver;
    WebDriverWait wait;
    public GlobalSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }
    
    @FindBy(xpath="//input[@placeholder='How can we help on this day?']")
    WebElement searchBox;
    public void verifySearchbox(){
        this.elementVisible(searchBox);
    }
    public void enterSearchValue(String searchVlaue){
    	try{
        searchBox.sendKeys(searchVlaue);

    	WebElement element=driver.findElement(By.id("async-example-item-0"));
    	this.clickOnButtonUsingJs(element);
        searchBox.sendKeys(Keys.ENTER);
    	}
    	catch(Exception e){
    		this.enterSearchText(searchVlaue);		
    	}
    }
    @FindBy(xpath="//button[@data-test='clearSearchButton']")
    WebElement clearBttn;
    public void verifyClearBttn(){
        this.elementVisible(searchBox);
    }
    public void clickOnClearBttn(){
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(clearBttn));
        this.clickOnButtonUsingJs(clearBttn);
    }
    public void verifyClearTextBox(){
        String actual=searchBox.getAttribute("value").toString();
        Assert.assertTrue(actual.equals(""));
    }
    
    public void setProxy(){
    	   String baseUrl="";
	    
    	   if(reader.getEnv().equalsIgnoreCase("SIT")) {
    		   baseUrl = "https://victory:L@unch123@qa.investor.vcm.com/search-results?searchTerm=Victory%20RS%20Select%20Growth%20Fund";
          }
          else if(reader.getEnv().equalsIgnoreCase("UAT")) {     
        	  baseUrl = "https://victory:St@ge123@stage.investor.vcm.com/search-results?searchTerm=Victory%20RS%20Select%20Growth%20Fund";
              }
    	   driver.get(baseUrl);        
    }
    @FindBy(xpath="//h5[text()='Recent Searches']")
    WebElement recentSearchHeading;
    
    public void verifyRecentSearch(){
        this.elementVisible(recentSearchHeading);
    }
    @FindBy(id="search-term")
    WebElement searchResults;
    
    public void verifySearchResult(){
        this.elementVisible(searchResults);
        log.info("verify Search results");
    }
    
    @FindBy(xpath="//div[@id='searchHistory']/ul/li/a[1]")
    WebElement recentSearch;
    
    public void clickOnRecentSearch(){
        
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(recentSearch));
        recentSearch.click();
        
    }
    
    @FindBy(xpath="//span[@aria-label='Search']/img")
    WebElement globalSearch;
    @FindBy(xpath="//img[@alt='search']")
    List<WebElement> searchIcon;
    @FindBy(xpath="//img[@class='cookie_close']")
    WebElement closeCookieBtn;
    public void clickonSearchIcon() {
    	if(this.isElementPresent(By.xpath("//img[@class='cookie_close']")) && driver.findElement(By.xpath("//img[@class='cookie_close']")).isDisplayed()) {
            wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.elementToBeClickable(closeCookieBtn));
            this.clickOnButtonUsingJs(closeCookieBtn);
        }
    	try{
    		wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.elementToBeClickable(searchIcon.get(0)));
    		Assert.assertTrue(searchIcon.get(0).isDisplayed());
    		searchIcon.get(0).click();
    	}
    	catch (Exception e){
    		log.info(e);
        	WebElement element=driver.findElement(By.xpath("//span[@aria-label='Search']/img"));
        	wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Assert.assertTrue(element.isDisplayed());
        	element.click();
            
  
    	}
    }
    
    @FindBy(xpath="//span[text()='Close']")
    WebElement closeBtn;
    public void clickonCloseBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
        this.clickOnButtonUsingJs(closeBtn);
    }
    @FindBy(id="nav-txt-search")
    WebElement searchTextBox;
    
    public void enterSearchText(String searchVlaue) {
    	try{
    		searchTextBox.sendKeys(searchVlaue);

    		searchTextBox.sendKeys(Keys.ENTER);

        	}
        	catch(Exception e){
        		this.enterSearchValue(searchVlaue);
        	}
        
    }
	public void enterSearchValue1(String searchVlaue) {
		searchBox.sendKeys(searchVlaue);
	}
}


