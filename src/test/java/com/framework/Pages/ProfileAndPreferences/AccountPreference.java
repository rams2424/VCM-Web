package com.framework.Pages.ProfileAndPreferences;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;

public class AccountPreference  {
    
    Logger log = LoggerHelper.getLogger(AccountPreference.class);
    WebDriver driver;
    public AccountPreference(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void verifyAccountPreferencePage() {
        log.info(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("accountPreference"), "Verified Navigation to Account Preference Page");
    }
    
    
    
}
