package Maven_Project.TestNG_Framework_page_object_pattern;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class AddExpensesPage {
	public static WebElement element = null;

	public static void goToAddExpensePage(WebDriver driver) {
		element = driver.findElement(By.id("go_add_expense"));
		element.click();
		Reporter.log("Found add expense page with locator - 'go_add_expense' and clicked it");
	}
	
	public static WebElement findDayField(WebDriver driver) {
		element = driver.findElement(By.id("day"));
		return element;
	}
	
	public static void fillDayField(WebDriver driver, String str1) {
		element = findDayField(driver);
		Reporter.log("Found Day field with locator - 'day'");
		element.clear();
		element.sendKeys(str1);
		Reporter.log("Sent input to the day field: " + str1);
	}
	
	public static WebElement findMonthField(WebDriver driver) {
		element = driver.findElement(By.id("month"));
		element.clear();
		return element;
	}
	
	public static void fillMonthField(WebDriver driver, String str1) {
		element = findMonthField(driver);
		Reporter.log("Found Month field with locator - 'month'");
		element.clear();
		element.sendKeys(str1);
		Reporter.log("Sent input to the month field: " + str1);
	}
	
	public static WebElement findYearField(WebDriver driver) {
		element = driver.findElement(By.id("year"));
		return element;
	}
	
	public static void fillYearField(WebDriver driver, String str1) {
		element = findYearField(driver);
		Reporter.log("Found year input field with locator - 'year'");
		element.clear();
		element.sendKeys(str1);
		Reporter.log("Sent input to the year input field: " +str1);
	}
	
	public static WebElement findAmountField(WebDriver driver) {
		element = driver.findElement(By.id("amount"));
		return element;
	}
	
	public static void fillAmountField(WebDriver driver, String str1) {
		element = findAmountField(driver);
		Reporter.log("Found amount input field with locator - 'amount'");
		element.clear();
		element.sendKeys(str1);
		Reporter.log("Sent input to the amount input field: " + str1);
	}
	
	public static WebElement findReasontField(WebDriver driver) {
		element = driver.findElement(By.id("reason"));
		return element;
	}
	
	public static void fillReasonField(WebDriver driver, String str1) {
		element = findReasontField(driver);
		Reporter.log("Found reason input field with locator - 'reason'");
		element.clear();
		element.sendKeys(str1);
		Reporter.log("Sent input to the reason input field: " + str1);
	}
	
	public static void clickCreateExpense(WebDriver driver) {
		element = driver.findElement(By.id("submit"));
		element.click();
		Reporter.log("Found create expense button with locator - 'submit' and clicked");
	}
	
	public static void selectCategory(WebDriver driver, String str1) {
		element = driver.findElement(By.id("category"));
		Reporter.log("Found dropdown element with locator - 'category'");
		Select sel = new Select(element);
		sel.selectByVisibleText(str1);
		Reporter.log("Selected an element from the dropdown: " + str1);
	}

}






