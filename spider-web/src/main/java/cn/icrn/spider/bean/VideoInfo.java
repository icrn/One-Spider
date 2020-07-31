package cn.icrn.spider.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: yankang
 * Date: 2017/9/16
 */
@Data
@NoArgsConstructor
public class VideoInfo {

    String title;

    String imgUrl;

    String id;

    List<Video> Video;
}
