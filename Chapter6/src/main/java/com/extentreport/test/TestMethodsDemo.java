package com.extentreport.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {

    //断言
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals(1,2);

    }

    //日志
    @Test
    public void test2(){
        Reporter.log("这是人为添加的日志信息1111111111");
        throw new RuntimeException();
    }
}
