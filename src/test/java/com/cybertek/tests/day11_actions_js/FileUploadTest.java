package com.cybertek.tests.day11_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //sending file with sendKeys method
        chooseFile.sendKeys("C:\\Users\\KONSTANTINUPOLI\\Desktop\\file.txt"); /* ->the file address for windows operator
                                    OR
       chooseFile.sendKeys("C:/Users/KONSTANTINUPOLI/Desktop/file.txt"); ->  the file address for windows operator;
       but above -> to determine/write the file address is useless in real work environment
       because we will push codes the other team so they cant use the our file
       due to our address. it should be universal/ dynamic to use the others. SO, we should create or save inside the intellij
       **** we create the file on the left side to package side ->follow the below way->>>>
       test(over the green java file)> hover over >right click>new> Directory>resources>hover over resources>right click>new>file
       or past the file into resources file as a (right click-> Copy"file.text)
       then give the name and enter ********
                  */

        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();

        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"file.txt");

    }

    @Test
    public void test2(){

        // REAL WORK ENVIRONMENT LOCATE TO THE FILE TEXT; SOMEBODY TAKE OUR CODE THEIR COMPUTER AND CODE SHOULD THE WORK THEM TOO
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));

        //sending file with sendKeys method
        //how can we get where our procet is located dynamic-> System.getProperty() method
        String projectPath = System.getProperty("user.dir");// our project location DYNAMICALLY
        String filePath = "src/test/resources/textfile.txt"; // our file path, RESOURCES AND TEXT FILE ,
        // it must be same all of us, everything(text file etc.) should be under our project to starts the other computer,
        // our projects should be independence from our computer to able to use all platform
        String fullPath = projectPath+"/"+filePath; // we added the  the filePath + projectPath to the fullPath
        chooseFile.sendKeys(fullPath); // we send the full path

        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();

        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"textfile.txt");

    }

}