package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {

	static WebDriver driver;

	public static void initDriver() {
		// Open browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
