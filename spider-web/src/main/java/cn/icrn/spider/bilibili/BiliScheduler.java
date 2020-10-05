package cn.icrn.spider.bilibili;

import cn.icrn.spider.Pipeline;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yan
 * Date: 2020-10-05
 * Time: 21:41
 */
public class BiliScheduler {

    @Autowired
    private Pipeline pipeline;

    @Autowired
    private BiliProcesser biliProcesser;

    public void start() {
        Map<String, Video> map = coreSchedule();
        pipeline.cacheVideoInfo(map);
    }

    private Map<String, Video> coreSchedule() {
        // todo
        String tid = "22";
        Map<String, Video> stringVideoMap = biliProcesser.processerVideo(tid);
        return stringVideoMap;
    }





}
