package com.framework.Pages.AccountOpening;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class PreferencesPage extends BasePage  {
	
	WebDriverWait wait;
	Logger log = LoggerHelper.getLogger(PreferencesPage.class);
	WebDriver driver;
	public PreferencesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[@for='online']")
	WebElement onlineRadioBtn;
	public void clickOnOnlineBtn() {
		wait =new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(onlineRadioBtn));
		onlineRadioBtn.click();
	}
	public void clickOndeliveryPreferenceBtn(String pref) {
		if(pref.equalsIgnoreCase("Online")) {
			this.clickOnOnlineBtn();
		}else if(pref.equalsIgnoreCase("Paper")) {
			this.clickOnPaperRadioBtn();
		}
	}
	@FindBy(xpath="//label[@for='paper']")
	WebElement paperRadioBtn;
	public void clickOnPaperRadioBtn() {
		wait =new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(paperRadioBtn));
		paperRadioBtn.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'5.  Preferences')]")
	WebElement preferenceTxt;
	
	public void verifyPreferencePage() {
		this.elementVisible(preferenceTxt);
	}
	@FindBy(xpath="//span[contains(text(),'Yes, I want to')]/..")
	WebElement wantToReinvestBtn;
	
	@FindBy(xpath="//span[contains(text(),'No, I do not want')]/..")
	WebElement dontWantToReinvest;
	
	public void verifyDidiventAndCapitalPref() {
		this.elementVisible(wantToReinvestBtn);
		this.elementVisible(dontWantToReinvest);
	}
	public void verifydeliveryPreference() {
		this.elementVisible(onlineRadioBtn);
		this.elementVisible(paperRadioBtn);
	}

}
