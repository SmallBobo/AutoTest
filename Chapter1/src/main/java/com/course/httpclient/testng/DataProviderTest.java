package com.course.httpclient.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "dataProviderTest1")
    public void dataProTest(String name,int age,int hight){
        System.out.println("dataprovider方法name="+name+";age = "+age+";hight = "+hight);

    }

    @DataProvider(name = "dataProviderTest1")
    public Object[][] providerData(){
        Object[][] o=new Object[][]{
                {"ZhangSan",10,20},
                {"LiSi",20,30}
        };
        return o;
    }

    //根据函数名不同进行传参
    @Test(dataProvider = "provider1")
    public void test1(String name,int age){
        System.out.println("test1的name"+name+";age"+age);
    }
    @Test(dataProvider = "provider1")
    public void test2(String name,int age){
        System.out.println("test2的name="+name+";age="+age);
    }

    @DataProvider(name = "provider1")
    public Object[][] dataProvider(Method method){
        Object[][] result = null;
        if(method.getName().equals("test1")) {
            result = new Object[][]{
                    {"Wangermazi", 30},
                    {"XiaoTaoQi", 44}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                        {"LiBai",2000},
                        {"DuFu",3000}
            };
        }
        return result;

    }
}
