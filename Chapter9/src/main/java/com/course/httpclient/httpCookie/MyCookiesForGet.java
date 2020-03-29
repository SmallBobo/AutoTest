package com.course.httpclient.httpCookie;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("httpclientgetcookie");
        url = bundle.getString("test.url");
        System.out.println(url);
    }
    @Test
    public void testGetCookie() throws IOException {
        String resault;
        String uri = bundle.getString("test.getcookie.uri");
        String testurl = this.url+uri;
        System.out.println(testurl);
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        resault = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(resault);

        //获取cookie
        this.store = client.getCookieStore();
        List<Cookie> cookieList= store.getCookies();
        System.out.println(cookieList);
        for(Cookie cookie:cookieList){
            String cookieKey= cookie.getName();
            String cookieValue = cookie.getValue();
            System.out.println("cookie's name is "+cookieKey+"; cookie's value is "+cookieValue);
        }
    }

    //使用获取到的cookie进行访问
    @Test(dependsOnMethods = {"testGetCookie"})
    public void getWithCookie() throws IOException {
        String withCookieUri = this.bundle.getString("test.withcookie.uri");
        String testWithUrl = this.url+withCookieUri;
        System.out.println(testWithUrl);
        HttpGet get = new HttpGet(testWithUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
    }

}
