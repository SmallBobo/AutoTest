package com.course.testng;

import org.testng.annotations.Test;

public class DependensTest {
    @Test
    public void test1(){
        System.out.println("测试方法1位被依赖的测试");
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("测试方法2需要依赖方法1的执行");
    }
}
