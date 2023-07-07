package pageEvents;

import pageObjects.HomePageElements;
import utils.*;
public class HomePageEvents {
	
	ElementFetch elementFetch=new ElementFetch();
	
	public void clickOnSignUpButton() {
		elementFetch.getWebElement("XPATH", HomePageElements.signupbtn).click();
	
	}
}
