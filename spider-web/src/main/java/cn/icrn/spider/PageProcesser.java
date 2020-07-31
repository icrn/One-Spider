package cn.icrn.spider;

import cn.icrn.spider.bean.Video;
import cn.icrn.spider.bean.VideoInfo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: yankang
 * Date: 2017/9/9
 */
public class PageProcesser {

    public static Map<String, VideoInfo> processerIndex(String res, String title) {
        Map<String, VideoInfo> map = new HashMap();
        JSONObject json = JSONObject.parseObject(res).getJSONObject("data");
        JSONArray newSeason = json.getJSONArray(title);
        for (int i = 0 ; i < newSeason.size() ; i ++) {
            JSONObject obj = newSeason.getJSONObject(i);
            VideoInfo info = new VideoInfo();
            info.setImgUrl(obj.get("cover").toString());
            info.setTitle(obj.get("title").toString());
            info.setId(obj.get("id").toString());
            map.put(info.getId(), info);
        }
        return map;
    }

    public static Map<String, Video> processerDeatail(String res, String title) {
        Map<String, Video> map = new HashMap();
        JSONObject json = JSONObject.parseObject(res).getJSONObject("data").getJSONObject("season");
        JSONArray newSeason = json.getJSONArray(title);
        for (int i = 0 ; i < newSeason.size() ; i ++) {
            JSONObject obj = newSeason.getJSONObject(i);
            Video video = new Video();
            String episode = obj.get("episode").toString();
            video.setPid(obj.get("episodeSid").toString());
            video.setEpisode(episode);
            map.put(episode, video);
        }
        return map;
    }

    public static void processerVideo(String res, Video video) {
        JSONObject json = JSONObject.parseObject(res).getJSONObject("data").getJSONObject("m3u8");
        String url = null;
        Object str = json.get("url");
        if (str == null) {
            str = json.get("webUrl");
        }
        if (str != null) {
            url = str.toString();
        }
        video.setVideoUrl(url);
    }
}
