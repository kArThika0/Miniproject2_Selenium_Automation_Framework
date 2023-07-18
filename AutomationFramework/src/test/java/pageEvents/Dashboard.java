package pageEvents;

import org.testng.Assert;

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
 
	}
	
	public void clickpunchInEmployee() {
		elementfetch.getWebElement("XPATH", DashboardElements.punchInDashboardButton).click();
		Assert.assertTrue(elementfetch.getWebElement("XPATH", DashboardElements.attendanceTitle).isDisplayed(), "The page didnt navigate to attendance page of employee");
	}
	
	public void datePicker() {
		elementfetch.getWebElement("XPATH", DashboardElements.calendarIconButton).click();
		
	}
	
}
