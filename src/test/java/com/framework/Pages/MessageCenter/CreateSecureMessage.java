package com.framework.Pages.MessageCenter;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.BasePage;

public class CreateSecureMessage extends BasePage {
        
    WebDriverWait wait;
    WebDriver driver;
    
    Logger log = LoggerHelper.getLogger(CreateSecureMessage.class);
    
    public  CreateSecureMessage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
    @FindBy(xpath="//span[contains(text(),'Create Secure Message')]")
    WebElement createSecureMessageLink;
    public void verifyCreateSecureMessage(String txt) {
        log.info(txt);
        log.info(createSecureMessageLink.getText());
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(createSecureMessageLink));
        Assert.assertTrue(createSecureMessageLink.getText().equalsIgnoreCase(txt));
    }
    
    @FindBy(xpath="//*[@id='topics-drop-down']")
    WebElement Topic;
    
    @FindBy(xpath="//div[@id='accounts-drop-down']")
    WebElement AccountService;
    
    public  void SelectTopic(String TopicName) throws InterruptedException{
        log.info(Topic.isDisplayed());
        Assert.assertTrue(Topic.isDisplayed());
        this.clickOnButton(Topic);
        
         WebElement SelectingTopic = driver.findElement(By.xpath("//span[contains(text(),'"+TopicName+"')]"));
        SelectingTopic.click();
        //span[contains(text(),'Account Opening')]
        
    }
    
    public void SelectAccount( String Accountnumber, String AccountType) throws InterruptedException{
        
    }
    @FindBy(xpath="//input[@id='subject-text-box']")
    WebElement Subject;
    public void Subject(String Test) throws Throwable {
        Subject.sendKeys(Test);
    }
    
    @FindBy(xpath="//textarea[@id='message-body-text-box']")
    WebElement MessageB;
    public void MessageB(String Message){
        MessageB.sendKeys(Message);
       // js.executeScript("window.scrollBy(0,500)");
    }
    
    @FindBy(xpath="//span[contains(text(),'Submit')]")
    WebElement Submit;
    public void ClickSubmit(){
    	wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
    	 wait.until(ExpectedConditions.elementToBeClickable(Submit));
         
    	this.clickOnButtonUsingJs(Submit);
    }
    
    
    @FindBy(xpath="//small[@id='topics-drop-down-error']")
    WebElement TopicErrorMsg;
    
    public void verifyTopicErrorMsg(String expected) {
        
        log.info("Topic Error Message"+TopicErrorMsg.getText());
        log.info("Expected"+expected);
        log.info(TopicErrorMsg.getText().contains(expected));
    
        Assert.assertTrue(TopicErrorMsg.getText().contains(expected));
    }
    
     @FindBy(xpath="//small[contains(text(),'Please enter minimum 2 characters')]")
        WebElement SubjectErrorMsg;
        
        public void verifySubjectErrorMsg(String expected) {
            log.info("Subject Error Message"+SubjectErrorMsg.getText());
            log.info("Expected"+expected);
            log.info(SubjectErrorMsg.getText().contains(expected));
            
            Assert.assertTrue(SubjectErrorMsg.getText().contains(expected));
        }
        
         @FindBy(xpath="//small[contains(text(),'Please enter minimum 5 characters')]")
            WebElement MessageBodyErrorMsg;
            
            public void verifyMessageBodyErrorMsg(String expected) {
                log.info("MessageBody Error Message"+MessageBodyErrorMsg.getText());
                log.info("Expected"+expected);
                log.info(MessageBodyErrorMsg.getText().contains(expected));
                
                Assert.assertTrue(MessageBodyErrorMsg.getText().contains(expected));
            }
            
            @FindBy(xpath="//main[@id='main-content']//p[3]")
            WebElement FileUpload;
            public void UploadFile() throws AWTException, InterruptedException{
            	
//            	FileUpload.sendKeys("C:\\Users\\835009\\Pictures\\Saved Pictures\\Screenshot 2020-10-03 125824.png");
//                
             
               
                js.executeScript("arguments[0].click();", FileUpload);
                
                uploadFile("C:\\Users\\835009\\Pictures\\Saved Pictures\\Screenshot 2020-10-03 125824.png");
//                System.getProperty("user.dir")+"src\\test\\FIleUploadOnCreateSecureMeessage\\Screenshot 2020-09-24 092257.png"
            }
            
            
             public void uploadFile(String filePath) throws AWTException {
                    //copy content
                    StringSelection stringSelectionObj= new StringSelection(filePath);
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelectionObj, null);
                 
                    //paste content by CTRL + V event
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
             
             @FindBy(xpath="//div[text()='Delete']")
             WebElement Delete;
             public void DeleteFile(){
            	 wait = new WebDriverWait(driver, 40);
            	 wait.until(ExpectedConditions.elementToBeClickable(Delete));
                this.clickOnButtonUsingJs(Delete);
             }
             @FindBy(xpath="//button[@id='statusMsgClose']")
             WebElement CancelPopup;
             public MessageCenterPage navigatetomessagecenterpage(){
                 CancelPopup.click();
                 
                 return new MessageCenterPage(driver);
             }
            
    
}