package com.framework.Pages.MessageCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.DropDownHelper.DropDownHelper;
import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class MessageCenterPage extends BasePage{
    
    WebDriverWait wait;
    WebDriver driver;
    public MessageCenterPage(WebDriver driver) {
        log.info("Inside Message Center Constructor");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    static int Count = 0;
    Logger log = LoggerHelper.getLogger(MessageCenterPage.class);
    DropDownHelper dropDownHelper = new DropDownHelper();
    @FindBy(xpath="//div[@data-test='messages']")
    List<WebElement>MessageNo;
    
    @FindBy(xpath="//span[contains(text(),'Message Center')]")
    WebElement messageCenterLink;
    
    public void verifyMessageCenterPage(String txt) {
        log.info(txt);
        log.info(messageCenterLink.getText());
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(messageCenterLink));
        Assert.assertTrue(messageCenterLink.getText().equalsIgnoreCase(txt));
    }
    
    @FindBy(xpath="//div[@data-test='messagesContainer'][1]//input[@type='checkbox']")
    WebElement msgCheckBox;
    
    public void clickOnSingleCheckBox() {
        log.info(this.isSelectedCheckBox(msgCheckBox));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(msgCheckBox));
       
        this.clickOnButtonUsingJs(msgCheckBox);
    } 
    @FindBy(xpath="//div[@data-test='messagesContainer'][2]//input[@type='checkbox']")
    WebElement SecondmsgCheckBox;
    
    public void clickOnSecondmsgCheckBox() {
        log.info(this.isSelectedCheckBox(SecondmsgCheckBox));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(SecondmsgCheckBox));
        this.selectCheckBox(SecondmsgCheckBox);    
    } 
    @FindBy(xpath="//div[@data-test='messagesContainer'][3]//input[@type='checkbox']")
    WebElement ThirdmsgCheckBox;
    
    @FindBy(xpath="//div[@data-test='messagesContainer'][4]//input[@type='checkbox']")
    WebElement FourthmsgCheckBox;
    
    public void ClickOnFirstFourCheckBox(){
        this.selectCheckBox(msgCheckBox);
        this.selectCheckBox(SecondmsgCheckBox);
        this.selectCheckBox(ThirdmsgCheckBox);
        this.selectCheckBox(FourthmsgCheckBox);
    }
    public void ClickonlastFourCheckBox(){ 	
        for(int i=5 ; i<= 8 ; i++) {
            WebElement LastCheckBoxs = driver.findElement(By.xpath("//div[@data-test='messagesContainer']["+i+"]//input[@type='checkbox']"));
            this.selectCheckBox(LastCheckBoxs);
        }
        
    }
    @FindBy(xpath="//div[contains(text(),'Mark as Read')]")
    WebElement markAsReadBtn;
    
    public void clickOnMarkAsReadBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(markAsReadBtn));
        log.info(markAsReadBtn.isDisplayed());
        Assert.assertTrue(markAsReadBtn.isDisplayed());
        this.clickOnButton(markAsReadBtn);
        this.verifyPageIsLoaded();
    }
    public void clickOnfirstMessage(){
        wait = new WebDriverWait(driver,40);
        log.info(MessageNo.get(0).isDisplayed());
        this.clickOnButton((MessageNo.get(0)));
    }
    @FindBy(xpath="//div[contains(text(),'Mark as Unread')]")
    WebElement MarkAsUnreadBtnClick;
    public void clickOnMarkAsUnReadBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(MarkAsUnreadBtnClick));
        log.info(MarkAsUnreadBtnClick.isDisplayed());
        Assert.assertTrue(MarkAsUnreadBtnClick.isDisplayed());
        MarkAsUnreadBtnClick.click();
        this.verifyPageIsLoaded();
    }
    
    
    @FindBy(xpath="//h1[@data-test='messageCenterLabel']")
    WebElement msgCenterLabel;
    
    public void verifyMessageCenterLabel(String expectedTxt) {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(msgCenterLabel));
        log.info("Actual"+msgCenterLabel.getText());
        log.info("Expected"+expectedTxt);
        Assert.assertTrue(expectedTxt.equalsIgnoreCase(msgCenterLabel.getText()));
    }
    @FindBy(xpath="//div[text()='Create Secure Message']")
    WebElement createSecureMsgLink;
    
    public CreateSecureMessage navigatetocreateSecuremessage(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", createSecureMsgLink);
        return new CreateSecureMessage(driver);
    }
    
    public void verifyCreateSecureMsgLink(String secureMsgTxt) {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(createSecureMsgLink));
        log.info("Actual"+createSecureMsgLink.getText());
        log.info("Expected"+secureMsgTxt);
        String Expected = createSecureMsgLink.getText().toString();
        Assert.assertEquals(secureMsgTxt ,Expected);
        
    }
    @FindBy(xpath="//label[contains(text(),'Select All')]/../input")
    WebElement selectAllCheckBox;
    
    public void verifySelectAllCheckBox() {
        this.elementVisible(selectAllCheckBox);
    }
    
    @FindBy(xpath="//button[@data-test='actionDelete']")
    WebElement deleteBtn;
    
    public void verifyDeleteButtonisDisplayed() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
        this.elementVisible(deleteBtn);
    }
    @FindBy(xpath="//button[@data-test='actionMarkAsUnread']")
    WebElement markAsUnreadBtn;
    
    public void verifyMarkAsUnreadBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(markAsUnreadBtn));
        this.elementVisible(markAsUnreadBtn);
    }
    
    public void verifyMarkAsReadBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(markAsReadBtn));
        this.elementVisible(markAsReadBtn);
    }
    @FindBy(xpath="//div[@data-test='messagesSortButtonsContainerDiv']//div")
    WebElement sortByDateTxt;
    
    public void verifysortByDateTxt(String txt) {
        log.info("Verify Sort By Text"+txt);
        log.info("Actual"+sortByDateTxt.getText());
        Assert.assertTrue(txt.equalsIgnoreCase(sortByDateTxt.getText()));
    }
    @FindBy(xpath="//select[@data-test='inboxType']")
    WebElement msgDropDown;
    
    public void verifyMsgDropDown(String inbox,String deleted,String sent) {
        log.info(inbox);
        log.info(deleted);
        log.info(sent);
        List<String>expected = new ArrayList<String>();
        expected.add(inbox);
        expected.add(deleted);
        expected.add(sent);
        List<String> dropDownValues = dropDownHelper.getAllDropDownValues(msgDropDown);
        log.info(dropDownValues.equals(expected));
        Assert.assertTrue(dropDownValues.equals(expected));
    }
    
    @FindBy(xpath="//select[@data-test='orderType']")
    WebElement sortByDropDown;
    public void verifysortByDropDown(String asse,String dess) {
        log.info("Assending"+asse);
        log.info("Decending"+dess);
        List<String>list = dropDownHelper.getAllDropDownValues(sortByDropDown);
        List<String> expected = new ArrayList<String>();
        expected.add(asse);
        expected.add(dess);
    }
    @FindBy(xpath="//*[contains(text(),'Load More')]")
    WebElement loadMoreBtn;
    
   
    public void clickOnDeleteButton(){
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        deleteBtn.click();
    }
    @FindBy(xpath="//button[@id='confirmation-modal-primary-btn']")
    WebElement deleteConfirmationBtn;
    
    @FindBy(xpath="//button[@data-analytic-id='confirmation-modal-cancel']")
    WebElement cancelConfirmationBtn;
    
    public void deleteMsgConfirmationBox() {
        wait = new WebDriverWait(driver, 40);
       // String txt = driver.findElement(By.cssSelector("div#VCM-Modal-title")).getText();
      //  log.info(txt);
      //  wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmationBtn));
        this.clickOnButtonUsingJs(deleteConfirmationBtn);
      //  deleteConfirmationBtn.click();                
    }
    public void verifyDeleteMessageisDisplayed(String msg) {
        wait = new WebDriverWait(driver, 40);
        log.info("Expected Msg"+msg);
        boolean flag =  driver.findElement(By.xpath("//p[contains(text(),'"+msg+"')]")).isDisplayed();
        log.info("Flag" +flag);
        Assert.assertTrue(flag);
    }
    
    public void VerifyAllMessagesAreDeleted (String msg){
        wait = new WebDriverWait(driver, 40);
        log.info("Expected Msg"+msg);
        String flag =  driver.findElement(By.xpath("//div[@data-test='messageListContainer']//div")).getText();
        log.info("Flag" +flag);
        Assert.assertTrue(msg.equalsIgnoreCase(flag));
    }
    public void clickOnLoadMoreBtn() {
        wait =new WebDriverWait(driver, 40);
        for(int i =0;i<7;i++) {
            if(this.isElementPresent((By) loadMoreBtn)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", loadMoreBtn);
                loadMoreBtn.click();
            }
        }
    }
    
    @FindBy(xpath="//span[@data-testid='Badge']")
    WebElement MsgNotificationIconHeader; 
    
    @FindBy(xpath="//*[@id='main-content']/div[1]/div[5]/div[3]/div[2]/div/div/div[1]/div/div[1]/span")
    WebElement MsgNotificationDashboard; 
  
    public void CheckNotificationCount() { 
        /*wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.visibilityOf(MsgNotificationIconHeader));
        wait.until(ExpectedConditions.visibilityOf(MsgNotificationDashboard));
        String HeaderIconCount = MsgNotificationIconHeader.getText();
        String DashboardCout = MsgNotificationDashboard.getText();
        int HeaderVal = Integer.parseInt(HeaderIconCount);
        int DashboardVal = Integer.parseInt(DashboardCout);
        Assert.assertEquals(HeaderVal , DashboardVal);	*/
        try {
    	log.info("Inside the step method  CheckNotificationCount  ");
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(MsgNotificationIconHeader));
        wait.until(ExpectedConditions.visibilityOf(MsgNotificationDashboard));
        String HeaderIconCount = MsgNotificationIconHeader.getText();
        String DashboardCoutText = MsgNotificationDashboard.getText();
        log.info("HeaderIconCount = "+HeaderIconCount);
        log.info("DashboardCoutText = "+DashboardCoutText);
        String[] dashBoardCount = DashboardCoutText.split("\\+");
        log.info("dashBoardCount =  "+dashBoardCount[0]);
        int HeaderVal = Integer.parseInt(HeaderIconCount);
        int DashboardVal = Integer.parseInt(dashBoardCount[0]);
        Assert.assertEquals(HeaderVal , DashboardVal);	
    	}catch(Exception ex) {
    		log.info("Inside the catch block .");
    		Assert.fail("failed in message center...."+ex);
    	}
    }
    
    @FindBy(xpath="//button[@data-test='readSubject']")
    WebElement read;
    String Read = "readSubject";
    String unRead ="unReadSubject";
    
    public void verifyMessageIsHighlighted() {
        wait = new WebDriverWait(driver, 40);
        read.getAttribute("data-test");
        Assert.assertTrue(Read.equalsIgnoreCase(read.getAttribute("data-test")));
    }
    
    @FindBy(xpath="//button[@data-test='unReadSubject']")
    WebElement Uread;
    public void verifyMessageIsNotHighlighted() throws InterruptedException{
        wait = new WebDriverWait(driver, 40);
        Uread.getAttribute("data-test");
        Assert.assertTrue(unRead.equalsIgnoreCase(Uread.getAttribute("data-test")));
    }
    
    public void VerifyMultipleMessagesAreHighlighted()throws InterruptedException{
        List<WebElement>MultipleReadMsg=(driver.findElements(By.xpath("//button[@data-test='readSubject']")));
        for(int i = 0 ; i<=3 ;i++){
            log.info(MultipleReadMsg.get(i).getAttribute("data-test")); 
            Assert.assertTrue(Read.equalsIgnoreCase( MultipleReadMsg.get(i).getAttribute("data-test")));
        }
    }
    
    public void VerifyMultipleMessagesAreNotHighlighted()throws InterruptedException{
        List<WebElement>MultipleUnreadMsg=(driver.findElements(By.xpath("//button[@data-test='unReadSubject']")));
        for(int i = 0 ; i<= 3 ; i++){
            log.info(MultipleUnreadMsg.get(i).getAttribute("data-test")); 
            Assert.assertTrue(unRead.equalsIgnoreCase( MultipleUnreadMsg.get(i).getAttribute("data-test")));
        }
    }
    
    public void CheckCountandVerifyVisible() {
        Count= MessageNo.size();
        if(Count>=10) { 
            this.elementVisible(loadMoreBtn);
        }
    }
       
    public void VerifyListOfMessagesAreNotHighlighted() { 
        wait =new WebDriverWait(driver, 40);
        List<WebElement>SelectedMsgs = driver.findElements(By.xpath("//button[@data-test='unReadSubject']"));
        for(int i=0 ; i<7 ; i++) {
            String DataTest = SelectedMsgs.get(i).getAttribute("data-test");
            log.info(DataTest);
            Assert.assertTrue(DataTest.equalsIgnoreCase("unReadSubject"));
        }
    }
    public void VerifyListOfMessagesAretHighlighted() { 
        wait =new WebDriverWait(driver, 40);
        List<WebElement>SelectedMsgs = driver.findElements(By.xpath("//button[@data-test='readSubject']"));
        wait =new WebDriverWait(driver, 40);
        for(int i=0 ; i<5 ; i++)	{
            String DataTest = SelectedMsgs.get(i).getAttribute("data-test");
            log.info(DataTest);
            Assert.assertTrue(DataTest.equalsIgnoreCase("readSubject"));
        }
    }
    @FindBy(xpath="//select[@id='Select']")
    WebElement SelectSentItems;
    @FindBy(xpath="//option[text()='Sent Items']")
    WebElement Sent;
    public void ClickOnSentItems(){
    	Select s = new Select(SelectSentItems);
    	s.selectByVisibleText("Sent Items");
        
        
      //  this.clickOnButtonUsingJs(SelectSentItems);
       
       // this.clickOnButtonUsingJs(Sent);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
     //   js.executeScript("arguments[0].click();", Sent);   
    }
    public void verifyLastsentItem(String  Subject) {
        log.info("Started verifyLastsentItem >>>  "+Subject);
        try{
        Thread.sleep(4000); 
        }catch(Exception ex){log.info("Exception caught"+ex);}
    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //WebElement LastSub = driver.findElement(By.xpath("//button[normalize-space()='"+Subject+"']"));
        WebElement LastSub = driver.findElement(By.xpath("(//button[contains(text(),'"+Subject+"')])[1]"));
        Assert.assertTrue(LastSub.getText().contains(Subject));
        String A=LastSub.getText();
        log.info(A);
        
    }
     
    public void selectAllButtonClick() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(selectAllCheckBox));
        log.info(selectAllCheckBox.isDisplayed());
        Assert.assertTrue(selectAllCheckBox.isDisplayed());
        selectAllCheckBox.click();
    }

    
}

