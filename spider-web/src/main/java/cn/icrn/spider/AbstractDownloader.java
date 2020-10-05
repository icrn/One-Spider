package cn.icrn.spider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yan
 * Date: 2020-10-05
 * Time: 21:28
 */
public abstract class AbstractDownloader {

    private Map<String, String> map = new HashMap();

    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public String downloadPost(String url, String parm){
        Connection con = Jsoup.connect(url).headers(map).ignoreContentType(true);
        String str[] = parm.split(" ");
        for (int i = 0; i < str.length; i+=2) {
            con.data(str[i], str[i+1]);
        }
        try {
            return con.post().text();
        } catch (IOException e) {
            logger.error("download data error. ", e);
        }
        return null;
    }

}
