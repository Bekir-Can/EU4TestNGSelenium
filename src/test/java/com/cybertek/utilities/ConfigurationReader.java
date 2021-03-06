package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
//This class has only one reason/job; we gonna provide the key this class one method and it will give us the value
    // these type of class calls single responsibility principle
public class ConfigurationReader {

    private static Properties properties;

    static { //static block  always runs before everything.
                // We wanna load the file first one time then call the method (below the method))

        try {
            // what file to read
            String path = "configuration.properties"; //to use; to find and read
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path); //file reading
            // properties --> class that store properties in key / value format
            properties = new Properties();
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {

        return properties.getProperty(keyName);
    }


}
