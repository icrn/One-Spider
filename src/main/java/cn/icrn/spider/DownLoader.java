package cn.icrn.spider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: yankang
 * Date: 2017/9/9
 */
public class DownLoader {

    private static final Map<String, String> map = new HashMap();

    static {
        map.put("a", "4dbb0181-84e2-41bd-acb5-f8b06599c8c7");
        map.put("clientVersion", "3.6.1");
        map.put("clientType", "ios");
        map.put("token", "f09f1606d8124f08b75b09e2400092a3");
        map.put("authentication", "RRTV f09f1606d8124f08b75b09e2400092a3:CMDeBj:JBosVj:twmkRQmWq6_CR4DLdu1vCX");
    }

    public static String downloadPost(String url, String parm){
        Connection con = Jsoup.connect(url).headers(map).ignoreContentType(true);
        String str[] = parm.split(" ");
        for (int i = 0; i < str.length; i+=2) {
            con.data(str[i], str[i+1]);
        }
        try {
            return con.post().text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
