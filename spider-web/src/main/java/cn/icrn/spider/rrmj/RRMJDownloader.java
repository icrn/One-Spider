package cn.icrn.spider.rrmj;

import cn.icrn.spider.AbstractDownloader;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: yankang
 * Date: 2017/9/9
 */
public class RRMJDownloader extends AbstractDownloader {

    private static final Map<String, String> map = new HashMap();

    static {
        map.put("a", "4dbb0181-84e2-41bd-acb5-f8b06599c8c7");
        map.put("clientVersion", "3.6.1");
        map.put("clientType", "ios");
        map.put("token", "f09f1606d8124f08b75b09e2400092a3");
        map.put("authentication", "RRTV f09f1606d8124f08b75b09e2400092a3:CMDeBj:JBosVj:twmkRQmWq6_CR4DLdu1vCX");
    }


}
