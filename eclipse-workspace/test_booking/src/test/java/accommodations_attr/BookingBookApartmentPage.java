package accommodations_attr;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookingBookApartmentPage {

	@FindBy (id = "hp_hotel_name")
	private WebElement nameApart;
	
	@FindBy (xpath = "//div[@id=\"right\"]//form/button[@id=\"hcta\"]")
	private WebElement bookBtn;
	
	@FindBy (xpath = "//div[@class=\"hp-section-3-col\"][1]//div[contains(@class,\"hp-date-input\")]")
	private WebElement dataFieldIn;
	
	@FindBy (xpath = "//div[@class=\"hp-section-3-col\"][2]//div[contains(@class,\"hp-date-input\")]")
	private WebElement dataFieldOut;
	
	@FindBy (xpath = "//div[@class=\"hp-section-3-col\"][1]//div[@class=\"c2-month\"][1]//tbody/tr[5]/td[1]")
	private WebElement dataFieldCheckInWeek;
	
	@FindBy (xpath = "//div[@class=\"hp-section-3-col\"][2]//div[@class=\"c2-month\"][1]//tbody/tr[5]/td[7]")
	private WebElement dataFieldCheckOutWeek;
	
	@FindBy (xpath = "//div[@class=\"hp-section-3-col\"]/button[contains(@class,\"b-button\")]")
	private WebElement searchAPlaces;
	
	private final String apartName;
	
	public BookingBookApartmentPage() {
		this.apartName = "";
	}
	
	public BookingBookApartmentPage(String apartName) {
		this.apartName = apartName;
	}

	@FindBy (xpath = "//span[@class = \"sb-searchbox__title-text\"]")
	private WebElement ApartHeader;
	
	public BookingAccomodationsPage openApartmentDescriptionPage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		//Assert.assertTrue((nameApart.getText()).contains(apartName), "The name of apartment is not correct!");
		
		bookBtn.click();
		
		dataFieldIn.click();
		dataFieldCheckInWeek.click();
		
		dataFieldOut.click();
		dataFieldCheckOutWeek.click();
		
		searchAPlaces.click();
		
		return new BookingAccomodationsPage();
	}
}
