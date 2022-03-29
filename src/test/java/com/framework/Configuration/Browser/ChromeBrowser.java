package com.framework.Configuration.Browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.Helper.ProjectLevelFilePath;



public class ChromeBrowser {
    
    private static ChromeBrowser ch = null;
    private ChromeBrowser () {
        
    }
    public static ChromeBrowser getInstance() {
        if(ch ==null)
            ch = new ChromeBrowser();
        return ch;
    }
    
    public static Capabilities getChromeCapabilities() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        chrome.setJavascriptEnabled(true);
        chrome.setBrowserName("Chrome");
        chrome.setCapability(ChromeOptions.CAPABILITY, option);       
        return chrome;
    }
    
    public static  WebDriver getChromeDriver(Capabilities cap) {
        String path = ProjectLevelFilePath.getProjectPath()+"//src//main//resources//Drivers//chromedriver.exe";
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver",
                path);
        return new ChromeDriver(cap);
    }
}
