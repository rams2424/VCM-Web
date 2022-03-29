package com.framework.Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.ConfigReader.PropertyFileReader;
import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;
import com.framework.Hook.Hooks;
import com.framework.Pages.AccountOpening.OpenAccountPage;
import com.framework.Pages.AccountServices.AccountServicesPage;
import com.framework.Pages.AdviceAndTools.FaqPage;
import com.framework.Pages.AdviceAndTools.InvestorLearningPage;
import com.framework.Pages.AdviceAndTools.MilitaryFinancePage;
import com.framework.Pages.DocumentCenter.DocumentCenterPage;
import com.framework.Pages.Login.LoginPage;
import com.framework.Pages.MessageCenter.CreateSecureMessage;
import com.framework.Pages.MessageCenter.MessageCenterPage;
import com.framework.Pages.Products.MutualFundPage;
import com.framework.Pages.Products.OurProductsPage;
import com.framework.Pages.Products.RetirementPage;
import com.framework.Pages.Products.SavingPlanPage;
import com.framework.Pages.Products.VictorySharePage;
import com.framework.Pages.ProfileAndPreferences.ProfilePage;
import com.framework.Pages.Transaction.Liquidation.SellPage;
import com.framework.Pages.Transaction.Purchase.PurchasePage;

import tech.grasshopper.pdf.pojo.cucumber.Hook;

