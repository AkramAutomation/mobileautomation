package app;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SignIn {
	@SuppressWarnings("rawtypes")
	AndroidDriver dvr;
	@Test
	public void login() throws InterruptedException {

		// Click Toggle
		Thread.sleep(1000);
		dvr.findElementByClassName("android.widget.ImageButton").click();

		// Click Sign In Button
		dvr.findElementByXPath("//android.widget.CheckedTextView[@text='Sign In' and@index='0']").click();

		// Enter Email ID
		dvr.findElementById("com.cheapticket:id/emailIdEditText").sendKeys("akram@yopmail.com");

		// Enter Password
		dvr.findElementByXPath("//android.widget.EditText[@index='1']").sendKeys("123456");

		// Click Sign In Button
		dvr.findElementById("com.cheapticket:id/signInButton").click();


	}

}
