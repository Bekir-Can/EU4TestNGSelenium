package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework_1TestCase_3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        Thread.sleep(2000);
        searchBox.sendKeys("selenium webdriver");
        Thread.sleep(2000);
//        WebElement searchButton = driver.findElement(By.xpath("//button[@class='pure-button pure-button-primary-progressive']/child::i"));
//        Thread.sleep(2000);
//        searchButton.click();
//
//
//        WebElement link = driver.findElement(By.partialLinkText("Selenium (software)"));
//        link.click();
//
//        String expectedResultUrl ="https://en.wikipedia.org/wiki/Selenium_(software)";
//        String actualUrlResult = "https://en.wikipedia.org/wiki/Selenium_(software)";
//
//        if(expectedResultUrl.equals(actualUrlResult)){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//            System.out.println("expectedUrl = " + expectedResultUrl);//we wrote,if to give fail, we can see the difference
//            System.out.println("actualUrl = " + actualUrlResult);//we wrote,if to give fail, we can see the difference
//        }
//
//
//        Thread.sleep(2000);
//
//        driver.quit();
    }

}
