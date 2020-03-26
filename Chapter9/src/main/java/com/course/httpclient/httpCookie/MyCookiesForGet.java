package com.course.httpCookie;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;

    //测试前读取配置文件中的url等信息
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("httpclientgetcookie", Locale.CHINA);
        url = bundle.getString("test.url");
        System.out.println(url);
    }

    @Test
    public void testGetCookie() throws IOException {
        String resault;
        String uri = bundle.getString("test.httpcookie.uri");
        String testurl = this.url+uri;
        System.out.println(testurl);
        HttpGet get = new HttpGet("testurl");
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        resault = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(resault);
}
}
