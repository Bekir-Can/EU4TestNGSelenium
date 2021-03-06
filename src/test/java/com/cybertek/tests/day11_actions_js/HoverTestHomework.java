package com.cybertek.tests.day11_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTestHomework {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /* hover over each image in the web side verify
     * verify each name: user text is displayed
     * we should not located three image it will universal(loop if use  maybe) dynamically locate and dynamically
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();

        WebElement img1 = driver.findElement(By.xpath("//div[@class='figure']/child::img"));

        Actions action1 = new Actions(driver);

        Thread.sleep(2000);
        action1.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text1.isDisplayed(), "verify text 1 is displayed");
        //Assert.assertEquals(text1.isDisplayed(),true); //the other way to verify
        // We have to verify something everytime while we were testing software***


        }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();

        for (int i = 1; i <= 3; i++) { //  we are trying to locate each of the image one by one with loop dynamically

            String xPathImg = "(//img)["+i+"]"; // here is important ***.we can manipulate dynamic xpath
            WebElement img1 = driver.findElement(By.xpath(xPathImg));
            System.out.println(xPathImg);

            Actions action1 = new Actions(driver); // hover over the image
            Thread.sleep(2000);
            action1.moveToElement(img1).perform();


            String textXPath = "//h5[.='name: user"+i+"']";
            WebElement text1 = driver.findElement(By.xpath(textXPath));
            System.out.println(textXPath);
            Assert.assertTrue(text1.isDisplayed(), "verify user "+i+" is displayed");


        }


    }

    }

