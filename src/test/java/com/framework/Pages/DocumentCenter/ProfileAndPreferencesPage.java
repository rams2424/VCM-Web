package com.framework.Pages.DocumentCenter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class ProfileAndPreferencesPage extends BasePage {
    WebDriverWait wait;
    WebDriver driver;
    public  ProfileAndPreferencesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logger log = LoggerHelper.getLogger(ProfileAndPreferencesPage.class);
    
    @FindBy(xpath="//*[@class='sc-iKpIOp sc-fdqjUm bYMxfJ']")
    WebElement ProfilesAndPreferences;
    public void VerifyProfileAndPreferences(){
        this.elementVisible(ProfilesAndPreferences);
        
    }
    @FindBy(xpath="//*[@id='bread-crum-link-home']")
    WebElement homePage;
    public void  navigateToHomePage() throws InterruptedException {	 
        this.verifyPageIsLoaded();
        this.clickOnButton(homePage);
    }
    
}
