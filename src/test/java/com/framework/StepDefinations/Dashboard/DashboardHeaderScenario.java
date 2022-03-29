package com.framework.StepDefinations.Dashboard;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.Products.MutualFundPage;
import com.framework.Pages.Products.OurProductsPage;
import com.framework.Pages.Products.RetirementPage;
import com.framework.Pages.Products.SavingPlanPage;
import com.framework.Pages.Products.VictorySharePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DashboardHeaderScenario {
    
    HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
    OurProductsPage ourproducts;
    MutualFundPage mutualfund;
    SavingPlanPage saving;
    RetirementPage Retirement;
    VictorySharePage Victoryshare;
    @Then("^Click On products Check Visibility of All Products$")
    public void Click_On_products_Check_Visibility_of_All_Products() throws Throwable {
        homePage.checkVisibiltyProducts();
        
    }
    
    @And("^Click On Our Products$")
    public void Click_On_Our_Products() throws Throwable {
        ourproducts= homePage.navigatetoOurProducts();
        ourproducts.verifyProductsPage();
        
        
    }
    @And("^Click On Mutual Fund$")
    public void Click_On_Mutual_Fund() throws Throwable {
        mutualfund= homePage.navigatetoMutualFund();
        mutualfund.verifyMutualFundPage();
        
        
    }
    @And("^Click On Saving Plan$")
    public void Click_On_Saving_Plan() throws Throwable {
        saving= homePage.navigatetoSavingPlanPage();
        saving.verifySavingPlanPage();
        
        
    }
    @And("^Click On VictoryShare$")
    public void Click_On_VictoryShare() throws Throwable {
        Victoryshare= homePage.navigatetoVictorySharePage();
        Victoryshare.verifyVictorySharePage();
        
        
    }
    @And("^Click On Retirement$")
    public void Click_On_Retirement() throws Throwable {
        Retirement= homePage.navigatetoRetirementPage();
        Retirement.verifyRetirementPage();
        
        
    }
    
}
