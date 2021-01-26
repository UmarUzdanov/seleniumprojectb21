package com.cybertek.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Intro {

    @BeforeClass
    public void setupMethod(){
        System.out.println("Before method is running...");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running...");
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("Before class running...`");
        }
    @AfterClass
    public void teardownClass() {
        System.out.println("After class running...");
    }
        @Test
    public void test1(){
        System.out.println("Running test 1...");
    }

    @Test
    public void test2(){
        System.out.println("running test 2...");
    }
    @Test
    public void test3(){
        String str1 = "hello";
        String str2 = "hello";


        Assert.assertTrue(str1.equals(str2));

        Assert.assertEquals(str1, str2, "Asserting with assertEquals on line 56");
    }
}
