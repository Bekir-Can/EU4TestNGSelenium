package com.cybertek.tests.day7_testing;

import org.testng.annotations.Test;

public class FirstTestNGTest { //When we click the class run button, it runs all tests inside the this class

    @Test //We start always @Test + Enter without space
    public void test1(){ // After to write this method run button come out which is green button on the left.
        // that button is not running with java, not TestNG. It runs different consul

        System.out.println("My First Test Case");

    }

    @Test //
    public void test2(){
        System.out.println("My Second Test Case");

    }

    /*We have two Test Case in the same class
    If we dont want to run the any test case put the comment out sign (//),
    only in front of the @Test (//@Test) */

}

/*After this class When Jamal said create a new Test.We are going to create the below syntax;

    @Test
    public void test1(){
        System.out.println("My First Test Case");
    }

 */