package com.cybertek.tests.day16_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone => we need to locate =>contactInfoPage
     * verify that email is mbrackstone9@example.com => we need to locate =>contactInfoPage
     * verify that phone number is +18982323434 => we need to locate =>contactInfoPage
     */
    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");//First step => give the name of the report then
                                                                                // we gonna go to Log the steps

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username: "+username);//Second step for report Logs
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to --> Customers > Contacts");//Third step
        new DashboardPage().navigateToModule("Customers","Contacts");// if we wanna use one time to navigation
                                                                                // we can use this syntax

        ContactsPage contactsPage = new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com");//fourth step
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        extentLogger.info("Verify full name is "+ expectedFullName);//fourth step
        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");

        extentLogger.info("verify email is mbrackstone9@example.com");//fourth step
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify email");

        extentLogger.info("verify phone number is +18982323434");//fourth step
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");
        /*
        we wrote the our codes until from up to above the Assert syntax without extendLoggers which starts extendLogger,
        after we need to add the report now and we have to create everytime reports which is main part of testing
        because people does not care what we wrote the code they care the report,
         who does not care what we use tools Cucumber,TestNg etc. So We create the report each action as use extentLogger
        */
        extentLogger.pass("PASSED");
        /*
         After everything pass we wrote this syntax, we don't need flash because it is ready in our;
         TestBase class in @AfterTestMethod, if the test gives fail it will take a screenshot
          as use TestBase class in @AfterTestMethod and to add the report.
        *
        * */

    }


}