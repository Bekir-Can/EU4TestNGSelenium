package com.cybertek.tests.day13_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

        String browserType = ConfigurationReader.get("browser");
        /*
        *********
          Jamal do this as a example;
          open the day5->AmazonTest-> inside package change browser like below;
          WebDriver driver = WebDriverFactory.getDriver("chrome"); <<AmazonTest class browser then>>
          put the ConfigurationReader.get("browser") inside the .getDriver()-->look the below example
          WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"); from now on
          we will change only switch the key of browser which is inside the configuration.properties file
          like; firefox , chrome which need the browser.We can not do this implement to the before classes
          which are we created until day12. Because they didn't configured, they should be updated.
          After today we can do
        **********
          browser is key name from ConfigurationReader class***
          ConfigurationReader.get("browser") will return everything as a String we provide the key,
          it will get the value
         */
        System.out.println("browserType = " + browserType);// we dont specify here anything like firefox,chrome etc.

        String url = ConfigurationReader.get("url");

        System.out.println("url = " + url); //same things (above the explain about the browser) acceptable/valid for url
        /*
        we can not do this implement to the before classes which are we created until day12.
        Because they didn't configured, they should be updated
        */

    }

    @Test
    public void OpenBrowserWithConf(){

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.ENTER);
        // with +keys.ENTER, we simulate the keyword
      //  driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.TAB);

    }


}