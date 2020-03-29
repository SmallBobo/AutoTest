package com.course.httpclient.testng.multthread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
    @Test
    public void test1(){
        System.out.printf("%ntest1方法的Thread ID：%s%n",Thread.currentThread().getId());
    }

    @Test
    public void tes2(){
        System.out.printf("%ntest2方法的Thread ID：%s%n",Thread.currentThread().getId());
    }
}
