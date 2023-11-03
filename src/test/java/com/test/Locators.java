package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators extends Base {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/Register.php");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("kani");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("1234");
//		driver.findElement(By.xpath("//*[@type='password'and@id='re_password']")).sendKeys("1234");
		driver.findElement(By.xpath("(//*[@type='password'])[2]")).sendKeys("1234");
		driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("1234");
		driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("1234");
		
	}

}
