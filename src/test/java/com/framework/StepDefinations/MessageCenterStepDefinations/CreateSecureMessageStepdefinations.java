package com.framework.StepDefinations.MessageCenterStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.MessageCenter.CreateSecureMessage;
import com.framework.Pages.MessageCenter.MessageCenterPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateSecureMessageStepdefinations{
    HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
    MessageCenterPage messageCenterPage=new MessageCenterPage(DriverFactory.getInstance().getDriver());
    CreateSecureMessage createmessage=new CreateSecureMessage(DriverFactory.getInstance().getDriver());
    
    @When("^Navigate to Online Message Center$")
    public void navigate_to_online_message_center() throws Throwable {
        messageCenterPage = homePage.navigateToMessageCenterPageFromDashBoard();
        messageCenterPage.verifyMessageCenterPage("Message Center");
        
    }
    @And("^Click On Create_Secure_Messages$")
    public void click_On_Create_Secure_Messages() throws InterruptedException{
        createmessage = messageCenterPage.navigatetocreateSecuremessage();
        
        
    }
    @And("^Click On Topic \"([^\"]*)\"$")
    public void click_On_Topic(String TopicName) throws InterruptedException {
        createmessage.SelectTopic(TopicName);
        
    }
    @And("^Choose Account \"([^\"]*)\" and \"([^\"]*)\"$")
    public void Choose_Account_something_and_something(String AccountNumber, String AccountType) throws InterruptedException {
        createmessage.SelectAccount(AccountNumber,AccountType);
        
    }
    @And("^Write \"([^\"]*)\"$")
    public void write_Subject(String Test) throws Throwable  {
        createmessage.Subject(Test);
        
    }
    @Then("^Write a Message \"([^\"]*)\"$")
    public void  Write_MessageBody(String Message) throws Throwable{
        
        createmessage.MessageB(Message);
    }
    @Then("^ClickOnSubmit$")
    public void ClickOnSubmit() throws Throwable{
        createmessage.ClickSubmit();
    }
    
    @Then("^ClickOnSubmit For Checking Error$")
    public void ClickOnSubmit_For_Checking_Error() throws Throwable{
        createmessage.ClickSubmit();
    }
    
    
    @And("^Check Error Message for Topic \"([^\"]*)\"$")
    public void  Check_Error_Message_for_Topic(String ErrorMsg1) throws Throwable{
        
        createmessage.verifyTopicErrorMsg(ErrorMsg1);
    }
    
    @And("^Check Error Message for Subject \"([^\"]*)\"$")
    public void  Check_Error_Message_for_Subject(String ErrorMsg2) throws Throwable{
        
        createmessage.verifySubjectErrorMsg(ErrorMsg2);
    }
    
    @And("^Check Error Message for MessageBody \"([^\"]*)\"$")
    public void  Check_Error_Message_for_MessageBody(String ErrorMsg3) throws Throwable{
        
        createmessage.verifyMessageBodyErrorMsg(ErrorMsg3);
    }
    @Then("^Upload File$")
    public void Upload_File() throws Throwable{
        createmessage.UploadFile();
    }
    @Then("^Delete File$")
    public void Delete_File() throws Throwable{
        createmessage.DeleteFile();
        
    }
    @Then("^Cancel The Popup$")
    public void Cancel_The_Popup() throws Throwable{
        messageCenterPage=createmessage.navigatetomessagecenterpage();
        
    }
    @Then("^Click Sent Items$")
    public void Click_Sent_Items() throws Throwable{
        messageCenterPage.ClickOnSentItems();
        
    }
    @And("^Verify Last Message \"([^\"]*)\"$")
    public void Verify_Last_Message(String Test) throws Throwable  {
        messageCenterPage.verifyLastsentItem(Test);
        
    }
    
    
}