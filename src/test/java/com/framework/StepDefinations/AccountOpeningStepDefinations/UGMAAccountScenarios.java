package com.framework.StepDefinations.AccountOpeningStepDefinations;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.AccountOpening.UGMAAccount.InvestingforChildrenPage;
import com.framework.Pages.AccountOpening.UGMAAccount.PersonalInfoPage;

import io.cucumber.java.en.When;

public class UGMAAccountScenarios {
    PersonalInfoPage personalInfo = new PersonalInfoPage(DriverFactory.getInstance().getDriver());
    InvestingforChildrenPage ugmaPage = new InvestingforChildrenPage(DriverFactory.getInstance().getDriver());
    @When("^Click On UGMA Account$")
    public void click_On_UGMA_Account() throws Throwable {
        ugmaPage.clickOnUGMAAccount();
    }

    @When("^Enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\",\"([^\"]*)\"$")
    public void enter_and(String fname, String lname, String ssn1, String ssn2, String ssn3, String dob, String relation) throws Throwable {
        personalInfo.enterName(fname);
        personalInfo.enterLastName(lname);
        personalInfo.enterChildSSN(ssn1, ssn2, ssn3);
        personalInfo.enterDob(dob);
        personalInfo.enterRelationShip(relation);
    }
}
