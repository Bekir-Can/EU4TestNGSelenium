package com.cybertek.tests.day11_actions_js;

import org.testng.annotations.Test;

public class FilePathExampleReview {
    @Test
    public void test1(){
        System.out.println( System.getProperty("user.dir"));
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";

        String fullPath = projectPath+"/"+filePath;
        System.out.println(fullPath);

    }

}
