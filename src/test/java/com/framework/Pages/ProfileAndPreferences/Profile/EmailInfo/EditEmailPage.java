package com.framework.Pages.ProfileAndPreferences.Profile.EmailInfo;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class EditEmailPage extends BasePage  {
	Logger log = LoggerHelper.getLogger(EditEmailPage.class);
	WebDriverWait wait;
	WebDriver driver;
	public EditEmailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1/span[text()='Edit Email Information']")
	WebElement verifyEditEmailPage;
	
	@FindBy(id="emailId")
	WebElement emailId;
	
	public void verifyEditEmailPage() {
		this.elementVisible(verifyEditEmailPage);
	}
	
	public void enterEmailid(String arg1) {
		this.clearAndSendKeys(emailId, arg1);
		emailId.sendKeys(Keys.TAB);
	}
}
