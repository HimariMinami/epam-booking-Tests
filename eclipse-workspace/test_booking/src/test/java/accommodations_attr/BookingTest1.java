package accommodations_attr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTest1 {

	private static final String BOOKING_URL = "https://www.booking.com/";
	private static final String DESTINATION_1 = "�����";
	
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
	
	@Test(description = "����� ��� ������� 10 ��������� ���������� � �������� �� ������ ��� 1 ��������")
	public void FilterCity()
	{
		// ����� ����� ���������� �� ������ � 23 �� 29 ������� � ����� ��� 1 ��������, ��������� ������ ����������� ���������.
		// ������������� ����� ��� ������ �������. ��������� ��� ������������ ��� ������� 10 ��������� ����������.
		
		PageFactory.initElements(driver, BookingMainPage.class).openAccomodationsPageFilter(DESTINATION_1, 1, 0, 1, false, 7);
		PageFactory.initElements(driver, BookingAccomodationsPage.class).accomodationCity(driver, DESTINATION_1, 10);
	}
	
	@AfterClass(description = "Stop Browser")
	public void stopBrowser()
	{
		driver.quit();
	}
}
