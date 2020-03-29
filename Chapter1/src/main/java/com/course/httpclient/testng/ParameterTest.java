package com.course.httpclient.testng;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterTest {

    @Test
    @Parameters({"name","age"})
    public void paramTest(String name,int age){

        System.out.println("name = "+name+"; age="+age);
        System.out.printf("paramTest方法的ThreadID：%s%n",Thread.currentThread().getId());
    }
}
