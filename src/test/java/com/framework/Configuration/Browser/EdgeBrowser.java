package com.framework.Configuration.Browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.Helper.ProjectLevelFilePath;

public class EdgeBrowser {
    private static EdgeBrowser ch = null;
    private EdgeBrowser () {
        
    }
    public static EdgeBrowser getInstance() {
        if(ch ==null)
            ch = new EdgeBrowser();
        return ch;
    }
    
    public static Capabilities getEdgeCapabilities() {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("useAutomationExtension", false);
        DesiredCapabilities edge = DesiredCapabilities.edge();
        return edge;
    }
    
    public static  WebDriver getEdgeDriver(Capabilities cap) {
        String path = ProjectLevelFilePath.getProjectPath()+"//src//main//resources//Drivers//msedgedriver.exe";
        System.out.println(path);
        System.setProperty("webdriver.edge.driver",
                path);
        return new EdgeDriver(cap);
    }
    
}
