package com.framework.Pages.Login;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.framework.Helper.Navigation.Browser.BrowserHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Pages.BasePage;
import com.framework.Pages.HomePage;

public class LoginPage  extends BasePage{
    
    Logger log = Logger.getLogger(LoginPage.class);
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);   
    }
    BrowserHelper browserHelper = new BrowserHelper(DriverFactory.getInstance().getDriver());
    @FindBy(xpath="//img[@class='cookie_close']")
    WebElement closeCookieBtn;
    
    public void closeCookieButton() {
        if(this.isElementPresent(By.xpath("//img[@class='cookie_close']")) && driver.findElement(By.xpath("//img[@class='cookie_close']")).isDisplayed()) {
            wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(closeCookieBtn));
            this.clickOnButtonUsingJs(closeCookieBtn);
        }
    }
    @FindBy(css="input#onlineId")
    WebElement onlineId;
    
    private void enterOnlineid(String oId) {
        this.sendKeys(onlineId, oId);
    }
    @FindBy(css="input#password")
    WebElement pass;
    
    private void enterPassWord(String pass1) {
        this.sendKeys(pass, pass1);
    }
    @FindBy(xpath="//*[@id='button']/span")
    WebElement signinBtn;
    
    @FindBy(css="span[data-test='greetmsg']")
    WebElement greetMsg;
    public void clickOnSignInButton() {
        if(this.isElementPresent(By.xpath("//*[@id='button']/span")) && driver.findElement(By.xpath("//*[@id='button']/span")).isDisplayed()) {
            wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(signinBtn));
            //this.scrollToElement(signinBtn);
            this.clickOnelement(signinBtn);
        }
    }
    
    public void login(String onlineId,String pass) throws InterruptedException {
        //log.info("Onlineid"+onlineId);
        //log.info("PassWord"+pass);
        this.waitForPageLoaded();
        this.closeCookieButton();
        this.LoginToSIT(onlineId, pass); 
      //  this.verifyPageIsLoaded();
    }
    
    public void LoginToSIT(String onlineId,String pass) { 
        try {
            // this.handleAuthenticatioPop();
            log.info("Online id = > "+onlineId);
            log.info("password = > "+pass);
            this.closeCookieButton();
            this.enterOnlineid(onlineId);
            this.enterPassWord(pass);
            this.clickOnSignInButton();
           // this.verifyLogin();
            Thread.sleep(3000);
            this.CheckforLoginError();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        
    }
	
      public void loginforFail(String onlineId,String pass) throws InterruptedException {
    	log.info("Onlineid = > "+onlineId);
        log.info("PassWord = > "+pass);
        try {
        this.waitForPageLoaded();
        this.closeCookieButton();
        this.enterOnlineid(onlineId);
        this.enterPassWord(pass);
        this.clickOnSignInButton();
        Thread.sleep(3000);
        }catch(Exception ex) {}
    }
    public void verifyLogin() {
        if(isElementPresent(By.xpath("//*[contains(text(),'Please enter valid credentials.')]"))) {
            log.info("Online id and password is correct");
        } else {
            //Assert.fail("Incorrect online id and password"); 
        }
    }
    
    public void handleAuthenticatioPop() throws FindFailed, InterruptedException {
        Screen screen=new Screen();
        String path = System.getProperty("user.dir");
        System.out.println("Path"+path);
        Pattern  image1=new Pattern(path+"\\src\\main\\resources\\Images\\u.PNG");
        screen.wait(image1,20);
        screen.type(image1,"victory");   
        screen.type(Key.TAB);
        screen.type(Key.TAB);
        screen.type(Key.TAB);
        screen.type(Key.ENTER);
    }
    
    @FindBy(xpath="//p[contains(text(),'Your credentials are not correct.')]")
    WebElement loginErrorMsg;
    
    @FindBy(xpath="//p[contains(text(),'your account has been locked')]")
    WebElement accntLockErrorMsg;
    
    @FindBy(xpath="//p[contains(text(),'Please enter valid credentials')]")
    WebElement invalidcredErrorMsg;
	
    @FindBy(xpath="//h1[contains(text(),\"Choose Validation Method\")]")
    WebElement otpPage1;
    
	public void checkForinvalidCredentials() {

		try {
			if (loginErrorMsg.isDisplayed()) {
				Assert.assertFalse(true);
			}
		} catch (Exception ex) {
		}
	}
    
	public void checkForAccountLocked() {
		
		try {
			if (accntLockErrorMsg.isDisplayed()) {
				Assert.assertFalse(true);
			}
		} catch (Exception ex) {
			
		}
		
	}
 
	public void checkForInvalidUserNamePwd() {

		try {
			if (invalidcredErrorMsg.isDisplayed()) {
				Assert.assertFalse(true);
			}
		} catch (Exception ex) {
		}
	}
	
	public void checkForOTPPage() {
	    
		try {
			if (otpPage1.isDisplayed()) {
				log.info("LOG: OTP Page is displayed  >>>>>>>>>>>>>>>>");
				Assert.assertFalse(true,"OTP Page is displayed");
			}
		} catch (Exception ex) {
		}
	}
    
	public void CheckforLoginError() {
		log.info("LOG: Checking for login error message");
		this.checkForAccountLocked();
		this.checkForinvalidCredentials();
		this.checkForInvalidUserNamePwd();
		this.checkForOTPPage();
		log.info("LOG: Checking for login error message done here ");

	}
    
    @FindBy(xpath="//p[contains(text(),\"Password is mandatory. It cannot be left blank\")]")
    WebElement passwordMandatoryMessage;
    
    public void CheckVisibilityOf_passwordMandatoryMessage(){
        this.elementVisible(passwordMandatoryMessage);		
    }
    
    @FindBy(xpath="//p[contains(text(),\"User ID is mandatory. It cannot be left blank\")]")
    WebElement userIdMandatoryMessage;
    
    public void CheckVisibilityOf_userIdMandatoryMessage(){
        this.elementVisible(userIdMandatoryMessage);		
    }
    @FindBy(xpath="//a[text()='Investor Relations ']")
    WebElement linkInvestorRelations;
    
    public void CheckVisibilityOf_linkInvestorRelations(){
        this.elementVisible(linkInvestorRelations);		
    }
    
    
    @FindBy(xpath="//ul[contains(@class,'showinDesktop toplinks')]/li/a[contains(@class,'contact')]")
    WebElement linkContactUs;
    
    public void CheckVisibilityOf_linkContactUs(){
        this.elementVisible(linkContactUs);		
    }
    
    @FindBy(xpath="//a[contains(text(),'Careers')]")
    WebElement careers;
    
    public void CheckVisibilityOf_careers(){
        this.elementVisible(careers);		
    }
    
    @FindBy(xpath="//a[contains(text(),'Policies')]")
    WebElement Policies;
    
    public void CheckVisibilityOf_Policies(){
        this.elementVisible(Policies);		
    }
    
    
    @FindBy(xpath="//a[contains(text(),'News')]")
    WebElement news;
    
    public void CheckVisibilityOf_news(){
        this.elementVisible(news);		
    }
    
    @FindBy(xpath="//a[contains(text(),'Terms of Use')]")
    WebElement termsOfUse;
    
    public void CheckVisibilityOf_termsOfUse(){
        this.elementVisible(termsOfUse);		
    }
    
    @FindBy(xpath="//a[contains(text(),'Terms & Conditions')]")
    WebElement termsAndConditions;
    
    public void CheckVisibilityOf_termsAndConditions(){
        this.elementVisible(termsAndConditions);		
    }
    
    @FindBy(xpath="//a[contains(text(),'Sign in here')]")
    WebElement InvestorsSignIn;
    
    public void CheckVisibilityOf_InvestorsSignIn(){
        this.elementVisible(InvestorsSignIn);		
    }
    
    @FindBy(xpath="//span[contains(text(),'Sign In/Register')]")
    WebElement signInRegister;
    
    public void CheckVisibilityOf_signInRegister(){
        this.elementVisible(signInRegister);		
    }
    
    @FindBy(xpath="//img[@class='drop-icon']")
    WebElement dropIcon;
    
    public void CheckVisibilityOf_dropIcon(){
        this.elementVisible(dropIcon);		
    }
    
    @FindBy(xpath="//img[contains(@class,'FAB')]")
    WebElement FAB;
    
    public void CheckVisibilityOf_FAB(){
        this.elementVisible(FAB);		
    }
    
    @FindBy(id="SignUpBtn")
    WebElement SignUpBtn;
    
    public void CheckVisibilityOf_SignUpBtn(){
        this.elementVisible(SignUpBtn);		
    }
    
    
    @FindBy(xpath="//li[contains(@aria-label,'USAA')]//a[contains(text(),'USAA')]")
    WebElement USSAmembers;
    
    public void CheckVisibilityOf_USSAmembers(){
        this.elementVisible(USSAmembers);		
    }
    
    @FindBy(xpath="//a[text()='Financial Professionals ']")
    WebElement financialProfessionals;
    
    public void CheckVisibilityOf_financialProfessionals(){
        this.elementVisible(financialProfessionals);		
    }
    
    @FindBy(xpath="//a[text()='Institutional Investors ']")
    WebElement institutionalInvestors;
    
    public void CheckVisibilityOf_institutionalInvestors(){
        this.elementVisible(institutionalInvestors);		
    }
    
    @FindBy(xpath="//a[contains(@href,'facebook')]")
    WebElement fbContact;
    
    public void CheckVisibilityOf_fbContact(){
        this.elementVisible(fbContact);		
    }
    @FindBy(xpath="//a[contains(@href,'twitter')]")
    WebElement twitterContact;
    
    public void CheckVisibilityOf_twitterContact(){
        this.elementVisible(twitterContact);		
    }
    @FindBy(xpath="//a[contains(@href,'youtube')]")
    WebElement youtubeContact;
    
    public void CheckVisibilityOf_youtubeContact(){
        this.elementVisible(youtubeContact);		
    }
    
    @FindBy(xpath="//a[contains(@href,'linkedin')]")
    WebElement linkedinContact;
    
    public void CheckVisibilityOf_linkedinContact(){
        this.elementVisible(linkedinContact);		
    }
    
    public void clickOn_linkedinContact(){
        //this.verifyPageIsLoaded();
        String parentWindow = driver.getWindowHandle();
        linkedinContact.click();
        new WebDriverWait(driver,40).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("https://www.linkedin.com/"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow); 
    }
    
    
    public void clickOn_youtubeContact(){
        String parentWindow = driver.getWindowHandle();
        youtubeContact.click();
        new WebDriverWait(driver,40).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/channel"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow); 
    }
    
    public void clickOn_twitterContact(){
        this.verifyPageIsLoaded();
        
        String parentWindow = driver.getWindowHandle();
        twitterContact.click();
        new WebDriverWait(driver,40).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/vcmtweets"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }
    
    
    public void clickOn_FBContact(){
        
        this.verifyPageIsLoaded();
        
        
        
        String parentWindow = driver.getWindowHandle();
        fbContact.click();
        new WebDriverWait(driver,40).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/victorycapitalmanagement/"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }
    
    
    public void clickOn_linkInvestorRelations(){
        this.clickOnButton(linkInvestorRelations);
    }
    
    public void verifyInvestorRelationsPage() {
        browserHelper.SwitchToWindow(1);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://ir.vcm.com/overview/default.aspx"));
        browserHelper.switchToParentWithChildClose();
    }
    
    public void clickOn_USSAmembers(){
        this.clickOnButton(USSAmembers);
    }	
    
    public void verifyUSSAmembersPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qa.investor.vcm.com/member"));
    }
    
    public void clickOn_financialProfessionals(){
        this.clickOnButton(financialProfessionals);
    }
    
    public void verifyFinancialProfessionalPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qa.advisor.vcm.com/financial-professional"));
    }
    
    
    public void clickOn_institutionalInvestors(){
        this.clickOnButton(institutionalInvestors);
    }	
    
    public void verifyInstitionalInvestorsPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qa.institutional.vcm.com/institutional-investor"));
    }
    
    public HomePage navigateToHomePage(){
        return new HomePage(driver);	
    }
    
    public void clickOn_Signup(){
        this.clickOnButton(SignUpBtn);
    }	
    public void verifySignUp() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/personal-details"));
    }
    
    
    public void clickOn_Signin_Register(){
        this.clickOnButton(signInRegister);
    }
    public void verifySignin_Register() {
        browserHelper.SwitchToWindow(1);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qa.mysecure.vcm.com/sign-in"));
        browserHelper.switchToParentWithChildClose();
    }
    
    
    public void clickOn_ContactUs(){
        this.clickOnButton(linkContactUs);
    }
    public void verifyContactUs() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/contact-us"));
    }
    
    
    
    public void clickOn_DropIcon(){
        this.clickOnButton(dropIcon);
        this.CheckVisibilityOf_financialProfessionals();
        this.CheckVisibilityOf_institutionalInvestors();
        this.CheckVisibilityOf_USSAmembers();
    }
    
    public void clickOn_InvesterLogin(){
        this.clickOnButton(InvestorsSignIn);
    }	
    public void verifyInvesterLoginPage() {
        browserHelper.SwitchToWindow(1);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.vcm.com/docs/default-source/default-document-library/victory-capital-terms-of-service.pdf"));
        browserHelper.switchToParentWithChildClose();
    }
    
    public void clickOn_TermsAndConditions(){
        this.clickOnButton(termsAndConditions);		
    }
    public void verifyTermsAndConditionsPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/user-agreement"));
    }
    
    
    public void clickOn_TermsOfUse(){
        this.clickOnButton(termsOfUse);
    }
    public void verifyTermsOfUse() {
        browserHelper.SwitchToWindow(1);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.vcm.com/docs/default-source/default-document-library/victory-capital-terms-of-service.pdf"));
        browserHelper.switchToParentWithChildClose();
    }
    public void clickOn_Careers(){
        this.clickOnButton(careers);
    }
    public void verifyCareersPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/careers"));
    }
    public void clickOn_Policies(){
        this.clickOnButton(Policies);
    }
    public void verifyPoliciesPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/policies"));
    }
    
    public void clickOn_News(){
        this.clickOnButton(news);
    }
    public void verifyNewsPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/news"));
    }
    
    @FindBy(xpath="//div[contains(@class,'escape-hatch-class-dialog ModalViews__ViewContainer-xkqjo0-0 kfBXca')]")
    WebElement FABassist;
    @FindBy(xpath="//div[@data-testid='wicon-component-id']")
    WebElement FABcloseImg;
    
    public void clickOn_FABNeedAssistance(){
        this.clickOnButton(FAB);
        this.CheckVisibilityOf_FABassist();
        this.CheckVisibilityOf_FABcloseImg();
    }
    public void CheckVisibilityOf_FABassist(){
        this.elementVisible(FABassist);		
    }
    public void CheckVisibilityOf_FABcloseImg(){
        this.elementVisible(FABcloseImg);		
    }
    public void clickOn_FABcloseImg(){
        this.clickOnButton(FABcloseImg);
        this.CheckVisibilityOf_FAB();
    }
    
    @FindBy(xpath="//a[contains(text(),'Forgot User ID')]")
    WebElement forgotUserId;
    
    public void CheckVisibilityOf_forgotUserId(){
        this.elementVisible(forgotUserId);		
    }
    public void clickOn_ForgotUserId(){
        this.clickOnButton(forgotUserId);
    }
    public void verifyRetreiveUseridPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/recover-online-id"));
    }
    
    
    @FindBy(xpath="//a[contains(text(),'Forgot Password')]")
    WebElement forgotPassword;
    
    public void CheckVisibilityOf_forgotPassword(){
        this.elementVisible(forgotPassword);		
    }	
    public void clickOn_ForgotPassword(){
        this.clickOnButton(forgotPassword);
    }
    public void verifyRetreivePasswordPage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://sit.msweb.vcm.com/retrieve-password"));
    }
    
    
    public void CheckVisibilityOf_useridText(){
        this.elementVisible(onlineId);		
    }
    
    public void CheckVisibilityOf_passwordText(){
        this.elementVisible(pass);		
    }
    
    public void CheckVisibilityOf_signinButton(){
        this.elementVisible(signinBtn);		
    }
    
    public void LoginToSITusingWrongCredentials(String userName, String pass) {
        log.info("UserName"+userName);
        log.info("Password"+pass);
        this.enterOnlineid(userName);
        this.enterPassWord(pass);
    }
    @FindBy(css="p#password_error")
    WebElement passwordErrorMsg;
    
    public void CheckVisibilityOf_errorMessage() {
        this.elementVisible(passwordErrorMsg);
    }
    public void LoginToSITwithoutUseridANDpassword() {
        this.enterOnlineid("");
        this.enterPassWord("");
    }
    
    @FindBy(xpath="//*[contains(text(),'For your security')]")
    WebElement accountLockMsg;
    
    /**
     * Verify Account locked message is displaying or not
     */
    public void verifyAccountLockedMsg(String expected) {
        log.info("Expected"+expected);
        Assert.assertTrue(accountLockMsg.isDisplayed());
    }
    @FindBy(xpath="//button[contains(@class,'menuDropIcon')]")
    WebElement dropDownLink;
    public void clickOnMenuDropDown() {
        dropDownLink.click();
    }
    //@FindBy(xpath="//p[@id='password_error']")
    @FindBy(xpath="//p[contains(text(),'Your credentials are not correct')]")
    WebElement incorrectPassMsg;
    public void verifyIncorrectLogin(String expected) {
	    try{
    		Thread.sleep(2000);
    	}catch(Exception ex){}
    	if(incorrectPassMsg.isDisplayed()) {
    		log.info("Error message is displayed !!!!!!!!!!!!!");
    	}else {
    		log.info("Error message is NOT displayed !!!!!!!!!!!!!");
    		Assert.fail("No Error message displayed for invalid credentials ..");
    	}
       //Assert.assertTrue(incorrectPassMsg.isDisplayed());
    }
}
