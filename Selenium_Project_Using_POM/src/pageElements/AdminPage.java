package pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {
	@FindBy(id="menu_admin_viewAdminModule")
	public static WebElement admin;
	
	@FindBy(id="menu_admin_UserManagement")
	public static WebElement usermanagement;
	
	@FindBy (id="menu_admin_viewSystemUsers")
	public static WebElement users;
	
	@FindBy(id="searchSystemUser_userName")
	public static WebElement username;
	
	@FindBy(id="searchSystemUser_userType")
	public static WebElement userrole;
	
	@FindBy (id="searchSystemUser_status")
	public static WebElement userstatus;
	
	@FindBy(id="searchBtn")
	public static WebElement searchbutton;
	
	@FindBy(xpath ="//tr[@class='odd']//following::td[3]")
	public static WebElement admintext;
	
	@FindBy(xpath ="//tr[@class='odd']//following::td[5]")
	public static WebElement enabledtext;
	
	
}
