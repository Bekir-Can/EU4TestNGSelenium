package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework_1_TestCase_2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Selenium");
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        WebElement title = driver.findElement(By.xpath( "//title[contains(text(),'Selenium')]" ) );
        System.out.println(title.isEnabled());

        System.out.println("driver.getTitle() = " + driver.getTitle());

        Thread.sleep(3000);
        driver.quit();
    }
}
