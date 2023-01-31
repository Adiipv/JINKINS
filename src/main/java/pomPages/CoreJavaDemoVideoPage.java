package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaDemoVideoPage {
	
	@FindBy(xpath="//h1[.='Core Java For Selenium Training']")
	private  WebElement pageHeader;
	@FindBy(xpath = "//button[@aria-label='Play']")
	private  WebElement playButton;
	@FindBy(xpath = "//button[@aria-label='Pause']")
	private  WebElement pauseButton;
	@FindBy(xpath = "//span[text()='Add To Wishlist']")
	private  WebElement addToWishlistButton;
	
	
	
	public CoreJavaDemoVideoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	public void clickPlayButton() {
		playButton.click();
	}
	
	public void clickPauseButton() {
		pauseButton.click();
	}
	
	public void  clickAddToWishlistButton() {
		addToWishlistButton.click();
	}

}
