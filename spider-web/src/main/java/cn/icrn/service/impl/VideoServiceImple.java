package cn.icrn.service.impl;

import cn.icrn.service.VideoService;
import cn.icrn.spider.Pipeline;
import cn.icrn.spider.bean.VideoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: yankang
 * Date: 2017/9/16
 */
@Service
public class VideoServiceImple implements VideoService {

    @Autowired
    private Pipeline pipeline;

    public List<VideoInfo> getVideo(List<String> name) {
        List<VideoInfo> infos = new ArrayList<>();
        for (String title : name) {
            VideoInfo cacheVideoInfo = (VideoInfo) pipeline.getCacheVideoInfo(title, VideoInfo.class);
            infos.add(cacheVideoInfo);
        }
        return infos;
    }

}
