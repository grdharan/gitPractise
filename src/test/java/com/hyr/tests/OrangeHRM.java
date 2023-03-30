package com.hyr.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
@Test
public void alaunchapp() throws Exception {
	ChromeOptions co = new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(co);
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(10000);
}
@Test
public void bEnterLoginDetails() throws InterruptedException{
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	Thread.sleep(10000);
}
@Test
public void cNavigateToMyInfo() throws Exception {
	driver.findElement(By.xpath("//span[text()='My Info']")).click();
	Thread.sleep(10000);
}
@Test
public void dVerifyMyInfo() throws Exception {
System.out.println(driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-name']")).isDisplayed());
Thread.sleep(5000);
driver.quit();
}
@Test
public void eVerifyLogin() throws Exception  {
	WebElement element = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
	System.out.println(element.isDisplayed());
	System.out.println(element.getText());
	Thread.sleep(5000);
	driver.quit();
}
}