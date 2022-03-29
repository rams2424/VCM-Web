package com.framework.Configuration.Browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.Helper.ProjectLevelFilePath;

public class IEBrowser {

	public static Capabilities getIExplorerCapabilities() {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,
				ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		return cap;
	}
	
	public static  WebDriver getIExplorerDriver(Capabilities cap) {
		 String path = ProjectLevelFilePath.getProjectPath()+"//src//main//resources//Drivers//IEDriverServer.exe";
	        System.out.println(path);
	        System.setProperty("webdriver.ie.driver",
	                path);
		return new InternetExplorerDriver(cap);
	}
	
}
