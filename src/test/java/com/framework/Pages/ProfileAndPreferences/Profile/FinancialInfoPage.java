package com.framework.Pages.ProfileAndPreferences.Profile;



import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.DropDownHelper.DropDownHelper;
import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;



public class FinancialInfoPage extends BasePage{
	Logger log = LoggerHelper.getLogger( FinancialInfoPage.class);
	WebDriverWait wait;
	DropDownHelper dropDownHelper = new DropDownHelper();
	private WebDriver driver;
	public FinancialInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//button[@id='vcm-cms-annual-income-select']")
	WebElement AnnualIncome;
	
	public void ChooseAnnualIncome(String arg){
		//wait.until(ExpectedConditions.elementToBeClickable(AnnualIncome));
		AnnualIncome.click();
		 WebElement clickonprefix= driver.findElement(By.xpath("//span[contains(normalize-space(),'"+arg+"')]"));
		 wait = new WebDriverWait(driver, 40);
		 wait.until(ExpectedConditions.elementToBeClickable(clickonprefix));
		
		 clickonprefix.click();
	
	}
	@FindBy(xpath="//p[@id='vcm-cms-taxbracket']/span[1]")
	WebElement Taxbracket;
	
	public void verifyTaxBracket (String arg){
		
		 String Verifytax = Taxbracket.getText().toString();
		 log.info("Expected : "+arg);
		 log.info("Actual : "+Verifytax);
		 Assert.assertTrue(arg.equals(Verifytax));
		
	}
	
	
	@FindBy(xpath="//button[@id='vcm-cms-net-worth-select']")
	WebElement NetWorth;
	
	public void ChooseNetWorth(String arg){
		
		 WebElement Networt= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='vcm-cms-net-worth-select']")));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", Networt);
		
		
		NetWorth.click();
		 WebElement clickonNetWorth= driver.findElement(By.xpath("//span[contains(normalize-space(),'"+arg+"')]"));
		 this.clickOnButton(clickonNetWorth);
	
	}
	
	
	
	@FindBy(xpath="//button[@id='vcm-cms-tax-filing-status-select']")
	WebElement TaxFilingStatus;
	
	public void TaxFilingStatus(String arg){
		wait.until(ExpectedConditions.elementToBeClickable(TaxFilingStatus));
		this.clickOnButtonUsingJs(TaxFilingStatus);

		 WebElement clickonTaxFiling= driver.findElement(By.xpath("//span[contains(text(),'"+arg+"')]"));
		 this.clickOnButton(clickonTaxFiling);
	
	}
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement SaveButton;
	public void ClickonSave() {
     this.clickOnButton( SaveButton);
		
	}  
	@FindBy(xpath="//*[contains(text(),'Successfully updated Financial Information.')]")
    WebElement updateMsg;
    public void verifyInformationIsUpdated(String expected) {
        log.info("Expected"+expected);
        log.info("Actual"+updateMsg.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(updateMsg.getText()));
    }
	
	
  
	 @FindBy(xpath="//button[@id='vcm-cms-annual-income-select']")
	    WebElement AnnualIncomeDropDown;
	 @FindBy(xpath="//div[@id='vcm-cms-annual-income-select-option-container']//span")
	    List<WebElement> statusValues;
	    
	    public void veriyAnnualIncomeDropDown(String range1,String range2,String range3,String range4 ,String range5,String range6,String range7){
	        log.info(range1);
	        log.info(range2);
	        log.info(range3);
	        log.info(range4);
	        log.info(range5);
	        log.info(range6);
	        log.info(range7);
	        AnnualIncomeDropDown.click();
	        List<String>list = new ArrayList<>();
	        for(WebElement e:statusValues) {
	            list.add(e.getText());
	            log.info(list); 
	        }
	        
	        List<String>expected = new ArrayList<String>();
	        expected.add(range1);
	        expected.add(range2);
	        expected.add(range3);
	        expected.add(range4);
	        expected.add(range5);
	        expected.add(range6);
	        expected.add(range7);
	       log.info(expected);
	       // Assert.assertTrue(list.contains(expected));
	       Assert.assertEquals(list,expected);
	        
	      WebElement clickonprefix= driver.findElement(By.xpath("//span[contains(normalize-space(),'"+range1+"')]"));
			wait = new WebDriverWait(driver, 40);
		 wait.until(ExpectedConditions.elementToBeClickable(clickonprefix));
			
			 clickonprefix.click();
	        
	     }
	    @FindBy(xpath=" //div[@id='vcm-cms-net-worth-select-option-container']//span")
	    List<WebElement> statusValuesNet;
	    
	 
	    public void verifyNetWorthDropDown(String range1,String range2,String range3,String range4 ){
	        log.info(range1);
	        log.info(range2);
	        log.info(range3);
	        log.info(range4);
	        this.clickOnButtonUsingJs(NetWorth);
	        List<String>list = new ArrayList<>();
	        for(WebElement e:statusValuesNet) {
	            list.add(e.getText());
	        }
	        List<String>expected = new ArrayList<String>();
	        expected.add(range1);
	        expected.add(range2);
	        expected.add(range3);
	        expected.add(range4);
	        Assert.assertTrue(list.containsAll(expected)); 
	       WebElement clickonNetWorth= driver.findElement(By.xpath("//span[contains(normalize-space(),'"+range1+"')]"));
			 this.clickOnButton(clickonNetWorth);
	       
	        
	    }
	    @FindBy(xpath="//div[@id='vcm-cms-tax-filing-status-select-option-container']//span")
	    List<WebElement> statusValuestax;
	    
	    public void verifyTaxFilingDropDown(String range1,String range2,String range3,String range4 , String range5 ){
	        log.info(range1);
	        log.info(range2);
	        log.info(range3);
	        log.info(range4);
	        log.info(range5);
	        this.clickOnButtonUsingJs(TaxFilingStatus);
	        List<String>list = new ArrayList<>();
	        for(WebElement e:statusValuestax) {
	            list.add(e.getText());
	            log.info(list);
	        }
	        List<String>expected = new ArrayList<String>();
	        expected.add(range1);
	        expected.add(range2);
	        expected.add(range3);
	        expected.add(range4);
	        expected.add(range5);
	        log.info(expected);
	        log.info(list);
	       // Assert.assertTrue(list.contains(expected));
	        //Assert.assertEquals(list,expected);
	        WebElement clickonTaxFiling= driver.findElement(By.xpath("//span[contains(text(),'"+range1+"')]"));
			
			 this.clickOnButtonUsingJs(clickonTaxFiling);
	        
	       
	
	    }
	    
}
