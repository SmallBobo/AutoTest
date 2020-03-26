package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的标签，被标记的方法为测试的一部分
    @Test
    public void Case1(){
        System.out.println("@Test标记的测试方法");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("@AfterMethod标记的方法，在@Test标记的测试方法之后执行，有多少测试方法，执行多少次");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("@BforeMethod标记的方法，在每个@Test标记的方法前执行");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("@BeforeClass标记的方法，在每个类开始时执行");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("@AfterClass标记的方法，在每个类结束时运行");
    }
    @BeforeSuite
    public void BeforeSuit(){
        System.out.println("@BeforeSuite测试套件标记的方法，所有测试类开始之前时运行");
    }
    public void AfterSuit(){
        System.out.println("@AfterSuit测试套件标记的方法，在所有的类结束之后运行");
    }
}
