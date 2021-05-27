package com.cybertek.tests.day10_iframe_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//*[@placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");

        String actualMessage = driver.findElement(By.xpath("//*[.='The date of birth is not valid']")).getText();
        String expectedMessage = "The date of birth is not valid";
        Assert.assertEquals(actualMessage, expectedMessage, "Verify The date of birth is not valid warning is visible");
    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        List<WebElement> elements = driver.findElements(By.cssSelector(".form-check-label"));
        System.out.println("elements.size() = " + elements.size());

        ArrayList<String> expected = new ArrayList<>();
        expected.add("C++");
        expected.add("Java");
        expected.add("JavaScript");

        for (int i = 0; i < expected.size() - 1; i++) {

            Assert.assertEquals(elements.get(i).getText(), expected.get(i), "Verify is visible check box");

        }

    }

    @Test
    public void test3() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("B");

        System.out.println("Warning message test is = "
                + driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[1]")).getText());

       String actualText = driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[1]")).getText();
        String expectedText = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualText, expectedText, "Warning Message is not verify ");
    }


}
