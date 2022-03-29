package com.framework.StepDefinations.ProfileNPreferances;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.ProfileAndPreferences.BasicInformation;
import com.framework.Pages.ProfileAndPreferences.Profile.PersonalInformationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PersonalInformation {
	
	BasicInformation Basic=new BasicInformation(DriverFactory.getInstance().getDriver());
	PersonalInformationPage PIPage=new PersonalInformationPage(DriverFactory.getInstance().getDriver());
	
	
	@Then("^User Click On Personal Information$")
	public void User_Click_On_Personal_Information() throws Throwable {
		Basic.ClickOnPersonalInformation();
	}
	@Then("^Click On save Bttn$")
	public void Click_On_save_Bttn() throws Throwable {
		PIPage.ClickOnSaveBtn();
	}
	
	
	@Then("^Check FullName is not Editable$")
	public void Check_FullName_is_not_Editable() throws Throwable {
		PIPage.checkName();
	}
	
	@Then("^Check MemberId is not Editable$")
	public void Check_MemberId_is_not_Editable() throws Throwable {
		PIPage.Member();
	}
	
//	@Then("^Check SSN is not Editable$")
//	public void Check_SSN_is_not_Editable() throws Throwable {
//		PIPage.SocialSN();
//	}
//	
	
	
	@And("^Check Citizenship is not Editable$")
	public void Check_Citizenship_is_not_Editable() throws Throwable {
		PIPage.CheckCitizanship();
	}
	
	@Then("^Check Service Number is visible For Changing SSN DOB Citizenship$")
	public void Check_Service_Number_is_visible_For_Changing_SSN_DOB_Citizenship() throws Throwable {
		PIPage.ServiceNoVisibility();
	}
	
	
	
	
	
	@Then("^Choose prefix \"([^\"]*)\"$")
	public void Choose_prefix( String arg) throws Throwable {
		PIPage.ChoosePrefix(arg);
	}
	
	@Then("^Choose Suffix \"([^\"]*)\"$")
	public void Choose_Suffix( String arg1) throws Throwable {
		PIPage.ChooseSuffix(arg1);
	}
	
	@Then("^Select Gender")
	public void Select_Gender() throws Throwable {
		PIPage.SelectGender();
	}
	
	
	@Then("^Select MaritalStatus \"([^\"]*)\"$")
	public void Select_MaritalStatus( String arg3) throws Throwable {
		PIPage.SelectMaritalStatus(arg3);
	}
	
	@Then("^Verify that Personal Information is Updated with\"([^\"]*)\"message \\.$")
	public void verify_that_Personal_Information_is_Updated_with_message(String arg1) throws Throwable { 
		PIPage.verifyInformationIsUpdated(arg1);
	   
	    
	}
	
}
