package com.cybertek.tests.day11_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSEReview {

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
    public void clickWithJS() {

        driver.get("http://practice.cybertekschool.com/");
        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));
        // dropDownLink.click();//sometime click does not work so we use javascript code like below the code
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", dropDownLink);

    }

    @Test
    public void typeWithJS() {

        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor typeTextJS = (JavascriptExecutor) driver;
        String textIn = "Hello Disable Input";
        typeTextJS.executeScript("arguments[0].setAttribute('valeu','"+textIn+"')",inputBox);

    }
}