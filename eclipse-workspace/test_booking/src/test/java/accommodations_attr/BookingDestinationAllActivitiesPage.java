package accommodations_attr;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookingDestinationAllActivitiesPage {

	@FindBy (className = "css-4zzkap")
	private WebElement countryHeader;
	
	@FindBy (xpath = "//div[@class=\"css-1nha944\"]//div[@class=\"css-1qm1lh\"][1]")
	private WebElement firstAttraction;
	
	@FindBy (xpath = "//div[@class=\"css-1nha944\"]//div[@class=\"css-1qm1lh\"][1]/a/div/div[2]/div[1]/div[1]")
	private WebElement costFirstAttraction;
	
	@FindBy (xpath = "//div[@class=\"css-1qm1lh\"][1]//h4[@class=\"css-1j2nyyh\"]")
	private WebElement nameActivity;
	
	private static final String ALL_ACTIVITIES = "css-1qm1lh";	
	private static final String CMBBX_ACTIVITIES_NUM = "//span[@class=\"css-1d2tbqv\"]";
	
	private String costFAttr;
	private String nameActiv;
	
	public void assertActivitiesCity(WebDriver driver)
	{
		Assert.assertTrue(ParamIsCorrect(driver, CMBBX_ACTIVITIES_NUM, ALL_ACTIVITIES), "The number of activities is not correct!");		
	}
	
	public BookingActivityPage activityDescription()
	{		
		costFAttr = costFirstAttraction.getText();
		nameActiv = nameActivity.getText();
		firstAttraction.click();
				
		return new BookingActivityPage(costFAttr, nameActiv);
	}
	
	private String text;
	private int num;
	private int sum = 0;
	
	// �������� �� ������������ ���������� ���������
	public boolean ParamIsCorrect(WebDriver driver, String A, String clN)
	{
		try
		{
			List<WebElement> elements = driver.findElements(By.className(clN));
			List<WebElement> elements1 = driver.findElements(By.xpath(A));
			
			int q = elements.size();
			
			for (WebElement qn: elements1) {
			    text = qn.getText();
			    text = text.replace("(", "");
			    text = text.replace(")", "");			    
			    num = Integer.parseInt(text);
			    sum += num;
			    text = null;
			}
			
			if(sum == q)
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