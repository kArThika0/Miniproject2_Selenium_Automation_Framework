package pageEvents;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import pageObjects.SignupPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	ElementFetch elementfetch= new ElementFetch();
	public void checkLoginPageOpenedOrNot() {
		Assert.assertTrue(elementfetch.getListWebElements("XPATH", LoginPageElements.LoginPageTitle).size()>0, "Loginpage did not open");
	}
	
	public void enterUserName() {
		elementfetch.getWebElement("XPATH", LoginPageElements.userNameTextBox).sendKeys("Admin");
	}
	
	public void enterPassword() {
		elementfetch.getWebElement("CSS", LoginPageElements.passwordTextBox).sendKeys("admin123");
	}
	public void clickLoginButton() {
		elementfetch.getWebElement("XPATH", LoginPageElements.loginButton).click();
	}
}
