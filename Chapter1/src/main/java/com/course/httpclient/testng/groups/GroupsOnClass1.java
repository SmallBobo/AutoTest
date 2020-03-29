package com.course.httpclient.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("GroupsOnClass1的stu1方法");
    }
    public void stu2(){
        System.out.println("GroupsOnClass1的stu2方法");
    }
}
