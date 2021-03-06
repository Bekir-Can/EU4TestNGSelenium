package com.cybertek.tests.day12_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
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
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());// we got all table1' inside the text,as a full table with tableTag

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com")); // we checked the inside the table

    }

    @Test
    public void getAllHeaders(){

        // how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Header size:" + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }
    @Test
    public void printTableSize(){
        // how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Header size:" + headers.size()); //column size

        //number of rows

        List<WebElement> allRowWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowWithHeader.size() = " + allRowWithHeader.size());//row size, include header

        //number of rows without header ( we prefer this way then above the way)
        List<WebElement> allRowWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowWithoutHeader.size() = " + allRowWithoutHeader.size()); //row size, exclude header
    }

    @Test
    public void getRow(){
        //print the second row information

        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        //as a change the index number we can get the other row list
        // for single element==>>.findelement(), no ==> .findelements() ==> this is to find plural elements
        //System.out.println("row2.getText() = " + row2.getText());

        //get all rows dynamically
        // 1.find number of rows
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));

        // 2.iterate one bye one
        for (int i = 1; i <= numRows.size(); i++) {

            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));// String concatination
            System.out.println( i+"-" + row.getText());

        }
//        for (WebElement numRow : numRows) {  // this ==> for each loop doesn't prefer to use for locator manipulation
//                                                  and printing the rows in this type example
//
//            System.out.println(numRow.getText());

       // }
    }
    @Test
    public void getAllCellInOneRow(){

        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[1]/td"));
        //as a change the index number we can find the other rows with for each loop

        // loop shortcuts iter+enter and itar+enter
        for (WebElement webElement : allCellsInOneRow) {
            System.out.println(webElement.getText());

        }


    }
    @Test
    public void getAsingleCellByIndex(){
       WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("Single cell " + cell.getText());

        WebElement cell1 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
        System.out.println("cell1.getText() = " + cell1.getText());


    }

    @Test
    public void printAllCellsByIndex() {

        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumns();

        System.out.println("columnNumber = " + columnNumber);
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {

            //iterate through each cell in the row
            for (int j = 1; j < columnNumber; j++) {

                String cellXpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());

            }


        }
    }

    @Test
    public void getCellInRelationToAnotherCellInRow(){

        String firstName = "Jason";
        String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }

    private int getNumberOfColumns() {

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberOfRows() {

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        return allRowsWithoutHeader.size();
    }


}

