package com.framework.Helper.Navigation;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.framework.Helper.Logger.LoggerHelper;

public class NavigationHelper  {
    WebDriver driver;
    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }
    Logger log = LoggerHelper.getLogger(NavigationHelper.class);
    
    public void navigateTo(String url) {
        log.info("URL"+url);
        driver.get(url);
    }
    
    public void naviagteTo(URL url) {
        log.info("URL Path"+url.getPath());
        driver.get(url.getPath());
    }
    
    public String getTitle() {
        log.info(driver.getTitle());
        return driver.getTitle();
    }
    
    public String getCurrentUrl() {
        log.info(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    
    
}
