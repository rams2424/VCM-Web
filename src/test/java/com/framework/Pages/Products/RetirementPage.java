package com.framework.Pages.Products;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.Logger.LoggerHelper;

public class RetirementPage {
	
	Logger log = LoggerHelper.getLogger(OurProductsPage.class);
	 WebDriver driver;
	public RetirementPage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }
	
	
	


	public void verifyRetirementPage() {
		if(driver.getCurrentUrl().equals("https://qa.investor.vcm.com/products/retirement")){
			log.info("Navigated to "+driver.getCurrentUrl());
		}
		else{
			log.error("Failed Navigated to "+driver.getCurrentUrl());
		}	
	}

}
