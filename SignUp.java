package app;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SignUp {
	@SuppressWarnings("rawtypes")
	AndroidDriver dvr;
	@Test
	public void signup() throws InterruptedException 
	{
		// Click Toggle
				dvr.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(4000);

				// Click Sign In 
				dvr.findElementByXPath("//android.widget.TextView[@text='Infants' and @index='0']").click();

				// Click SignUp Button
				dvr.findElementByXPath("//android.widget.TextView[@text='Sign Up' and @index='2']").click();

				// Name
				dvr.findElementById("com.cheapticket:id/name_edt").sendKeys("Akram");

				// Email
				dvr.findElementByXPath("//android.widget.EditText[@text='Email' and @index='1']").sendKeys("akgram@yopmail.com");

				// Mobile 
				dvr.findElementByXPath("//android.widget.EditText[@text='Mobile' and @index='2']").sendKeys("8510002202");

				// Password
				dvr.findElementByXPath("//android.widget.EditText[@index='3']").sendKeys("123456");

				// Password Again
				dvr.findElementByXPath("//android.widget.EditText[@index='4']").sendKeys("123456");

				// Click SignUp Button
				dvr.findElementById("com.cheapticket:id/signUpButton").click();
				Thread.sleep(8000);

	}
}
