package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Add_to_cart
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\SOFT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[2]")).click();;
       driver.findElement(By.xpath("//ul[@class=\"list\"]/li[2]/ul[1]/li[2]/a")).click();
       driver.findElement(By.xpath("//input[contains(@onclick,\"/18/1/1\")]")).click();;
       String text = driver.findElement(By.xpath("//div[@class=\"table-wrapper\"]/table /tbody/tr[1]/td[4]/a")).getText();
       System.out.println(text);
        driver.findElement(By.xpath("//input[contains(@onclick,\"19/1/1\")]")).click();;
        String print = driver.findElement(By.xpath("//div[@class=\"table-wrapper\"]/table/tbody/tr[2]/td[4]/a")).getText();
      System.out.println(print);
    }
}
