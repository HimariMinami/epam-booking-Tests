package accommodations_attr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookingActivityPage {

	@FindBy (xpath = "//div[@class=\"css-37ds6r\"]//div[@class=\"css-1qxslmw\"]//div[@class=\"css-156c2rk\"]")
	private WebElement costAttraction;
	
	private String costFAttr;
	
	public BookingActivityPage() {
		this.costFAttr = "";
	}
	
	public BookingActivityPage(String costFAttr) {
		this.costFAttr = costFAttr;
	}

	public void assertCityHeader()
	{
		Assert.assertTrue((costAttraction.getText()).contains(costFAttr), "The city header is not correct!");
	}
}
