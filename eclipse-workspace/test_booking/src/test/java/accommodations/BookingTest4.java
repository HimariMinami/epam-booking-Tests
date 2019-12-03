package accommodations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTest4 {

	private static final String BOOKING_URL = "https://www.booking.com/";
	private static final String DESTINATION_4 = "Берлин";
	
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
	
	@Test(description = "Найти на 2 дня с 31 декабря по 1 января на двоих 1 и более занятых варианта проживания")
	public void LateReservation()
	{
		// Найти с 31 декабря по 1 января на двоих 1 и более вариантов проживания с надписью "Вы не успели!" 
		PageFactory.initElements(driver, BookingMainPage.class).openAccomodationsPageFilter(DESTINATION_4, 1, 0, 1, false, 2);
		PageFactory.initElements(driver, BookingAccomodationsPage.class).accomodationLateReserv(driver, 2);
	}
	
	@AfterClass(description = "Stop Browser")
	public void stopBrowser()
	{
		driver.quit();
	}
}
