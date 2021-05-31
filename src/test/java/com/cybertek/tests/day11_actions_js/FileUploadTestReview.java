package com.cybertek.tests.day11_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTestReview {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.name("file"));
        //chooseFile.sendKeys("C:\\Users\\KONSTANTINUPOLI\\Desktop\\file (2).txt"); ==>Static way
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/Vytracktestdata.xlsx";
        String fullPath = projectPath+"/"+filePath;
        System.out.println(fullPath);
        chooseFile.sendKeys(fullPath);


        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();

        String actualFileName = driver.findElement(By.cssSelector(".panel.text-center")).getText();
        Assert.assertEquals(actualFileName,"Vytracktestdata.xlsx");

    }





}