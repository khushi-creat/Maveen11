package org.example;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Digitalstrom
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\SOFT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a[1] ")).click();
        driver.findElement(By.xpath("//div[@class=\"listbox\"]/ul[1]/li[1]/ul[1]/li[1] ")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/div[2]/h2/a")).click();
        driver.findElement(By.xpath("//div[@class=\"overview-buttons\"]/div[3]")).click();
        driver.findElement(By.xpath("//div[@class=\"buttons\"]/input[1]")).click();
        String text = driver.findElement(By.xpath("//div[@class=\"form-fields\"]/div[1]/span[2]/span[1]")).getText();
        System.out.println(text);
        String print = driver.findElement(By.xpath("//div[@class=\"form-fields\"]/div[2]/span[2]/span[1]")).getText();
        System.out.println(print);


    }
}
