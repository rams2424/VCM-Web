package com.framework.StepDefinations.DocumentCenter;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.DocumentCenter.DocumentCenterPage;
import com.framework.Pages.DocumentCenter.FilterdocumentsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FilterDocumentsStepDefination {
    HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
    DocumentCenterPage documentcenterPage=new DocumentCenterPage(DriverFactory.getInstance().getDriver());
    FilterdocumentsPage filterdoc=new FilterdocumentsPage(DriverFactory.getInstance().getDriver());
    
    @And("^Click On Filter Documents PopUp$")
    public void click_on_filter_documents_popup() throws Throwable {
        filterdoc=documentcenterPage.Navigatetofilterdocuments();  
    }
    @Then("^Verify Filter Document PopUp is Displayed as \"([^\"]*)\"$")
    public void verify_filter_document_popup_is_displayed_as_something(String expected) throws Throwable {
        filterdoc.verifyFilterDocumentPopup(expected);
    }
    
    @And("^Verify Documents Category \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void verify_documents_category_somethingsomethingsomethingsomethingsomethingsomething(String st, String trade, String tax, String accmaintance, String general, String other) throws Throwable {
        filterdoc.verifyAllFilterCatoryIsDisplaying(st, trade, tax, accmaintance, general, other);
    }
    @And("^Verify Clear Filter, Apply filter buttons are  displaying$")
    public void verify_clear_filter_apply_filter_buttons_are_displaying() throws Throwable {
        filterdoc.verifyApplyFilterButton();
        filterdoc.verifyClearFiltersBtnIsDisplaying();
    }
    
    @And("^Start And End Date fields are displaying$")
    public void start_and_end_date_fields_are_displaying() throws Throwable {
        filterdoc.verifyStartDateField();
        filterdoc.verifyEndDateField();
    }
    
    @And("^Verify message as \"([^\"]*)\"$")
    public void verify_message_as_something(String msg) throws Throwable {
        filterdoc.verifyDocumentRangeMsg(msg);
    }
    
    @Then("^Start should be display as \"([^\"]*)\"$")
    public void start_should_be_display_as_something(String startdate) throws Throwable {
        filterdoc.verifyStartDate(startdate);
    }

    @And("^Click On Specific Category \"([^\"]*)\"$")
    public void click_on_specific_category_something(String category) throws Throwable {
        filterdoc.clickOnSpecificCategory(category);
    }

    @Then("^End date should be display as \"([^\"]*)\"$")
    public void end_date_should_be_display_as(String arg1) throws Throwable {
       filterdoc.verifyEndDate(arg1);
    }

    @And("^Click on clear filter Button$")
    public void click_on_clear_filter_button() throws Throwable {
        filterdoc.ClickOnClearFilterBtn();
    }
    @And("^Click on Apply Filter Button$")
    public void click_on_apply_filter_button() throws Throwable {
        documentcenterPage = filterdoc.ClickOnApplyFilterBtn();
    }
    
    @Then("^Document category Should be display as \"([^\"]*)\"$")
    public void document_category_should_be_display_as_something(String categoryname) throws Throwable {
        documentcenterPage.verifyCategoryField(categoryname);
    }
    @And("^Enter Start Date as \"([^\"]*)\"$")
    public void enter_start_date_as_something(String startdate) throws Throwable {
        filterdoc.enterStartDate(startdate);
    }

    @And("^Enter End Date as \"([^\"]*)\"$")
    public void enter_end_date_as_something(String enddate) throws Throwable {
        filterdoc.enterEndDate(enddate);
    }
    @Then("^message should be display for more than 1 year as \"([^\"]*)\"$")
    public void message_should_be_display_for_more_than_1_year_as_something(String expectedmsg) throws Throwable {
        filterdoc.verifyErrorMessageForMoreThan1Year(expectedmsg);
    }
}
