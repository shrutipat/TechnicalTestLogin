package com.virgingames.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Archita Patel
 */
public class LoadProperty {
    static Properties prop;

    static FileInputStream input;

    public String getProperty(String key) {
        prop = new Properties();
        try {
            input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\virgingames\\resources\\configfiles\\config.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
