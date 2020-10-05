package cn.icrn.spider.bilibili;

import cn.icrn.spider.Constant;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yan
 * Date: 2020-10-05
 * Time: 21:39
 */
public class BiliProcesser {

    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private BiliDownloader biliDownloader;

    /**
     * 爬取某个分区的所有视频
     * @param tid
     * @return
     */
    public Map<String, Video> processerVideo(String tid) {
        Map<String, Video> map = new HashMap<>();
        int pageNum = getPageNum(tid);
        for (int i = 1; i <= pageNum; i++) {
            String url = null;
            try {
                url = Constant.biliCrawlerUrl + "?tid=" + tid + "&pn=" + i;
                String result = biliDownloader.downloadPost(url, "");
                JSONObject res = JSONObject.parseObject(result);
                JSONArray videos = res.getJSONObject("data").getJSONArray("archives");
                for (int j = 0; j < videos.size(); j++) {
                    JSONObject vObj = videos.getJSONObject(j);
                    Video v = new Video();
                    v.setId(String.valueOf(vObj.getInteger("aid")));
                    v.setTitle(vObj.getString("title"));
                    v.setAuthor(vObj.getString("author"));
                    v.setCategory(vObj.getString("tname"));
                    v.setCoin(vObj.getJSONObject("stat").getInteger("coin"));
                    v.setFavorite(vObj.getInteger("favorites"));
                    if (vObj.get("play").equals("--"))
                        v.setPlay(0);
                    else
                        v.setPlay(vObj.getInteger("play"));
                    v.setBarrage(vObj.getInteger("video_review"));
                    v.setComment(vObj.getJSONObject("stat").getInteger("reply"));
                    map.put(v.getTitle(), v);
                }
            } catch (Exception e) {
                logger.error("process page error, url: {}", url, e);
                continue;
            }
        }
        return map;
    }

    /**
     *  获取全部分页
     * @param tid
     * @return
     */
    private int getPageNum(String tid) {
        String url = Constant.biliCrawlerUrl + "?tid=" + tid;
        int pageNum = 0;
        String content = biliDownloader.downloadPost(url, "");
        JSONObject res = JSONObject.parseObject(content);
        JSONObject page = res.getJSONObject("data").getJSONObject("page");
        pageNum = (page.getInteger("count") - 1) / page.getInteger("size") + 1;
        return pageNum;
    }


}
