package cn.icrn.spider.rrmj;

import cn.icrn.spider.Pipeline;
import cn.icrn.spider.bean.Video;
import cn.icrn.spider.bean.VideoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: yankang
 * Date: 2017/9/9
 */
@Service
public class Schedule {

    @Autowired
    private Pipeline pipeline;

    @Autowired
    private RRMJDownloader rrmjDownloader;

    public void start() {
        Map<String, VideoInfo> map = scheduleIndex();
        for (String id : map.keySet()) {
            VideoInfo info = map.get(id);
            Map<String, Video> deatailMap = scheduleDeatail(id);
            for (String dkey : deatailMap.keySet()) {
                Video video = deatailMap.get(dkey);
                scheduleVideo(id, video);
            }
            info.setVideo(new ArrayList(deatailMap.values()));
        }
        pipeline.cacheVideoInfo(map);
    }

    private Map<String, VideoInfo> scheduleIndex(){
        String url = "http://api.rr.tv/v3plus/season/usk/index";
        String title = "results";
        Map<String, VideoInfo> map = new HashMap<>();
        for(int i = 1 ; i < 10 ; i++) {
            String parm = "page "+i+" rows 18";
            String res = rrmjDownloader.downloadPost(url, parm);
            map.putAll(PageProcesser.processerIndex(res, title));
        }
        return map;
    }

    private Map<String, Video> scheduleDeatail(String id){
        String url = "http://api.rr.tv/v3plus/season/detail";
        String parm = "seasonId "+id;
        String res = rrmjDownloader.downloadPost(url, parm);
        Map<String, Video> map = PageProcesser.processerDeatail(res, "playUrlList");
        return map;
    }

    private void scheduleVideo(String id,Video video){
        String url = "http://api.rr.tv/video/findM3u8ByEpisodeSidAuth";
        String parm = "seasonId "+id+" quality high episodeSid "+video.getPid();
        String res = rrmjDownloader.downloadPost(url, parm);
        PageProcesser.processerVideo(res, video);
    }


}
