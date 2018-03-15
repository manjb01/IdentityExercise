package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavPage {

	@FindBy(id = "Vrm")
	private WebElement reg_number;
	
	@FindBy(name = "Continue")
	private WebElement continue_Button;
	
	public WebElement getRegistrationNumber() {
		return reg_number;
	}

	public WebElement getContinueButton() {
		return continue_Button;
	}

	public void submitContinueButton() {
		continue_Button.click();
	}

	public void sendRegistrationNumber(String value) {
		reg_number.sendKeys(value);
	}

	
}
