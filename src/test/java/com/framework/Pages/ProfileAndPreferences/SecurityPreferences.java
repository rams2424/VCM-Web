package com.framework.Pages.ProfileAndPreferences;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;

public class SecurityPreferences  {
	
	Logger log = LoggerHelper.getLogger(SecurityPreferences.class);
	WebDriver driver;
	public SecurityPreferences(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void verifySecurityPreferencePage() {
		log.info(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("SecurityPreferences"), "Verified Navigation to Security Preference Page");
	}

}
