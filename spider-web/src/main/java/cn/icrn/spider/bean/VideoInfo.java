package cn.icrn.spider.bean;


import java.util.List;

/**
 * Author: yankang
 * Date: 2017/9/16
 */
public class VideoInfo {

    String title;

    String imgUrl;

    String id;

    List<Video> Video;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<cn.icrn.spider.bean.Video> getVideo() {
        return Video;
    }

    public void setVideo(List<cn.icrn.spider.bean.Video> video) {
        Video = video;
    }
}
