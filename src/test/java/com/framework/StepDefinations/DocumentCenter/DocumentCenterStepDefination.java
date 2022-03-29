package com.framework.StepDefinations.DocumentCenter;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.DocumentCenter.DocumentCenterPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocumentCenterStepDefination {
    
    HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
    DocumentCenterPage documentcenterPage =new DocumentCenterPage(DriverFactory.getInstance().getDriver());
    @And("^Check Document Center is visible under profile down caret button$")
    public void Check_Document_Center_is_visible_under_profile_down_caret_button() throws Throwable {
        homePage.clickOnRecentActivityBtn();
        homePage.clickOn_Dropdown();
        homePage.verifyDocumentCenterOption();
    }
    @Then("^Click On Document Center$")
    public void Click_On_Document_Center()  throws Throwable {
        documentcenterPage = homePage.navigateToDocumentDenterPage();
        documentcenterPage.verifyDocumentCenterPage("Document Center");
    }
    @And("^Verify Components are Displaying$")
    public void Verify_Components_are_Displaying() throws Throwable {;
        documentcenterPage.CheckDownloadAdobeReader();
        documentcenterPage.CheckHelpFaqs();
        documentcenterPage.CheckSortByDateMenu();
        documentcenterPage.CheckFilterdocuments();
    }
    @And("^Verify It is Navigating to Document Center Page$")
    public void verify_it_is_navigating_to_document_center_page() throws Throwable {
        documentcenterPage.verifyDocumentCenterPage("Document Center");
    }
    @Then("^Documents not available message should be display as \"([^\"]*)\"$")
    public void documents_not_available_message_should_be_display_as_something(String expectedmsg) throws Throwable {
        documentcenterPage.verifyDocoumentNotAvailableMsg(expectedmsg);
    }
    @Then("^verify Document is displayed for that date range \"([^\"]*)\"$")
    public void verify_document_is_displayed_for_that_date_range_something(String date) throws Throwable {
        documentcenterPage.verifyDocumentDate(date);
    }
    @And("^Click on Document From Dashboard$")
    public void click_on_document_from_dashboard() throws Throwable {
        documentcenterPage.clickOnDocumentIcon();
    }
    @And("^Click on Download document icon from dashboard$")
    public void click_on_download_document_icon_from_dashboard() throws Throwable {
        documentcenterPage.verifyDownloadDocImgDisplaying();
    }
    
    @Then("^Document should be open in new Tab$")
    public void document_should_be_open_in_new_tab() throws Throwable {
        documentcenterPage.verifyDocumentOpenedInNewTab();
    }
    @When("^User is on Guest Dashboard$")
    public void User_is_on_Guest_Dashboard() throws Throwable {
        documentcenterPage.verifyPageIsLoaded();
        documentcenterPage.verifyGuestDashboard();
    }
    
    @Then("^User should be Navigate to Guest dashboard$")
    public void user_should_be_navigate_to_guest_dashboard() throws Throwable {
        documentcenterPage.verifyGuestDashboard();
    }
    @And("^Click on Home link$")
    public void click_on_home_link() throws Throwable {
        documentcenterPage.verifyPageIsLoaded();
        documentcenterPage.clickOnHomeLink();
    }
    
    @When("^Click on download Adobe reader$")
    public void click_on_download_Adobe_reader() throws Throwable {
        documentcenterPage.verifyDownloadAdobeLink();
    }
    @Then("^User should be navigate to Download adobe reader page$")
    public void user_should_be_navigate_to_download_adobe_reader_page() throws Throwable {
        documentcenterPage.verifyDownloadAdobeReaderPage();
    }
    @Then("^Verify \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" is displaying$")
    public void verify_somethingsomething_and_something_is_displaying(String accname, String docdate, String cat) throws Throwable {
        documentcenterPage.verifyAccountTitle(accname);
        documentcenterPage.verifyDocumentDateTitle(docdate);
        documentcenterPage.verifycategoryTxt(cat);
    }
    
     @Then("Verify Document Center Message \"([^\"]*)\"$")
    public void verify_document_center_message(String msg) {
    	documentcenterPage.verifyDocMessageisDisplayed();
    	
    }
    
    @Then("Verify Document Format Message \"([^\"]*)\"$")
    public void verify_document_format_message(String msg) {
    	documentcenterPage.verifyDocMessageFormatisDisplayed();
    	
    }
    
    @Then("Click On Access Document")
    public void click_on_access_document() {
    	documentcenterPage.clickOnAccessDocumentLink();
    }
    
}
