package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //navigate to another website with different selenium method
       driver.navigate().to("http://www.facebook.com");

       //to wait while passing the each page below syntax, which means is wait 3 second here then move on
       Thread.sleep(3000);// when I wrote first time, sleep has red line then,=> go on read below the text,
        // I did hover over the sleep  (Add exception to method signature) clicked red line disappear
        // and main method' added (throws InterruptedException)


       //goes back to previous page
       driver.navigate().back();

        Thread.sleep(2000);

        //goes forward to previous page
        driver.navigate().forward();


        //refresh to web page
        driver.navigate().refresh();




    }

}
