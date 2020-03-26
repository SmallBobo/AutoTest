package com.course.testng.multthread;

import org.testng.annotations.Test;

public class MultiThread {
    @Test(invocationCount = 10,threadPoolSize = 4)
    public void multi1(){
        System.out.println(1);
        System.out.printf("Thread ID: %s%n",Thread.currentThread().getId());
    }
}
