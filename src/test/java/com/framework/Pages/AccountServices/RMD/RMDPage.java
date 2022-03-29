package com.framework.Pages.AccountServices.RMD;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class RMDPage extends BasePage {
	   
    static WebDriver driver;
    WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(RMDPage.class);
    public RMDPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h1[text()='Required Minimum Distribution']")
	WebElement title;
	public void visibilityOfTitle() {
		this.elementVisible(title);
	}

	@FindBy(id="postLoginFooter")
	WebElement footer;	

    @FindBy(xpath = "//h3[text()='Required Minimum Distribution Rules Changed in 2020']")
     WebElement rmdDistributionSectionText;

    @FindBy(xpath = "//div[@role='button']")
     WebElement rmdCardList;

    @FindBy(xpath = "//h2[text()='What is a Required Minimum Distribution (RMD)?']")
     WebElement retirementArticleSection;

    @FindBy(id="read-article")
     WebElement readArticleButton;

    @FindBy(xpath = "//h2[text()='Required Minimum Distribution Calculators']")
     WebElement rmdCalculatorSection;

    @FindBy(css = "#current-year")
     WebElement calculatorCurrentYearButton;

    @FindBy(css = "#future")
     WebElement calculatorFutureButton;

    @FindBy(xpath = "//div[text()='See All Retirement']")
     WebElement seeAllRetirementButton;

    @FindBy(xpath = "//a[contains(@href,'vcm.com/products/retirement')]")
     WebElement seeAllRetirementLink;
  
	
	public void visibilityOfBackButtonAndFooter() {
		verifyBackButtonIsDisplayed();
		this.elementVisible(footer);
	}
	public void NonvisibilityOfCardListing() {
		Assert.assertFalse(isElementPresent(By.xpath("//div[@role='button']")));
	}
	public void visibilityOfDistributionRules() {
		this.verifyPageIsLoaded();
		Assert.assertTrue(rmdDistributionSectionText.isDisplayed());
		
	}
	public void visibilityOfRetirementBttn() {
		this.elementVisible(retirementArticleSection);
		
	}
	public void visibilityOfRMDCalcAndCurrentAndFutureBttn() {
		this.elementVisible(rmdCalculatorSection);
		this.elementVisible(calculatorCurrentYearButton);
		this.elementVisible(calculatorFutureButton);
	}
	public void visibilityOfRetirementArticleSectionandReadArticleButtn() {
		this.elementVisible(retirementArticleSection);
		this.elementVisible(readArticleButton);
	}
	public void visibilityOfTitleRulesCard() {
		this.verifyPageIsLoaded();
		this.visibilityOfTitle();
		Assert.assertTrue(rmdDistributionSectionText.isDisplayed());
		Assert.assertTrue(rmdCardList.isDisplayed());
		
	}
	
	
	

}
