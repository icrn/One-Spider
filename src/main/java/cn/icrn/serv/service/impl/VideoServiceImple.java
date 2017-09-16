package cn.icrn.serv.service.impl;

import cn.icrn.serv.service.VideoService;
import cn.icrn.spider.Pipeline;
import cn.icrn.spider.bean.VideoInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: yankang
 * Date: 2017/9/16
 */
@Service
@AllArgsConstructor
public class VideoServiceImple implements VideoService {

    private final Pipeline pipeline;

    public List<VideoInfo> getVideo(List<String> name) {
        List<VideoInfo> infos = new ArrayList<>();
        for (String title : name) {
            infos.add(pipeline.getCacheVideoInfo(title));
        }
        return infos;
    }

}
