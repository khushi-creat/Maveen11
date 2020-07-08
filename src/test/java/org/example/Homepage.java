package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Homepage
{
    static WebDriver driver;
    public static void waituntilelementsclick(By by,int a)
    {
    WebDriverWait wait = new WebDriverWait(driver, a);
    wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public static void sleep1(int b)
    {
        try
        {
            Thread.sleep(b * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\SOFT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a[1] ")).click();
        driver.findElement(By.xpath("//div[@class=\"listbox\"]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
        String text = driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/h2[1]/a[1]")).getText();
        System.out.println(text);

    }
}
