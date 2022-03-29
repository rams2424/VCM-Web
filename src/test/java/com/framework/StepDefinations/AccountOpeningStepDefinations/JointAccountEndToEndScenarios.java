package com.framework.StepDefinations.AccountOpeningStepDefinations;

import org.apache.log4j.Logger;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.AccountOpening.OpenAccountPage;
import com.framework.Pages.AccountOpening.PersonalInfoPage;
import com.framework.Pages.AccountOpening.GeneralInvestmentAccount.GeneralInvestmentAccountPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class JointAccountEndToEndScenarios {
    Logger log = LoggerHelper.getLogger(JointAccountEndToEndScenarios.class);
    GeneralInvestmentAccountPage giaPage = new GeneralInvestmentAccountPage(DriverFactory.getInstance().getDriver());
    OpenAccountPage openAccountPage = new OpenAccountPage(DriverFactory.getInstance().getDriver());
    PersonalInfoPage personalinfo = new PersonalInfoPage(DriverFactory.getInstance().getDriver());
    HomePage homepage = new HomePage(DriverFactory.getInstance().getDriver());
    
    @Given("^click on \"([^\"]*)\" Account$")
    public void click_on_something_account(String jointtype) throws Throwable {
        log.info("Account type"+jointtype);
        openAccountPage.clickOnGIAAccount();
        openAccountPage.clickOnNextButton();
        giaPage.clickonJointAccount(jointtype);
        openAccountPage.clickOnNextButton();
    }
    @And("^enter All personal information,\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enter_all_personal_informationsomethingsomethingsomethingsomethingsomethingsomethingsomethingsomethingsomething(String relationship, String fname, String lname, String dob, String gender, String marital, String securityno1, String securityno2, String securityno3) throws Throwable {
        log.info("RelationShip" +relationship);
        log.info("First Name"+fname);
        log.info("Last Name" +lname);
        log.info("DOB"+dob);
        log.info("Gender"+gender);
        log.info("Marital status"+marital);
        log.info("security 1"+securityno1);
        log.info("security 2"+securityno2);
        log.info("security 3"+securityno3);
        personalinfo.clickOnrelationDropDown(relationship);
        personalinfo.enterFirstName(fname);
        personalinfo.enterLastName(lname);
        homepage.clickOnDate(dob);
        personalinfo.selectGenderChkBox(gender);
        personalinfo.clickOnMaritalDropown(marital);
        personalinfo.enterSocialSecurityNo(securityno1, securityno2, securityno3);
    }
    
    @And("^Enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enter_somethingsomethingsomething(String addressline1, String zipcode, String phycheckbox) throws Throwable {
        log.info("Address line1"+addressline1);
        log.info("Zip Code"+zipcode);
        log.info("phyCheckBox"+phycheckbox);
        personalinfo.enterJointAddress(addressline1);
        personalinfo.enterzipAddress(zipcode);
        personalinfo.clickOnUseThisAddressBtn();
        personalinfo.clickonPhyAddressChkBox();
        personalinfo.selectGenderChkBox(phycheckbox);
    }
    
    @And("^enter primaryphone no \"([^\"]*)\"$")
    public void enter_primaryphone_no_something(String primaryphone) throws Throwable {
        log.info("primary Phone "+primaryphone);
        personalinfo.enterPrimaryPhoneNo(primaryphone);
    }
    
    @And("^enter primaryEmail \"([^\"]*)\"$")
    public void enter_primaryemail_something(String primaryemail) throws Throwable {
        log.info("primary Email"+primaryemail);
        personalinfo.enterPrimaryEmail(primaryemail);
        personalinfo.clickOnEmployeeStatusDropDown();
        personalinfo.clickOnJointSourceDropDn(); 
        personalinfo.clickOnUseThisAddressBtn();
    }
    
}
