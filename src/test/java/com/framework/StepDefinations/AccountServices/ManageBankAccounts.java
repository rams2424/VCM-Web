package com.framework.StepDefinations.AccountServices;

import com.framework.Hook.DriverFactory;
import com.framework.Hook.Hooks;
import com.framework.Pages.AccountServices.AccountServicesPage;
import com.framework.Pages.AccountServices.BankAccounts.AddBankAccount;
import com.framework.Pages.AccountServices.BankAccounts.BankAccount;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageBankAccounts {
    
    AccountServicesPage accServices=new AccountServicesPage(DriverFactory.getInstance().getDriver());
    BankAccount bankAcc=new BankAccount(DriverFactory.getInstance().getDriver());
    AddBankAccount addBank=new AddBankAccount(DriverFactory.getInstance().getDriver());
    @When("^I click on Bank Accounts$")
    public void i_click_on_Bank_Accounts() throws Throwable {
        accServices.navigateToBankAccount();
        
    }
    
    @Then("^I should see the Bank Accounts title page and Add button$")
    public void i_should_see_the_Bank_Accounts_title_page_and_Add_button() throws Throwable {
        bankAcc.visibilityOfTitle();
        bankAcc.visibilityOfAddButton();
    }
    
    @Then("^I should see the Back button and disclaimer footer in Bank Accounts page$")
    public void i_should_see_the_Back_button_and_disclaimer_footer_in_Bank_Accounts_page() throws Throwable {
        bankAcc.visibilityOfBackButtonAndFooter();
    }
    
    @When("^I click Add button$")
    public void i_click_Add_button() throws Throwable {
        bankAcc.clickOnAddButton();
    }
    
    @Then("^I should see Add Bank Account page$")
    public void i_should_see_Add_Bank_Account_page() throws Throwable {
        addBank.visibilityOfTitle();
    }
    
    @Then("^I should see the Type Account - savings and checkings$")
    public void i_should_see_the_Type_Account_savings_and_checkings() throws Throwable {
        addBank.visibilityOfRadioBttns();
    }
    
    @Then("^I should see the Transit Routing Number and the Account Number$")
    public void i_should_see_the_Transit_Routing_Number_and_the_Account_Number() throws Throwable {
        addBank.visibilityOfTextFields();
    }
    
    @Then("^I should see Cancel and Next buttons in Add Bank Account page$")
    public void i_should_see_Cancel_and_Next_buttons_in_Add_Bank_Account_page() throws Throwable {
        addBank.visibilityOfCancelAndNextBttn();
    }
    
    @When("^I click Transit Routing Number edit text field and I do not entered data$")
    public void i_click_Transit_Routing_Number_edit_text_field_and_I_do_not_entered_data() throws Throwable {
        addBank.enterTransitRoutingNumber("");
    }
    
    @When("^I click Account Number edit text field and I do not entered data$")
    public void i_click_Account_Number_edit_text_field_and_I_do_not_entered_data() throws Throwable {
        addBank.enterAccountNumber("");
    }
    
    @Then("^I should see that error messages are displayed for Type of Account, Transit Routing Number and Account Number$")
    public void i_should_see_that_error_messages_are_displayed_for_Type_of_Account_Transit_Routing_Number_and_Account_Number() throws Throwable {
        addBank.visibilityOfErrorMsg();
    }
    
    @Then("^I should see that Next button is disabled inside the Add Bank page$")
    public void i_should_see_that_Next_button_is_disabled_inside_the_Add_Bank_page() throws Throwable {
        addBank.verifyNextButtonisDisabled();
    }
    
    @When("^I complete all the required fields \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_complete_all_the_required_fields_and(String type, String transit, String accNum) throws Throwable {
        addBank.enterReqValues(type,transit,accNum);
    }
    
    
    @Then("^I reach the Verify Bank Details Page and I should see that all elements \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" are correct$")
    public void i_reach_the_Verify_Bank_Details_Page_and_I_should_see_that_all_elements_and_are_correct(String type, String transit, String accNum) throws Throwable {
        addBank.verifySavedDetails(type,transit,accNum);
    }
    
    @Then("^I should see the Cancel and Submit buttons inside the Verify Bank Details Page$")
    public void i_should_see_the_Cancel_and_Submit_buttons_inside_the_Verify_Bank_Details_Page() throws Throwable {
        addBank.visibilityOfCancelAndNextBttn();
    }
    
}
