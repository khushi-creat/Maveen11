package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.soap.Text;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public class Register_time
{
    static WebDriver driver;  //created object
    //waiting method for elementclick
    public static void waituntilelementclick(By by, int a){
        WebDriverWait wait = new WebDriverWait(driver,a);  //create  object
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    //calling method for sleep
    public static void sleep1(int b)
    {
        try
        {
            Thread.sleep(b * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    // calling mathod to click on element
    public static void clickonelement(By by)
    {
        driver.findElement(by).click();
    }
    //calling method for text element
    public static String getTextformElement (By by)
    {
        return driver.findElement(by).getText();
    }
    //calling method for timestamp
    public static long timestamp()
    {

        return (System.currentTimeMillis());
    }
    //calling method for type text
    public static void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys();
    }
    // calling method for sendkey element
    public  static void sendkeyelement(By by, String data)
    {
        driver.findElement(by).sendKeys(data);
    }
    // calling method for invisible text
    public static void selectfromDropByVisibleText(By by, String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    //calling method for visiblevalue
    public static void selectfromDropByVisiblevalue(By by, String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    //calling method for visibleindex
    public static void selectfromDropByVisibleIndex(By by, int index)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
   // @AfterMethod
   // public static void  closepogrrame()
   // {
    //   driver.close();
   // }

    @BeforeMethod
    public static void chromehomepage()
    {
        // setting up chromedriver path
     System.setProperty("webdriver.chrome.driver","C:\\SOFT\\chromedriver.exe");
     // creating chormedriver object
     driver = new ChromeDriver();
     //maximizing screen
     driver.manage().window().maximize();
     //applying implicity waite
     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     //open the url
     driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public static void login()
    {
        //click on element for ragister page
        clickonelement(By.xpath("//a[@class=\"ico-register\"]"));
        //eplicity waite for element
        waituntilelementclick(By.xpath("//input[@id=\"gender-male\"]"),40);
        //selectthe gender
        clickonelement(By.xpath("//input[@id=\"gender-male\"]"));
        sleep1(3);
        //text first name
        sendkeyelement(By.xpath("id(\"FirstName\")"),"Khushi");
        //text last name
        sendkeyelement(By.xpath("//input[@name=\"LastName\"]"),"Patel");
        //type the birth date
        selectfromDropByVisibleIndex(By.xpath("//select[@name=\"DateOfBirthDay\"]"),9);
        //type the birth month
        selectfromDropByVisibleText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"July");
        //type the birth year
        selectfromDropByVisiblevalue(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1988");
        //type email id
        sendkeyelement(By.xpath(" //input[@id=\"Email\"]"), "test+"+timestamp()+"@gmail.com");
        //type company name
        sendkeyelement(By.xpath(" //input[@id=\"Company\"]"), "abcd ltd");
        //click on check box
        clickonelement(By.xpath("//input[@type=\"checkbox\"]"));
        //type the password
        sendkeyelement(By.xpath("//input[@id=\"Password\"]"), "password");
        //type the confirm password
        sendkeyelement(By.xpath(" //input[@id=\"ConfirmPassword\"]"),"password");
        //click on register button
        clickonelement(By.xpath(" //input[@id=\"register-button\"]"));
        //expected stetment
        String expectedText = "Your registration completed";
        //achualtext
        String achualText = getTextformElement(By.xpath("//div[@class=\"page-body\"]/div[1]"));
        //result in assert
        Assert.assertEquals(achualText,expectedText);
    }
    @Test
    public static void computer()
    {
        //click on computer
        clickonelement(By.xpath("//div[@class=\"header-menu\" ]/ul[1]/li[1]/a"));
        //click on deshtop
        waituntilelementclick(By.xpath("//ul[@class=\"sublist\"]/li[1]/a"), 40);
       // click on build your on computer
        waituntilelementclick(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/h2/a"),40);
       // click on email a friend
        waituntilelementclick(By.xpath("//input[@value=\"Email a friend\"]"),40);
       // enter friend email
        sendkeyelement(By.xpath("//input[@class=\"friend-email\"]"),"patel_khushi2@yahoo.co.in");
        //enter user email
        sendkeyelement(By.xpath("//input[@class=\"your-email\"]"),"tashvi2008@gmail.com");
        //typ persnol massage
        sendkeyelement(By.xpath("//textarea[@id=\"PersonalMessage\"]"), "Have a look this product hope you like it");
        //click on send email button
        clickonelement(By.xpath("//input[@value=\"Send email\"]"));
        //expected statment
        String expectedText = "Your message has been sent.";
        //achual statment
        String achualText = getTextformElement(By.xpath("//div[@class=\"page-body\"]/div[2]"));
        //result in assert
        Assert.assertEquals(achualText,expectedText);
    }
    @Test
    public static void electronic()
    {
        //click on electronics element
        clickonelement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[2]"));
        //sleep thread method for element waite
        sleep1(4);
        //click on cell phones element
        clickonelement(By.xpath("//div[@class=\"listbox\"]/ul[1]/li[2]/ul[1]/li[2]/a"));
        //click on  HTC One M8 Android L 5.0 Lollipop & add in cart
        clickonelement(By.xpath("//input[contains(@onclick,\"/18/1/1\")]"));
        //click on HTC One Mini Blue & add in cart
        clickonelement(By.xpath("//input[contains(@onclick,\"19/1/1\")]"));
        //expected result
        String expectedText = "HTC One M8 Android L 5.0 Lollipop";
        //sleep thread method for element wait
        sleep1(5);
        //achual result
        String achualText = getTextformElement(By.xpath("//div[@class=\"table-wrapper\"]/table /tbody/tr[1]/td[4]/a"));
        //expected result
        String requiredText = "HTC One Mini Blue";
        //achual result
        String resultText = getTextformElement(By.xpath("//div[@class=\"table-wrapper\"]/table/tbody/tr[2]/td[4]/a"));
        //result in assert
        Assert.assertEquals(achualText,expectedText);

    }
}
