package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	@FindBy(xpath = "//img[contains(@src,'contactus')]")
	private WebElement contactUsImage;
	@FindBy(name="name")
	private WebElement fullNameTf;
	@FindBy(name="sender")
	private WebElement emailTF;
	@FindBy(name="subject")
	private WebElement subjectTF;
	@FindBy(name="message")
	private WebElement messageTA;
	@FindBy(xpath ="//button[.='Send us mail']")
	private WebElement sendUsMailButton;
	
	
	
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	public void setContactDetails(String name, String email,String subject,String message) {
		fullNameTf.sendKeys(name);
		emailTF.sendKeys(email);
		subjectTF.sendKeys(subject);
		messageTA.sendKeys(message);
	}
	
	public void clickSendUsMailButton() {
		sendUsMailButton.click();
	}


	public WebElement getHeaderImage() {
		// TODO Auto-generated method stub
		return contactUsImage;
	}
	
	

}
