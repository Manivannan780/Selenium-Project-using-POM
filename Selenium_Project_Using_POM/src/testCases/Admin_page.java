package testCases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import commonFunctions.CommonFunction;
import pageElements.AdminPage;
import pageElements.Login_Page;

public class Admin_page extends CommonFunction {

	String Adtext=null;
	String enbtext=null;
	public void adminpage() {

		PageFactory.initElements(driver,AdminPage.class);
		Actions obj=new Actions(driver);
		obj.moveToElement(AdminPage.admin);
		obj.moveToElement(AdminPage.usermanagement);
		obj.moveToElement(AdminPage.users);
		obj.click().build().perform();

	}



	public void dropdownselection() {
		Select dropdown=new Select(AdminPage.userstatus);
		Select dropdown2=new Select(AdminPage.userrole);
		dropdown.selectByIndex(1);
		dropdown2.selectByIndex(1);

	}

	public void gettxt() {
		Adtext=AdminPage.admintext.getText();
		enbtext=AdminPage.enabledtext.getText();
	}

	@Test
	public void admin() {
		adminpage();

		AdminPage.username.sendKeys("Admin");

		dropdownselection();
		AdminPage.searchbutton.click();

		gettxt();

		Assert.assertEquals(Adtext, "Admin");
		Assert.assertEquals(enbtext, "Enabled");

	}
}
