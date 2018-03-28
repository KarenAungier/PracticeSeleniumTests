package login;
import org.testng.annotations.Test;

import login.ReadExcelFile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


public class login {

	ChromeDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		//Navigate to the driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Karen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
										
		String computerUrl = "http://54.214.252.219/Cityelectric/";
										
		//open the url
		driver.get(computerUrl);
										
		//maximise screen
		driver.manage().window().maximize();
	}
	

	@Test(dataProvider="testdata")
	public void login(String username, String password) throws InterruptedException 
	{
		
		
		
		//Create object of WebDriverWait class and it will wait max 20 seconds (Default accepts seconds)
		WebDriverWait wait = new WebDriverWait(driver, 20);
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtUser' and @name='txtUser']")));
		driver.findElement(By.id("txtUser")).sendKeys(username);
		System.out.println("USERNAME = "+ username);
				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtPassword' and @name='txtPassword']")));
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		System.out.println("PASSWORD = " + password);
				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"btnValidate\"]")));
		driver.findElement(By.xpath("//*[@id=\"btnValidate\"]")).click();
		System.out.println("LOGIN BUTTON LOCATED CLICKED SUCCESSFULLY");
				
				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ddlProjects\"]")));
		WebElement project = driver.findElement(By.id("ddlProjects"));
		project.click();
		driver.findElement(By.xpath("//*[@id=\"ddlProjects\"]/option")).click();
				
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	}
	

	@AfterMethod
	void ProgramTermination()
	{
		driver.quit();
	}
	
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed()
	{
		
		ReadExcelFile config  = new ReadExcelFile("C:\\Users\\Karen\\Documents\\practical.xlsx"); //creating object along with Path of excel file
		
		//Gets the Number of Rows in the sheet
		int rows = config.getRowCount(1);
		
		//Creates a new 2 dimentional array called object
		Object[][] credentials = new Object[rows][2];
		
		for(int i = 0; i<rows; i++)
		{
			//[i] = row, [0] = column
			//getData(int sheetnumber, int row, int column)
			credentials[i][0] = config.getData(1, i, 0);
			//[i] = row, [1] = column
			//getData(int sheetnumber, int row, int column)
			credentials[i][1] = config.getData(1, i, 1);
		}
		return credentials;
	}
	
	


}
