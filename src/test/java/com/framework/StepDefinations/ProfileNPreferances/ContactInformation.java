package com.framework.StepDefinations.ProfileNPreferances;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.ProfileAndPreferences.BasicInformation;
import com.framework.Pages.ProfileAndPreferences.Profile.AddSeasonalAddress;
import com.framework.Pages.ProfileAndPreferences.Profile.ContactInformationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ContactInformation {
    
    BasicInformation Basic=new BasicInformation(DriverFactory.getInstance().getDriver());
    ContactInformationPage CIPage=new ContactInformationPage(DriverFactory.getInstance().getDriver());
    AddSeasonalAddress ADDSeasonal=new AddSeasonalAddress(DriverFactory.getInstance().getDriver());
    
    @Then("^User Click On Contact Information$")
    public void User_Click_On_Contact_Information() throws Throwable {
        CIPage=	Basic.navigateToContactInformation();
    }
    
    @Then("^Click On Add Seasonal Address$")
    public void Click_On_Add_Seasonal_Address() throws Throwable {
        ADDSeasonal=CIPage.navigatetoaddSeasonalAddress();
    }
    
    @And("^Enter Address Line1 \"([^\"]*)\"$")
    public void Enter_Address_Line1(String arg) throws InterruptedException {
        
        ADDSeasonal.EnterAddLine1(arg);
    }
    
    @And("^Enter ZipCode \"([^\"]*)\"$")
    public void Enter_ZipCode(String arg1) throws InterruptedException {
        
        ADDSeasonal.EnterZipCode(arg1);
        ADDSeasonal.UseThisAdd();
    }
    
    @And("^Click On Save$")
    public void Click_On_Save() throws Throwable {
        ADDSeasonal.ClickOnSave();
    }
    
    @And("^Click On Start Date For Add \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void Click_On_Start_DateFor_Add_something_and_something_and_something_and_something(String Day, String MonthwithDate, String year, String Monthyr) throws InterruptedException {
        ADDSeasonal.from_Date(Day, MonthwithDate, year, Monthyr);
    }
    
    @And("^Click On End Date For Add \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void Click_On_End_DateFor_Add_something_and_something_and_something_and_something(String Day1, String MonthwithDate1, String year1, String Monthyr1) throws InterruptedException {
        ADDSeasonal.End_Date(Day1, MonthwithDate1, year1, Monthyr1);
    }
   
    
    
}
