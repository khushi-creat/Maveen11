package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Auto10class{
    static WebDriver driver;

    public static void main(String[] args)
    {
      System.setProperty("webdriver.chrome.driver","C:\\SOFT\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      driver.get("https://demo.nopcommerce.com/");
      driver.findElement(By.xpath("//a[@class='ico-register']")).click();
      driver.findElement(By.id("FirstName")).sendKeys("khushbu");
      driver.findElement(By.id("LastName")).sendKeys("patel");
      String pageText = driver.findElement(By.xpath("//div/strong")).getText();
      System.out.println(pageText);
    }
}
