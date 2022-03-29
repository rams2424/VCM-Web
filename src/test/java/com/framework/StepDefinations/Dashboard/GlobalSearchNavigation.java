package com.framework.StepDefinations.Dashboard;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.GlobalSearch.GlobalSearchPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalSearchNavigation {
    
    
    HomePage home=new HomePage(DriverFactory.getInstance().getDriver());
    GlobalSearchPage search=new GlobalSearchPage(DriverFactory.getInstance().getDriver());
    
    @Then("^Verify Global Search icon is visible$")
    public void verify_Global_Search_icon_is_visible() throws Throwable {
        home.verifyGlobalSearch();
    }
    
    @Then("^click on Global Search icon$")
    public void click_on_Global_Search_icon() throws Throwable {
        home.clickonSearch();
    }
    
    @When("^click on Search icon$")
    public void click_on_Search_icon() throws Throwable {
        search.clickonSearchIcon();
    }
    @Then("^Verify Search box, clear and recent searches are displayed$")
    public void verify_Search_box_clear_and_recent_searches_are_displayed() throws Throwable {
        search.verifySearchbox();
        search.verifyClearBttn();
        search.verifyRecentSearch();
    }
    @When("^click on close$")
    public void click_on_close() throws Throwable {
        
        search.clickonCloseBtn();
    }
    
    
    @Then("^Enter search text \"([^\"]*)\"$")
    public void enter_search_text(String arg1) throws Throwable {
        search.enterSearchValue(arg1);
    }
    @Then("^Enter search text as \"([^\"]*)\"$")
    public void enter_search_text_as(String arg1) throws Throwable {
        search.enterSearchText(arg1);
    }
    @Then("^Enter text \"([^\"]*)\"$")
    public void enter_text(String arg1) throws Throwable {
        search.enterSearchValue1(arg1);
    }

    
    @When("^Clicked Enter proxy is asked$")
    public void clicked_Enter_proxy_is_asked() throws Throwable {
        search.setProxy();
    }
    @Then("^Search results should be displayed in new tab$")
    public void search_results_should_be_displayed_in_new_tab() throws Throwable {
        search.verifySearchResult();
    }
    
    @When("^click on clear$")
    public void click_on_clear() throws Throwable {
        search.clickOnClearBttn();
    }
    
    @Then("^search box should be cleared$")
    public void search_box_should_be_cleared() throws Throwable {
        search.verifyClearTextBox();
    }
    
    @When("^click on any recent searches$")
    public void click_on_any_recent_searches() throws Throwable {
        search.clickOnRecentSearch();
    }
    
    
}
