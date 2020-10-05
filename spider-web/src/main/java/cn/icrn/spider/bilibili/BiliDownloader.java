package cn.icrn.spider.bilibili;

import cn.icrn.spider.AbstractDownloader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yan
 * Date: 2020-10-05
 * Time: 21:14
 */
public class BiliDownloader extends AbstractDownloader {

    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private static final Map<String, String> map = new HashMap();

    static {
        map.put("Accept", "application/json,text/javascript,*/*;q=0.01");
        map.put("Accept-Encoding", "gzip,deflate,sdch");
        map.put("AcceptLanguage", "zh-CN,zh;q=0.8");
        map.put("Content-Type", "text/html;charset=UTF-8");
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE 2.X MetaSr 1.0");
    }


}