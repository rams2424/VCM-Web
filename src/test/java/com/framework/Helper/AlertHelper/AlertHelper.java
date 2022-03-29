package com.framework.Helper.AlertHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class AlertHelper {
    
    static  WebDriver driver;
    private Logger log = Logger.getLogger(AlertHelper.class);
    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }
    public Alert getAlert() {
        return driver.switchTo().alert();
    }
    
    public void AcceptAlert() {
        getAlert().accept();
    }
    
    public void DismissAlert() {
        getAlert().dismiss();
    }
    
    public String getAlertText() {
        String text = getAlert().getText();
        log.info(text);
        return text;
    }
    
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            log.info("true");
            return true;
        } catch (NoAlertPresentException e) {
            log.info("Exception"+e.getMessage());
            return false;
        }
    }
    
    public void AcceptAlertIfPresent() {
        if (!isAlertPresent())
            return;
        AcceptAlert();
        log.info("Alert is present");
    }
    
    public void DismissAlertIfPresent() {
        if (!isAlertPresent())
            return;
        DismissAlert();
        log.info("dismiss alert");
    }
    
    public void AcceptPrompt(String text) {
        if (!isAlertPresent())
            return;
        Alert alert = getAlert();
        alert.sendKeys(text);
        alert.accept();
        log.info(text);
    }
}
