package com.framework.Hook;

import org.openqa.selenium.WebDriver;


public class DriverFactory {
    
private DriverFactory() {}
    
    private static DriverFactory instance = new DriverFactory();
    
    public static DriverFactory getInstance() {
        return instance;
    }
    
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    
    public WebDriver getDriver() {
        //System.out.println("Get the driver >>>>>>>>>>>>>>> ");
        return driver.get();
    }
    
    public void setDriver(WebDriver webdriverparam) {
        //System.out.println("Set the driver >>>>>>>>>>>>>>> ");
        driver.set(webdriverparam);
        
        
    }
    
    public void closeBrowser() {
        System.out.println("Close the driver >>>>>>>>>>>>>>> ");
        //driver.get().close();
        driver.get().quit();
        driver.remove();
    }
    

}
