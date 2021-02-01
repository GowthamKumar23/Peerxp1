package tests;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageYatra.BookingPage;

public class Tester {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException, ParseException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		BookingPage BP = new BookingPage(driver);
		BP.enterdetails();
		System.out.println();
		Assert.assertEquals(driver.getTitle(), "Yatra.com | Bengaluru to Delhi flights");
		driver.quit();

	}

}
