package com.framework.Helper;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.Configuration.Browser.BrowserType;
import com.framework.Configuration.Browser.ChromeBrowser;
import com.framework.Configuration.Browser.EdgeBrowser;
import com.framework.Configuration.Browser.FirefoxBrowser;
import com.framework.Configuration.Browser.IEBrowser;

public class InitializeWebDriver {
    
    public static  WebDriver driver;
    
    static String username = "Ashwini.Ghuge2%40cognizant.com"; // Your username
    static String authkey = "ufc8d5bc322cb321";  // Your authkey
    public  static WebDriver getDriver(BrowserType btype) {
        try	{
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", "chrome");
            cap.setCapability("headless", true);
            switch (btype) {
                case Chrome:
                    driver =  ChromeBrowser.getChromeDriver(ChromeBrowser.getChromeCapabilities());
                   System.out.println("Driver"+driver);
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
                case Firefox:
                    driver = FirefoxBrowser.getFirefoxDriver(FirefoxBrowser.getFirefoxCapabilities());
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
                case Iexplorer:
                    driver = IEBrowser.getIExplorerDriver(IEBrowser.getIExplorerCapabilities());
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
                case EdgeBrowser:
                    driver = EdgeBrowser.getEdgeDriver(EdgeBrowser.getEdgeCapabilities());
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
                case RemoteDriver:
                    cap.setCapability("browserName", "Firefox");
                    cap.setCapability("version", "83");
                    cap.setCapability("platform", "Windows 10");
                    cap.setCapability("screenResolution", "1366x768");
                    driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), cap);
                    System.out.println(((RemoteWebDriver) driver).getSessionId());
                    driver.manage().window().maximize();
                    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                    break;  
                case EC2Hub:
                    ChromeOptions options = new ChromeOptions();
                    driver = new RemoteWebDriver(new URL("http://172.23.194.57:4444/wd/hub"),options); 
                    break;
                default:
                    driver =  ChromeBrowser.getChromeDriver(ChromeBrowser.getChromeCapabilities());
                    break;
            }
        }catch(Exception e) {
            
        }
        return driver;
    }
    
}
