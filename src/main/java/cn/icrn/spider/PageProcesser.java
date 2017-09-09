package cn.icrn.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: yankang
 * Date: 2017/9/9
 */
public class PageProcesser {

    public static Map<String, String> processerIndex(String res, String title) {
        Map<String, String> map = new HashMap();
        JSONObject json = JSONObject.parseObject(res).getJSONObject("data");
        JSONArray newSeason = json.getJSONArray(title);
        for (int i = 0 ; i < newSeason.size() ; i ++) {
            JSONObject obj = newSeason.getJSONObject(i);
            map.put(obj.get("title").toString(), obj.get("id").toString());
        }
        return map;
    }

    public static Map<String, String> processerDeatail(String res, String title) {
        Map<String, String> map = new HashMap();
        JSONObject json = JSONObject.parseObject(res).getJSONObject("data").getJSONObject("season");
        JSONArray newSeason = json.getJSONArray(title);
        for (int i = 0 ; i < newSeason.size() ; i ++) {
            JSONObject obj = newSeason.getJSONObject(i);
            map.put(obj.get("episode").toString(), obj.get("episodeSid").toString());
        }
        return map;
    }

    public static String processerVideo(String res) {
        Map<String, String> map = new HashMap();
        JSONObject json = JSONObject.parseObject(res).getJSONObject("data").getJSONObject("m3u8");
        return json.get("url").toString();
    }
}
