package pageObjects;

public interface SignupPageElements {
	String signupText= "/html[1]/body[1]/div[1]/div[1]/div[2]/h2[1]";
	String emailaddress= "email";
	String termsAndConditionCheckbox= "//input[@id='terms']";
	String iAmNotARobotCheckbox="//body/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/center[1]/div[1]";
	String signUpButton="//button[contains(text(),'Sign up')]";
}
