package com.course.httpclient.testng;

import org.testng.annotations.Test;

public class ExpectedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void expectedException(){
        System.out.println("异常测试");
        throw new RuntimeException();
    }
}
