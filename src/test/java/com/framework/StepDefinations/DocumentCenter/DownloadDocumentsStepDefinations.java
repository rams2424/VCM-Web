package com.framework.StepDefinations.DocumentCenter;

import com.framework.Hook.DriverFactory;
import com.framework.Pages.HomePage;
import com.framework.Pages.DocumentCenter.DocumentCenterPage;

import io.cucumber.java.en.And;

public class DownloadDocumentsStepDefinations  {
    
    HomePage homePage =new HomePage(DriverFactory.getInstance().getDriver());
    DocumentCenterPage documentcenter=new DocumentCenterPage(DriverFactory.getInstance().getDriver());
    
    @And("^Click On Download Document link$")
    public void click_on_download_documenty_link() throws Throwable {
        documentcenter.verifyDownloadDocuments();
    }
    
    
}
