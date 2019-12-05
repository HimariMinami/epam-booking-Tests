package accommodations_attr;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookingApartmentsPage {

	@FindBy (xpath = "//span[@class = \"sb-searchbox__title-text\"]")
	private WebElement titleApart;
	
	@FindBy (xpath = "//div[@style][2]//li[1]//a[contains(@class, \"bui-button\")]")
	private WebElement bookApart;
	
	@FindBy (xpath = "//div[@style][2]//li[1]//a[contains(@class, \"bui-card__title\")]")
	private WebElement nameApart;
	
	private String apartName;
	
	private final String apartHeader;
	
	public BookingApartmentsPage() {
		this.apartHeader = "";
	}
	
	public BookingApartmentsPage(String apartHeader) {
		this.apartHeader = apartHeader;
	}

	@FindBy (xpath = "//span[@class = \"sb-searchbox__title-text\"]")
	private WebElement ApartHeader;
	
	public BookingBookApartmentPage openBookApartmentPage(WebDriver driver) throws InterruptedException
	{
		Assert.assertTrue((titleApart.getText()).contains(apartHeader), "The name of title is not correct!");
		
		apartName = nameApart.getText();
		
		bookApart.click();
		Thread.sleep(2000);
		changeWindow(driver);
		
		return new BookingBookApartmentPage(apartName);
	}
	
	public void changeWindow(WebDriver driver) throws InterruptedException
	{
		Set<String> windows = driver.getWindowHandles();
	    Iterator<String> itr = windows.iterator();
	    
	    //patName will provide you parent window
	    String patName = itr.next();
	    //System.out.println("parentWindow Handle"+patName);
	    //chldName will provide you child window
	    String chldName1 = itr.next();
	    //System.out.println("childWindow Handle"+chldName);
	    //Switch to child window
	    String chldName2 = itr.next();
	    
	    driver.switchTo().window(chldName2);
		
        Thread.sleep(2000);
	}
}
