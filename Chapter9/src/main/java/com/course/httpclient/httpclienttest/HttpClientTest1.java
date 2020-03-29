package com.course.httpclient.httpclienttest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientTest1 {
    @Test
    public void testDemoGet() throws IOException {

        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpClient client = new DefaultHttpClient();
        HttpResponse responses = client.execute(get);
        result = EntityUtils.toString(responses.getEntity());
        System.out.println(result);

    }
}
