package com.cybertek.tests.day10_iframe_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit;

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().window().maximize();

        WebElement okButton = driver.findElement(By.xpath("//div[@id='mceu_34']/button"));
        okButton.click();

        // HOW TO SWITCH FRAMES
        // 1.Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        // to clear before sendkeys
        driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Mike Smith with USING ID OR NAME ATT.");

        // IN ORDER TO THE NEXT ACTION WE HAVE TO SWITCH BACK
        // goes back to first frame(main html
        // goes back to first frame, useful when wee have switched multiple frames
        driver.switchTo().defaultContent(); //--> THIS IS ONE OF WAY OF SWITCHING



        // 2. Switching with index , is starts number of 0
        driver.switchTo().frame(0); // we have only one ifamre in bigger html due to index number is 0
        Thread.sleep(2000);




        // to clear before sendkeys
        driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Mike Smith with INDEX");

        //second way to swicth parent
        driver.switchTo().parentFrame();

        // 3 . Using web element for switching
        // locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Mike Smith with WEB ELEMENT");


    }

    @Test
    public void test2 (){

        driver.get("http://practice.cybertekschool.com/nested_frames"); // we have 6 html in this page
        driver.manage().window().maximize();

        // switching to frame middle top
        driver.switchTo().frame("frame-top");

        //Top has 3 frame under left middle and right
        // Switch to frame middle
        driver.switchTo().frame("frame-middle");


        System.out.println(driver.findElement(By.id("content")).getText());


         // goes back to top frame
        driver.switchTo().parentFrame();

        // switching right with index
        driver.switchTo().frame(2);

        System.out.println( driver.findElement(By.tagName("body")).getText());

        //go to main html to switch botton
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());

    }



}

