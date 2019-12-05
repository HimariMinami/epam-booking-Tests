package accommodations_attr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTest7 {

	private static final String BOOKING_URL = "https://www.booking.com/";
	
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
	
	@Test(description = "�������� ������� � ������������� � ����������� ��� �������������")
	public void checkApartmentsPage() throws InterruptedException
	{
		// �� ������� �������� ������ �� �������� � ����� ���������� "�����������".
		// � ����� ����������� ������� ��������� ��� ��������� ������� � �������������.
		// ������� ������ ������������ ���������� � ������ ������ "������������� �����������".
		// � ����� ������� ��������� ��� ��������� �������� ������ ������������.
		// ������� ���� ���������� � 23 �� 29 ������� ��� 2 �������, 1 �����.
		// �� ����� ������� �������� ��� ���� ��������� ����� � ������� ���.
		// �� ����� ������� ��������� �������� ����� � ��������� ��� �������� ��� ������� 1 �������.
		
		
		PageFactory.initElements(driver, BookingMainPage.class).openApartmentsPage(driver);
		PageFactory.initElements(driver, BookingApartmentsPage.class).openBookApartmentPage(driver);
		PageFactory.initElements(driver, BookingBookApartmentPage.class).openApartmentDescriptionPage(driver);
		PageFactory.initElements(driver, BookingAccomodationsPage.class).accomodationDescription1(driver);
		PageFactory.initElements(driver, BookingAccomodationPage.class).accomodationSelectRoom(driver, 1);
	}
	
	@AfterClass(description = "Stop Browser")
	public void stopBrowser()
	{
		driver.quit();
	}
}
