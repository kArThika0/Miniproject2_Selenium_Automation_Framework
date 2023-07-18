package pageEvents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import TestScript.BaseTest;
import pageObjects.DashboardElements;
import utils.ElementFetch;

public class Dashboard {
	ElementFetch elementfetch= new ElementFetch();
	
	public void checkLogin() {
	  Boolean checkTitle=elementfetch.getWebElement("XPATH", DashboardElements.dashboardtitle ).isDisplayed();
	  if (checkTitle.equals(true)){
		  System.out.println("Successful login and dashboard is displayed");
	  }
	  else
		  System.out.println("Not logged in and Dashboard is not displayed");
 elementfetch.getWebElement("XPATH",DashboardElements.adminTab).click();
 
	}
	public void dropDownBox() {
		elementfetch.getWebElement("XPATH", DashboardElements.adminSearchButton).click();
		
		WebElement dropdown=elementfetch.getWebElement("XPATH", DashboardElements.adminStatusDropDown);
		Select selectDropDown = new Select(dropdown);
		selectDropDown.selectByIndex(1);
		
	}
	
	public void clickpunchInEmployee() {
		elementfetch.getWebElement("XPATH", DashboardElements.punchInDashboardButton).click();
		Assert.assertTrue(elementfetch.getWebElement("XPATH", DashboardElements.attendanceTitle).isDisplayed(), "The page didnt navigate to attendance page of employee");
	}
	
	public void datePicker() {
		elementfetch.getWebElement("XPATH", DashboardElements.calendarIconButton).click();
		//we can directly send keys to this date picker rightnow
	}
}
