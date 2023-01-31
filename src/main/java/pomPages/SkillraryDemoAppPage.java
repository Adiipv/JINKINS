package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class SkillraryDemoAppPage {
	
	// declaration
	@FindBy(xpath = "//a[contains(.,'ECommerce')]")
	private WebElement pageHeader;
	@FindBy(id="course")
	private WebElement courseTab;
	@FindBy(xpath = "//span[@class='wrappers']/a[.='Selenium Training']")
	private WebElement seleniumTrainingLink;
	@FindBy(name = "addresstype")
	private WebElement categoryDropDown;
	@FindBy(xpath = "//a[.='Contact Us']")
	private WebElement contactUslink;
	
	public SkillraryDemoAppPage(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}
	
	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	public WebElement getContactUs() {
		return contactUslink;
	}

	
	public void mouseHoverToCourseTab(WebDriverUtility web) {
		web.mouseHover(courseTab);
	}
	public void clickSeleniumTraining() {
		seleniumTrainingLink.click();
		
	}
	public void selectCategory(WebDriverUtility web, int i) {
		web.dropdown(categoryDropDown,i);
	}
	
	public void clickContactUs() {
		contactUslink.click();
	}
}
