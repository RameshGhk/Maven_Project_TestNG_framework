package Maven_Project.TestNG_Framework_page_object_pattern;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class NewUserRegistrationPage {
	public static WebElement element = null;
	
	public static void newUserRegistrationLink(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='register.jsp']"));
		element.click();
	}
	
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
		element = driver.findElement(By.id("password1"));
		return element;
	}
	
	public static void fillPasswordTextBox(WebDriver driver, String Password) {
		element = passwordTextBox(driver);
		Reporter.log("Found password input field with locator -password1");
		element.sendKeys(Password);
		Reporter.log("Sent password: "+ Password);
	}
	
	public static WebElement repeatPasswordTextBox(WebDriver driver) {
		element = driver.findElement(By.id("password2"));
		return element;
	}
	
	public static void fillRepeatPasswordTextBox(WebDriver driver, String Password) {
		element = repeatPasswordTextBox(driver);
		Reporter.log("Found password input field with locator -password2");
		element.sendKeys(Password);
		Reporter.log("Sent password: "+ Password);
	}
	
	public static void clickLoginButton(WebDriver driver) {
		element = driver.findElement(By.id("submit"));
		Reporter.log("Found login button with locator - 'submit'");
		element.click();
		Reporter.log("Clicked login button");
   }
	
	public static void checkLogOutButton(WebDriver driver) {
		try {
			element = driver.findElement(By.id("logout"));
			Reporter.log("Found logout button with locator - 'logout' and new user account creation is successful");
		}
		catch (Exception e){
			Reporter.log("User account creation not success. Check account is already exists with same username");
		}
		
	}
	

}
