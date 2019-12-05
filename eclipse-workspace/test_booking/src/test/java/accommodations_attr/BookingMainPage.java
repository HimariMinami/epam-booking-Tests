package accommodations_attr;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
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
	
	@FindBy (xpath = "//div[contains(@class, \"bui-carousel--small\")]//li[1]/div/div[1]")
	private WebElement apartmentsLink;
	
	@FindBy (xpath = "//div[contains(@class, \"bui-carousel--small\")]//li[1]//a")
	private WebElement apartmentsHeader;
	
	private String apartHeader;
	
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
	
	public BookingApartmentsPage openApartmentsPage(WebDriver driver) throws InterruptedException
	{
		apartHeader = apartmentsHeader.getText();
		apartmentsLink.click();
		
		changeWindow(driver);
		
		return new BookingApartmentsPage(apartHeader);
	}
	
	public void changeWindow(WebDriver driver) throws InterruptedException
	{
		Set<String> windows = driver.getWindowHandles();
	    Iterator<String> itr = windows.iterator();
	    
	    //patName will provide you parent window
	    String patName = itr.next();
	    //System.out.println("parentWindow Handle"+patName);

	    //chldName will provide you child window
	    String chldName = itr.next();
	    //System.out.println("childWindow Handle"+chldName);

	    //Switch to child window
	    driver.switchTo().window(chldName);
		
        Thread.sleep(5000);
	}
}
