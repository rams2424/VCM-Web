package com.framework.StepDefinations.ProfileNPreferances;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.ProfileAndPreferences.Profile.BasicInformation;
import com.framework.Pages.ProfileAndPreferences.Profile.ContactInformationPage;
import com.framework.Pages.ProfileAndPreferences.Profile.EditContactInfo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditContact {
	 BasicInformation Basic=new BasicInformation(DriverFactory.getInstance().getDriver());
    ContactInformationPage CIPage=new ContactInformationPage(DriverFactory.getInstance().getDriver());
    EditContactInfo ECI=new EditContactInfo(DriverFactory.getInstance().getDriver());
    @Then("^Click On Edit Contact Information$")
    public void Click_On_Edit_Contact_Information() throws Throwable {
        ECI=CIPage.navigatetoEdit();
    }
    
    @Then("^Click On Address Type$")
    public void Click_On_Address_Type() throws Throwable {
        ECI.SelectAddType();
    }
    @And("^Enter Add Line1 \"([^\"]*)\"$")
    public void Enter_Add_Line1(String arg) throws InterruptedException {
        ECI.AddL1(arg);
    }
    
    @And("^Enter Zip \"([^\"]*)\"$")
    public void Enter_Zip(String arg1) throws InterruptedException {
        
        ECI.EnterZipCd(arg1);
        ECI.UseAdd();
        
    }
    
    @And("^Click Save$")
    public void Click_Save() throws Throwable {
        ECI.ClickCheck();
       CIPage= ECI.ClickOnSave();
    }    
    @Then("^Click On Back For Verification$")
    public void Click_On_Back_For_Verification() throws Throwable {
    	Basic=CIPage.ClickOnBack();
        
    }
    @And("^Verify The Updated Address \"([^\"]*)\"$")
    public void Verify_The_Updated_Address(String arg1) throws InterruptedException {
        
        Basic.VerifyAdd(arg1);
    }
}
