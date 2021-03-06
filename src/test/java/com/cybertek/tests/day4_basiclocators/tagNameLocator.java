package com.cybertek.tests.day4_basiclocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize the window
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        //sendkeys to fullname
        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith With TagName");

        /*
       we cannot use index when we use tagName locator. If there are multiple usage of same tag, we cannot point the second one.
       WebElement emailInput = driver.findElement(By.tagName("input")); --> like ***input***
       emailInput.sendKeys("mikesmith@gmail.com With TagName");
       */

        //sendkeys to email
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("abc@gmail.com");
        emailInput.click();

        //lazy way(shortway) to click button
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

          //  driver.quit();
    }
}
