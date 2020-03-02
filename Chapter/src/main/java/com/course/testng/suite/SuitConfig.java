package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuitConfig {
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite运行正常");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite运行正常");
    }
}
