package com.framework.Pages.Products;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.Logger.LoggerHelper;

public class VictorySharePage {
		
	Logger log = LoggerHelper.getLogger(VictorySharePage.class);
	 WebDriver driver;
	public VictorySharePage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }
		

	
	
	public void verifyVictorySharePage() {
		Assert.assertTrue(driver.getCurrentUrl().contains("vcm.com/products/victoryshares-etfs"));
		}
	
//		@FindBy(xpath="//a[@class='accept btn-primary']")
//		WebElement Accept;
//		public void AcceptAlert(){
//			Accept.click();
//		}
}
