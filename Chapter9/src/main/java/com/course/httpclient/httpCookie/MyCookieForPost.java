package com.course.httpclient.httpCookie;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class MyCookieForPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    //获取url
    @BeforeTest
    public void Befortest(){
        bundle = ResourceBundle.getBundle("httpclientgetcookie");
        url = bundle.getString("test.url");
        System.out.println(url);
    }
    //获取post请求所需要的cookie信息
    @Test
    public void getCookie() throws IOException {
        //拼接请求路径
        String getCookieUri = this.bundle.getString("test.getcookie.uri");
        String getCookieUrl = this.url+getCookieUri;

        //创建client
        DefaultHttpClient client = new DefaultHttpClient();
        //创建get方法
        HttpGet get = new HttpGet(getCookieUrl);
        //执行get方法
        HttpResponse response = client.execute(get);
        //获取cookie
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie:cookieList){
            String cookieKey = cookie.getName();
            String cookieValue = cookie.getValue();
            System.out.println("cookie's name is "+cookieKey+"; cookie's value is "+cookieValue);
        }
    }
    //携带cookie发送post请求
    @Test(dependsOnMethods = "getCookie")
    public void postMethodWithParam() throws IOException {
        //拼接url
        String postUri = bundle.getString("test.postWithCookie.uri");
        String postUrl = this.url+postUri;
        //创建client
        DefaultHttpClient client = new DefaultHttpClient();
        //client是只cookie
        client.setCookieStore(this.store);
        //创建post
        HttpPost post = new HttpPost(postUrl);
        //post 设置请求头
        //addHeader添加一个新的请求头字段。（一个请求头中允许有重名字段。）
        //setHeader：设置一个请求头字段，有则覆盖，无则添加。
        //post.addHeader("Content-type","application/json");
        post.setHeader("Content-type","application/json");

        //创建post方法，携带参数和头信息
        //创建参数
        JSONObject param = new JSONObject();
        param.put("login","true");
        //创建请求实体
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        //post设置请求实体
        post.setEntity(entity);
        //执行post请求
        HttpResponse response = client.execute(post);
        String postResult = EntityUtils.toString(response.getEntity());
        System.out.println(postResult);
        JSONObject resultJson = new JSONObject(postResult);
        String nameValue = (String) resultJson.get("name");
        System.out.println(nameValue);
        Assert.assertEquals(nameValue,"ZS");


    }
}
