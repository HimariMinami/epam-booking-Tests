package accommodations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingMainPage {
	@FindBy (className = "sb-searchbox__button")
	private WebElement accomodationSearchBtn;
	
	@FindBy (id = "ss")
	private WebElement destinationInput;
	
	@FindBy (className = "xp__dates-inner")
	private WebElement dataField;
	
	@FindBy (xpath = "//div/div[1]/table[1]//tr[5]/td[@class=\"bui-calendar__date\"][1]")
	private WebElement dataFieldCheckInWeek;
	
	@FindBy (xpath = "//div/div[1]/table[1]//tr[5]/td[@class=\"bui-calendar__date\"][6]")
	private WebElement dataFieldCheckOutWeek;
	
	@FindBy (xpath = "//div/div[1]/table[1]//tr[6]/td[@class=\"bui-calendar__date\"][2]")
	private WebElement dataFieldCheckInTwo;
	
	@FindBy (xpath = "//div/div[2]/table[1]//tr[1]/td[@class=\"bui-calendar__date\"][1]")
	private WebElement dataFieldCheckOutTwo;
	
	@FindBy (id = "xp__guests__toggle")
	private WebElement numGuestsInput;
	
	@FindBy (xpath = "//div[contains(@class, \"sb-group__field-adults\")]//button[1]/span[@class=\"bui-button__text\"]")
	private WebElement numAdultsBtnSubtract;
	
	@FindBy (xpath = "//div[contains(@class, \"sb-group__field-adults\")]//button[2]/span[@class=\"bui-button__text\"]")
	private WebElement numAdultsBtnAdd;
	
	@FindBy (xpath = "//div[contains(@class, \"sb-group-children\")]//button[2]/span[@class=\"bui-button__text\"]")
	private WebElement numCldrnBtnAdd;
	
	@FindBy (xpath = "//div[contains(@class, \"sb-group__field-rooms\")]//button[2]/span[@class=\"bui-button__text\"]")
	private WebElement numRoomsAdd;
	
	@FindBy (xpath = "//div[2]/label[@class=\"bui-checkbox__label\"]")
	private WebElement workCheckbox;
	
	public BookingAccomodationsPage openAccomodationsPageFilter(String destination, int numAdults, int numCldrns, int numRooms, boolean work, int days)
	{
		destinationInput.click();
		destinationInput.clear();
		destinationInput.sendKeys(destination);
		
		dataField.click();
		
		if(days == 2)
		{
			dataFieldCheckInTwo.click();
			dataFieldCheckOutTwo.click();
		}
		else
		{
			dataFieldCheckInWeek.click();
			dataFieldCheckOutWeek.click();
		}
		
		numGuestsInput.click();
		
		if(numAdults == 1)
		{
		 numAdultsBtnSubtract.click();
		}
		else if (numAdults >= 3)
		{
			for (int i = 0; i < (numAdults-2); i++){
				numAdultsBtnAdd.click();
			}
		}
		
		if(numCldrns != 0)
		{
			for (int i = 0; i < numCldrns; i++){
				numCldrnBtnAdd.click();
			}
		}
		
		if(numRooms > 1)
		{
			for (int i = 0; i < numRooms-1; i++){
				numRoomsAdd.click();
			}
		}
		
		if(work == true)
		{
			workCheckbox.click();
		}
		
		accomodationSearchBtn.click();
		
		return new BookingAccomodationsPage();
	}
	
	/*public BookingAccomodationsPage openAccomodationsWithCldrns(String destination)
	{
		destinationInput.click();
		destinationInput.clear();
		destinationInput.sendKeys(destination);
		
		dataField.click();
		
		dataFieldCheckIn.click();
		dataFieldCheckOut.click();
		
		numGuestsInput.click();
		for (int i = 0; i < 3; i++){
			numAdultsBtnAdd.click();
		}
		
		numCldrnBtnAdd.click();
		
		for (int i = 0; i < 2; i++){
			numRoomsAdd.click();
		}
		
		accomodationSearchBtn.click();
		return new BookingAccomodationsPage();
	}*/
	
	/*public BookingAccomodationsPage openAccomodationsPageWork(String destination)
	{
		destinationInput.click();
		destinationInput.clear();
		destinationInput.sendKeys(destination);
		
		dataField.click();
		
		dataFieldCheckIn.click();
		dataFieldCheckOut.click();
		
		numGuestsInput.click();
		numAdultsBtnSubtract.click();
		
		workCheckbox.click();
		
		accomodationSearchBtn.click();
		return new BookingAccomodationsPage();
	}*/
}
