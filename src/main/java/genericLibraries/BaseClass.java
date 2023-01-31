package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pomPages.ContactUsPage;
import pomPages.CoreJavaDemoVideoPage;
import pomPages.CoreJavaForSelenium;
import pomPages.SeleniumTrainingPage;
import pomPages.SkillraryDemoAppPage;
import pomPages.SkillraryHomePage;
import pomPages.TestingPage;

public class BaseClass {
	protected PropertiesFileUtility property;
	protected EXcelFileUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected SkillraryHomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected ContactUsPage contact;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaDemoVideoPage javaDemo;
	protected CoreJavaForSelenium  coreJava;
	
	@BeforeClass
	public void classSetup() {
		
		property = new PropertiesFileUtility();
		excel= new EXcelFileUtility();
		web= new WebDriverUtility();
		
		property.propertiesInitialization(IConstantPathInterface.PROPERTY_FILE_PATH);
		String browser = property.fectchProperties("browser");
		String url = property.fectchProperties("url");
		long time = Long.parseLong(property.fectchProperties("timeouts"));
		
		
		driver =web.openApplication(browser, url, time);
		home= new SkillraryHomePage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		
	}
	
	@BeforeMethod
	public void methodSetup() {
		excel.excelInitialization(IConstantPathInterface.EXCEL_FILE_PATH);
		demoApp=new SkillraryDemoAppPage(driver);
		contact=new ContactUsPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		testing=new TestingPage(driver);
		javaDemo=new CoreJavaDemoVideoPage(driver);
		coreJava=new CoreJavaForSelenium(driver);
		
	}
	
	
	
	@AfterMethod
	public void methodTearsDown() {
		excel.closeworkbook();
		
	}
	
	@AfterClass
	public void classTearDown() {
		web.quitBrowser();
		
	}

}
