package accommodations;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookingAccomodationPage {

	@FindBy (xpath  = "//table[@id = \"hprt-table\"]//tbody/tr[1]/td[5]//select")
	private WebElement selectRoomCmbbox;
	
	@FindBy (xpath = "//h2[@class = \"hp__hotel-name\"]")
	private WebElement hotelName;
	
	private static final String ROOM_CMBBOX_NUM = "//table[@id = \"hprt-table\"]//tbody/tr[1]/td[5]//select/option";
	
	public BookingAccomodationPage(String accomName) {
		Assert.assertTrue((hotelName.getText()).contains(accomName), "The hotel name is not correct!");
	}

	public BookingAccomodationPage(WebDriver driver) {
	}

	public void accomodationSelectRoom(WebDriver driver, int num)
	{
		selectRoomCmbbox.click();
		Assert.assertTrue(roomNumIsCorrect(driver, num), "The number of rooms is not correct!");		
	}
	
	public boolean roomNumIsCorrect(WebDriver driver, int num)
	{
		try
		{
			List<WebElement> elements = driver.findElements(By.xpath(ROOM_CMBBOX_NUM));
			if(elements.size() >= num+1)
			{
				return true;
			}
			else
			{ 
				return false;
			}
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
}
