package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Utils;

public class LandingDashboardPage extends Utils{

WebDriver driver;

public LandingDashboardPage(WebDriver driver) {
		super(driver);
		  this.driver =driver;
		PageFactory.initElements( driver, this);
		
	}

	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	public void goToURL() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void loginToHrm(String Username, String Password) {
		
		username.sendKeys(Username);
		password.sendKeys(Password);
		login.click();
	}
	//Individual testing template
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Desktop\\Eclipse workspace\\SDET Udemy\\OrangeHRM\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingDashboardPage lp = new LandingDashboardPage(driver);
		lp.goToURL();
		lp.loginToHrm("Admin", "admin123");
		
		
	}
}
