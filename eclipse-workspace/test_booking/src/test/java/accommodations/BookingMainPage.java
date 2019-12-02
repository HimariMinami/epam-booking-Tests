package accommodations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingMainPage {
	@FindBy (className = "sb-searchbox__button")
	private WebElement accomodationSearchBtn;
	
	@FindBy (id = "ss")
	private WebElement destinationInput;
	
	@FindBy (className = "xp__dates-inner")
	private WebElement dataField;
	
	@FindBy (xpath = "//div/div[1]/table[1]//tr[5]/td[@class=\"bui-calendar__date\"][1]")
	private WebElement dataFieldCheckIn;
	
	@FindBy (xpath = "//div/div[1]/table[1]//tr[5]/td[@class=\"bui-calendar__date\"][7]")
	private WebElement dataFieldCheckOut;
	
	@FindBy (id = "xp__guests__toggle")
	private WebElement numGuestsInput;
	
	@FindBy (xpath = "//div[contains(@class, \"sb-group__field-adults\")]//button[1]/span[@class=\"bui-button__text\"]")
	private WebElement numGuestsBtnSubtract;
	
	@FindBy (xpath = "//div[contains(@class, \"sb-group__field-adults\")]//button[2]/span[@class=\"bui-button__text\"]")
	private WebElement numGuestsBtnAdd;
	
	@FindBy (xpath = "//div[2]/label[@class=\"bui-checkbox__label\"]")
	private WebElement workCheckbox;
	
/*	public BookingMainPage name(WebDriver driver, Class  )
	{
		PageFactory.initElements(driver);
	}
*/	
	public BookingAccomodationsPage openAccomodationsPageFilter(String destination)
	{
		destinationInput.click();
		destinationInput.clear();
		destinationInput.sendKeys(destination);
		
		dataField.click();
		
		dataFieldCheckIn.click();
		dataFieldCheckOut.click();
		
		numGuestsInput.click();
		numGuestsBtnSubtract.click();
		
		accomodationSearchBtn.click();
		return new BookingAccomodationsPage();
	}
	
	public BookingAccomodationsPage openAccomodationsPageWork(String destination)
	{
		destinationInput.click();
		destinationInput.clear();
		destinationInput.sendKeys(destination);
		
		dataField.click();
		
		dataFieldCheckIn.click();
		dataFieldCheckOut.click();
		
		numGuestsInput.click();
		numGuestsBtnSubtract.click();
		
		workCheckbox.click();
		
		accomodationSearchBtn.click();
		return new BookingAccomodationsPage();
	}
}