public class HomePage extends BasePage {
    PropertyFileReader reader = new PropertyFileReader();
    String url;
    WebDriverWait wait;
    public static String accountNo;
    Logger log = LoggerHelper.getLogger(HomePage.class);
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//a[text()='Home']")
    WebElement homePageLink;
    public void verifyHomePageLink() {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(homePageLink));
        Assert.assertTrue(homePageLink.isDisplayed());
    }
    @FindBy(xpath="//div[@class='actualmessages']//div[@role='listitem'][1]//div[1]//following-sibling::div")
    WebElement clickOnMsgs;
    
    
    public MessageCenterPage navigateToMessageCenterPageFromDashBoard(){
        wait =new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(clickOnMsgs));
        JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getInstance().getDriver();
        js.executeScript("arguments[0].click();", clickOnMsgs);
        return new MessageCenterPage(driver);
    }
    @FindBy(xpath="//a[contains(text(),'Send us a Secure Message')]")
    WebElement SendSecureMessage;
    public CreateSecureMessage ClickOnSendSecureMessage(){
        JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getInstance().getDriver();
        js.executeScript("arguments[0].click();", SendSecureMessage);
        return new CreateSecureMessage(driver);
    }
    
    @FindBy(xpath="//button[contains(@class,'menuDropIcon')]")
    WebElement dropDownLink;
    
    @FindBy(xpath="//span[text()='Document Center']")
    WebElement clickOnDocCenter;
    
    @FindBy(xpath="//ul[@role='tablist']")
    WebElement horizontalMenu;
    
    @FindBy(xpath="//h1[@class='sr-only']")
    WebElement greetmsg;
    
    @FindBy(xpath="//p[@class='float-right loginDts']")
    WebElement lastSignIn;
    
    @FindBy(xpath="//div[@class='ach-message-center-main']")
    WebElement msgCenter;
    
    @FindBy(xpath="//h1[normalize-space()='Document Center']")
    WebElement docCenter;
    
    @FindBy(xpath="//span[contains(text(),'Sign Out')]")
    WebElement clickOnsignOut;
    
    @FindBy(xpath="//a[contains(@id,'LinktoTransaction')]")
    List<WebElement> LinkToAccount;
    
    @FindBy(xpath="//div[@id='upperRow']//ul[@class='header-navlink-main']//div//button")
    WebElement moreOptions;
    
    @FindBy(xpath="//span[contains(text(),'Holding Group')]")
    WebElement holdingGroup;
    public void ClickOn_HoldingGroup(String Hgroups){
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(holdingGroup));
        Assert.assertTrue(holdingGroup.isDisplayed());
        List<WebElement> HoldingAccounts = DriverFactory.getInstance().getDriver().findElements(By.xpath("//span[contains(text(),'"+Hgroups+"')]"));
        for (WebElement h : HoldingAccounts){
            if(h.getText().toString().equalsIgnoreCase(Hgroups)) {
                log.info("Selects "+h.getText());
                this.scrollIntoView(h);
                this.clickOnButtonUsingJs(h);
                break;
            }
        }
    }
    public void CheckVisibilityOf_HorizontalMenu(){
        this.elementVisible(horizontalMenu);         
    }
    public void CheckVisibilityOf_WelcomeMsg(){
        this.elementVisible(greetmsg);               
    }
    public void CheckVisibilityOf_LastSign(){
        this.elementVisible(lastSignIn);             
    }
    public void CheckVisibilityOf_MessageCenter(){
        this.elementVisible(msgCenter);              
    }
    public void CheckVisibilityOf_DocumentCenter(){
        this.elementVisible(docCenter);              
    }
    public void CheckVisibilityOf_ProfileName(){
        this.elementVisible(dropDownLink);           
    }
    public void clickOn_Dropdown(){
        this.verifyPageIsLoaded();
        this.clickOnButtonUsingJs(dropDownLink);
    }
    public void CheckVisibilityOf_Signout(){        
        this.elementVisible(clickOnsignOut);         
    }
    public void clickOn_SignOut(){
        this.clickOnButton(clickOnsignOut);
    }
    
    public void clickOn_MoreOptions(){
        moreOptions.click();
    }
    
    public LoginPage navigateToLoginPage() {
        return new LoginPage(driver);
    }
    public void VisibilityOf_MastersAccount(String accountType){
        log.info("Account Type:"+accountType);
        List<WebElement> LinkToAccounts = LinkToAccount;
        for (WebElement h : LinkToAccounts){
            if(h.getText().equalsIgnoreCase(accountType)) {
                log.info(h.getText());
                this.elementVisible(h);
            }
        }
    }
    public void ClickOn_MasterAccount(String Acc) throws InterruptedException{
        List<WebElement>accounts=driver.findElements(By.xpath("//a[contains(text(),'"+Acc+"')]"));
        List<WebElement>accountsCurVal=driver.findElements(By.xpath("//a[contains(text(),'"+Acc+"')]//following::div[1]"));
        for(int i=0;i<accounts.size();i++) {
            if(accounts.get(i).getText().contains(Acc)) {
                currentVal=accountsCurVal.get(i).getText();
                this.scrollIntoViewAndClick(accounts.get(i));
                
                break;
            }
        }
    }
    @FindBy(xpath="//*[@href='/transactionPurchases']")
    WebElement buyBtn;
    private void verifyBuyBtn() {
        Assert.assertTrue(buyBtn.isDisplayed());  
    }
    public PurchasePage navigateToPurchasePage() {
        this.verifyBuyBtn();
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(buyBtn));
        this.scrollIntoViewAndClick(buyBtn);
        return new PurchasePage(driver);
    }
    
    @FindBy(xpath="//div[contains(text(),'View all')]")
    WebElement viewAllLink;
    
    public void clickOnViewAllLink() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(viewAllLink));
        this.clickOnButtonUsingJs(viewAllLink);
        
        this.verifyPageIsLoaded();
    }
    public MessageCenterPage navigateToMessageCenteByIcon() {
        clickOnMsgIcon();
        clickOnViewAllLink();
        return new MessageCenterPage(driver);
    }
    
    @FindBy(xpath="//span[contains(text(),'Document Center')]")
    WebElement documentCenterLink;
    public DocumentCenterPage  navigateToDocumentDenterPage() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(documentCenterLink));
        documentCenterLink.click();
        return new DocumentCenterPage(driver);
    }
    
    @FindBy(xpath="//*[contains(text(),'New Account')]")
    WebElement openAccountPage;
    
    public void clickOnopenAccountBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(openAccountPage));
        this.clickOnelement(openAccountPage);
        verifyPageIsLoaded();
    }
    public OpenAccountPage navigateToAccountOpening() {
        return new OpenAccountPage(driver);
    }
    
    @FindBy(xpath="//*[contains(text(),'Sell')]")
    WebElement sellbutton;
    public SellPage navigateToSellPage() throws InterruptedException{
        wait =new WebDriverWait(driver, 40);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", sellbutton);
        return new SellPage(driver);
    }
    public void verifyOpenAccountBtnIsEnable() {
        Assert.assertTrue(openAccountPage.isDisplayed());
    }
    @FindBy(xpath="//input[contains(@id,'jointOwnerDateofBirth')]")
    WebElement dateOfBirth;
    
    public void clickOnDate(String date) {
        log.info("Date"+date);
        dateOfBirth.sendKeys(date);
        dateOfBirth.sendKeys(Keys.ENTER);
    }
    @FindBy(xpath="//*[text()='Load More']")
    WebElement  clickOnLoadMoreBtn;
    
    public void clickOnLoadMore() {	
        for(int i =0;i<8;i++) {
            if(this.isElementPresent(By.xpath("//*[text()='Load More']")) && driver.findElement(By.xpath("//*[text()='Load More']")).isDisplayed()) {
                log.info("Load More is present...");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", clickOnLoadMoreBtn);
                driver.findElement(By.xpath("//*[text()='Load More']//following-sibling::*")).click();
            }
        }
    }
    
    public void verifyNewZeroBalAccount() {
        String acc=accountNo.substring(accountNo.length()-4);
        By accounts=By.xpath("//a[contains(text(),'"+acc+"')]");
        Assert.assertTrue(this.isElementPresent(accounts));
        WebElement accountsCurVal=driver.findElement(By.xpath("//a[contains(text(),'"+acc+"')]//following::div[1]"));
        String zeroBal=accountsCurVal.getText().toString();
        log.info("Balance : "+zeroBal);
        Assert.assertEquals(zeroBal, "$0.00");
    }
    @FindBy(css="img#message-inbox-icon")
    WebElement msgIcon ;
    
    public void clickOnMsgIcon() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(msgIcon));
        this.scrollIntoViewAndClick(msgIcon);
    }
    
    public void verifyGuestUserDashboard() {
        this.verifyPageIsLoaded();
        Assert.assertTrue(driver.getCurrentUrl().contains("accountguestview"));
    }
    
    @FindBy(xpath="//div[@id='upperRow']//ul//button")
    WebElement headerlink;
    @FindBy(xpath="//*[@role='menuitem']//span[2]")
    WebElement signOutBtn;
    public void clickOnSignOutBtn() {
        wait = new WebDriverWait(driver, 40);
        this.verifyPageIsLoaded();
        wait.until(ExpectedConditions.elementToBeClickable(headerlink));
        this.clickOnButtonUsingJs(headerlink);
        wait.until(ExpectedConditions.elementToBeClickable(signOutBtn));
        this.clickOnButtonUsingJs(signOutBtn);
    }
    @FindBy(xpath="//*[contains(text(),'You have been successfully Signed Out')]")
    WebElement signOutWarningMsg;
    public void verifySignOutWarningMsg() {
        Assert.assertTrue(signOutWarningMsg.isDisplayed());
    }
    public void clickOn_DropdownValue(String arg1) {
        WebElement element=driver.findElement(By.xpath("//span[contains(text(),'"+arg1+"')]"));
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(element));
        this.clickOnelement(element);
    }
    public ProfilePage navigateToProfilePage() {
        return new ProfilePage(driver);
    }
    @FindBy(id="postLoginFooter")
    WebElement Footer ;
    
    @FindBy(xpath="//span[contains(text(),'Forms')]")
    WebElement Forms ;
    
    @FindBy(xpath="//span[contains(text(),'Legal & Privacy')]")
    WebElement LegalAndPrivacy ; 
    
    @FindBy(xpath="//span[contains(text(),'Mutual Fund Prospectuses')]")
    WebElement MFProspectuses  ; 
    
    @FindBy(xpath="//span[contains(text(),'ETF Prospectuses')]")
    WebElement ETFProspectuses  ; 
    
    @FindBy(xpath="//span[contains(text(),'Accessibility')]")
    WebElement Accessibility  ; 
    
    @FindBy(xpath="//span[contains(text(),'Support FAQs')]")
    WebElement SupportFAQs  ; 
    
    @FindBy(xpath="//h2[contains(text(),'Investing involves risk, including potential loss of principal.')]")
    WebElement DisclaimerText  ; 
    
    @FindBy(xpath="//img[@alt='Victory Capital Logo']")
    WebElement VictoryCapitalLogo ; 
    
    @FindBy(xpath="//div[contains(text( ),'Connect with us')]")
    WebElement ConnectWithUs ; 
    
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
    
    public void VerifyFooter (){
        this.elementVisible(Footer); 
    }
    
    public void VerifyFormsIcon (){
        this.elementVisible(Forms); 
    }
    
    public void verifyLegalAndPrivacy (){
        this.elementVisible(LegalAndPrivacy); 
    }
    
    public void verifyMFProspectuses(){
        this.elementVisible(MFProspectuses); 
    }   
    
    public void verifyETFProspectuses(){
        this.elementVisible(ETFProspectuses); 
    }  
    
    public void verifyAccessibility(){
        this.elementVisible(Accessibility); 
    }  
    
    public void verifySupportFAQs(){
        this.elementVisible(SupportFAQs); 
    } 
    
    public void verifyDisclaimerText (){
        this.elementVisible(DisclaimerText); 
    } 
    public void verifyVictoryCapitalLogo (){
        this.elementVisible(VictoryCapitalLogo); 
    } 
    
    public void verifyConnectWithUs (){
        this.elementVisible(ConnectWithUs); 
    }   
    
    
    @FindBy(xpath="//img[@aria-label='Search']")
    WebElement globalSearch;
    
    public void verifyGlobalSearch(){
        this.elementVisible(globalSearch);
    }
    
    public void clickonSearch(){
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(globalSearch));
        this.clickOnButtonUsingJs(globalSearch);
    }
    
    @FindBy(xpath="//button[@id='products']")
    WebElement Products;
    @FindBy(xpath="//a[@id='vcm-menu-item-Mutual Funds']")
    WebElement MutualFunds;
    @FindBy(xpath="//a[contains(normalize-space(),'VictoryShares')]")
    WebElement VictoryShares;
    @FindBy(xpath="//a[@id='vcm-menu-item-USAA 529 College Savings Plan']")
    WebElement SavingPlan;
    @FindBy(xpath="//a[@id='vcm-menu-item-Retirement']")
    WebElement Retirement;
    @FindBy(xpath="//a[@id='vcm-menu-item-Our Products']")
    WebElement OurProducts;
    public void checkVisibiltyProducts() throws InterruptedException{
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Products);
        this.elementVisible(MutualFunds);
        this.elementVisible(VictoryShares);
        this.elementVisible(SavingPlan);
        this.elementVisible(Retirement);
        
        
    }
    public OurProductsPage navigatetoOurProducts(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", OurProducts);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/products";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/products";
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new OurProductsPage(driver);
    }
    public MutualFundPage navigatetoMutualFund(){
        this.clickOnButtonUsingJs(MutualFunds);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/products/mutual-funds";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/products/mutual-funds";
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new MutualFundPage(driver);
    }
    
    public SavingPlanPage navigatetoSavingPlanPage(){
        this.clickOnButtonUsingJs(MutualFunds);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/products/usaa-529-college-savings-plan";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/products/usaa-529-college-savings-plan";
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new SavingPlanPage(driver);
    }
    public VictorySharePage navigatetoVictorySharePage(){
        this.clickOnButtonUsingJs(MutualFunds);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/products/victoryshares-etfs";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/products/victoryshares-etfs";
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new VictorySharePage(driver);
    }
    public RetirementPage navigatetoRetirementPage(){
        this.clickOnButtonUsingJs(MutualFunds);
        String baseUrl = "https://victory:L@unch123@qa.investor.vcm.com/products/retirement";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new RetirementPage(driver);
    }
    
    @FindBy(xpath="//button[@id='adviceTools']")
    WebElement AdviceTools;
    @FindBy(xpath="//a[@id='vcm-menu-item-Investor Learning Center']")
    WebElement InvestorLearningCenter;
    @FindBy(xpath="//a[@id='vcm-menu-item-Military Financial Readiness']")
    WebElement MilitaryFinancialReadiness;
    @FindBy(xpath="//a[@id='vcm-menu-item-FAQs ']")
    WebElement FAQs;
    
    public void checkVisibiltyAdviceTools() throws InterruptedException{
        this.clickOnButtonUsingJs(AdviceTools);
        this.elementVisible(InvestorLearningCenter);
        this.elementVisible(MilitaryFinancialReadiness);
        this.elementVisible(FAQs);
        
        
        
    }
    public MilitaryFinancePage NavigatetoMilitaryFinance(){
        this.clickOnButtonUsingJs(MilitaryFinancialReadiness);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/advice-tools/military-financial-readiness";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/advice-tools/military-financial-readiness";
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new MilitaryFinancePage(driver);
    }
    
    public InvestorLearningPage NavigatetoInvestorLearningPage(){
        this.clickOnButtonUsingJs(InvestorLearningCenter);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/advice-tools/investor-learning-center";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/advice-tools/investor-learning-center";
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new InvestorLearningPage(driver);
    }
    
    public FaqPage NavigatetoFaqPage(){
        this.clickOnButtonUsingJs(FAQs);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/advice-tools/faq";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/advice-tools/faq";
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new FaqPage(driver);
    }
    
    public void verifyDocumentCenterOption() {
        Assert.assertTrue( docCenter.isDisplayed());
    }
    @FindBy(css="button#stopCodeErrorMsgClose")
    WebElement stopCodeBtn;
    public void clickOnRecentActivityBtn() {
        this.verifyPageIsLoaded();
        if(this.isElementPresent(By.cssSelector("button#stopCodeErrorMsgClose")) && driver.findElement(By.cssSelector("button#stopCodeErrorMsgClose")).isDisplayed()) {
            this.clickOnButtonUsingJs(stopCodeBtn);
            
        }
    }
    public void clickOnForms() {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(Forms));
        String env = "env";
        log.info("ENV  val => "+env);
        if(env.equalsIgnoreCase("UAT")){
        String formsURL1 = "https://victory:St@ge123@stage.investor.vcm.com/tools-resources/forms";
        driver.navigate().to(formsURL1);
        }else {
        	 String formsURL1 = "https://victory:L@unch123@qa.investor.vcm.com/tools-resources/forms";
             driver.navigate().to(formsURL1);
        }
        
        try {
        	Thread.sleep(8000);
        }catch(Exception ex){
        	log.info("Exception caught ...");
        }
        //Forms.click();
    }
    public void clickOnLegalAndPrivacy() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(LegalAndPrivacy));
        scrollIntoViewAndClick(LegalAndPrivacy);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/policies";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/policies";
        }
        driver.get(url);
        
        
        
    } 
    
    
    public void clickOnMFProspectuses() { 
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(MFProspectuses));
        scrollIntoViewAndClick(MFProspectuses);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/literature/mutual-fund-prospectuses";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/literature/mutual-fund-prospectuses";
        }
        driver.get(url);
    }
    public void clickOnETFProspectuses() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(ETFProspectuses));
        scrollIntoViewAndClick(ETFProspectuses);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/literature/etf-prospectuses";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/literature/etf-prospectuses";
        }
        driver.get(url);
        
    }
    public void clickOnAccessibility() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(Accessibility));
        scrollIntoViewAndClick(Accessibility);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/accessibility";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/accessibility";
        }
        driver.get(url);
        
    }
    public void clickOnSupportFAQs() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(SupportFAQs));
        scrollIntoViewAndClick(SupportFAQs);
        if(reader.getEnv().equalsIgnoreCase("SIT")){
            url = "https://victory:L@unch123@qa.investor.vcm.com/tools-resources/faq";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/tools-resources/faq";
        }
        driver.get(url);
    }
    @FindBy(xpath="//*[@data-testid='wicon-component-id']")
    WebElement contactInfoIcon;
    public void verifyFlotingContactInfo() {
        Assert.assertTrue(contactInfoIcon.isDisplayed());
    }
    public void clickOnContactUsOption() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(contactInfoIcon));
        contactInfoIcon.click();
    }
    @FindBy(xpath="//span[text()='Secure Document']")
    WebElement sendSecureMsgTxt;
    public void verifySendsecureMsgOptionIsDisplaying() {
        Assert.assertTrue(sendSecureMsgTxt.isDisplayed());
    }
    public void clickOnSecureMsgLink() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(sendSecureMsgTxt));
        sendSecureMsgTxt.click();
    }
    @FindBy(xpath="//*[text()='Toll-Free']")
    WebElement tollFreeTxt;
    
    @FindBy(xpath="//*[text()='International']")
    WebElement internationalTxt;
    
    @FindBy(xpath="//*[text()='(210) 876-6700']")
    WebElement internationalNo;
    
    @FindBy(xpath="//*[text()='(800) 235-8396']")
    WebElement tollfreeNo;
    
    public void verifyTollFreeNo() {
        Assert.assertTrue(tollFreeTxt.isDisplayed());
        Assert.assertTrue(tollfreeNo.isDisplayed()); 
    }
    public void verifyInternationalNo() {
        Assert.assertTrue(internationalTxt.isDisplayed());
        Assert.assertTrue(internationalNo.isDisplayed());
    }
    @FindBy(xpath="//*[text()='Enable Co-Browsing']")
    WebElement enableCoBrowsingLink;
    public void verifyEnableCoBrowsingLink() {
        wait =new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(enableCoBrowsingLink));
        Assert.assertTrue(enableCoBrowsingLink.isDisplayed());
    }
    
    public void clickOnEnableCoBrowsing() {
        this.verifyPageIsLoaded();
        this.clickOnButtonUsingJs(enableCoBrowsingLink);
    }
    @FindBy(xpath="input#wc0-securityKey")
    WebElement securityKeytxt;
    public void verifySecurityKey() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(securityKeytxt));
        Assert.assertTrue(securityKeytxt.isDisplayed());
    }
    @FindBy(xpath="//button[contains(text(),'Share your screen')]")
    WebElement shareYourScreenTxt;
    public void verifyShareYourScreen() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(shareYourScreenTxt));
        Assert.assertTrue(shareYourScreenTxt.isDisplayed());
    }
    @FindBy(xpath="//h2[contains(text(),'Co-Browsing')]")
    WebElement cobrowsingWindowTitle;
    public void verifyCoBrowsingWindowTitle() {
        
    }
    @FindBy(xpath="//*[contains(text(),'You will have to be on the phone ')]")
    WebElement coBrowsingWindowTxt;
    public void verifyCoBrowsingWindowTxt(String expected) {
        log.info("Expected"+expected);
        log.info("Actual"+coBrowsingWindowTxt.getText());
        Assert.assertTrue(coBrowsingWindowTxt.getText().equalsIgnoreCase(expected));
    }
    @FindBy(xpath="//*[@data-testid='wicon-component-id']")
    WebElement closeContactUsOption;
    public void clickOncloseContactUseOption() throws InterruptedException {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(closeContactUsOption));
        closeContactUsOption.click();
        
    }
    
    @FindBy(xpath="//p[text()=' Total Portfolio ']/following::p[2]")
    WebElement percentTxt;
    public void verifyTotalPercentage(String expected) {
        log.info("expected"+expected);
        log.info("Actual"+percentTxt.getText());
        Assert.assertTrue(percentTxt.getText().equalsIgnoreCase(expected));
    }
    @FindBy(xpath="//div[@class='amount']/following::p[2]")
    WebElement dollertxt;
    public void verifyDollerAmount() {
        log.info("Amount"+dollertxt.getText());
        Assert.assertTrue(dollertxt.getText().contains("$"));
    }
    @FindBy(css="img[alt='VCM Logo']")
    WebElement logo;
    public void verifyVictoryLogo() {
        Assert.assertTrue(logo.isDisplayed());
    }
    @FindBy(css="p.loginDts")
    WebElement verifyLastLogintxt;
    public void verifyLastLoginMsg(String expected) {
        log.info("expected"+expected);
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(verifyLastLogintxt));
        log.info("Actual"+verifyLastLogintxt.getText());
        Assert.assertTrue(verifyLastLogintxt.getText().contains(expected));    
    }
    @FindBy(xpath="//h1[normalize-space()='Features']")
    WebElement featuresTxt;
    public void verifyFeatureTxt() {
        Assert.assertTrue(featuresTxt.isDisplayed());
    }
    @FindBy(xpath="//*[contains(@href,'/mutual-funds')]")
    WebElement mutualFundLink;
    public void verifyMutualFund(String expected) {
        log.info("expected"+expected);
        log.info("Actual"+mutualFundLink.getText());
        Assert.assertTrue(mutualFundLink.getText().contains(expected));  
    }
    @FindBy(xpath="//*[contains(@href,'/usaa')]")
    WebElement usaaLink;
    
    public void verifyUSAASaving(String expected) {
        log.info("expected"+expected);
        log.info("Actual"+usaaLink.getText());
        Assert.assertTrue(usaaLink.getText().contains(expected));  
    }
    @FindBy(xpath="//*[contains(text(),'Gains Distributions')]")
    WebElement learnAboutLink;
    public void verifyLearnLink(String expected) {
        log.info("expected"+expected); 
        log.info("Actual"+learnAboutLink.getText());
        Assert.assertTrue(learnAboutLink.getText().contains(expected));
    }
    
    @FindBy(xpath="//*[contains(@href,'/retirement')]")
    WebElement retirementLink;
    public void verifySecurityRetirement(String securityretirement) {
        log.info("expected"+securityretirement);
        log.info("Actual"+retirementLink.getText());
        Assert.assertTrue(retirementLink.getText().contains(securityretirement));   
    }
    @FindBy(xpath="//*[contains(text(),'Portfolio Planner')]")
    WebElement portfolioPlannerLink;
    public void verifyportfolioPlanner(String expected) {
        log.info("expected"+expected);
        log.info("Actual"+portfolioPlannerLink.getText());
        Assert.assertTrue(portfolioPlannerLink.getText().contains(expected));   
    }
    public void clickOnPortfolioPlanner() {
        this.clickOnButtonUsingJs(portfolioPlannerLink);
        if(reader.getEnv().equalsIgnoreCase("SIT")) {
            url = "https://marstone:vcmqa@vcm.qa-1.ext.marstone.com";
            driver.get(url);
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://marstone:vcmqa@vcm.qa-1.ext.marstone.com";
        }
        
    }
    public void verifyMarstonePage() {
        new WebDriverWait(driver,40).until(ExpectedConditions.numberOfWindowsToBe(2));
        String parentWindow = driver.getWindowHandle();
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("questionnaire/emergency-funds"));
                driver.close();
            }
        }
    }
    @FindBy(xpath="//*[contains(text(),'Achieve Your')]")
    WebElement achiveGoals;
    public void verifyAchiveYourGoalsTab(String expected) {
        log.info("expected"+expected);
        log.info("Actual"+achiveGoals.getText());
        Assert.assertTrue(achiveGoals.getText().contains(expected));   
    }
    public void clickOnMutualFundLink() {
        this.clickOnButtonUsingJs(mutualFundLink);
        if(reader.getEnv().equalsIgnoreCase("SIT")) {
            url = "https://victory:L@unch123@qa.investor.vcm.com/products/mutual-funds";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/products/mutual-funds";
        }
        driver.get(url);
    }
    public void verifyMutualFundPage() {
        log.info("Actual"+driver.getCurrentUrl());
        log.info("Expected"+"/products/mutual-funds");
        Assert.assertTrue(driver.getCurrentUrl().contains("/products/mutual-funds"));
    }
    
    public void clickOnUSAASavingLink() {
        this.clickOnButtonUsingJs(usaaLink);
        if(reader.getEnv().equalsIgnoreCase("SIT")) {
            url = "https://victory:L@unch123@qa.investor.vcm.com/products/usaa-529-college-savings-plan";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/products/usaa-529-college-savings-plan";
        }
        driver.get(url);
    }
    public void verifyUSAASavingPage() {
        log.info("Actual"+driver.getCurrentUrl());
        log.info("Expected"+"products/usaa-529-college-savings-plan");
        Assert.assertTrue(driver.getCurrentUrl().contains("products/usaa-529-college-savings-plan"));
    }
    public void clickOnSecureRetirement() {
        this.clickOnButtonUsingJs(retirementLink);
        if(reader.getEnv().equalsIgnoreCase("SIT")) {
            url = "https://victory:L@unch123@qa.investor.vcm.com/products/retirement";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/products/retirement";
        }
        driver.get(url);
    }
    public void verifySecureRetirementPage() {
        log.info("Actual"+driver.getCurrentUrl());
        log.info("Expected"+"products/retirement");
        Assert.assertTrue(driver.getCurrentUrl().contains("products/retirement"));
    }
    @FindBy(xpath="//h1[normalize-space()='Tools & Resources']")
    WebElement resourceAndToolsTxt;
    public void verifyResourecAndToolsTxt() {
        Assert.assertTrue(resourceAndToolsTxt.isDisplayed());
    }
    public void clickonAchiveGoals() {
        this.clickOnButtonUsingJs(achiveGoals);
        if(reader.getEnv().equalsIgnoreCase("SIT")) {
            url = "https://victory:L@unch123@qa.investor.vcm.com/tools-resources/investor-learning-center";
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/tools-resources/investor-learning-center";
        }
        driver.get(url);
    }
    public void verifyInvestorLeaningPage() {
        log.info(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("tools-resources/investor-learning-center"));
    }
    public void clickOnLearnAboutProduct() {
        this.verifyPageIsLoaded();
        this.scrollIntoView(learnAboutLink);
        this.clickOnButton(learnAboutLink);
        if(reader.getEnv().equalsIgnoreCase("SIT")) {
            url = "https://victory:L@unch123@qa.investor.vcm.com/products";
            //    		 driver.get(url);
        }
        else if(reader.getEnv().equalsIgnoreCase("UAT")) {      
            url = "https://victory:St@ge123@stage.mysecure.vcm.com/products";
        }
        
    }
    public void verifyProductPage() {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        log.info(driver.getCurrentUrl());
        //https://investor.vcm.com/assets/resources-mutualfunddoc/USAA%20Funds%20Estimated%20Capital%20Gains.pdf
        Assert.assertTrue(driver.getCurrentUrl().contains("products/mutual-funds"));
        
    }
    @FindBy(xpath="//h1[text()='Open an Account']")
    WebElement OpenAnAccountTab;
    public void verifyGuestOpenAccountTab() {
        this.elementVisible(OpenAnAccountTab);
    }
    public void verifyGuestAccountOpeningsFor(String arg1) {
        WebElement accountType=driver.findElement(By.xpath("//button[text()='"+arg1+"']"));
        this.elementVisible(accountType);
    }
    @FindBy(xpath="//p[contains(text(),'Your Document Center has a variety of account docu')]")
    WebElement DocumentTypeMess;
    public void documetcontainmessage(String expected){
        log.info("Expected"+expected);
        log.info("Actual" +DocumentTypeMess.getText());
        
        Assert.assertTrue(expected.equalsIgnoreCase(DocumentTypeMess.getText())); 
        
        
    }
    
    @FindBy(xpath="//p[contains(text(),'Documents are in PDF format and can be read with A')]")
    WebElement DocumentformatText;
    public void documetformat(String expected){
        log.info("Expected"+expected);
        log.info("Actual" +DocumentformatText.getText());
        
        Assert.assertTrue(expected.equalsIgnoreCase(DocumentformatText.getText())); 
        
        
    }
    @FindBy(xpath="//span[normalize-space()='Access your Documents']")
    WebElement Document;
    public DocumentCenterPage  navigateToDocumentCenter() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(Document));
        this.clickOnButtonUsingJs(Document);
        return new DocumentCenterPage(driver);
    }
    @FindBy(xpath="//a[text()='Account Services']")
    WebElement accountServices;
    public AccountServicesPage navigateToAccountServices() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(accountServices));
        this.clickOnButtonUsingJs(accountServices);
        return new AccountServicesPage(driver);
    }
    
}



