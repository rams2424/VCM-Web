package com.framework.Pages.AccountOpening;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;
import com.framework.Pages.AccountOpening.GeneralInvestmentAccount.GeneralInvestmentAccountPage;
import com.framework.Pages.AccountOpening.IndividualRetirementAccount.IndividualRetirementAccountPage;
import com.framework.Pages.AccountOpening.SpecialtyAccount.SpecialtyAccountPage;
import com.framework.Pages.AccountOpening.UGMAAccount.InvestingforChildrenPage;

public class OpenAccountPage extends BasePage {
	
	WebDriverWait wait;
	WebDriver driver;
	public OpenAccountPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	Logger log = LoggerHelper.getLogger(OpenAccountPage.class);
	
	@FindBy(xpath="//div[@id='breadcrumb']//following-sibling::div[1]//h1")
	WebElement openAccountTitle;
	public void VerifyAccountOpenTitle(String expectedTitle) {
		log.info(openAccountTitle.getText());
		log.info("Expected Title"+expectedTitle);
		Assert.assertTrue(openAccountTitle.getText().contains(expectedTitle));		
	}
	
	public void clickOnAccount(String accountType) {
		log.info("Account Type"+accountType);
		wait = new WebDriverWait(driver, 40);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+accountType+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		this.clickOnButton(element);
	}
	@FindBy(xpath="//*[contains(text(),'General Investment Account')]")
	WebElement generalInvestMentTab;
	
	public void clickOnGIAAccount() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(generalInvestMentTab));
		this.clickOnButton(generalInvestMentTab);
	}
	
	@FindBy(xpath="//*[contains(text(),'Individual Retirement Account')]")
	WebElement iraTab;
	public void clickOnIRATab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(iraTab));
		this.clickOnButton(iraTab);	
	}
	
	@FindBy(xpath="//*[contains(text(),'Investing for Children')]")
	WebElement investingForChildrenTab;
	
	public void clickOnInvestingForChildrenTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(investingForChildrenTab));
		this.clickOnButton(investingForChildrenTab);	
	}
	
	@FindBy(xpath="//*[contains(text(),'Specialty Account')]")
    WebElement specialityAccountTab;
	
	public void clickOnSpecialityAccount() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(specialityAccountTab));
		this.clickOnButton(specialityAccountTab);	
	}
	
	@FindBy(xpath="//*[text()='Next']")
	WebElement nextBtn;
	public void clickOnNextButton() throws InterruptedException {
	    this.verifyPageIsLoaded();
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		this.scrollIntoView(nextBtn);
		this.clickOnButtonUsingJs(nextBtn);
		 this.verifyPageIsLoaded();
	}
	public void verifyNextButtonIsVisible() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(nextBtn));
		Assert.assertTrue(nextBtn.isDisplayed());
	}
	@FindBy(xpath="//span[text()='Back']")
	WebElement backBtn;
	public void verifyBackBtnIsIsVisible() {
		Assert.assertTrue(backBtn.isDisplayed());
	}
	@FindBy(xpath="//span[text()='Save']")
	WebElement saveBtn;
	public void verifysaveBtnIsVisible() {
		Assert.assertTrue(saveBtn.isDisplayed());
	}
	@FindBy(css="button#cancelButton")
	WebElement cancelBtn;
	public void verifyCancelBtn() {
		Assert.assertTrue(cancelBtn.isDisplayed());
	}
	
	public GeneralInvestmentAccountPage navigateToGIASelectionPage() {
		return new GeneralInvestmentAccountPage(driver);
	}
	public void verifyGIAAccountIsDisplayed(String actual) {
		log.info("Actual"+actual);
		log.info("Expected "+generalInvestMentTab.getText());
		Assert.assertTrue(actual.equalsIgnoreCase(generalInvestMentTab.getText()));
	}
	public void verifyIRAAccountIsDisplayed(String actual) {
		log.info("Actual"+actual);
		log.info("Expected "+iraTab.getText());
		Assert.assertTrue(actual.equalsIgnoreCase(iraTab.getText()));
	}
	public void verifyInvestingForChildrenAccountDisplaying(String actual) {
		log.info("Actual"+actual);
		log.info("Expected "+investingForChildrenTab.getText());
		Assert.assertTrue(actual.equalsIgnoreCase(investingForChildrenTab.getText()));
	}
	public void verifySpecialityAccountIsDisplaying(String actual) {
		log.info("Actual"+actual);
		log.info("Expected "+specialityAccountTab.getText());
		Assert.assertTrue(actual.equalsIgnoreCase(specialityAccountTab.getText()));
	}
	
	public IndividualRetirementAccountPage navigateToIRAPage() {
		return new IndividualRetirementAccountPage(driver);
	}
	public InvestingforChildrenPage navigateToUGMAPage() {
		return new InvestingforChildrenPage(driver);
	}
	public SpecialtyAccountPage navigateToSpecialityPage() {
		return new SpecialtyAccountPage(driver);
	}
}
