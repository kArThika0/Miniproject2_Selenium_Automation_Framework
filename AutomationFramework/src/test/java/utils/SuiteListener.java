package utils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import TestScript.BaseTest;
public class SuiteListener implements ITestListener, IAnnotationTransformer{
	
	 public void onTestFailure(ITestResult result) {
		 
		 try {
			String fileName= System.getProperty("user.dir")+ "/screenshots/" + result.getMethod().getMethodName() +".png";
			File f= ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(fileName	));
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public  void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		    // not implemented
		 annotation.setRetryAnalyzer( RetryAnalyser.class);
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		 try {
				String fileName= System.getProperty("user.dir")+ "/screenshots/" + result.getMethod().getMethodName() +".png";
				File f= ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(f, new File(fileName	));
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
}
