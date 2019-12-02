package accommodations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookingAccomodationsPage {

	@FindBy (xpath  = "//div[@id=\"filter_uf\"]//a[1]")
	private WebElement filterBoxTown1;
	
	@FindBy (xpath  = "//div[@id=\"filter_uf\"]//a[3]")
	private WebElement filterBoxTown3;
	
	@FindBy (xpath  = "//div[@id=\"filter_uf\"]//a[3]")
	private WebElement accomodationBtn;

	private static final String PROFIT_PRICE = "d-deal-b";
	
	private String town1;
	private String town3;
	
	public BookingAccomodationPage accomodationDescription(WebDriver driver)
	{
		
		
		return new BookingAccomodationPage();
	}
	
	public void accomodationCity(WebDriver driver)
	{
		filterBoxTown1.click();
		town1 = filterBoxTown1.getText();
		Assert.assertTrue(townNumIsCorrect(driver, town1), "The number of accomodation for the first city is not correct!");
		filterBoxTown3.click();
		town3 = filterBoxTown3.getText();	
		Assert.assertTrue(townNumIsCorrect(driver, town3), "The number of accomodation for the third city is not correct!");
	}
	
	public void accomodationWorkPrPrice(WebDriver driver)
	{
		Assert.assertTrue(profitPriceAccomNumIsCorrect(driver), "The number of profit price is not correct!");
	}
	
	public boolean townNumIsCorrect(WebDriver driver, String town)
	{
		try
		{
			List<WebElement> elements = driver.findElements(By.xpath("//a[@class=\"bui-link\" and contains(@data-tooltip-text, \""+ town +"\"\")]"));
			if(elements.size() >= 2)
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
	
	public boolean profitPriceAccomNumIsCorrect(WebDriver driver)
	{
		try
		{
			List<WebElement> elements = driver.findElements(By.className(PROFIT_PRICE));
			if(elements.size() >= 2)
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
