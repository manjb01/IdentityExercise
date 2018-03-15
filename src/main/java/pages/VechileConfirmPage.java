package pages;
 import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VechileConfirmPage  {

	@FindBy(css = "#pr3 .reg-mark")
	WebElement text_Reg_number;

	@FindBy(id = "Vrm")
	WebElement field_Reg_number;

	
	@FindBy(xpath = ".//*[@id='pr3']/div/ul/li[2]/span[2]/strong")
	private WebElement text_make;

	@FindBy(xpath = ".//*[@id='pr3']/div/ul/li[3]/span[2]/strong")
	private WebElement text_colour;

	@FindBy(name = "Continue")
	WebElement Continue_Button;

	@FindBy(xpath = ".//*[@id='Correct_False']")
	WebElement match_no;


	@FindBy(xpath = ".//*[@id='Correct_True']")
	WebElement match_yes;

	@FindBy(xpath = ".//*[@id='content']/div[4]/p[2]/a")
	WebElement search_another_veh;

	public void setReg_textfield(String value) {
		field_Reg_number.sendKeys(value);
	}
	
	@FindBy(xpath = ".//*[@id='pr3']/div/h1")
	private WebElement heading;
	
	
	public String getlabel_Reg_number() {
		return  text_Reg_number.getText();
	}
	
	public String getHeading() {
		return heading.getText();
	}
	
	public boolean isPageOpened() {
		return getHeading().equals("Is this the vehicle you are looking for?");
	}

	public void getmatch_yes() {
		 match_yes.click();
	}
	public void getmatch_no() {
		match_no.click();
	}

	public void getsearch_another_veh() {
		 search_another_veh.click();
	}

	public void click_Continue_button() {
		Continue_Button.click();
	}
	
	public String getText_colour() {
		return text_colour.getText();
	}

	public String getText_Reg_number() {
		return field_Reg_number.getText();
	}
	public String getText_make() {
		return text_make.getText();
	}
	public WebElement getContinue() {
		return Continue_Button;
	}
	public void clickContinue_Button() {
		 Continue_Button.click();
	}



}
