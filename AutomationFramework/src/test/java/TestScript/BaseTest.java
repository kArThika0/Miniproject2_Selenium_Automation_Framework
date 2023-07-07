package TestScript;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Constants;

public class BaseTest {
 public static WebDriver driver;
 public static ExtentReports extent;
 public static ExtentSparkReporter sparkreporter;
 public static ExtentTest extentTest;
 
	
	@BeforeTest
	public void beforeTest() {
		sparkreporter= new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/report.html");
		extent= new ExtentReports();
		extent.attachReporter(sparkreporter);

	}
	@Parameters(value= {"browserName"})
	@BeforeMethod
	public  void beforeMethod(String browserName, Method testMethod) {
		extentTest= extent.createTest(testMethod.getName());
		setupDriver(browserName);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE) {
			String methodName= result.getMethod().getMethodName();
			String logTest= "Test Case"+ methodName + "failed";
			System.out.println(logTest);
			extentTest.log(Status.FAIL,"Test case Fail");
			
		}
		else if(result.getStatus()== ITestResult.SKIP) {
			String methodName= result.getMethod().getMethodName();
			String logTest= "Test Case"+ methodName + "skipped";
			System.out.println(logTest);
			extentTest.log(Status.SKIP,"Test case Skipped");
		}
		else if(result.getStatus()== ITestResult.SUCCESS) {
			String methodName= result.getMethod().getMethodName();
			String logTest= "Test Case"+ methodName + "success";
			System.out.println(logTest);
			extentTest.log(Status.PASS,"Test case Pass");
		}
		driver.quit();
	}
	
	@AfterTest
	public  void afterTest() {
		
		extent.flush();
	}
	public void setupDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
	}
}
