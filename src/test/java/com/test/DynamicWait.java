package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWait extends Base  {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//staticWait
		Thread.sleep(3000);
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//WebDriverWait
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		
		//FluentWait
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(0)).ignoring(Throwable.class);
		f.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		
		
		
		WebElement down = driver.findElement(By.xpath("//*[contains(text(),' Back to top')]"));
		WebElement up = driver.findElement(By.xpath("//*[contains(text(),'Sign in for your best experience')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", down);
}
}
