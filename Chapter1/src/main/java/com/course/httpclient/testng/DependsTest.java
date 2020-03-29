package com.course.httpclient.testng;

import org.testng.annotations.Test;

public class DependsTest {
    @Test
    public void test1(){
        System.out.println("test1");
        throw new RuntimeException();
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test(dependsOnMethods = {"test1","test2"})
    public void test3(){
        System.out.println("test3");
    }
}
