package cn.icrn.spider;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: yankang
 * Date: 2017/9/9
 */
public class DownLoader {

    private static final Map<String, String> map = new HashMap();

    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    static {
        map.put("a", "4dbb0181-84e2-41bd-acb5-f8b06599c8c7");
        map.put("clientVersion", "3.6.1");
        map.put("clientType", "ios");
        map.put("token", "f09f1606d8124f08b75b09e2400092a3");
    }

    public static String downloadPost(String url, String parm,Integer level){
        HttpResponse httpResponse = null;
        String res = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        for  (String key : map.keySet()){
            post.setHeader(key, map.get(key));
        }
        if(level == 3){
            post.setHeader("authentication", "RRTV f09f1606d8124f08b75b09e2400092a3:CMDeBj:JBosVj:twmkRQmWq6_CR4DLdu1vCX");
        }
        post.setEntity(getEntity(parm, CONTENT_TYPE));
        try {
            httpResponse = client.execute(post);
            res = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String downloadGet(String url, String parm){
        HttpResponse httpResponse = null;
        String res = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url+"?"+parm);
        for  (String key : map.keySet()){
            get.setHeader(key, map.get(key));
        }

        try {
            httpResponse = client.execute(get);
            res = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    //设置entity
    public static StringEntity getEntity(String parm,String contentType){
        StringEntity reqEntity = null;
        try {
            reqEntity = new StringEntity(parm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        reqEntity.setContentType(contentType);
        return reqEntity;
    }

}
