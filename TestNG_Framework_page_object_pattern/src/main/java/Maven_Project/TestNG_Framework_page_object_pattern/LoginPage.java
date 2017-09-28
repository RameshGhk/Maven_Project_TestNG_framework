package Maven_Project.TestNG_Framework_page_object_pattern;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class LoginPage {
	public static WebElement element = null;

	public static WebElement usernameTextBox(WebDriver driver) {
		element = driver.findElement(By.id("login"));
		return element;
	}
	
	public static void fillUserName(WebDriver driver, String username) {
		element = usernameTextBox(driver);
		Reporter.log("Found username input field with locator-'login'");
		element.sendKeys(username);
		Reporter.log("Sent username: "+ username);
	}

	public static WebElement passwordTextBox(WebDriver driver) {
		element = driver.findElement(By.id("password"));
		return element;
	}
	
	public static void fillPasswordTextBox(WebDriver driver, String Password) {
		element = passwordTextBox(driver);
		Reporter.log("Found password input field with locator -password");
		element.sendKeys(Password);
		Reporter.log("Sent password: "+ Password);
	}
	
	public static void clickLoginButton(WebDriver driver) {
		element = driver.findElement(By.id("submit"));
		Reporter.log("Found login button with locator - 'login'");
		element.click();
		Reporter.log("Clicked login button");
   }
	public static void checkLogOutButton(WebDriver driver) {
		try {
			element = driver.findElement(By.id("logout"));
			Reporter.log("Found logout button with locator - 'logout' and login to expense tracker is successful");
		}
		catch (Exception e){
			Reporter.log("Login to expense tracker failed");
		}
		
	}
	
	
	
}