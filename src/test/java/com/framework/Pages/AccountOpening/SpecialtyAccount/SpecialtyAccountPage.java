package com.framework.Pages.AccountOpening.SpecialtyAccount;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class SpecialtyAccountPage extends BasePage {
	
	Logger log = LoggerHelper.getLogger(SpecialtyAccountPage.class);
	WebDriverWait wait;
	WebDriver driver;
	public SpecialtyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Trust')]")
	WebElement trustTab;
	public void clickOnTrustTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(trustTab));
		trustTab.click();
	}
	
	public void verifyTrustAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(trustTab.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'Estate')]")
	WebElement estateTab;
	public void clickOnEstateTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(estateTab));
		estateTab.click();
	}
	
	public void verifyEstateAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(estateTab.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'Guardian ')]")
	WebElement guardianTab;
	public void clickOnGuardianTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(guardianTab));
		guardianTab.click();
	}
	public void verifyGuardianAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(guardianTab.getText()));
	}
	
	@FindBy(xpath="//h3[contains(text(),'Beneficiary')]")
	WebElement benifiTab;
	public void clickOnbenifiTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(benifiTab));
		benifiTab.click();
	}
	
	public void verifyBenifiAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(benifiTab.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'403')]")
	WebElement fourThreeTab;
	public void clickOnfourThreeTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(fourThreeTab));
		fourThreeTab.click();
	}
	public void verifyfourThreeAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(fourThreeTab.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'Transfer on Death')]")
	WebElement transferOnDeathTab;
	public void clickOntransferOnDeathTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(transferOnDeathTab));
		transferOnDeathTab.click();
	}
	public void verifytransferOnDeathAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(transferOnDeathTab.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'Optional Retirement Program')]")
	WebElement orpTab;
	public void clickOnorpTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(orpTab));
		orpTab.click();
	}
	
	public void verifyorpAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(orpTab.getText()));
	}
	@FindBy(xpath="//h3[contains(text(),'Business/Organization')]")
	WebElement businessOrgTab;
	public void clickOnBusinessOrgnazationTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(businessOrgTab));
		businessOrgTab.click();
	}
	public void verifyBusinessOrgAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(businessOrgTab.getText()));
	}
	
	
	@FindBy(xpath="//h3[contains(text(),'Business/Organization')]")
	WebElement conservatorTab;
	public void clickOnconservatorTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(conservatorTab));
		conservatorTab.click();
	}
	
	public void verifyconservatorAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(conservatorTab.getText()));
	}
	
	@FindBy(xpath="//h3[contains(text(),'Guardianship')]")
	WebElement guardianShipTab;
	public void clickOnguardianShipTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(guardianShipTab));
		guardianShipTab.click();
	}
	
	public void verifyguardianShipAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(guardianShipTab.getText()));
	}
	
	@FindBy(xpath="//h3[contains(text(),'Pension')]")
	WebElement pentionTab;
	public void clickOnpentionTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(pentionTab));
		pentionTab.click();
	}
	public void verifypentionAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(pentionTab.getText()));
	}
	
	@FindBy(xpath="//h3[contains(text(),'Profit Sharing Plan')]")
	WebElement profitshareingPlanTab;
	public void clickOnprofitshareingPlanTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(profitshareingPlanTab));
		profitshareingPlanTab.click();
	}
	public void verifyprofitshareingPlanAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(profitshareingPlanTab.getText()));
	}
	
	
	@FindBy(xpath="//h3[contains(text(),'Broker Dealer')]")
	WebElement brokerDealer;
	public void clickOnbrokerDealer() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(brokerDealer));
		brokerDealer.click();
	}
	public void verifybrokerDealerAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(brokerDealer.getText()));
	}
	
	@FindBy(xpath="//h3[contains(text(),'Financial Institution')]")
	WebElement financialInstiTab;
	public void clickOnfinancialInstiTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(financialInstiTab));
		financialInstiTab.click();
	}
	public void verifyfinancialInstiAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(financialInstiTab.getText()));
	}
	
	@FindBy(xpath="//h3[contains(text(),'Business Corporation')]")
	WebElement businessCorporateTab;
	public void clickOnbusinessCorporateTab() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(businessCorporateTab));
		businessCorporateTab.click();
	}
	
	public void verifyRothConversionIRAAccount(String expected) {
		log.info("Expected"+expected);
		Assert.assertTrue(expected.equalsIgnoreCase(businessCorporateTab.getText()));
	}
	
	@FindBy(xpath="//h3[contains(text(),'Roth')]")
    WebElement rothConversionIRATab;
    public void clickOnRothConversionIRATab() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(rothConversionIRATab));
        rothConversionIRATab.click();
    }
	public void clickOnAccountType(String accountType) {
		log.info("Account Type"+accountType);
		switch(accountType) {
			case "Trust":
				this.clickOnTrustTab();
				break;
			case "Estate":
				this.clickOnGuardianTab();
				break;
			case "Guardian IRA":
				this.clickOnGuardianTab();
				break;
			case "Beneficiary IRA":
				this.clickOnbenifiTab();
				break;
			case "403B":
				this.clickOnfourThreeTab();
				break;
			case "Transfer on Death":
				this.clickOntransferOnDeathTab();
				break;
			case "Optional Retirement Program (ORP)":
				this.clickOnorpTab();
				break;
			case "Business/Organization":
				this.clickOnBusinessOrgnazationTab();
				break;
			case "Guardianship":
				this.clickOnGuardianTab();
				break;
			case "Pension":
				this.clickOnpentionTab();
				break;
			case "Profit Sharing Plan":
				this.clickOnprofitshareingPlanTab();
				break;

			case "Roth Conversion IRA":
			    this.clickOnRothConversionIRATab();
			    
			case "Business Corporation":
				this.clickOnbusinessCorporateTab();
				break;
		}
	}
	
}
