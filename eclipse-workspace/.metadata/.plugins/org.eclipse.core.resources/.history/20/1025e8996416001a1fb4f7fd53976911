package accommodations_attr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingToursActivitiesPage {

	@FindBy (xpath = "//a[@data-decider-header=\"attractions\"]")
	private WebElement toursActivitiesLink;
	
	@FindBy (xpath = "//section[3]//div[@class=\"css-1kgbwqn\"][1]")
	private WebElement romeToursActivitiesBtn;
	
	@FindBy (xpath = "//section[3]//div[@class=\"css-1kgbwqn\"][1]//div[@class=\"css-88t9ak\"]")
	private WebElement firstAnotherNumToursActivities;
	
	@FindBy (xpath = "//section[3]//div[@class=\"css-1kgbwqn\"][1]//div[@class=\"css-1s8e6wr\"]")
	private WebElement firstAnotherCityNameToursActivities;
	
	private String firstAnotherNumTA;
	private String firstAnotherCNameTA;
	
	public BookingToursActivitiesDestinationPage ToursActivitiesDestination()
	{
		toursActivitiesLink.click();
		
		firstAnotherNumTA = firstAnotherNumToursActivities.getText();
		firstAnotherCNameTA = firstAnotherCityNameToursActivities.getText();
				
		romeToursActivitiesBtn.click();
		
		return new BookingToursActivitiesDestinationPage(firstAnotherNumTA, firstAnotherCNameTA);
	}
	
}
