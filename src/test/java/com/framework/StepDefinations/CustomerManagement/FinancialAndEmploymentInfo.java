package com.framework.StepDefinations.CustomerManagement;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.BasePage;
import com.framework.Pages.ProfileAndPreferences.BasicInformation;
import com.framework.Pages.ProfileAndPreferences.Profile.EmpIoymentInfoPage;
import com.framework.Pages.ProfileAndPreferences.Profile.FinancialInfoPage;
import com.framework.Pages.ProfileAndPreferences.Profile.ManageMilitaryInformationPage;

import io.cucumber.java.en.Then;

public class FinancialAndEmploymentInfo extends BasePage{ 
	
	
	BasicInformation Basic=new BasicInformation(DriverFactory.getInstance().getDriver());
	FinancialInfoPage FI = new FinancialInfoPage (DriverFactory.getInstance().getDriver());
	ManageMilitaryInformationPage MI = new ManageMilitaryInformationPage (DriverFactory.getInstance().getDriver());
	EmpIoymentInfoPage EI = new EmpIoymentInfoPage(DriverFactory.getInstance().getDriver());
	

	@Then("^User Click On Manage Financial Information$")
public void user_Click_On_Manage_Financial_Information() throws Throwable { 
		Basic.ClickOnFinacialInformation();
    
}

@Then("^Choose Annual Income \"([^\"]*)\"$")
public void choose_Annual_Income(String arg1) throws Throwable { 
	
    FI.ChooseAnnualIncome(arg1);
}

@Then("^Verify Tax bracket \"([^\"]*)\"$")
public void verify_Tax_bracket(String arg1) throws Throwable { 
	FI.verifyTaxBracket(arg1);
}

@Then("^Choose Net worth \"([^\"]*)\"$")
public void choose_Net_worth(String arg1) throws Throwable {
	FI.ChooseNetWorth(arg1);
    
}

@Then("^Choose Tax filing Status \"([^\"]*)\"$")
public void choose_Tax_filing_Status(String arg1) throws Throwable {
	FI.TaxFilingStatus(arg1); 
}

@Then("^Click on Save button in the Financial Information Page$")
public void click_on_Save_button_in_the_Financial_Information_Page() throws Throwable {
   FI.ClickonSave();
   
}

@Then("^Verify that Success message \"([^\"]*)\" is Displayed\\.$")
public void verify_that_Success_message_is_Displayed(String arg1) throws Throwable {
	FI.verifyInformationIsUpdated(arg1);
   
    
}

@Then("^Verify Annnual Drop has the values \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\" Displayed\\.$")
public void verify_Annnual_Drop_has_the_values_Displayed(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
   
    FI.veriyAnnualIncomeDropDown(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
}

@Then("^Verify Networth Dropdown is dispalyed with \"([^\"]*)\" ,\"([^\"]*)\" , \"([^\"]*)\" ,\"([^\"]*)\" Values\\.$")
public void verify_Networth_Dropdown_is_dispalyed_with_Values(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	FI.verifyNetWorthDropDown(arg1, arg2, arg3, arg4);
   
   
}

@Then("^Verify Tax Filing Status DropDown is dispalyed with Five options \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\\.$")
public void verify_Tax_Filing_Status_DropDown_is_dispalyed_with_Five_options(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
   
   FI.verifyTaxFilingDropDown(arg1, arg2, arg3, arg4, arg5);
}

@Then("^User Click On Manage Employment Information$")
public void user_Click_On_Manage_Employment_Information() throws Throwable { 
	Basic.ClickOnEmploymentInformation();
   
    
}

@Then("^Choose Employment Status as \"([^\"]*)\" \\.$")
public void choose_Employment_Status_as(String arg1) throws Throwable {
	EI.ChooseEmploymentStatus(arg1);
   
    
}

@Then("^Choose Primary Source of Income as \"([^\"]*)\"\\.$")
public void choose_Primary_Source_of_Income_as(String arg1) throws Throwable {
	EI.ChoosePrimarySourceOfIncome(arg1);
   
    
}

@Then("^Click on Save button in the Employment Information Page$")
public void click_on_Save_button_in_the_Employment_Information_Page() throws Throwable {
	EI.ClickonSave();
   
    
}

@Then("^Verify that Employment Information is Updated with\"([^\"]*)\"message \\.$")
public void verify_that_Employment_Information_is_Updated_with_message(String arg1) throws Throwable { 
	EI.verifyInformationIsUpdated(arg1);
   
    
}

@Then("^Verify Employment Status DropDown has values \"([^\"]*)\" ,\"([^\"]*)\",\"([^\"]*)\" ,\"([^\"]*)\" , \"([^\"]*)\" ,\"([^\"]*)\" ,\"([^\"]*)\" , \"([^\"]*)\"\\.$")
public void verify_Employment_Status_DropDown_has_values(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {
   EI.verifyEmpStatusDropDown(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    
}

@Then("^Choose Military Employment Status as \"([^\"]*)\"$")
public void choose_Military_Employment_Status_as(String arg1) throws Throwable {
   EI.ChooseEmploymentStatusMilitary(arg1);
    
}

@Then("^Select Industry Type As \"([^\"]*)\"$")
public void select_Industry_Type_As(String arg1) throws Throwable {
	   EI.ChooseIndustry(arg1);
}

@Then("^Select Occupation As \"([^\"]*)\"$")
public void select_Occupation_As(String arg1) throws Throwable {
EI.SelectOccupation(arg1);
    
}

@Then("^Select Employer Name as \"([^\"]*)\"$")
public void select_Employer_Name_as(String arg1) throws Throwable {
   
    EI.SelectEmpName(arg1);
}


@Then("^Select Zip Code as \"([^\"]*)\"$")
public void select_Zip_Code_as(String arg1) throws Throwable {
   EI.SelectZipCode(arg1);
    
}

@Then("^Select AdressLineOne as \"([^\"]*)\"$")
public void select_AdressLineOne_as(String arg1) throws Throwable { 
	EI.SelectAdressLine1(arg1);
   
    
}

@Then("^Select AdressLineTwo as \"([^\"]*)\"$")
public void select_AdressLineTwo_as(String arg1) throws Throwable {
	EI.SelectAdressLine2(arg1);
   
    
}


}




