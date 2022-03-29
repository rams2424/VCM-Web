package com.framework.StepDefinations.MessageCenterStepDefinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.MessageCenter.MessageCenterPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MessageCenterPositiveScenarios { 
    
    MessageCenterPage messageCenterPage = new MessageCenterPage (DriverFactory.getInstance().getDriver());
    Logger log = LoggerHelper.getLogger(MessageCenterPositiveScenarios.class);
    WebDriverWait wait;  
    @Then("^Verify that Notification count of both msg icon and dashboard icon are the same$")
    public void verify_that_Notification_count_of_both_msg_icon_and_dashboard_icon_are_the_same() throws Throwable {    
        messageCenterPage.CheckNotificationCount();
        
    }
    @Then("^Click on Select All button$")
    public void click_on_Select_All_button() throws Throwable { 
        messageCenterPage.selectAllButtonClick();
    }
    @When("^Click on Mark as Read$")
    public void click_on_Mark_as_Read() throws Throwable {
        messageCenterPage.clickOnMarkAsReadBtn();
    }
    
    @Then("^Verify that all the Messages are not Highlighted$")
    public void verify_that_all_the_Messages_are_not_Highlighted() throws Throwable {
        messageCenterPage.VerifyListOfMessagesAreNotHighlighted();
        
    }
    @When("^Click on Mark as Unread$")
    public void click_on_Mark_as_Unread() throws Throwable {
        messageCenterPage.clickOnMarkAsUnReadBtn();
    }
    
    @Then("^Verify that all Messages are Highlighted$")
    public void verify_that_all_Messages_are_Highlighted() throws Throwable { 
        messageCenterPage.VerifyListOfMessagesAretHighlighted();
        
    }
    @Then("^Verify That Load more icon is present if there are more than ten messages$")
    public void verify_That_Load_more_icon_is_present_if_there_are_more_than_ten_messages() throws Throwable {
        messageCenterPage.CheckCountandVerifyVisible();
        
    }
    @Then("^User should be on Message Center Page$")
    public void user_should_be_on_message_center_page() throws Throwable {
        messageCenterPage.verifyMessageCenterPage("Message Center");
    }
    @And("^Verify Message as \"([^\"]*)\"$")
    public void verify_message_as_something(String msg) throws Throwable {
        log.info("Message"+msg);
    }
    
}



