package com.cybertek.tests.day9_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {

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
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dropdown");
        // 1. Locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.cssSelector("#state"));
        /*the important thing is; Does our dropdown  select tag or not in html.
         If there is not select tag we cannot use this shape*/


        /*We are creating object from select class Why? The reason is
         * Note: If we don't have any ready selenium methods , we cannot solve our this problems
         *  with the regular WebElement methods,for this there is special selenium class which name is Select ,
         * select class from selenium library
         */

        // 2. We need to select the web element to create Select object passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement); //Parameter could be WebElement

        //getOptions --> return all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();
        
        //we can check how many result we have
        //print size of options
        System.out.println("options.size() = " + options.size());
        //result 52, normaly USA's states 51 + Select a State options!!! -->so; 51+1 = 52 ; in side the dropdown box

        //print option one bye one
        for (WebElement option : options) {
            System.out.println(option.getText());


        }
    }
    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1. Locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.cssSelector("#state"));

        // 2. We need to select the web element to create Select object passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement); //Parameter could be WebElement

        // How to verify that first selection is Selected a state, Which is first the list
        String expectedOptinon = "Select a State"; // it needs to be same data type with below the data type
        //WebElement firstSelectedOption = stateDropdown.getFirstSelectedOption().getText();
        //We chanded the data type  with getText() above the syntax then write down

        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOptinon,"verify first selection");
        //we don't need to ignoreCase or etc. Because it should be case sensetive at the real work environment

        //HOW TO SELECT OPTIONS FROM DROPDOWN LIST?

        // 1. SELECT USING VISIBLE TEXT.
        // There are 3(three) different ways select the options from dropdown.
        // dropDown object->stateDropDown.selectByVisibleText(whatever see on the screen);

        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");//Now virginia first option BECAREFULL!!!!
        expectedOptinon = "Virginia";//Case Sensetive is important!!!!!! otherwise gives FAIL
        actualOption = stateDropdown.getFirstSelectedOption().getText();//first option now virginia
        Assert.assertEquals(actualOption,expectedOptinon,"verify first selection");

        // 2. SELECT USING INDEX
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);
        expectedOptinon = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOptinon,"verify first selection");

        // 3. SELECT USING VALUE
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");
        expectedOptinon = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOptinon,"verify first selection");








    }
}
