package com.cybertek.tests.day14_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase { //First automated test our

    /** <<<TASK>>>
     * Before The start TEST;
     * First Read and understand the project
     * Second Manually Test the project if it pass to continue automates test!!!!
     *
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */
    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage(); // We need LoginPage. Because we didn't extends the BasePage to the LoginPage,
                                                // because they dont have common properties each other
                                                // Because we have separate constructor

        loginPage.loginAsDriver();//to do login in => loginPage steps, as use LoginPage Class and loginAsDriver(){} methods

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage(); // we gonna get title

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify subtitle"); // Until here first step

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2);// we need to wait to load the page time otherwise it gave fail

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitle Calendar Events");

    }
}