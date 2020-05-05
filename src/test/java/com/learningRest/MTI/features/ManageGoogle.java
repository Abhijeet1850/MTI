package com.learningRest.MTI.features;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageGoogle {

	@Given("^I login into Chrome Browser and I entered URL \"([^\"]*)\"$")
	public void i_login_into_Chrome_Browser_and_I_entered_URL(String data) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\test\\eclipse-workspace\\MTI\\src\\main\\java\\com\\learningRest\\MTI\\Drivers\\Windows\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--test-type");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-popup-blocking");
		DesiredCapabilities chromeCap = DesiredCapabilities.chrome();
		chromeCap.setJavascriptEnabled(true);
		options.setCapability(ChromeOptions.CAPABILITY, chromeCap);

	//	WebDriver driver = new ChromeDriver(options);
	//	driver.get("http://www.google.com");

	}

	@When("^I enter \"([^\"]*)\" in google search textbox$")
	public void i_enter_in_google_search_textbox(String arg1) throws Throwable {

	}

	
	@When("^I use below data in google search textbox$")
	public void i_use_below_data_in_google_search_textbox(DataTable data) throws Throwable {
	    
		// 1. List of List 
		// 2. List of Maps
		
	/*	List<List<String>> abc = data.raw();
		for(int i=1; i<abc.size();i++)
		{
			
			
			System.out.println(abc.get(i));
			
			/*for(int j=0;j<abc.get(i).size();j++)
			{
				
				System.out.println(abc.get(i).get(j));
				
			}
		}
		*/
		
		List<Map<String,String>> data1 = data.asMaps(String.class, String.class);
		
		for(int i=0;i<data1.size();i++)
		{
			//System.out.println(data1.get(i));
			Test.dummyTestDataPrint(data1.get(i));
			
			
		}
		
		
		
	}
	
	
	
	@When("^I click Search Button$")
	public void i_click_Search_Button() throws Throwable {

	}

	@Then("^I am verifying first Search Result$")
	public void i_am_verifying_first_Search_Result() throws Throwable {

	}

}
