package com.framework.Helper.Navigation.Browser;

import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.Logger.LoggerHelper;


public class BrowserHelper  {
    
    Logger log = LoggerHelper.getLogger(BrowserHelper.class);
    WebDriver driver;
    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goBack() {
        driver.navigate().back();		
    }
    
    public void goForward() {
        driver.navigate().forward();
    }
    
    public void refresh() {
        driver.navigate().refresh();		
    }
    
    public Set<String> getWindowHandlens() {
        return driver.getWindowHandles();
    }
    
    public void SwitchToWindow(int index) {
        
        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());
        
        if (index < 0 || index > windowsId.size())
            throw new IllegalArgumentException("Invalid Index : " + index);
        
        driver.switchTo().window(windowsId.get(index));
        
    }
    
    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());
        driver.switchTo().window(windowsId.get(0));
        
    }
    
    public void switchToParentWithChildClose() {
        switchToParentWindow();
        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());
        for (int i = 1; i < windowsId.size(); i++) {
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }
        switchToParentWindow();
    }
    
    public void switchToFrame(WebElement element) {
        log.info("Frame Id"+element.getText());
        driver.switchTo().frame(element.getText());
    }
    
    public void switchToFrame(String nameOrId) {
        log.info("Name"+nameOrId);
        driver.switchTo().frame(nameOrId);		
    }
}
