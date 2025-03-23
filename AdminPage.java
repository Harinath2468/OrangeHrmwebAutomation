package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Utils;
import customExceptions.EmployeeNotFoundException;

public class AdminPage extends Utils{
	WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(@href,'admin')]")
	WebElement admin;
	
	@FindBy(xpath="//div[@class='oxd-table-filter']//input[@class='oxd-input oxd-input--active']")
	WebElement EmployeeName;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchEmployee;
	
	@FindBy(xpath="//div[@role='cell'][4]")
	List<WebElement> employees;

	@FindBy(xpath="//div[@role='cell'][2]")
	WebElement usernameDisplayed;
	
	//to search for an employee 
	public void getEmployeeRecord() {
		admin.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for(WebElement employee : employees) {
			System.out.println(employee.getText());
			
		}
		
	}
	public void getEmployee(String username) throws EmployeeNotFoundException {
		admin.click();
		EmployeeName.sendKeys(username);
		searchEmployee.click();
		//if employee found
		if(usernameDisplayed.getText().equalsIgnoreCase(username)) {
			System.out.println(usernameDisplayed.getText()+" is an employee of Xcompany.");
		}else {
			throw new EmployeeNotFoundException("No record found on this username");
			//System.out.println("No record found on this username");
		}
	}
	
	//Individual testing template
	public static void main(String[] args) throws EmployeeNotFoundException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Desktop\\Eclipse workspace\\SDET Udemy\\OrangeHRM\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingDashboardPage lp = new LandingDashboardPage(driver);
		lp.goToURL();
		lp.loginToHrm("Admin", "admin123");
		
		AdminPage ad = new AdminPage(driver);
		ad.getEmployeeRecord();
		ad.getEmployee("Admin");
		
	}
}
