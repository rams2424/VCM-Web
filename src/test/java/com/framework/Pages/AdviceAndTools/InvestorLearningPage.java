package com.framework.Pages.AdviceAndTools;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.Logger.LoggerHelper;

public class InvestorLearningPage {
	
	
		Logger log = LoggerHelper.getLogger(InvestorLearningPage.class);
		 WebDriver driver;
		public InvestorLearningPage(WebDriver driver) {
	       this.driver = driver;
	       PageFactory.initElements(driver, this);
	   }

	
}
