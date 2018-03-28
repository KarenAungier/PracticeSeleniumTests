package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAConnectorLoginTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Karen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//start browser
		WebDriver driver = new ChromeDriver();
		
		//get Web Page
		driver.get("http://54.214.252.219/Cityelectric/");
		
		//Maximize the Browser Window
		driver.manage().window().maximize();
		
		//Create object of WebDriverWait class and it will wait max 20 seconds (Default accepts seconds)
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtUser' and @name='txtUser']")));
		WebElement username = driver.findElement(By.id("txtUser"));
		username.sendKeys("Karen");
		System.out.println("USERNAME ENTERED SUCCESSFULLY");
		
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtPassword' and @name='txtPassword']")));
		driver.findElement(By.id("txtPassword")).sendKeys("password");
		System.out.println("PASSWORD ENTERED SUCCESSFULLY");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"btnValidate\"]")));
		driver.findElement(By.xpath("//*[@id=\"btnValidate\"]")).click();
		System.out.println("LOGIN BUTTON LOCATED CLICKED SUCCESSFULLY");
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ddlProjects\"]")));
		WebElement project = driver.findElement(By.id("ddlProjects"));
		project.click();
		driver.findElement(By.xpath("//*[@id=\"ddlProjects\"]/option")).click();
		
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		
		
		
		
		
		
		
		
	}

}
