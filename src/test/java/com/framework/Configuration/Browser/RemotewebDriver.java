package com.framework.Configuration.Browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemotewebDriver {
    
    private static RemotewebDriver ch = null;
    private RemotewebDriver () {
        
    }
    public static RemotewebDriver getInstance() {
        if(ch ==null)
            ch = new RemotewebDriver();
        return ch;
    }
    
    public static  WebDriver getRemoteDriver(String url,Capabilities cap) throws MalformedURLException {
        return new RemoteWebDriver(new URL(url),cap);
    }
    
}
