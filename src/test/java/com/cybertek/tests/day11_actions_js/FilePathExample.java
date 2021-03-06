package com.cybertek.tests.day11_actions_js;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test1(){

        //C:\Users\KONSTANTINUPOLI\IdeaProjects\EU4TestNGSelenium\src\test\resources\textfile.txt

        //How can we get where our project is located dynamically?
        //System.out.println(System.getProperty("os.name");-->to gives our computer operation system, example

        //to gets ->projectPath = C:\Users\KONSTANTINUPOLI\IdeaProjects\EU4TestNGSelenium
        String projectPath = System.getProperty("user.dir"); //to gives our project location folder
        System.out.println("projectPath = " + projectPath);

        String filePath = "/src/test/resources/textfile.txt";//relative project path
        // we add one to the starting which comes after the projectPath in above the  String projectPath

        String fullPath = projectPath+"/"+filePath;
        System.out.println(fullPath); // to give out absolute path

    }
}

