package com.framework.Hook;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.framework.ConfigReader.PropertyFileReader;
import com.framework.Helper.Logger.LoggerHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    PropertyFileReader reader = new PropertyFileReader();
    public WebDriver driver;
    public static String currentVal;
    public static String accountNo;
    static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    Logger log = LoggerHelper.getLogger(Hooks.class);
    WebDriverWait wait;
/*    String browserName = "Chrome";
    String plateform = "CBT";
    String version  = "88";
    String env = "UAT";
    String OsType = "Windows";*/
    String browserName =getValuefrommvnProperties("browser");
    String plateform = getValuefrommvnProperties("platform");
    String version = getValuefrommvnProperties("version");
    String env = getValuefrommvnProperties("environment");
    String OsType = getValuefrommvnProperties("opersys");
    @Before()
    public  void launchDriver(Scenario scenario) throws InterruptedException {
    	long id = Thread.currentThread().getId();
        String scenarioName = scenario.getName();
        System.out.println("Before test-method. scenario is: " +scenarioName+"   ID is "+id);
        log.info("BrowserType = "+browserName);       
        log.info("LOG =================>"+plateform);
        log.info("LOG =================>"+version);
        log.info("LOG =================>"+browserName);
        log.info("LOG =================>"+env);
        log.info("LOG =================>"+OsType);
        String url = null;
        log.info("Browser Type" +browserName);
        BrowserFactory bf = new BrowserFactory();
        DriverFactory.getInstance().setDriver(bf.getBrowserSession(plateform,browserName,OsType,version,scenarioName));
        driver = DriverFactory.getInstance().getDriver();
        if(env.equalsIgnoreCase("SIT")) {
            if(browserName.equalsIgnoreCase("Firefox")){
                url= "https://"+reader.getSITURL();
                log.info("Application URL = "+url);
            } else {
                url = "https://"+reader.getSITUserName()+":"+reader.getSITPassword()+"@"+reader.getSITURL();
                log.info("Application URL = "+url);
            }
        }
        else if(env.equalsIgnoreCase("UAT")) {
            if(browserName.equalsIgnoreCase("Firefox")){
                url="https://"+reader.getUATURL();
                log.info("Application URL"+url);
            } else {
                //log.info("Application URL"+url);         
                url = "https://"+reader.getUATUserName()+":"+reader.getUATPassword()+"@"+reader.getUATURL();
                log.info("Application URL => "+url);
            }
        }
        launchUrl(url);
    }
    
    private void launchUrl(String url) {
        log.info("Application URL => "+url);
        driver.manage().window().maximize();
        driver.get(url);
        if(browserName.equalsIgnoreCase("Firefox")){
        	if(env.equalsIgnoreCase("SIT")){
                wait = new WebDriverWait(driver, 40);
                wait.until(ExpectedConditions.alertIsPresent());  
                Screen screen=new Screen();
                String path = System.getProperty("user.dir");
                log.info("Path"+path);
                screen.type("victory");   
                screen.type(Key.TAB);
                screen.type("L@unch123");
                screen.type(Key.TAB);
                screen.type(Key.ENTER);
            	}
        	else if(env.equalsIgnoreCase("UAT")){
                wait = new WebDriverWait(driver, 40);
                wait.until(ExpectedConditions.alertIsPresent());  
                Screen screen=new Screen();
                String path = System.getProperty("user.dir");
                log.info("Path"+path);
                screen.type("victory");   
                screen.type(Key.TAB);
                screen.type("St@ge123");
                screen.type(Key.TAB);
                screen.type(Key.ENTER);
            	}
        	
        } 
    }  
    
    public WebDriver getDriver() {
        return driver;
    }
    
       
    @After()
    public  void closeDriver() {
    	System.out.println("After method => closing the browser");
    	long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
    	DriverFactory.getInstance().closeBrowser();
    	
       // driver.quit();
       // driver=null;
    }
    
    public String getValuefrommvnProperties(String param) {
    	//log.info("LOG:: Property input => "+param);
    	String value = "";
    	try {
    	 value =  System.getProperty(param);
    	
    	}catch(Exception ex) {
    		log.info("LOG:: Caught exception => "+ex);
    		return null;
    	}
    	//log.info("LOG:: Property found => "+value);
    	return value;
    }
    
   
}
