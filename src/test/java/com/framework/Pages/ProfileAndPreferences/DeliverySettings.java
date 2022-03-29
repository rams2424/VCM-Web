package com.framework.Pages.ProfileAndPreferences;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;

public class DeliverySettings {
    
    Logger log = LoggerHelper.getLogger(DeliverySettings.class);
    WebDriver driver;
    public DeliverySettings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void verifyDeliverySettingsPage() {
        log.info(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("deliverySettings"), "Verified Navigation to Delivery Preference Page");
    }
    
}
