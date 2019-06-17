package com.virgingames.resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Archita Patel
 */
public class TestData {

    @DataProvider(name = "inputs")
    public Object [][] getData(){
        return new Object[][]{
                {"username111", "password111"},
                {"username222", "password222"},
                {"username333", "password333"}
        };
    }
}
