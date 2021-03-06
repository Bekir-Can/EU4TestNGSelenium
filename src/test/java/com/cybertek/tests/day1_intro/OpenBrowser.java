package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {
//        //For First Line
//        * we have to enter this line every time we want to open chrome;
//        mean that hey webdriver, can you make chrome(any browser) ready for me for automation
//        * WebDriverManager is responsible for downloading the driver for different the browser
//        WebDriverManager.chromedriver().setup();// First Line
//
//        //For Second Line
//        * Creating object,we created chromedriver object, LEFT SIDE is WebDriver(Polymorphism),
//        driver comes from ChromeDriver; basically which browser is gonna automate,driver is represent that our browser
//        // we will create object our ChromeDriver
//        //ChromeDriver is coming from selenium(we can see above the import),
//        //WebDriver represent the browser
//        //we are creating driver for chrome browser
//        //new ChromeDriver()-->this part will open chrome browser
//        WebDriver driver = new ChromeDriver();// Second Line
//
//        driver.get("https://cybertekschool.com");//.get(url) method used for navigation to page

        WebDriverManager.firefoxdriver().setup();// this line will allow selenium to automate firefox browser

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.facebook.com");

        driver.close();


    }
}
