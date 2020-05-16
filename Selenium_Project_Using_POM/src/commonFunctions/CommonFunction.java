package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public  class CommonFunction {
	Logger logg=Logger.getLogger(CommonFunction.class);
	public static WebDriver driver;
	public static Properties properties;

	//File Reading
	public Properties inputfile() throws IOException {
		FileInputStream readfile=new FileInputStream("input.properties");
		properties=new Properties();
		properties.load(readfile);
		return properties;
		
	}

	//We pass the URL and Location of selenium driver using Config file properties
	@BeforeSuite
	public void lauchbrowser() throws IOException {
		PropertyConfigurator.configure("log4jproject.properties");
		logg.info("Property File Reading");
		inputfile();
		logg.info("Chrome browser launching");
		String Url=properties.getProperty("Url");
		String Location=properties.getProperty("Location");
		System.setProperty("webdriver.chrome.driver",Location);
		driver=new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
}
	
	
	
	@AfterSuite
	public void closebrowser() {
		logg.info("End of the automation,browser Closed");
	driver.quit();
	}
}
