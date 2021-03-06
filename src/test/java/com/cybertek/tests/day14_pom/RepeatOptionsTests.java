package com.cybertek.tests.day14_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*
     * We dont need to extends BasePage to the RepeatOptionsTests class. It is not POM(page object module) class.
     * This is class that we will create our test case
    * */

    /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat (check box)
    Verify that repeat every days is checked (Radio Button)
    verify that repeat weekday is not checked (Radio Button)
    * */


    @Test
    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
//       calendarEventsPage.waitUntilLoaderScreenDisappear();
//       BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        Thread.sleep(5000);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked. It should be selected .assertTrue => it returns TRUE
        //How we work/verify/something check or not with radio button? => .isSelected
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify repeat days is selected");
        //verify that repeat weekday is not checked. It should not be selected .assertFalse => it returns FALSE
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify weekday is not selected");

    }

      /* <<<TASK>>>
     VERIFY REPEAT OPTIONS
        Open Chrome browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */

    @Test
    public void test2() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
//        calendarEventsPage.waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        Thread.sleep(5000);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();

        //How can we implement the Select to the POM, we can not use DropDown as a web element.
        // So we need to create select object with repeat DropDown web element
        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();//we checks first select tag is there or not as inspect
                                                                        //if there is that is select DropDown for review day8 classs


        // Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        // In order to keep our expect options(result)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly"); // We create have one list of String added options

        List<String> actualList = new ArrayList<>(); //we create empty list,
        // we can not compare list of web element which is below and list of String so we created empty list of Array




        // We need to get the options, we get all the possible options with=> getOptions method
        List<WebElement> actualOptions = repeatsDropdown.getOptions();

        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());
        }

        /* This list getting text list of web element something we do always as a tester.
         Whenever we gettext web element we dont click them most of the tim, we do this in order the verify them
         If we are repeating something always we need to provide gettext element we need a create method
         */

        //ready method for getting text of list of web elements
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions); // in one line we need this for converting

        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        Assert.assertEquals(actualList,expectedList,"Verify Daily weekly monthly yearly");

    }
}