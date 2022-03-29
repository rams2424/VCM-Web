package com.framework.Configuration.Browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.Helper.ProjectLevelFilePath;

public class FirefoxBrowser {

    private static FirefoxBrowser ch = null;
    private FirefoxBrowser () {
        
    }
    public static FirefoxBrowser getInstance() {
        if(ch ==null)
            ch = new FirefoxBrowser();
        return ch;
    }
	public static Capabilities getFirefoxCapabilities() {
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		//FirefoxProfile profile = new FirefoxProfile();
	//	profile.setAcceptUntrustedCertificates(true);
		//profile.setAssumeUntrustedCertificateIssuer(true);
		//firefox.setCapability(FirefoxDriver.PROFILE, profile);
		//firefox.setCapability("marionette", true);
		return firefox;
	}
	
	public static  WebDriver getFirefoxDriver(Capabilities cap) {
	    String path = ProjectLevelFilePath.getProjectPath()+"//src//main//resources//Drivers//geckodriver.exe";
        System.out.println(path);
		System.setProperty("webdriver.gecko.driver",path);
		return new FirefoxDriver(cap);
	}
	
}
