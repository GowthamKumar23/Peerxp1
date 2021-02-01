package pageYatra;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import excel.ExcelFunc;

public class BookingPage 
{
	WebDriver driver;
	ExcelFunc ef = new ExcelFunc();
	//Select selector; 
	By tripType = By.xpath("//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[1]/ul[1]/li[1]/a");
	By cityFrom = By.id("BE_flight_origin_city");
	By fromCityList = By.xpath("//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/div/div/div/li");
	By toCityList = By.xpath("//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[2]/ul/li[1]/ul/li[3]/div/div/ul/div/div/div/li");
	By departDate = By.id("BE_flight_origin_date");
	//By Date = By.linkText("27");
	By passInfo = By.id("BE_flight_paxInfoBox");
	By clas = By.id("flight_class_select_child");
	By submit = By.id("BE_flight_flsearch_btn");
	
	public BookingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
   	public void enterdetails() throws InterruptedException, IOException, ParseException
   	{
   		driver.findElement(tripType).click();
   		WebElement from = driver.findElement(cityFrom);
   		from.click();
   		Thread.sleep(1000);
   		from.clear();
   		List<WebElement> fromCities = driver.findElements(fromCityList);
   		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
   		for(WebElement f : fromCities)
   		{
   			if(f.getText().contains((CharSequence)ef.getCellData(1, 0)))
   			{
				f.click();
				break;
   			}
   		}
   		
   		List<WebElement> toCities = driver.findElements(toCityList);
   		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
   		
   		for(WebElement t : toCities)
		{
			if(t.getText().contains((CharSequence)ef.getCellData(1, 1)))
			{
				t.click();
				break;
			}
		}
   	    System.out.println(fromCities.size());

   		//to.sendKeys("Delhi");
   	    
   		driver.findElement(departDate).click();
   		String d = (String)ef.getCellData(1, 2);
   		d =(d.substring(1, 11));
   		SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
   		format.parse(d);
   		//System.out.println(d);
   		driver.findElement(By.id(d)).click();
   		
   		driver.findElement(passInfo).click();
   		int adults = (int)(Float.parseFloat( ef.getCellData(1, 3).toString()));
   		int child = (int)(Float.parseFloat(ef.getCellData(1, 4).toString()));
   		int infants =(int)(Float.parseFloat(ef.getCellData(1, 5).toString()));
   		passList(adults,child,infants);
   		List<WebElement> classType = driver.findElements(clas);
   		for (WebElement ct:classType) 
   		{
			if(ct.getText().equals("Economy"))
			{
				ct.click();
				break;
			}
			
		}driver.findElement(submit).click();
   	    //JavascriptExecutor js = (JavascriptExecutor) driver;
   	   // js.executeScript("document.getElementById('BE_flight_origin_date').value='3 Feb 21'");
   		//driver.findElement(Date).click();
   		//driver.quit();
   	}


	private void passList(int adults,int child,int infants)
	{
		int i =1,j=0,k=0;
		
		while(i <adults)
		{
			driver.findElement(By.className("ddSpinnerPlus")).click();
			i++;
		}
	    while(j<child)
	    {
	    	driver.findElement(By.xpath("//*[@id=\"BE_flight_passengerBox\"]/div[1]/div[2]/div/div/span[2]")).click();
			j++;
		 }
	    while(k<infants)
	    {
	    	driver.findElement(By.xpath("//*[@id=\"BE_flight_passengerBox\"]/div[1]/div[3]/div/div/span[2]")).click();
			k++;
		 }
		
	}

   	
   	
}
