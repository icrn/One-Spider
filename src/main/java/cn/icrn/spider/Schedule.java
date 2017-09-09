package cn.icrn.spider;

import java.util.Map;

/**
 * Author: yankang
 * Date: 2017/9/9
 */
public class Schedule {

    public static void main(String[] args) {
        String url = "http://api.rr.tv/v3plus/season/usk/index";
        String parm = "page=1&rows=18";
        String title = "currentNewSeason";
        String res = DownLoader.downloadPost(url, parm, 1);
        Map<String, String> map = PageProcesser.processerIndex(res, title);
        String id = map.get("马男波杰克 第四季");
        String url1 = "http://api.rr.tv/v3plus/season/detail";
        String parm1 = "seasonId="+id+"";
        String res1 = DownLoader.downloadPost(url1, parm1, 2);
        Map<String, String> map1 = PageProcesser.processerDeatail(res1, "playUrlList");
        String pid = map1.get("1");
        String url2 = "http://api.rr.tv/video/findM3u8ByEpisodeSidAuth";
        String parm2 = "seasonId="+id+"&quality=high&episodeSid="+pid;
        String res2 = DownLoader.downloadPost(url2, parm2, 3);
        String res3 = PageProcesser.processerVideo(res2);
        System.out.println(res3);
    }

}
