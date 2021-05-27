package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework_1_TestCase_1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("iphone");
        Thread.sleep(3000);
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/child::span"));
        String resultText = result.getText();
        System.out.println("resultText = " + resultText);


        Thread.sleep(3000);
        driver.quit();

    }
}
