package TestScript;

import org.testng.annotations.Test;

import pageEvents.*;

public class Tests extends BaseTest{
	@Test
	public static void sample() {
		
		LoginPageEvents loginPageEvents= new LoginPageEvents();
		loginPageEvents.checkLoginPageOpenedOrNot();
		loginPageEvents.enterUserName();
		loginPageEvents.enterPassword();
		loginPageEvents.clickLoginButton();
		
		Dashboard dashboard= new Dashboard();
		dashboard.checkLogin();
		dashboard.clickpunchInEmployee();
		
		
		
		
		
		/*HomePageEvents homePageEvents= new HomePageEvents();
		homePageEvents.clickOnSignUpButton();
		SignupPageEvents signUpPageEvents = new SignupPageEvents();
		signUpPageEvents.checkForSigupTitle();
		signUpPageEvents.enterEmailAddress();
		signUpPageEvents.clickCheckBox();
		signUpPageEvents.clickRobotVerificationCheckBox();
		signUpPageEvents.clickSignUpButton();*/
	}
	
}
