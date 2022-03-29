package com.framework.Pages.Transaction.Liquidation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.Hooks;
import com.framework.Pages.BasePage;

public class ReviewPage extends BasePage {
    Logger log = LoggerHelper.getLogger(ReviewPage.class);
    WebDriver driver;
    private Hooks hook;
    public ReviewPage( WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//*[text()='Submit']")
    WebElement Submit;
    
    public void clickOnSubmit(){
        this.clickOnButton(Submit);
    }
    public ConfirmationPage navigateToConfirmation(){
        this.clickOnSubmit();
        return new ConfirmationPage(driver);
    }
    @FindBy(xpath="//*[text()='Cancel']")
    WebElement Cancel;
    @FindBy(xpath="//*[text()='Back']")
    WebElement Back;
    
    public void VisibilityBackAndCancelButton(){
        this.elementVisible(Cancel);
        this.elementVisible(Back);
    }
    
}
