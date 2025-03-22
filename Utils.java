package Abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Utils {
	
	 WebDriver driver;

	public Utils(WebDriver driver) {
		
		 this.driver = driver ;
		PageFactory.initElements( driver, this);
		
	}
	
	@FindBy(xpath="//a[contains(@href,'admin')]")
	WebElement admin;
	
	@FindBy(xpath="//a[contains(@href,'dashboard')]")
	WebElement dashboard;
	
	@FindBy(xpath="//a[contains(@href,'pim')]")
	WebElement pim;
	
	public void goToDashboardPage() {
		dashboard.click();		
	}
	
	public void goToAdminPage() {
		admin.click();		
	}
	
	public void goToPimPage() {
		pim.click();		
	}
	
}
