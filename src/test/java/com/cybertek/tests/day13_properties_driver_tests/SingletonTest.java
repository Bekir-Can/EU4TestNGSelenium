package com.cybertek.tests.day13_properties_driver_tests;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    /*Singleton driver : When we have the ready, selenium methods that we need to pass each time driver */

    //@Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }


    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = Driver.get();
        Thread.sleep(2000);
        driver.get("https://www.google.com");

        Driver.closeDriver();
        /*
        We executed the all test inside this class and worked in one browser.Why? Because singleton, same object,
    until we close of driver, close driver is making our driver = null; inside the closeDriver(); method inside in Driver class,
    which is inside the utilities class.
     *** Until our close our driver, Right now we can not run two different test from two different packages
    but once we can run does not matter, it is gonna be the same.
    */

    }

    @Test
    public void test3(){
        WebDriver driver = Driver.get();

        driver.get("https://www.amazon.com");
    }

}
