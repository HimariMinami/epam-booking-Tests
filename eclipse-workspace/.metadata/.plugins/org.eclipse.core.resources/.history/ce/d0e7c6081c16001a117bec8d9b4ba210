package accommodations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTest6 {

	private static final String BOOKING_URL = "https://www.booking.com/";
	private static final String DESTINATION_1 = "Литва";
	
	private WebDriver driver;
	
	@BeforeClass(description = "Start browser!")
	public void startBrowser()
	{
		driver = new FirefoxDriver();
		driver.get(BOOKING_URL);
	}
	
	@BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicite wait and maximize window")
	public void addImplicitly()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Maximize browser window
		driver.manage().window().maximize();
	}
	
	@Test(description = "")
	public void abc4()
	{
		//

	}
	
	@AfterClass(description = "Stop Browser")
	public void stopBrowser()
	{
		driver.quit();
	}
}
