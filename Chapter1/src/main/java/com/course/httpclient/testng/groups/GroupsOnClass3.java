package com.course.httpclient.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "TEA")
public class GroupsOnClass3 {
    public void teachear1(){
        System.out.println("GroupsOnClass3中的方法1");
    }
    public void teachear2(){
        System.out.println("GroupsOnClass3中的方法2");
    }
}
