package com.cybertek.tests.day10_iframe_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//*[@placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");

        String actualMessage = driver.findElement(By.xpath("//*[.='The date of birth is not valid']")).getText();
        String expectedMessage = "The date of birth is not valid";
        Assert.assertEquals(actualMessage,expectedMessage,"Verify The date of birth is not valid warning is visible");
    }
}
