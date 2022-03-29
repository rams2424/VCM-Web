package com.framework.StepDefinations.MessageCenterStepDefinations;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.MessageCenter.MessageCenterPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MessageCenterFieldVerificationScenario {
	
	 
	WebDriverWait wait;
	HomePage homepage = new HomePage (DriverFactory.getInstance().getDriver());
	MessageCenterPage messageCenterPage =new MessageCenterPage(DriverFactory.getInstance().getDriver());

	@When("^Click On Message From Message Center Dashboard$")
	public void click_On_Message_From_Message_Center_Dashboard() throws Throwable {
	    messageCenterPage =  homepage.navigateToMessageCenteByIcon();
	}           

	@Then("^Verify the \"([^\"]*)\" text in the Message Center Page$")
	public void verify_the_text_in_the_Message_Center_Page(String arg) throws Throwable {
		messageCenterPage.verifyMessageCenterPage(arg);
		
	}
	
	@When("^Click on Message Center Header icon and then click View all button$")
	public void click_on_Message_Center_Header_icon_and_then_click_View_all_button() throws Throwable {
		homepage.clickOnMsgIcon();
		homepage.clickOnViewAllLink();
	}
	  

	@Then("^Verify \"([^\"]*)\" text and Select all radio button is displayed$")
	public void verify_text_and_Select_all_radio_button_is_displayed(String secureMsgTxt) throws Throwable {
		messageCenterPage.verifyCreateSecureMsgLink(secureMsgTxt);
		messageCenterPage.verifySelectAllCheckBox();
    }

	@Then("^Delete , Mark as Read and Mark as Unread buttons should be dispalyed$")
	public void delete_Mark_as_Read_and_Mark_as_Unread_buttons_should_be_dispalyed() throws Throwable {
		messageCenterPage.verifyDeleteButtonisDisplayed();
		messageCenterPage.verifyMarkAsReadBtn();
		messageCenterPage.verifyMarkAsUnreadBtn();
	}

	@Then("^\"([^\"]*)\" text and dropdown should be displayed$")
	public void text_and_dropdown_should_be_displayed(String arg1) throws Throwable {
		messageCenterPage.verifysortByDateTxt(arg1); 
	}

	@Then("^Sort by date dropdown should have \"([^\"]*)\" and \"([^\"]*)\" field dispalyed$")
	public void sort_by_date_dropdown_should_have_and_field_dispalyed(String asse, String dess) throws Throwable { 
		messageCenterPage.verifysortByDropDown(asse, dess);
	}

	@Then("^Inbox Type dropdown should be displayed with fields \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void inbox_Type_dropdown_should_be_displayed_with_fields_and(String inbox, String deleted, String sent) throws Throwable {
	    messageCenterPage.verifyMsgDropDown(inbox, deleted, sent);
	}
}
