package com.cybertek.tests.day4_basiclocators;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextandPartialLinkTextLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.manage().window().maximize();

        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        //link1.click();
        WebElement link4 = driver.findElement(By.partialLinkText("again"));// word should be unique in the whole text
        link4.click();
        Thread.sleep(3000);
        //driver.quit();

    }

}
