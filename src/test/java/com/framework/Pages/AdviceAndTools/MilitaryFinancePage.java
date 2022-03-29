package com.framework.Pages.AdviceAndTools;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.Logger.LoggerHelper;

public class MilitaryFinancePage {
	
	
	Logger log = LoggerHelper.getLogger(MilitaryFinancePage.class);
	 WebDriver driver;
	public MilitaryFinancePage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this);
  }

}
