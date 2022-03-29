package com.framework.Pages.AccountServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class DeliverySettingsPage extends BasePage { 
    WebDriverWait wait;
    WebDriver driver;
    public DeliverySettingsPage(WebDriver driver) {
        log.info("Inside Message Center Constructor");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logger log = LoggerHelper.getLogger(DeliverySettingsPage.class); 
    
    @FindBy(xpath="//a[contains(text(),'Delivery Settings')]")
    WebElement DeliverySettings;
    
    public void ClickOnDeliverySettings() {
        
        log.info(DeliverySettings.getText());
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(DeliverySettings));
        DeliverySettings.click(); 
        this.verifyPageIsLoaded();
    }
    @FindBy(xpath="//h1[contains(text(),'Delivery Settings')]")
    WebElement DeliverySettingsPage;
    public void VerifyDeliverySettingsPage() { 
        this.elementVisible(DeliverySettingsPage);   
    } 
    @FindBy(xpath="//*[contains(text(),'Get Notified By')]")
    WebElement GetNotifiedby;
    
    @FindBy(xpath="//h2[contains(text(),'Urgent Messages')]")
    WebElement UrgentMessages;
    
    @FindBy(xpath="//h2[contains(text(),'Notifications')]")
    WebElement Notification;
    
    @FindBy(xpath="//*[@id='main-content']/div[1]/div[1]/div[2]/div[2]/div[1]")
    WebElement Email;
    
    @FindBy(xpath="//*[@id='main-content']/div[1]/div[1]/div[2]/div[2]/div[2]")
    WebElement textmessage; 
    
    
    @FindBy(xpath="//h2[contains(text(),'Call Time Preference')]")
    WebElement Calltimepreference; 
    
    @FindBy(xpath="//*[@id='main-content']/div[1]/div[1]/div[3]/div[2]")
    WebElement CTPDescription; 
    
    @FindBy(xpath="//div[@id='call-pref-timezone-label']/span")
    WebElement Timezone; 
    
    @FindBy(xpath=" //div[@role='radiogroup']")
    WebElement TimeintervalList; 
    
    @FindBy(xpath="//h3[contains(text(),'Member Services')]")
    WebElement MemberServices;
    
    @FindBy(xpath=" //h3[contains(text(),'403B support Service')]")
    WebElement SupportService;
    
    public void VerifyGetNotifiedByOption() { 
        this.elementVisible(GetNotifiedby); 
    }
    
    
    public void VerifyUrgentMessagesOption() { 
        this.elementVisible(UrgentMessages); 
    }
    
    public void VerifyNotificationOption() { 
        this.elementVisible(Notification); 
        
    }
    public void VerifyEmailChannel() { 
        this.elementVisible(Email); 
        
    }
    public void VerifytextmessageChannel() { 
        this.elementVisible(textmessage); 
        
    }
    
    public void VerifyCalltimepreference() { 
        this.elementVisible(Calltimepreference); 
        
    }
    
    public void VerifyCTPDescription() { 
        this.elementVisible(CTPDescription); 
        
    }
    public void VerifyTimezone() { 
        this.elementVisible(Timezone); 
        
    }  public void VerifyTimeintervalList() { 
        this.elementVisible(TimeintervalList); 
        
    }  public void VerifyMemberServicesChannel() { 
        this.elementVisible(MemberServices); 
        
    }  public void VerifySupportServiceChannel() { 
        this.elementVisible(textmessage); 
        
    }  
}