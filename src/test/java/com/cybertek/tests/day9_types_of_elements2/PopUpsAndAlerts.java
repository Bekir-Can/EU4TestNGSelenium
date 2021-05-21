package com.cybertek.tests.day9_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpsAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() {

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click the Destroy the World
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        //click NO button
        driver.findElement(By.xpath("//span[.='No']")).click();

    }

    @Test
    public void test2() throws InterruptedException {

        // Below the codes only works JAVA SCRIPT ALERTS!!!!!!
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        // click CLICK For JS Alert Button
        //driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click(); // to find the other way
        driver.findElement(By.xpath("//button[1]")).click();

        // switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        // click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss(); // we click cancel with dismiss

        // click for JS Promt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("MikeSmith");

        alert.accept();

    }

}
















