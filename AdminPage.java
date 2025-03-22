package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Utils;

public class AdminPage extends Utils{
	WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(@href,'admin')]")
	WebElement admin;
	
	@FindBy(xpath="//input[contains(@placeholder,'Type')]")
	WebElement EmployeeName;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchEmployee;
	
	//to search for an employee 
	public void employeeRecord(String employeeName) {
	admin.click();
	EmployeeName.sendKeys(employeeName);
	searchEmployee.click();
	List<WebElement> employees = driver.findElements(By.xpath("//div[@role='cell'][4])"));
	
		for(WebElement employee : employees) {
		//if employee found
		if(employee.getText().equalsIgnoreCase(employeeName)) {
			System.out.println(employee.getText()+"  is an employee of Xcompany.");
		}
		else {
			System.out.println("No record found");
		}
	}

}
