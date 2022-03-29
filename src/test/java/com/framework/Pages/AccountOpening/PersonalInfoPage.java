package com.framework.Pages.AccountOpening;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.DropDownHelper.DropDownHelper;
import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class PersonalInfoPage extends BasePage  {
	
	WebDriverWait wait;
	WebDriver driver;
	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	Logger log = LoggerHelper.getLogger(PersonalInfoPage.class);
	DropDownHelper dropdown =  new DropDownHelper();
	
	@FindBy(xpath="//span[contains(text(),'2.  Personal Info')]")
	WebElement personalInfoTxt;
	
	public void verifyPersonalInfoPageIsDisplaying() {
		this.elementVisible(personalInfoTxt);
	}
	
	@FindBy(css="input[name='Address Line 2']")
	WebElement addressLine1;
	
	public void enterAddress(String address) {
		log.info("Address line 1"+address);
		addressLine1.sendKeys(address);
	}
	@FindBy(css="input[name='zipCode']")
	WebElement zipCode;
	
	public void enterZipCode(String zipcode) {
		log.info("Zip Code"+zipcode);
		zipCode.sendKeys(zipcode);
	}
	@FindBy(id="mailinguspsSuggestedCardId")
	WebElement useAddresssBtn;
	
	public void clickOnAddressBtn() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(useAddresssBtn));
	    this.clickOnButtonUsingJs(useAddresssBtn);
	    while(true){
	    try{
	    	 this.clickOnButtonUsingJs(useAddresssBtn);
	    	}
	    catch(Exception e){
			break;
	    }  
	    }
	}
	@FindBy(css="input#empStatus")
	WebElement empStatusDropdown;
	
	public void enterEmployeeStatus(String txt) {
		log.info("Employee Status"+txt);
		dropdown.SelectUsingVisibleValue(empStatusDropdown, txt);
	}
	@FindBy(css="input#primarySourceofIncome")
	WebElement primarySource;
	
	public void enterPrimarySource(String primarySource) {
		log.info("Primary Source"+primarySource);
		dropdown.SelectUsingVisibleValue(empStatusDropdown, primarySource);
	}
	@FindBy(css="input#jointOwnerssnOne")
	WebElement ssnTxt1;
	@FindBy(css="input#jointOwnerssnTwo")
	WebElement ssnTxt2;
	@FindBy(css="input#jointOwnerssnThree")
	WebElement ssnTxt3;
	
	public void enterSocialSecurityNo(String ssn1,String ssn2,String ssn3) {
		log.info("SSN1"+ssn1);
		log.info("SSN2"+ssn2);
		log.info("SSN3"+ssn3);
		ssnTxt1.sendKeys(ssn1);
		ssnTxt2.sendKeys(ssn2);
		ssnTxt3.sendKeys(ssn3);
	}
	@FindBy(css="input#JointPrimaryPhoneNumber0")
	WebElement primaryPhoneNo;
	public void enterPrimaryPhoneNo(String phoneNo) {
		log.info("Phone no"+phoneNo);
		primaryPhoneNo.sendKeys(phoneNo);
	}
	@FindBy(xpath="//input[contains(@id,'jointOwnerprimaryemail')]")
	WebElement primaryEmail;
	
	public void enterPrimaryEmail(String email) {
		log.info("Email Id"+email);
		primaryEmail.sendKeys(email);
	}
	@FindBy(xpath="//input[contains(@id,'jointOwnerFirstName')]")
	WebElement fname;
	public void enterFirstName(String fName) {
		log.info("First Name"+fName);
		fname.sendKeys(fName);
	}
	@FindBy(xpath="//input[contains(@id,'jointOwnerLastName')]")
	WebElement lname;
	
	public void enterLastName(String lName) {
		log.info("First Name"+lName);
		lname.sendKeys(lName);
	}
	@FindBy(xpath="//input[contains(@id,'jointOwnerrelationship')]")
	WebElement relationDropDown;
	public void clickOnrelationDropDown(String type) {
		log.info("Relation Type"+type);
		relationDropDown.click();
		driver.findElement(By.xpath("//span[contains(text(),'"+type+"')]")).click();
	}
	@FindBy(xpath="//label[contains(@for,'Male0')]")
	WebElement maleTxt;
	public void clickOnMaleRadioBtn() {
		this.selectCheckBox(maleTxt);
	}
	@FindBy(xpath="//label[contains(@for,'Female0')]")
	WebElement FemaleTxt;
	public void clickOnFeMaleRadioBtn() {
		this.selectCheckBox(FemaleTxt);
	}
	public void selectGenderChkBox(String type) {
		if(type.equals("Male")) {
			clickOnMaleRadioBtn();
		} else if(type.equals("Female")) {
			clickOnFeMaleRadioBtn();
		}
	}
	@FindBy(xpath="//input[contains(@id,'maritalStatus0')]")
	WebElement maritalStatusDropdown;
	public void clickOnMaritalDropown(String type) {
		log.info("Marital Status"+type);
		maritalStatusDropdown.click();
		driver.findElement(By.xpath("//span[contains(text(),'"+type+"')]")).click();
	}
	@FindBy(xpath="//input[contains(@id,'jointOwnermailingAddressLine2')]")
	WebElement joinOwnerAddress;
	@FindBy(xpath="//input[contains(@id,'jointOwnermailingzipcode')]")
	WebElement jointzip;
	
	public void enterJointAddress(String address) {
		log.info("Address"+address);
		joinOwnerAddress.sendKeys(address);
	}
	@FindBy(css="input#jointOwnermailingcity0")
	WebElement cityName;
	public void enterzipAddress(String zipCode) throws InterruptedException {
		log.info("Zip Code"+zipCode);
		jointzip.sendKeys(zipCode);	
		zipCodeSpan.click();
	}
	public void clickOncity() {
	       cityName.click();
	}
	@FindBy(xpath="//span[contains(@id,'jointOwnerisPhysicalAddressSameasMailingAddress0')]/following-sibling::div//span[contains(text(),'Yes')]/..")
	WebElement phyaddressChkBox;
	public void clickonPhyAddressChkBox() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(phyaddressChkBox));
		phyaddressChkBox.click();
	}
	
	public void selectAccountType(String accType){
		WebElement type= driver.findElement(By.xpath("//h3[text()='"+accType+"']"));
		this.clickOnButton(type);
	}
	@FindBy(id="beneficiaryP1BeneficiaryType")
  	WebElement beneficiaryP1BeneficiaryType;
	
	@FindBy(xpath="//span[text()='Non-Individual']")
  	WebElement nonIndividual;
	@FindBy(xpath="//span[text()='Individuals']")
  	WebElement individual;
	@FindBy(xpath="//input[@name='relationToAccHolder']")
  	WebElement relationToAccHolder;
	@FindBy(xpath="//span[text()='Spouse']")
  	WebElement spouse;
	@FindBy(xpath="//span[text()='Non Spouse']")
  	WebElement nonspouse;
	@FindBy(id="beneficiaryP1DistributionPercentage")
  	WebElement beneficiaryP1DistributionPercentage;
	@FindBy(id="beneficiaryP1FirstName")
  	WebElement beneficiaryP1FirstName;
	@FindBy(id="beneficiaryP1LastName")
  	WebElement beneficiaryP1LastName;
	@FindBy(id="beneficiaryP1BeneficiaryDOB")
  	WebElement beneficiaryP1BeneficiaryDOB;
	@FindBy(xpath="//div[contains(@class,'today')]")
  	WebElement todayDOB;
	
	
		public void enterInfo(String benType,String relation,String percentage, String fname, String lname) {
			//this.enterPrimarySourceOfIncome();
			this.scrollIntoViewAndClick(beneficiaryP1BeneficiaryType);
			if(benType.equalsIgnoreCase("Individuals")){
				this.clickOnButton(individual);
				this.clickOnButton(relationToAccHolder);
				if(relation.equalsIgnoreCase("spouse"))
					this.clickOnButton(spouse);
				else
					this.clickOnButton(nonspouse);
				this.sendKeys(beneficiaryP1DistributionPercentage, percentage);
				this.sendKeys(beneficiaryP1FirstName, fname);
				this.sendKeys(beneficiaryP1LastName, lname);
				this.clickOnButton(beneficiaryP1BeneficiaryDOB);
				this.clickOnButton(todayDOB);
			}
			else{
		this.clickOnButton(nonIndividual);
		this.sendKeys(beneficiaryP1DistributionPercentage, percentage);
		this.sendKeys(beneficiaryP1FirstName, fname);
			}
	}
		@FindBy(xpath="//span[text()='Use this address']")
		WebElement useThisAddressBtn;
		public void clickOnUseThisAddressBtn() throws InterruptedException {
		    if(this.isElementPresent(By.xpath("//span[text()='Use this address']")) && driver.findElement(By.xpath("//span[text()='Use this address']")).isDisplayed()) {
		        Thread.sleep(3000);
		        useThisAddressBtn.click();
		    }
		}

		@FindBy(xpath="//label[@for='mailingzipcode0']")
	  	WebElement zipCodeSpan;
		public void enterZip(String zip) {
			log.info(zipCode.getAttribute("value").toString().length());
			int i=zipCode.getAttribute("value").toString().length();
			while(i!=0){
				zipCode.sendKeys(Keys.BACK_SPACE);
				i--;
			}
			this.sendKeys(zipCode, zip);
			zipCodeSpan.click();
			zipCodeSpan.click();
		}

		@FindBy(id="mailingzipcode0inputErrorText")
	  	WebElement zipError;
		public void verifyZipError() {
			this.elementVisible(zipError);
		}
		
		public void verifyZipAccepted() {
			By alert=By.xpath("//div[@role='alert']");
			wait = new WebDriverWait(driver, 40);
			Assert.assertFalse(this.isElementPresent(alert));
		}
		public void selectBlankBenefeciaryType() {
			this.clickOnButton(beneficiaryP1BeneficiaryType);
			beneficiaryP1BeneficiaryType.sendKeys(Keys.TAB);
		}
		@FindBy(id="beneficiaryP1BeneficiaryType-error")
	  	WebElement beneficiaryP1BeneficiaryTypeerror;
		public void verifyBeneficiaryTypeerror() {
			this.elementVisible(beneficiaryP1BeneficiaryTypeerror);
		}
		public void enterDistributionPercentage(String per) {
			this.clearAndSendKeys(beneficiaryP1DistributionPercentage, per);
			beneficiaryP1BeneficiaryType.sendKeys(Keys.TAB);
		}
		@FindBy(id="beneficiaryP1DistributionPercentageinputErrorText")
	  	WebElement beneficiaryP1DistributionPercentageinputErrorText;
		public void verifyDistributionPercentageError() {
			this.elementVisible(beneficiaryP1DistributionPercentageinputErrorText);
		}
		public void enterBeneficiaryP1FirstName(String fname) {
			this.clearAndSendKeys(beneficiaryP1FirstName, fname);
			beneficiaryP1FirstName.sendKeys(Keys.TAB);
		}
		@FindBy(id="beneficiaryP1FirstNameinputErrorText")
	  	WebElement beneficiaryP1FirstNameinputErrorText;
		public void verifyBeneficiaryP1FirstNameError() {
			this.elementVisible(beneficiaryP1FirstNameinputErrorText);
		}
		public void enterBeneficiaryP1LastName(String lname) {
			this.clearAndSendKeys(beneficiaryP1LastName, lname);
			beneficiaryP1LastName.sendKeys(Keys.TAB);
		}
		@FindBy(id="beneficiaryP1LastNameinputErrorText")
	  	WebElement beneficiaryP1LastNameinputErrorText;
		public void verifyBeneficiaryP1LastNameError() {
			this.elementVisible(beneficiaryP1LastNameinputErrorText);
		}
		public void verifyRecommendation() {
			this.elementVisible(useAddresssBtn);
		}
		@FindBy(id="PrimaryPhoneNumber0")
	  	WebElement PrimaryPhoneNumber;
		
		public void enterPhoneNumber(String phone) {
			int i=PrimaryPhoneNumber.getAttribute("value").toString().length();
			while(i!=0){
				PrimaryPhoneNumber.sendKeys(Keys.BACK_SPACE);
				i--;
			}
			this.sendKeys(PrimaryPhoneNumber, phone);
			zipCodeSpan.click();
		}
		@FindBy(id="PrimaryphoneNumber_error")
	  	WebElement PrimaryphoneNumber_error;
		public void verifyPhoneNumberError() {
			this.elementVisible(PrimaryphoneNumber_error);
		}
		@FindBy(css="input#JointempStatus0")
		WebElement statusDropDown;
		public void  clickOnEmployeeStatusDropDown() {
		    statusDropDown.click();
		    WebElement retiredDropDnValue = driver.findElement(By.xpath("//span[text()='Retired']"));
		    this.clickOnButtonUsingJs(retiredDropDnValue);
		}
		@FindBy(css="input#JointprimarySourceofIncome0")
		WebElement jointPrimarySourceDropDn;
		public void clickOnJointSourceDropDn() {
		    jointPrimarySourceDropDn.click();
		    WebElement DropDnValue = driver.findElement(By.xpath("//span[text()='Social Security']"));
            this.clickOnButtonUsingJs(DropDnValue);
		}
		@FindBy(xpath="//span[text()='Save']")
		WebElement saveBtn;
		
		public void clickOnSaveBtn() {
		    this.verifyPageIsLoaded();
		    wait = new WebDriverWait(driver, 40);
		    wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		    this.clickOnButtonUsingJs(saveBtn);
		}
		@FindBy(xpath="//h2[text()='Save Successful']")
		WebElement verifyPopUp;
		@FindBy(css="button#confirmation-modal-primary-btn")
		WebElement confirmationBtn;
		public void verifyMySavedItemPopup() {
		    wait = new WebDriverWait(driver, 40);
		    wait.until(ExpectedConditions.visibilityOf(verifyPopUp));
		    Assert.assertTrue(verifyPopUp.isDisplayed());
		    confirmationBtn.click();
		}
			
	
}
