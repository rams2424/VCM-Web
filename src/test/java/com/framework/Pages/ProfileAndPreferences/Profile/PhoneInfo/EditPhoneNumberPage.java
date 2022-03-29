package com.framework.Pages.ProfileAndPreferences.Profile.PhoneInfo;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;


public class EditPhoneNumberPage extends BasePage {
    Logger log = LoggerHelper.getLogger(EditPhoneNumberPage.class);
    WebDriverWait wait;
    WebDriver driver;
    public EditPhoneNumberPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//h1/span[text()='Edit Phone Number']")
    WebElement verifyEditPhnPage;
    
    @FindBy(id="vcm-cms-phone-number-0")
    WebElement phnNumber;
    
    public void verifyEditPhnPage() {
        this.elementVisible(verifyEditPhnPage);
    }
    
    public void enterPhoneNumber(String arg1) {
        this.clearAndSendKeys(phnNumber, arg1);
        phnNumber.sendKeys(Keys.TAB);
    }
}
