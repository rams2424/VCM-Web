package com.framework.StepDefinations.AccessForm;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.AccessForms.AccessFormsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccessFormScenarios {
    
    HomePage homepage = new HomePage(DriverFactory.getInstance().getDriver());
    AccessFormsPage accessForm = new AccessFormsPage(DriverFactory.getInstance().getDriver());
    @When("^Click on Form on footer$")
    public void click_on_form_on_footer() throws Throwable {
        homepage.clickOnForms();
    }

    @Then("^Verify User is navigating to forms page$")
    public void verify_user_is_navigating_to_forms_page() throws Throwable {
        accessForm.verifyAccessFormTxt("Forms");
    }

    @And("^verify Adobe reader link is displaying$")
    public void verify_adobe_reader_link_is_displaying() throws Throwable {
        accessForm.verifyAdobeReadrelInkIsDisplaying();
    }
    @And("^Verify Form Page title is displaying as \"([^\"]*)\"$")
    public void verify_form_page_title_is_displaying_as_something(String title) throws Throwable {
        accessForm.verifyAccessFormTxt(title);
    }
    @When("^Click on Popular Option$")
    public void click_on_popular_option() throws Throwable {
        accessForm.clickOnAllFormsTab();
        accessForm.clickOnFrequentlyUsedTab();
    }

    @Then("^Customer should be able to see the popular forms with the description$")
    public void customer_should_be_able_to_see_the_popular_forms_with_the_description() throws Throwable {
        accessForm.verifyFrequentlyTxt();
        accessForm.verifyFormId();
        accessForm.verifyCategoryName();
        accessForm.verifyFormName();
    }

    @And("^Customer should be able to see the Form name along with description for each form$")
    public void customer_should_be_able_to_see_the_form_name_along_with_description_for_each_form() throws Throwable {
        accessForm.verifyFormId();
        accessForm.verifyCategoryName();
        accessForm.verifyFormName();
    }
    @When("^Click on All Forms$")
    public void click_on_all_forms() throws Throwable {
        accessForm.clickOnAllFormsTab();
    }
    @Then("^Document Should be open in next tab$")
    public void document_should_be_open_in_next_tab() throws Throwable {
       accessForm.verifyDocumentOpenInNewTab();
    }
    @Then("^Verify Customer can see two  option to check Frequently Used and All forms$")
    public void verify_Customer_can_see_two_option_to_check_Frequently_Used_and_All_forms() throws Throwable {
        accessForm.verifyFrequentlyUsedTab();
        accessForm.verifyAllFormsTab();
    }
    @When("^Click on Home link from Forms page$")
    public void click_on_home_link_from_forms_page() throws Throwable {
        accessForm.clickOnHomeLink();
    }

    @Then("^User should be navigate to home page$")
    public void user_should_be_navigate_to_home_page() throws Throwable {
        homepage.verifyHomePageLink();
    }
}
