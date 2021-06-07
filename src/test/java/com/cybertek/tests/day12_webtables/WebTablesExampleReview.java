package com.cybertek.tests.day12_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExampleReview {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();

    }

    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("table.getText() = " + table.getText());
        Assert.assertTrue((table.getText().contains("jsmith@gmail.com")));


    }

    @Test
    public void getAlHeaders() {

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText());

        }

    }

    @Test
    public void getTableSize() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("rowsSize.size() = " + rows.size());

        for (WebElement webElement : rows) {

            System.out.println("webElement.getText() = " + webElement.getText());

        }

    }

    @Test
    public void getRow() {

//        List<WebElement> row2 = driver.findElements(By.xpath("(//table[@id='table1']//tbody/tr)[2]/td"));
//
//        for (WebElement webElement : row2) {
//
//            System.out.println("webElement.getText() = " + webElement.getText());
//
//        }
        List<WebElement> row3 = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println("row3.size() = " + row3.size());

        for (int i = 0; i < row3.size(); i++) {
            //  WebElement row = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+i+"]"));
            // System.out.println(i+"-" + row.getText());

            System.out.println("row3.get(i-1).getText() = " + row3.get(i).getText());
        }
    }

    @Test
    public void getAlCellOneRow() {

        List<WebElement> numRow = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println("numRow.size() = " + numRow.size());

        for (int i = 1; i <= numRow.size(); i++) {

            String locateCell = "//table[@id='table1']//tbody/tr[" + i + "]/td";
            List<WebElement> getAllCell = driver.findElements(By.xpath(locateCell));


            for (WebElement webElement : getAllCell) {
                System.out.println("webElement.getText() = " + webElement.getText());

            }

        }
    }

    @Test
    public void getAsingleCellOneRow() {
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[3]/td[5]"));
        System.out.println("singleCell.getText() = " + singleCell.getText());

    }

    @Test
    public void oneByOneCellget() {

        String firstName = "Jason";
        String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        String xpath2 = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";//for pratic

        List<WebElement> numRow = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println("numRow.size() = " + numRow.size());


        for (int i = 1; i <= numRow.size(); i++) {

            for (int j = 1; j <= 6; j++) {

                WebElement element = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[" + j + "]"));
                System.out.println("element.getText() = " + element.getText());

            }


        }

    }


}



