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

import java.util.List;

public class HoverOverHomework {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void oneImage() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();

        List<WebElement> hoverOverImages = driver.findElements(By.xpath("//img[@alt='User Avatar']"));

        for (int i = 1; i <=  hoverOverImages.size(); i++) { //  we are trying to locate each of the image one by one with loop dynamically

            Actions action1 = new Actions(driver); // hover over the image
            Thread.sleep(2000);
            action1.moveToElement(hoverOverImages.get(i-1)).perform();


            String textXPath = "//h5[.='name: user"+i+"']";
            WebElement text1 = driver.findElement(By.xpath(textXPath));
            System.out.println(textXPath);
            Assert.assertTrue(text1.isDisplayed(), "verify user "+i+" is displayed");

        }

    }
}