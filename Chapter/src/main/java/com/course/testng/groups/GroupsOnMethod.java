package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("服务端方法1");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("服务端方法2");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("客户端方法3");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("客户端方法4");
    }
    @BeforeGroups("server")
    public void beforeGroupsServer(){
        System.out.println("BeforeGroups服务端测试分组前执行");
    }
    @AfterGroups("server")
    public void afterGropsServer(){
        System.out.println("AfterGroups服务端测试分组之后执行");
    }
    @BeforeGroups("client")
    public void beforeGroupsClient(){
        System.out.println("BeforeGroups客户端测试分组前执行");
    }
    @AfterGroups("client")
    public void afterGropsClient(){
        System.out.println("AfterGroups客户端测试分组之后执行");
    }
}
