package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import commonFunctions.CommonFunction;
import pageElements.Dashboard_Page;
import pageElements.Login_Page;

public class Test_Userlogin_Dashboard extends CommonFunction {
	
	String dashboardstring=null;
	public void login() {
		PageFactory.initElements(driver,Login_Page.class);
		String un=properties.getProperty("username");
		String pw=properties.getProperty("password");
		Login_Page.username.sendKeys(un);
		Login_Page.password.sendKeys(pw);
	}
	
	
	public void getdashboardtext() {
		PageFactory.initElements(driver, Dashboard_Page.class);
		dashboardstring=Dashboard_Page.pendingleave.getText();
		
	}
	@Test
	public void testlogin() {
		login();
		Login_Page.loginbutton.click();
		getdashboardtext();
		Assert.assertEquals(dashboardstring, "No Records are Available");
		
	}
	
	

}
