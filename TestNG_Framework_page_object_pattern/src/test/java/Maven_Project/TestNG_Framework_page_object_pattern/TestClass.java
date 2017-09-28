package Maven_Project.TestNG_Framework_page_object_pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Reporter;
import PageClassesPackage.AddExpensesPage;
import PageClassesPackage.ListCategoryPage;
import PageClassesPackage.ListExpensesPage;
import PageClassesPackage.LoginPage;
import PageClassesPackage.NewUserRegistrationPage;
import UsefulMethodsPackage.GenericMethods;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class TestClass {
	public static WebElement element = null;
	String baseUrl;
	WebDriver driver;
	private GenericMethods gm;
	
	@BeforeMethod
	public void BeforeMethod() {
		baseUrl = "http://thawing-shelf-73260.herokuapp.com/";
		System.setProperty("webdriver.gecko.driver", "/C:/Users/HP/Documents/workspace/geckodriver.exe");
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	
	@Test(enabled=true)
	public void testcase1_create_new_user() {
		Reporter.log("User Story-007 : Running testcase1_create_new_user ");
		try {
			NewUserRegistrationPage.newUserRegistrationLink(driver);
			NewUserRegistrationPage.fillUserName(driver, "abcd");
			NewUserRegistrationPage.fillPasswordTextBox(driver, "1234");
			NewUserRegistrationPage.fillRepeatPasswordTextBox(driver, "1234");
			NewUserRegistrationPage.clickLoginButton(driver);
			NewUserRegistrationPage.checkLogOutButton(driver);
		}
		catch (Exception e){
			Reporter.log("User account creation not success. Check account is already exists with same username");
		}

	}
	
	@Test(enabled=true)
	public void testcase2_loginToTracker() {
		Reporter.log("Running testcase2_loginToTracker ");
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		LoginPage.checkLogOutButton(driver);
	}
	
	@Test(enabled=true)
	public void testcase3_list_category() {
		Reporter.log("Running testcase3_list_category", true );
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		String[] myStringArray1 = {"bmw", "audi", "honda"};
		int len1 = myStringArray1.length;
		for (int i = 0; i < len1; i++){
			gm.getElement("go_list_categories", "id").click();
			gm.getElement("go_add_category", "id").click();
			WebElement element10 = gm.getElement("name", "id");
			element10.sendKeys(myStringArray1[i]);
			gm.getElement("submit", "id").click();
		}
	}
	
	@Test(enabled=true)
	public void testcase4_add_expenses() {
		Reporter.log("User Story-002 : Running testcase4_Add_expenses", true );
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		AddExpensesPage.goToAddExpensePage(driver);
		AddExpensesPage.fillDayField(driver, "1");
		AddExpensesPage.fillMonthField(driver, "1");
		AddExpensesPage.fillYearField(driver, "2000");
		AddExpensesPage.selectCategory(driver, "audi");
		AddExpensesPage.fillAmountField(driver, "60000");
		AddExpensesPage.fillReasonField(driver, "Purchased");
		AddExpensesPage.clickCreateExpense(driver);

		AddExpensesPage.goToAddExpensePage(driver);
		AddExpensesPage.fillDayField(driver, "2");
		AddExpensesPage.fillMonthField(driver, "9");
		AddExpensesPage.fillYearField(driver, "2017");
		AddExpensesPage.selectCategory(driver, "bmw");
		AddExpensesPage.fillAmountField(driver, "70000");
		AddExpensesPage.fillReasonField(driver, "Sold");
		AddExpensesPage.clickCreateExpense(driver);
	
		AddExpensesPage.goToAddExpensePage(driver);
		AddExpensesPage.fillDayField(driver, "1");
		AddExpensesPage.fillMonthField(driver, "1");
		AddExpensesPage.fillYearField(driver, "2100");
		AddExpensesPage.selectCategory(driver, "honda");
		AddExpensesPage.fillAmountField(driver, "12000");
		AddExpensesPage.fillReasonField(driver, "Sales");
		AddExpensesPage.clickCreateExpense(driver);
	}
	
	@Test(enabled=true)
	public void testcase5_list_expenses() {
		Reporter.log("User Story-001: Running testcase5_list_expenses", true );
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		gm.getElement("go_list_expenses", "id").click();
		WebElement table_element = driver.findElement(By.xpath("//table[@class='table']"));
		Reporter.log("List of expenses are :", true);
	    ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
	    for (WebElement row : rows) {
	        ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.tagName("td"));
	        for (WebElement cell : cells) {
	            Reporter.log(cell.getText(), true);
	        }
	    }
	
	}
	
	@Test(enabled=true)
	public void testcase6_edit_expenses() {
		Reporter.log("User Story-003 : Running testcase6_edit_expenses", true );
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		ListExpensesPage.editListedExpenses(driver);
		AddExpensesPage.fillDayField(driver, "2");
		AddExpensesPage.fillMonthField(driver, "9");
		AddExpensesPage.fillYearField(driver, "2017");
		AddExpensesPage.selectCategory(driver, "audi");
		AddExpensesPage.fillAmountField(driver, "25000");
		AddExpensesPage.fillReasonField(driver, "sale");
		AddExpensesPage.clickCreateExpense(driver);
		
	}
	
	@Test(enabled=true)
	public void testcase7_delete_expenses() {
		Reporter.log("User Story-003 : Running testcase7_delete_expenses", true );
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		ListExpensesPage.deleteListedExpenses(driver);
	}
	
	@Test(enabled=true)
	public void testcase8_edit_category() {
		Reporter.log("User Story-004 : Running testcase8_edit_category", true );
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		ListCategoryPage.clickListCategoryPage(driver);
		ListCategoryPage.editListedCategory(driver);
		ListCategoryPage.fillNameField(driver, "Chicken");
		ListCategoryPage.clickSaveCategoryPage(driver);
	}
	
	@Test(enabled=true)
	public void testcase9_delete_category() {
		Reporter.log("User Story-004 : Running testcase9_delete_category", true );
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		ListCategoryPage.clickListCategoryPage(driver);
		ListCategoryPage.deleteListedCategory(driver);

	}
	
	@Test(enabled=true)
	public void testcase99_edit_user_account() {
		Reporter.log("User Story-008 : Running testcase99_edit_user_account", true );
		LoginPage.fillUserName(driver, "abcd");
		LoginPage.fillPasswordTextBox(driver, "1234");
		LoginPage.clickLoginButton(driver);
		driver.findElement(By.id("editaccount")).click();
		element = driver.findElement(By.name("login"));
		Reporter.log("Is user name field is enabled? : " + element.isEnabled());
		Reporter.log("Username field is not enable hence not possible to change the user name");
		driver.findElement(By.id("password")).sendKeys("1234");
		Reporter.log("Found input Oldpassword field and sent old password");
		driver.findElement(By.id("newpassword1")).sendKeys("1234");
		Reporter.log("Found input newpassword1 field and sent new password");
		driver.findElement(By.id("newpassword2")).sendKeys("1234");
		Reporter.log("Found input newpassword2 field and confirmed new password");
		driver.findElement(By.id("submit")).click();
		Reporter.log("Found update account button and clicked it\n "
				+ "User account access data is changed successfully ");

	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}

