package com.framework.StepDefinations.HomePageStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Login.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class VisibilityScenario {
	

    public HomePage HPobj=new HomePage(DriverFactory.getInstance().getDriver());
    public LoginPage LPobj;
    @Given("^Member is logged in to the VCM home page$")
    public void member_is_logged_in_to_the_VCM_home_page() throws Throwable {
    	HPobj.verifyHomePageLink();
    }

    @Given("^Check Horizontal menu items are visible$")
    public void check_Horizontal_menu_items_are_visible() throws Throwable {
	HPobj.CheckVisibilityOf_HorizontalMenu();
    }

    @Given("^Welcome message is visible$")
    public void welcome_message_is_visible() throws Throwable {
	HPobj.CheckVisibilityOf_WelcomeMsg();
    }

    @Given("^Check last sign in date is visible$")
    public void check_last_sign_in_date_is_visible() throws Throwable {
	HPobj.CheckVisibilityOf_LastSign();
    }

    @Given("^Check Message center is visible$")
    public void check_Message_center_is_visible() throws Throwable {
	HPobj.CheckVisibilityOf_MessageCenter();
    }

    @Given("^Check Document Center is visible$")
    public void check_Document_Center_is_visible() throws Throwable {
	HPobj.CheckVisibilityOf_DocumentCenter();
    }

    @Given("^Check Profile name is visible$")
    public void check_Profile_name_is_visible() throws Throwable {
	HPobj.CheckVisibilityOf_ProfileName();
    }

    @Given("^Check Sign out is visible under profile down caret button$")
    public void check_Sign_out_is_visible_under_profile_down_caret_button() throws Throwable {
	HPobj.clickOn_Dropdown();
	HPobj.CheckVisibilityOf_Signout();
    }

    @Then("^Sign out successfully$")
    public void sign_out_successfully() throws Throwable {
    HPobj.clickOn_MoreOptions();
	HPobj.clickOn_SignOut();	
    }
    
    @And("^Verify User is navigated to HomePage$")
    public void verify_user_is_navigated_to_homepage() throws Throwable {
        HPobj.verifyHomePageLink();
    }
	@Then("^User is logged Out$")
    public void user_is_logged_out() throws Throwable {
		HPobj.clickOn_Dropdown();
		HPobj.clickOn_DropdownValue("Sign Out");
    }
	
}
