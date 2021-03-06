package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        //Task open chrome and navigate to http://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //driver.navigate().to("http://practice.cybertekschool.com");//get=navigation

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium ****.getTitle****-> is important
        // System.out.println(driver.getTitle());//sout/soutv for print the title

        //getting title from browser with selenium ****.getTitle****-> is important
        String title = driver.getTitle();// After to write-> driver.getTitle() then->alt+enter
                                            // => to get variable, short cut

        // to print variable name and value --> soutv+enter-->shortcut
        System.out.println("title = " + title);

        //getting url from browser with selenium
        String currentUrl = driver.getCurrentUrl();// After to write-> driver.getCurrentUrl() then->alt+enter
                                                        // => to get variable, short cut
        System.out.println("currentUrl = " + currentUrl); //soutv+enter-->shortcut

        //getting source code from browser with selenium-->.getPageSource();
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }

}
