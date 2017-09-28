package Maven_Project.TestNG_Framework_page_object_pattern;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.openqa.selenium.By;



public class ListCategoryPage {
	public static WebElement element = null;
	
	public static void clickListCategoryPage(WebDriver driver) {
		element = driver.findElement(By.id("go_list_categories"));
		element.click();
		Reporter.log("Clicked on List category page to edit/delete");
	}
	
	public static WebElement findNametField(WebDriver driver) {
		element = driver.findElement(By.id("name"));
		return element;
	}
	
	public static void fillNameField(WebDriver driver, String str1) {
		element = findNametField(driver);
		Reporter.log("Found Category Name input field with locator - 'name'");
		element.clear();
		element.sendKeys(str1);
		Reporter.log("Sent input to the name input field: " + str1);
	}
	
	public static void clickSaveCategoryPage(WebDriver driver) {
		element = driver.findElement(By.id("submit"));
		element.click();
		Reporter.log("Clicked on Save category button to save the category");
	}
	
	public static void editListedCategory(WebDriver driver) {
		try{
			List<WebElement> listedExpense = driver.findElements(
					By.xpath("//*[@title='edit category']"));
			int size = listedExpense.size();
			Reporter.log("Size of the list: " + size, true);
			for (int i=0; i<size;) {
				listedExpense.get(i).click();
				Reporter.log("clicked to edit the listed category");
			}
		}
		catch (Exception e) {
			}	
		}
	
	public static void deleteListedCategory(WebDriver driver) {
		try{
			List<WebElement> listedExpense = driver.findElements(
					By.xpath("//*[@title='delete category']"));
			int size = listedExpense.size();
			Reporter.log("Size of the list: " + size, true);
			for (int i=0; i<size;) {
				listedExpense.get(i).click();
				Reporter.log("clicked to delete the listed category");	
			}	
		}
		catch (Exception e) {
			}
		Alert alert = driver.switchTo().alert();
		Reporter.log("pop up alert before deleting");
		alert.accept();
		Reporter.log("Accepted alert message and delete successful");
		}
}
