package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemoTest extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception {
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("testName", "IOSDemoTest");
		dc.setCapability("instrumentApp", true);
		dc.setCapability("platform", "DhirajPractise");

		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
	}

	 @Test
	 public void test() {
	  driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Password']")));
	  driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
	  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@accessibilityLabel='loginButton']")));
	  driver.findElement(By.xpath("//*[@accessibilityLabel='loginButton']")).click();
	  driver.findElement(By.xpath("//*[@accessibilityLabel='makePaymentButton']")).click();
	  driver.findElement(By.xpath("//*[@placeholder='Phone']")).sendKeys("1232432");
	  driver.findElement(By.xpath("//*[@placeholder='Name']")).click();
	  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Name']")));
	  driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("aswqa");
	  driver.findElement(By.xpath("//*[@placeholder='Amount']")).sendKeys("90");
	  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@accessibilityLabel='countryButton']")));
	  driver.findElement(By.xpath("//*[@accessibilityLabel='countryButton']")).click();
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@accessibilityLabel='Greece']")));
	  driver.findElement(By.xpath("//*[@accessibilityLabel='Greece']")).click();
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@accessibilityLabel='cancelButton']")));
	  driver.findElement(By.xpath("//*[@accessibilityLabel='cancelButton']")).click();
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@accessibilityLabel='logoutButton']")));
	  driver.findElement(By.xpath("//*[@accessibilityLabel='logoutButton']")).click();
	 }

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
