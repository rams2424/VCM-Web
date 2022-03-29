package com.framework.Hook;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.Configuration.Browser.EdgeBrowser;
import com.framework.Configuration.Browser.FirefoxBrowser;
import com.framework.Helper.Logger.LoggerHelper;

public class BrowserFactory {
    
    public WebDriver driver;

    static String username = "jagadeesh.javali%40cognizant.com"; 
    static String authkey  = "ua72c5de8f8571c0"; 
    static String usrName1 = "Ashwini.Ghuge2%40cognizant.com";
    static String authKey1 = "ufc8d5bc322cb321";
    Hooks h = new Hooks();
    public static final String resolution = "1366x768";
    public static final String windows = "Windows 10";
    public static final String Mac = "Mac OSX 10.15";
    public static final String EC2URL = "http:/172.23.194.57:4444/wd/hub";
    public static final String CBTURL = "@hub.crossbrowsertesting.com:80/wd/hub";
    public static final String InternetExplorer = "Internet Explorer";
    Logger log = LoggerHelper.getLogger(BrowserFactory.class);
    DesiredCapabilities caps = new DesiredCapabilities();
    public WebDriver getBrowserSession(String platform,String browserType,String osType,String version,String scenarioName) {
        
        try {
            if (platform.equalsIgnoreCase("CBT")) {
                log.info("LOG: Entered case of CBT platform..");
                caps.setCapability("name", scenarioName);
                caps.setCapability("record_video", "true");
                if(browserType.equalsIgnoreCase("InternetExplorer")) {
                    caps.setCapability("browserName",InternetExplorer);
                }else {
                    caps.setCapability("browserName",browserType);
                }
                caps.setCapability("browserName", browserType);
                caps.setCapability("version",version);
                if(osType.equalsIgnoreCase("Mac")) {
                    caps.setCapability("platform", Mac); 
                }else if(osType.equalsIgnoreCase("Windows")){
                    caps.setCapability("platform", windows);
                }
                caps.setCapability("screenResolution", resolution);
                if(h.getValuefrommvnProperties("executedBy").equalsIgnoreCase("ashwini")) {
                    driver = new RemoteWebDriver(new URL("http://" + usrName1 + ":" + authKey1 +CBTURL), caps);
                } else {
                    driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +CBTURL), caps);
                }
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            }else if (platform.equalsIgnoreCase("EC2Hub")) {
                log.info("LOG: Entered case of EC2Hub platform..");
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(new URL(EC2URL),options); 
                
            }else if (platform.equalsIgnoreCase("Local")) {
                log.info("LOG: Entered case of local platform..");  
                String path = "C:\\Users\\820264\\Documents\\VCMAutomationLatest\\VCMAutomation\\VCMAutomation\\src\\main\\resources\\Drivers\\chromedriver.exe";   
                System.setProperty("webdriver.chrome.driver",path);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            }
        }catch(Exception ex) {
            log.info("Exception caugh ..."+ex);
            return null;
        }
        
        return driver;
        
    }
    
    
}
