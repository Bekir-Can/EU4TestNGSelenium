package com.cybertek.tests.day9_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsReview {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().window().maximize();
        System.out.println("Before driver.getTitle() = " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
           if (!handle.equals(currentWindowHandle)){
               driver.switchTo().window(handle);

           }

        }

        System.out.println("After driver.getTitle() = " + driver.getTitle());

    }
}