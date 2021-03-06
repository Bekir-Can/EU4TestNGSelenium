package com.cybertek.tests.day7_testing;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");

    }
    @Test
    public void test1(){


        System.out.println("First Assertion");
        Assert.assertEquals("title","tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");


    }

    @Test
    public void test2(){
        Assert.assertEquals("test2","test22","verify test2");
    }

    @Test
    public void test3(){
        String expectedTitle ="Cyb";
        String actualTitle = "Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with Cyb");
        // we can see the above the message, if test gives only fail and it is not fix, if we write it

    }

    @Test
    public void test4(){
        //Test case : verify email contains @ sign
        String email = "mikesmith.com";

        Assert.assertTrue(email.contains("@"),"verify email contains @");

    }

    @Test
    public void test5(){
        // We want to make sure something is FALSE, just like something is not selected or existed or not clickable
        //Basically kind of negative test, in those cases we want to very fy something returning FALSE or not. For this
        // We use  .assertFalse

        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");// it gives pass the test

    }


    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    } //Be carefull-> will not be equal



    @AfterMethod
    public void tearDown(){
        System.out.println("Close browser");
    }


}













