package pageEvents;
import java.time.Duration;

import org.testng.Assert;

import TestScript.BaseTest;
import pageObjects.SignupPageElements;
import utils.*;
public class SignupPageEvents {
ElementFetch elementfetch= new ElementFetch();
	public void checkForSigupTitle() {
	Assert.assertTrue(elementfetch.getListWebElements("XPATH", SignupPageElements.signupText).size()>0, "Signup page did not open");
	}
	
	public void enterEmailAddress() {
		elementfetch.getWebElement("ID", SignupPageElements.emailaddress).sendKeys("carthika608@gmail.com");
	}
	
	public void clickCheckBox() {
		elementfetch.getWebElement("XPATH", SignupPageElements.termsAndConditionCheckbox).click();
		
	}
	
	public void clickRobotVerificationCheckBox() {
		//elementfetch.getWebElement("XPATH", SignupPageElements.iAmNotARobotCheckbox).click();
		//Implicitly creating a delay to handle recaptcha
		BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
	}
	
	public void clickSignUpButton() {
		elementfetch.getWebElement("XPATH", SignupPageElements.signUpButton).click();
	}
}

