package com.framework.Pages.Products;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class OurProductsPage extends BasePage {
	Logger log = LoggerHelper.getLogger(OurProductsPage.class);
	 WebDriver driver;
	public OurProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	

	public void verifyProductsPage() {
		if(driver.getCurrentUrl().equals("https://qa.investor.vcm.com/products")){
			log.info("Navigated to "+driver.getCurrentUrl());
		}
		else{
			log.error("Failed Navigated to "+driver.getCurrentUrl());
		}	
	}
}
