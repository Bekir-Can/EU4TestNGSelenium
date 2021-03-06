package com.cybertek.tests.day9_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();

    }
    @Test
    public void test1(){
    driver.get("http://practice.cybertekschool.com/windows");
    driver.manage().window().maximize();

        // get title -->getTitle
        System.out.println("Title before new window: " + driver.getTitle());

        driver.findElement(By.partialLinkText("Click Here")).click();

        System.out.println("Title before new window: " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle(); // keeps unique code the window, gets ID of window

        Set<String> windowHandles = driver.getWindowHandles(); // We have ready all windows inside the Set
        /* Set is kind of list ;
         Set doesn't keep duplicate values, it removes duplicate values, only keep unique values
         Set doesn't keep the order so we cannot use index, we cannot say first set of String is button 1, button 2 etc.
         We cannot navigate with index
         */

        for (String windowHandle : windowHandles) {

            if(!windowHandle.equals(currentWindowHandle)){

               driver.switchTo().window(windowHandle);


            }

        }
        System.out.println("Title after switch new window: " + driver.getTitle());
    }

        // If we have more than two windows!!!!!!
        @Test
    public void moreThan2Window(){

            driver.get("http://practice.cybertekschool.com/windows");
            driver.manage().window().maximize();

            driver.findElement(By.partialLinkText("Click Here")).click();

            System.out.println("Before Switch: " + driver.getTitle());

            Set<String> windowHandles = driver.getWindowHandles();

            //loop through each window
            for (String handle : windowHandles) {
                // one bye one change it
                driver.switchTo().window(handle);// the window changes here and compare our window

                // whenever your title equals to your expected window title
               if (driver.getTitle().equals("New Window")){ // We determined the windows ourself and locate,
                                                            // we are gonna to decide which window we want to switch
                                                            // to use TITLE OF WINDOW <Title> in html
                // stop on that window
                break;

               }

            }

            System.out.println("After Switch: " + driver.getTitle());
        }
}










