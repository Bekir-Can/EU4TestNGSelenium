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
        //driver.manage().window().maximize();//if we dont max the window scroll up and down test does not work!!!!!

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
        typeTextJS.executeScript("arguments[0].setAttribute('value','" + textIn + "')", inputBox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        // driver.manage().window().maximize();//if we dont max the window scroll up and down test does not work!!!!!
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            //  jse.executeScript("window.scrollBy(0,250)");
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }

    @Test
    public void scrollToElementDirectly() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement englishButton = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", englishButton);

    }

}
