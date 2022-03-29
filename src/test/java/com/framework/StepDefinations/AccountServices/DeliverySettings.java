package com.framework.StepDefinations.AccountServices;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Hook.DriverFactory;
import com.framework.Hook.Hooks;
import com.framework.Pages.AccountServices.DeliverySettingsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeliverySettings { 
    
    WebDriverWait wait;
    DeliverySettingsPage ds = new DeliverySettingsPage(DriverFactory.getInstance().getDriver());
    @When("^ Click on  Delivery Settings Page$")
    public void click_on_delivery_settings_page() throws Throwable {
       ds.ClickOnDeliverySettings();
    }
    
    @Then("^Verify get notified by and urgent message and notification text$")
    public void verify_get_notified_by_and_urgent_message_and_notification_text() throws Throwable {
        ds.VerifyGetNotifiedByOption();
        ds.VerifyUrgentMessagesOption();
        ds.VerifyNotificationOption();    
    }
    
}



