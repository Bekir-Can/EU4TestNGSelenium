package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkCheckBox {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();

    }

    @Test
    public void testCase1() throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Assert.assertFalse(driver.findElement(By.cssSelector("#txtAge")).isDisplayed());
        driver.findElement(By.cssSelector("#isAgeSelected")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#txtAge")).isDisplayed());


    }

    @Test
    public void testCase2() throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        String actual = checkAllButton.getAttribute("value");
        String expected = "Check All";
        Assert.assertEquals(actual, expected, "Verify “Check All” button text is “Check All”");
        checkAllButton.click();

        List<WebElement> checkAllBoxElements = driver.findElements(By.cssSelector(".cb1-element"));
        for (WebElement checkAllBoxElement : checkAllBoxElements) {

            Assert.assertTrue(checkAllBoxElement.isSelected(), "Verify all check boxes are checked");

        }
        WebElement uncheckAllButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        String actual2 = checkAllButton.getAttribute("value");
        String expected2 = "Uncheck All";
        Assert.assertEquals(actual2, expected2, "Verify button text changed to “Uncheck All”");
    }
}