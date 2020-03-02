package com.course.testng;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.testng.annotations.Test;

public class ExpectedException {
    //根据自己的输入断定系统会抛出异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeException(){
        //System的语句要放在throw异常之前，之后的语句不会被执行，反而会报错
        System.out.println("这是与其系统抛异常的测试");
        throw new RuntimeException();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void nullPointerException(){
        System.out.println("这是NotFound异常测试");
        throw new NullPointerException();
    }
}
